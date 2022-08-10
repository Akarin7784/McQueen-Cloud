package org.mcqueen.cloud.gateway.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 路由断言模型
 * @author McQueen
 */
@Data
public class GatewayPredicateDefinition {

    // 断言对应的 Name
    private String name;

    // 断言对应的规则
    private Map<String,String> args = new LinkedHashMap<>();
}
