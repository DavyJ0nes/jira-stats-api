package me.davyj0nes.components

import com.google.common.collect.ImmutableMap
import me.davyj0nes.stats.CurrentSprint
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/v1/stats")
class StatsComponent(private val jiraUser: String,
                     private val jiraToken: String,
                     private val jiraEndpoint: String) {
    @Path("/project/{projectId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun test(@PathParam("projectId") projectId: String): Response {
        val projectName = CurrentSprint(jiraUser, jiraToken, jiraEndpoint).getProjectInfo(projectId)

        val response = ImmutableMap.builder<String, String>()
            .put("project", projectName)
            .build()

        return Response.ok().entity(response).build()
    }
}

