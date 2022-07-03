package com.example.servlet.request

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet : HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

        printStartLine(req)
        printHeaders(req)
        printHeaderUtils(req)
        printEtc(req)

        resp.writer.write("ok")
    }

    private fun printStartLine(req: HttpServletRequest) {
        println("--- REQUEST-LINE - start ---")

        println("request.method = ${req.method}"); // GET
        println("request.protocol = ${req.protocol}"); // HTTP/1.1
        println("request.scheme = ${req.scheme}"); // http
        println("request.requestURL = ${req.requestURL}"); // http://localhost:8080/request-header
        println("request.requestURI = ${req.requestURI}"); // /request-header
        println("request.queryString = ${req.queryString}") // username=hi
        println("request.isSecure = ${req.isSecure}"); // https 사용 유무

        println("--- REQUEST-LINE - end ---");
        println();
    }

    private fun printHeaders(req: HttpServletRequest) {
        println("--- Headers - start ---")

        for (headerName in req.headerNames) {
            println("$headerName: ${req.getHeader(headerName)}")
        }
        println()

        println("--- Headers - end ---")
        println()
    }

    private fun printHeaderUtils(req: HttpServletRequest) {
        println("--- Header 편의 조회 start ---")

        println("[Host 편의 조회]")
        println("request.serverName = ${req.serverName}") // Host 헤더
        println("request.serverPort = ${req.serverPort}") // Host 헤더
        println()

        println("[Accept-Language 편의 조회]")
        for (locale in req.locales) {
            println("locale = $locale")
        }
        println("request.locale = ${req.locale}")
        println()

        println("[cookie 편의 조회]")
        req.cookies?.let {
            for (cookie in it) {
                println("${cookie.name}: ${cookie.value}")
            }
        }
        println()

        println("[Content 편의 조회]")
        println("request.contentType = ${req.contentType}")
        println("request.contentLength = ${req.contentLength}")
        println("request.characterEncoding = ${req.characterEncoding}")
        println()

        println("--- Header 편의 조회 end ---")
        println()
    }

    // 기타 정보는 HTTP 메시지의 정보는 아니다.
    private fun printEtc(req: HttpServletRequest) {
        println("--- 기타 조회 start ---")

        println("[Remote 정보]")
        println("request.remoteHost = ${req.remoteHost}")
        println("request.remoteAddr = ${req.remoteAddr}")
        println("request.remotePort = ${req.remotePort}")
        println()

        println("[Local 정보]")
        println("request.localName = ${req.localName}")
        println("request.localAddr = ${req.localAddr}")
        println("request.localPort = ${req.localPort}")
        println()

        println("--- 기타 조회 end ---")
        println()
    }
}
