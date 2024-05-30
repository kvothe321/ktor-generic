package net.kvt_craft.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class GetExperimentSampleDto(
    @SerialName("GetExperimentSamples")
    val getExperimentSamples: Array<JsonArray>
)

@Serializable
data class ExperimentSample(
    val type: String,
    val id: Int,
    val values: Array<Double>
)

/*
@Serializable
sealed class ExperimentSample

@Serializable
@SerialName("EKG")
data class LightSample(
    val type: String,
    val id: Int,
    val measurements: List<Int>
) : ExperimentSample()

@Serializable
@SerialName("GSR")
data class GsrSample(
    val id: Int,
    val measurements: List<Double>
) : ExperimentSample()

@Serializable
data class GetExperimentSampleDto(
    @SerialName("GetExperimentSamples")
    val getExperimentSamples: List<ExperimentSample>
)

val module = SerializersModule {
    polymorphic(ExperimentSample::class) {
        subclass(LightSample::class, LightSample.serializer())
        subclass(GsrSample::class, GsrSample.serializer())
    }
}

val format = Json {
    serializersModule = module
    classDiscriminator = "type"
}*/
