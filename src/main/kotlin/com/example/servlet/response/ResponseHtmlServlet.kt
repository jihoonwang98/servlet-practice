package com.example.servlet.response

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "responseHtmlServlet", urlPatterns = ["/response-html"])
class ResponseHtmlServlet: HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        // resp.setHeader("Content-Type", "text/html;charset=utf-8")와 같은 코드
        resp.contentType = "text/html"
        resp.characterEncoding = "utf-8"

        resp.writer.apply {
            println("<html>")
            println("<body>")
            println("   <div>안녕?</div>")
            println("</body>")
            println("</html>")
        }
    }
}
