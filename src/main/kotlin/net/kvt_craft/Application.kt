package net.kvt_craft

import io.ktor.server.application.*
import net.kvt_craft.plugins.configureDatabase
import net.kvt_craft.plugins.configureRouting

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabase()
    configureRouting()
}
