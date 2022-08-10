package org.mcqueen.cloud.gateway.entity;

import lombok.Data;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 网关路由模型
 * @author McQueen
 */
@Data
public class GatewayRouteDefinition {

    // 路由的 ID
    private String id;

    // 路由断言配置集合
    private List<GatewayPredicateDefinition> predicates;

    // 路由过滤器配置集合
    private List<GatewayFilterDefinition> filters;

    // 路由转发目标的 URI
    private URI URI;

    // 路由的元素据
    private Map<String, Object> metadata;

    // 路由执行的顺序
    private int order = 0;

}
