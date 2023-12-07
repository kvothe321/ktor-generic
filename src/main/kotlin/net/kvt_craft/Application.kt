package net.kvt_craft

import io.ktor.server.application.*
import net.kvt_craft.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
}
