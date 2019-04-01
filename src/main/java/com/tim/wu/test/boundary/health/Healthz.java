package com.tim.wu.test.boundary.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Health
@ApplicationScoped
public class Healthz implements HealthCheck {

    @Inject
    @ConfigurationValue("service.sw.name")
    String swName;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Healthz")
                .withData("swName", swName)
                .up()
                .build();
    }
}