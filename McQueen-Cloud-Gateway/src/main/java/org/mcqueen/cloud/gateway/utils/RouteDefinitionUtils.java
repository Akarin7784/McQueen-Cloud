package org.mcqueen.cloud.gateway.utils;

import org.mcqueen.cloud.gateway.entity.GatewayFilterDefinition;
import org.mcqueen.cloud.gateway.entity.GatewayPredicateDefinition;
import org.mcqueen.cloud.gateway.entity.GatewayRouteDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由网关信息转换工具
 * @author McQueen
 */
public class RouteDefinitionUtils {

    /**
     * 屏蔽无参构造器
     */
    private RouteDefinitionUtils() {

    }

    /**
     * 描述：用于将数据库中存储的GatewayRouteDefinition转化为RouteDefinition
     * @param gatewayRouteDefinition 数据库中存储的网关信息
     * @return routeDefinition Gateway框架中定义的网关信息
     */
    public static RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gatewayRouteDefinition) {
        // 声明一个路由定义信息
        RouteDefinition routeDefinition = new RouteDefinition();
        // 设置路由 ID
        routeDefinition.setId(gatewayRouteDefinition.getId());
        // 设置路由执行顺序
        routeDefinition.setOrder(gatewayRouteDefinition.getOrder());
        // 设置转发目标 URI
        routeDefinition.setUri(gatewayRouteDefinition.getUri());
        // 设置元素据信息
        routeDefinition.setMetadata(gatewayRouteDefinition.getMetadata());

        // 遍历查询到的路由过滤器信息
        List<GatewayFilterDefinition> filters = gatewayRouteDefinition.getFilters();
        // 声明路由过滤器集合
        List<FilterDefinition> filterDefinitions = new ArrayList<>();
        for (GatewayFilterDefinition filter : filters) {
            // 将路由过滤器信息浅拷贝至过滤器定义中
            FilterDefinition filterDefinition = new FilterDefinition();
            BeanUtils.copyProperties(filter, filterDefinition);
            filterDefinitions.add(filterDefinition);
        }
        // 将路由过滤器定义信息过滤器定义集合中
        routeDefinition.setFilters(filterDefinitions);

        // 遍历查询到的路由断言信息
        List<GatewayPredicateDefinition> predicates = gatewayRouteDefinition.getPredicates();
        // 声明路由过滤器集合
        List<PredicateDefinition> predicateDefinitions = new ArrayList<>();
        for (GatewayPredicateDefinition predicate : predicates) {
            // 将路由过滤器信息浅拷贝至过滤器定义中
            PredicateDefinition predicateDefinition = new PredicateDefinition();
            BeanUtils.copyProperties(predicate, predicateDefinition);
            predicateDefinitions.add(predicateDefinition);
        }
        // 将路由过滤器定义信息过滤器定义集合中
        routeDefinition.setPredicates(predicateDefinitions);

        return routeDefinition;
    }
}
