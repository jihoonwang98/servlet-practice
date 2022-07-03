package com.example.servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", urlPatterns = ["/hello"])
class HelloServlet : HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("HelloServlet.service")
        println("request = $req")
        println("response = $resp")

        val username = req.getParameter("username")
        println("username = $username")

        resp.apply {
            contentType = "text/plain"
            characterEncoding = "utf-8"
            writer.write("hello $username")
        }
    }
}
