package com.example.servlet.request

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestParamServlet", urlPatterns = ["/request-param"])
class RequestParamServlet : HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println("[전체 파라미터 조회] - start")
        for (parameterName in req.parameterNames) {
            println("$parameterName=${req.getParameter(parameterName)}")
        }
        println("[전체 파라미터 조회] - end")
        println()

        println("[단일 파라미터 조회]")
        val username: String? = req.getParameter("username")
        println("request.getParameter(username) = $username")
        val age: Int? = req.getParameter("age")?.toIntOrNull()
        println("request.getParameter(age) = $age")
        println()

        println("[이름이 같은 복수 파라미터 조회]")
        println("request.getParameterValues(username)")
        val usernames: Array<String>? = req.getParameterValues("username")
        usernames?.let {
            for (username in it) {
                println("username=$username")
            }
        }

        resp.writer.write("ok")
    }
}
