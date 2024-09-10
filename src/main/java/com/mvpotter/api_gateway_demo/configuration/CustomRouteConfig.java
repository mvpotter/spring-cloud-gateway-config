package com.mvpotter.api_gateway_demo.configuration;

import java.util.Map;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class CustomRouteConfig {

    public CustomRouteConfig(RouteDefinitionWriter writer, CustomRouterProperties properties) {
        Map<String, RouteDefinition> routes = properties.getRoutes();
        for (Map.Entry<String, RouteDefinition> entry : routes.entrySet()) {
            String key = entry.getKey();
            RouteDefinition definition = entry.getValue();
            writer.save(Mono.just(definition).map(route -> {
                route.setId(key);
                return route;
            })).subscribe();
        }
    }

}
