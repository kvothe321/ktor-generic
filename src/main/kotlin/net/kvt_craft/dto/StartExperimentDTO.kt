package net.kvt_craft.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StartExperimentDTO(
    @SerialName("StartExperiment")
    private val startExperiment: Boolean
)
