package org.mcqueen.cloud.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;
import reactor.core.publisher.Flux;

public interface GatewayRouteService {

    Flux<RouteDefinition> getGatewayRoutes();

}
