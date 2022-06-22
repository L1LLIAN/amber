package lol.lily

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import lol.lily.plugins.*

fun main() {
    embeddedServer(Netty, port = 80, host = "0.0.0.0") {
        configureTemplating()
    }.start(wait = true)
}
