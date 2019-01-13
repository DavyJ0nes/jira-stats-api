package me.davyj0nes.dropwizard

import com.codahale.metrics.health.HealthCheckRegistry
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import me.davyj0nes.components.StatsComponent

class JiraStatsApplication: Application<JiraStatsConfiguration>() {
    private val healthRegistry = HealthCheckRegistry()
    private val healthCheckResource = HealthCheckResource(healthRegistry)

    override fun run(configuration: JiraStatsConfiguration, environment: Environment) {
        println("starting ${configuration.name}")
        val stats = StatsComponent(configuration.username, configuration.token, configuration.endpoint)

        environment.jersey().register(healthCheckResource)
        environment.jersey().register(stats)
    }
}