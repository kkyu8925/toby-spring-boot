package tobyspring.helloboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService
) {

    @GetMapping("/hello")
    fun hello(name: String): String {
        check(name.isNotBlank())
        return helloService.sayHello(name)
    }

    @GetMapping("/count")
    fun count(name: String): String {
        return "$name: ${helloService.countOf(name)}"
    }
}
