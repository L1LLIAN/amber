package lol.lily.plugins

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*
import java.io.File

const val flag = "\uD83C\uDFF3️\u200D⚧️"

fun Application.configureTemplating() {
    val path = System.getenv()["PIC_PATH"] ?: "C:\\Users\\lilya\\Desktop\\amb"
    val amberPath = File(path)

    routing {
        static("imgs") {
            staticRootFolder = amberPath
            files(".")
        }

        get("/") {
            val randomImg = amberPath.listFiles()!!.random()

            call.respondHtml {
                title = "Amber"

                head {
                    meta("og:title") {
                        content = "Amber Pics!"
                    }

                    meta("og:description") {
                        content = "$flag https://a.lily.lol for random amber picture $flag"
                    }

                    meta("og:image") {
                        content = "https://a.lily.lol/imgs/${randomImg.name}"
                    }
                }

                body {
                    h1 { +"uwu" }
                }
            }
        }
    }
}

