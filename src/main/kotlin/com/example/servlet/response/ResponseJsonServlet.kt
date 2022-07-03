package com.example.servlet.response

import com.example.servlet.request.MessageBody
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet : HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

        // Content-Type: application/json
        with(resp) {
            setHeader("content-type", "application/json")
            characterEncoding = "utf-8"
        }

        val body = MessageBody(username = "mojo", age = 10)
        val result = jacksonObjectMapper().writeValueAsString(body)

        resp.writer.write(result)
    }
}
