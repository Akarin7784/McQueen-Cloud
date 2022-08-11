package org.mcqueen.cloud.gateway.service.impl;

import org.mcqueen.cloud.gateway.entity.GatewayRouteDefinition;
import org.mcqueen.cloud.gateway.service.GatewayRouteService;
import org.mcqueen.cloud.gateway.utils.RouteDefinitionUtils;
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
        List<GatewayRouteDefinition> gatewayRouteDefinitions = mongoTemplate.find(query, GatewayRouteDefinition.class, "gatewayRouteDefinition");
        // 声明一个路由定义信息集合，准备存入路由信息
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        // 遍历查询到的路由信息
        for (GatewayRouteDefinition dbRoute : gatewayRouteDefinitions) {
            // 将数据库中的路由信息转换为路由定义信息
            RouteDefinition routeDefinition = RouteDefinitionUtils.assembleRouteDefinition(dbRoute);
            routeDefinitions.add(routeDefinition);
        }
        // 返回路由信息
        return Flux.fromStream(routeDefinitions.stream());
    }

}
