package net.kvt_craft.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import net.kvt_craft.dto.GetExperimentSampleDto
import net.kvt_craft.dto.StartExperimentDTO

fun Route.neuLogController() {
    get("/NeuLogAPI") {
        val startExperiment = call.request.queryParameters["StartExperiment"]
        when {
            call.request.uri.contains("StartExperiment") -> {
                call.respond(StartExperimentDTO(startExperiment = true))
            }

            call.request.uri.contains("GetExperimentSamples") -> {
                val gsrMockedData = getGsrMockedData()
                val ekgMockedData = getEkgMockedData()

                val jsonArrayGsr = JsonArray(gsrMockedData.map {
                    when (it) {
                        is String -> JsonPrimitive(it)
                        is Number -> JsonPrimitive(it)
                        else -> throw IllegalArgumentException("Unsupported type")
                    }
                })

                val jsonArrayEkg = JsonArray(ekgMockedData.map {
                    when (it) {
                        is String -> JsonPrimitive(it)
                        is Number -> JsonPrimitive(it)
                        else -> throw IllegalArgumentException("Unsupported type")
                    }
                })

                val jsonString = Json.encodeToString(JsonArray.serializer(), jsonArrayGsr)

                call.respond(
                    GetExperimentSampleDto(
                        getExperimentSamples = arrayOf(jsonArrayGsr, jsonArrayEkg)
                    )
                )
            }

            else -> {
                call.respond(HttpStatusCode.BadRequest)
            }
        }


    }

}

fun getGsrMockedData() = arrayOf(
    "GSR",
    1,
    3.58,
    5.08,
    2.03,
    4.58,
    3.62,
    7.61,
    5.56,
    4.42,
    5.76,
    4.56,
    8.92,
    6.09,
    4.39,
    5.39,
    2.70,
    3.14,
    7.96,
    6.58,
    5.98,
    5.22,
    3.50,
    3.11,
    4.27,
    -0.19,
    4.83,
    3.65,
    1.51,
    2.33,
    6.26,
    3.32,
    4.33,
    2.05,
    2.83,
    3.37,
    4.94,
    4.40,
    5.40,
    1.30,
    4.54,
    3.11,
    6.03,
    5.30,
    7.67,
    5.09,
    4.25,
    6.27,
    1.97,
    5.85,
    5.59,
    9.67,
    2.03,
    3.26,
    3.21,
    3.03,
    7.52,
    5.78,
    5.85,
    6.85,
    11.46,
    7.78,
    6.32,
    2.72,
    4.53,
    7.95,
    4.59,
    4.99,
    3.42,
    6.23,
    4.60,
    6.24,
    2.73,
    5.12,
    2.85,
    4.05,
    4.93,
    5.61,
    5.73,
    2.73,
    4.35,
    7.40,
    1.87,
    4.55,
    2.41,
    4.51,
    7.52,
    6.34,
    8.95,
    4.95,
    5.16,
    3.07,
    3.13,
    3.94,
    4.86,
    4.92,
    5.81,
    5.96,
    3.96,
    6.79,
    3.22,
    7.45,
    4.92,
    6.46,
    3.88,
    4.44,
    2.57,
    7.86,
    3.96,
    3.72,
    6.17,
    4.16,
    1.15,
    2.97,
    1.62,
    2.00,
    8.44,
    4.88,
    7.47,
    2.52,
    3.18,
    5.28,
    5.15,
    5.51,
    5.13,
    6.70,
    4.30,
    2.25,
    3.15,
    3.12,
    6.01,
    8.90,
    5.56,
    6.09,
    4.00,
    2.54,
    4.89,
    5.54,
    5.40,
    4.14,
    6.33,
    8.31,
    7.90,
    1.46,
    4.55,
    2.27,
    7.39,
    4.16,
    3.31,
    7.33,
    3.94,
    5.03,
    2.45,
    8.55,
    5.66,
    6.32,
    7.79,
    9.58,
    6.20,
    3.30,
    -0.93,
    2.56,
    4.86,
    6.55,
    2.92,
    5.74,
    3.71,
    3.99,
    3.94,
    8.06,
    7.91,
    3.51,
    2.15,
    5.60,
    4.18,
    6.17,
    5.68,
    6.32,
    7.64,
    5.23,
    4.77,
    2.95,
    8.02,
    5.16,
    7.69,
    5.34,
    4.76,
    1.30,
    3.42,
    4.51,
    9.21,
    3.33,
    5.66,
    4.29,
    0.30,
    2.63,
    1.18,
    1.05,
    5.80,
    3.84,
    7.39,
    7.41
)

