package com.example.servlet.request

import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestBodyStringServlet", urlPatterns = ["/request-body-string"])
class RequestBodyStringServlet: HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val messageBody = StreamUtils.copyToString(req.inputStream, StandardCharsets.UTF_8)
        println("messageBody = $messageBody")
        resp.writer.write("ok")
    }
}
