package org.mcqueen.cloud.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;
import reactor.core.publisher.Flux;

public interface GatewayRouteService {

    /**
     * 从数据库中获取所有网关信息
     *
     * @return Flux<RouteDefinition> 获取到的网关信息
     */
    Flux<RouteDefinition> getGatewayRoutes();

}
