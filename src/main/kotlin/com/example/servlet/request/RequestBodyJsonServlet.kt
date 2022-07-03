package com.example.servlet.request

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet: HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val messageBody = StreamUtils.copyToString(req.inputStream, StandardCharsets.UTF_8)

        val (username, age) = jacksonObjectMapper().readValue(messageBody, MessageBody::class.java)
        println("username = $username")
        println("age = $age")

        resp.writer.write("ok")
    }
}

data class MessageBody(
    val username: String,
    val age: Int,
)
