package com.mvpotter.api_gateway_demo.configuration;

import jakarta.validation.constraints.NotNull;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class CustomRouterProperties {

    @NotNull
    private Map<String, RouteDefinition> routes;

    public @NotNull Map<String, RouteDefinition> getRoutes() {
        return routes;
    }

    public void setRoutes(@NotNull Map<String, RouteDefinition> routes) {
        this.routes = routes;
    }

}
