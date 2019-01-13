package me.davyj0nes.dropwizard

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class JiraStatsConfiguration(
    @JsonProperty("name") var name: String = "not set",
    @JsonProperty("endpoint") var endpoint: String = "not set",
    @JsonProperty("username") var username: String = "not set",
    @JsonProperty("token") var token: String = "not set"
) : Configuration()
