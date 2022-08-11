package org.mcqueen.cloud.gateway.entity;

import lombok.Data;
import lombok.ToString;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 网关路由模型
 *
 * @author McQueen
 */
@Data
@ToString
public class GatewayRouteDefinition {

    // 路由的 ID
    private String id;

    // 路由断言配置集合
    private List<GatewayPredicateDefinition> predicates;

    // 路由过滤器配置集合
    private List<GatewayFilterDefinition> filters;

    // 路由转发目标的 URI
    private URI uri;

    // 路由的元素据
    private Map<String, Object> metadata = new LinkedHashMap<>();

    // 路由执行的顺序
    private int order = 0;

    // 路由是否生效
    private boolean enable;

}
