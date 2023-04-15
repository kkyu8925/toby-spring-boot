package tobyspring.helloboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HellobootApplication

fun main(args: Array<String>) {
    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer(ServletContextInitializer {
        val helloController = HelloController()

        it.addServlet("frontcontroller", object : HttpServlet() {
            override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
                // 인증, 보안, 다국어, 공통 기능
                if (req.requestURI.equals("/hello") && req.method.equals(HttpMethod.GET.name)) {
                    val name = req.getParameter("name")

                    val result = helloController.hello(name)

                    resp.status = HttpStatus.OK.value()
                    resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                    resp.writer.println(result)
                } else if (req.requestURI.equals("/user")) {
                    //
                } else {
                    resp.status = HttpStatus.NOT_FOUND.value();
                }
            }
        }).addMapping("/*")
    })
    webServer.start()
}
