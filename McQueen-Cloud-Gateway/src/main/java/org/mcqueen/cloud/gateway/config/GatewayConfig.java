package org.mcqueen.cloud.gateway.config;

import org.mcqueen.cloud.gateway.service.GatewayRouteService;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * 注入自定义路由配置数据源
 *
 * @author McQueen
 */
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 5)
@AutoConfigureBefore(GatewayAutoConfiguration.class)
public class GatewayConfig {

    @Bean
    @ConditionalOnBean(GatewayRouteService.class)
    @ConditionalOnMissingBean(RouteDefinitionRepository.class)
    public InDBRouteDefinitionRepository inDBRouteDefinitionRepository(GatewayRouteService gatewayRouteService) {
        return new InDBRouteDefinitionRepository(gatewayRouteService);
    }

}
