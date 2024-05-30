package net.kvt_craft

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import net.kvt_craft.plugins.configureContentNegotiation
import net.kvt_craft.plugins.configureDatabase
import net.kvt_craft.plugins.configureRouting

fun main(args: Array<String>) {
    EngineMain.main(args)

}

@Suppress("unused") // Referenced in application.yaml
fun Application.module() {
    configureContentNegotiation()
    configureDatabase()
    configureRouting()
    configureCORS()
}

fun Application.configureCORS() {
    install(CORS) {
        anyHost() // This allows any host to access your server. For production, specify your allowed hosts explicitly.
        // You can also specify hosts like this:
        // host("localhost:4200")
    }
}