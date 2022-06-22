package lol.lily.plugins

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*
import java.io.File

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
                    meta {
                        httpEquiv = "cache-control"
                        content = "max-age=0"
                    }

                    meta {
                        httpEquiv = "cache-control"
                        content = "no-cache"
                    }

                    meta {
                        httpEquiv = "expires"
                        content = "0"
                    }

                    meta {
                        httpEquiv = "expires"
                        content = "Tue, 01 Jan 1980 1:00:00 GMT"
                    }

                    meta {
                        httpEquiv = "pragma"
                        content = "no-cache"
                    }

                    meta("viewport") {
                        content = "width=device-width, minimum-scale=0.1"
                    }

                    meta("twitter:card") {
                        content = "summary_large_image"
                    }

                    meta("theme-color") {
                        content = "#d154ff"
                    }

                    meta("og:url") {
                        content = "https://a.lily.lol/${randomImg.name}"
                    }

                    meta("og:title") {
                        content = "Amber Pics!"
                    }

                    meta("og:description") {
                        content = "https://a.lily.lol for random amber picture"
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

