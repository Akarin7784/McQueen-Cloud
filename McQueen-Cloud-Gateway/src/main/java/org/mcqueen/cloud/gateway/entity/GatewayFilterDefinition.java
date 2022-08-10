package org.mcqueen.cloud.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 路由过滤器模型
 *
 * @author McQueen
 */
@Data
public class GatewayFilterDefinition {

    // 过滤器名称
    private String name;

    // 过滤器规则
    private Map<String, String> args = new LinkedHashMap<>();

}
