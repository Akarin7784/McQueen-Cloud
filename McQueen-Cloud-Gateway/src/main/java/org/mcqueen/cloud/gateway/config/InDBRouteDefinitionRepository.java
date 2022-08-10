package org.mcqueen.cloud.gateway.config;

import org.mcqueen.cloud.gateway.service.GatewayRouteService;
import org.mcqueen.cloud.gateway.service.impl.DynamicRouteServiceImpl;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

public class InDBRouteDefinitionRepository implements RouteDefinitionRepository {

    private final GatewayRouteService gatewayRouteService;

    public InDBRouteDefinitionRepository(GatewayRouteService gatewayRouteService) {
        this.gatewayRouteService = gatewayRouteService;
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return gatewayRouteService.getGatewayRoutes();
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return Mono.empty();
    }

}