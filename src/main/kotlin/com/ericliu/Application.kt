package com.ericliu

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.ericliu.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureSecurity()
        configureHTTP()
        configureMonitoring()
        configureTemplating()
    }.start(wait = true)
}
