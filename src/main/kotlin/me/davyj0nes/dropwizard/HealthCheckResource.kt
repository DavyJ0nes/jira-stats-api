package me.davyj0nes.dropwizard

import com.codahale.metrics.health.HealthCheckRegistry
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/** Key for Liveness `HealthCheck` in `HealthCheckRegistry`*/
internal const val LIVENESS_CHECK_KEY = "Liveness Health Check"

/** Key for Readiness `HealthCheck` in `HealthCheckRegistry`*/
internal const val READINESS_CHECK_KEY = "Readiness Health Check"

/**
 * This class contains the endpoints related to Liveness and Readiness checks.
 *
 * [healthCheckRegistry] is the 'HealthCheckRegistry` instance to use for checks.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
class HealthCheckResource(private val healthCheckRegistry: HealthCheckRegistry) {
    /** Runs the 'HealthCheck' for Liveness and returns the result.*/
    @Path("/liveness")
    @GET
    fun livenessCheck() = healthCheckRegistry.runHealthCheck(LIVENESS_CHECK_KEY)

    /** Runs the 'HealthCheck' for Readiness and returns the result.*/
    @Path("/readiness")
    @GET
    fun readinessCheck() = healthCheckRegistry.runHealthCheck(READINESS_CHECK_KEY)

    /** Runs all 'HealthCheck's held by the 'HealthCheckRegistry` and returns the results.*/
    @Path("/status")
    @GET
    fun statusCheck() = healthCheckRegistry.runHealthChecks()
}
