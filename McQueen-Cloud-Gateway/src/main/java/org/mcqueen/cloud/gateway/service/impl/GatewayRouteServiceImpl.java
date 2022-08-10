package org.mcqueen.cloud.gateway.service.impl;

import org.mcqueen.cloud.gateway.entity.GatewayFilterDefinition;
import org.mcqueen.cloud.gateway.entity.GatewayPredicateDefinition;
import org.mcqueen.cloud.gateway.entity.GatewayRouteDefinition;
import org.mcqueen.cloud.gateway.service.GatewayRouteService;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GatewayRouteServiceImpl implements GatewayRouteService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Flux<RouteDefinition> getGatewayRoutes() {
        // 从 MongoDB 中取出路由信息
        Query query = new Query(Criteria.where("enable").is(true));
        List<GatewayRouteDefinition> gatewayRouteDefinitions = mongoTemplate.find(query, GatewayRouteDefinition.class, "gateway-routes");

        // 声明一个路由定义信息集合，准备存入路由信息
        List<RouteDefinition> routeDefinitions = new ArrayList<>();

        // 遍历查询到的路由信息
        for (GatewayRouteDefinition dbRoute : gatewayRouteDefinitions) {

            // 声明一个路由定义信息
            RouteDefinition routeDefinition = new RouteDefinition();
            // 设置路由 ID
            routeDefinition.setId(dbRoute.getId());
            // 设置路由执行顺序
            routeDefinition.setOrder(dbRoute.getOrder());
            // 设置转发目标 URI
            routeDefinition.setUri(dbRoute.getURI());
            // 设置元素据信息
            routeDefinition.setMetadata(dbRoute.getMetadata());

            // 遍历查询到的路由过滤器信息
            List<GatewayFilterDefinition> filters = dbRoute.getFilters();
            // 声明路由过滤器集合
            List<FilterDefinition> filterDefinitions = new ArrayList<>();
            for (GatewayFilterDefinition filter : filters) {
                // 将路由过滤器信息浅拷贝至过滤器定义中
                FilterDefinition filterDefinition = new FilterDefinition();
                BeanUtils.copyProperties(filter,filterDefinition);
                filterDefinitions.add(filterDefinition);
            }
            // 将路由过滤器定义信息过滤器定义集合中
            routeDefinition.setFilters(filterDefinitions);

            // 遍历查询到的路由断言信息
            List<GatewayPredicateDefinition> predicates = dbRoute.getPredicates();
            // 声明路由过滤器集合
            List<PredicateDefinition> predicateDefinitions = new ArrayList<>();
            for (GatewayPredicateDefinition predicate : predicates) {
                // 将路由过滤器信息浅拷贝至过滤器定义中
                PredicateDefinition predicateDefinition = new PredicateDefinition();
                BeanUtils.copyProperties(predicate,predicateDefinition);
                predicateDefinitions.add(predicateDefinition);
            }
            // 将路由过滤器定义信息过滤器定义集合中
            routeDefinition.setPredicates(predicateDefinitions);

            // 添加路由定义信息到集合中
            routeDefinitions.add(routeDefinition);
        }

        // 返回路由信息
        return Flux.fromStream(routeDefinitions.stream());
    }
}
