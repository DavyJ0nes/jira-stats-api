package me.davyj0nes.jira

import com.atlassian.jira.rest.client.api.JiraRestClient
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory
import java.net.URI


class JiraClient(private val userName: String, private val token: String, private val endpoint: String) {
    fun connect() : JiraRestClient {
        return AsynchronousJiraRestClientFactory().createWithBasicHttpAuthentication(
            getJiraURI(),
            userName,
            token
        )
    }

    private fun getJiraURI(): URI {
        return URI.create(endpoint)
    }
}