fun getEkgMockedData() = arrayOf(
    "EKG",
    1,
    0.26,
    0.33,
    -0.30,
    0.64,
    -0.46,
    0.16,
    0.24,
    -0.01,
    -0.26,
    -1.34,
    0.36,
    -0.16,
    0.98,
    0.39,
    0.37,
    -0.56,
    -0.02,
    -0.34,
    0.22,
    0.10,
    0.19,
    0.25,
    -0.23,
    0.20,
    -1.05,
    0.71,
    -0.19,
    -0.03,
    -0.01,
    -0.37,
    -0.22,
    -0.04,
    -0.06,
    0.03,
    0.62,
    0.05,
    -0.31,
    -1.36,
    0.24,
    0.09,
    0.03,
    0.02,
    -0.62,
    -0.21,
    0.07,
    -0.19,
    0.58,
    0.73,
    0.45,
    0.52,
    1.10,
    0.06,
    -0.34,
    0.45,
    0.58,
    0.29,
    0.03,
    -0.58,
    0.81,
    0.18,
    0.00,
    -0.32,
    0.35,
    0.19,
    -0.09,
    -0.37,
    -0.19,
    -0.09,
    -0.42,
    0.25,
    0.53,
    0.32,
    -0.00,
    0.16,
    -0.24,
    0.33,
    -0.42,
    0.32,
    0.33,
    -0.46,
    0.89,
    0.60,
    -0.25,
    0.86,
    0.01,
    0.31,
    0.77,
    0.50,
    0.33,
    0.33,
    0.16,
    -0.24,
    0.18,
    0.09,
    -1.85,
    0.30,
    0.09,
    -1.19,
    0.77,
    0.02,
    -0.20,
    -0.61,
    -0.20,
    -0.01,
    0.24,
    -0.13,
    -0.79,
    0.55,
    -0.84,
    -0.59,
    0.66,
    -0.49,
    -0.15,
    0.90,
    -0.04,
    0.46,
    -0.20,
    0.51,
    0.33,
    1.23,
    -0.87,
    -0.24,
    0.34,
    -0.36,
    0.34,
    -0.41,
    -0.27,
    -0.40,
    -0.44,
    1.30,
    0.12,
    -0.19,
    0.39,
    0.11,
    -0.56,
    0.69,
    -0.90,
    0.88,
    0.34,
    -0.05,
    0.29,
    -0.77,
    -0.75,
    -0.15,
    -0.07,
    0.65,
    -0.03,
    0.38,
    -0.74,
    -0.16,
    0.31,
    0.05,
    0.04,
    0.42,
    -0.13,
    -0.71,
    -0.79,
    0.18,
    0.28,
    -0.53,
    0.20,
    0.66,
    -0.63,
    0.05,
    -0.73,
    0.08,
    1.08,
    -1.07,
    0.53,
    -0.02,
    0.19,
    -0.00,
    -0.97,
    1.77,
    -0.89,
    0.88,
    0.56,
    -0.07,
    -0.03,
    0.85,
    0.27,
    -0.26,
    0.76,
    -0.32,
    0.96,
    -0.33,
    0.40,
    -0.64,
    -0.72,
    0.44,
    0.31,
    -0.49,
    0.22,
    -0.37,
    0.45,
    0.06,
    0.17,
    -0.02,
    -0.06,
    1.00
)

