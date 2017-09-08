package com.nannoprice.api.config;

import com.nannoprice.api.controller.ProductResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/v1.0")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig () {
        register(ProductResource.class);
    }
}
