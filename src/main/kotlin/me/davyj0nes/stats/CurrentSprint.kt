package me.davyj0nes.stats

import com.atlassian.jira.rest.client.api.domain.Project
import me.davyj0nes.jira.JiraClient

class CurrentSprint(user: String, pass: String, url: String) {

    private val client = JiraClient(user, pass, url).connect()

    fun getProjectInfo(projectId: String): String {
        val project = client.projectClient.getProject(projectId).claim()

        return getProjectName(project)
    }

    private fun getProjectName(project: Project): String = project.name.toString()
}