package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.IntStream

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HelloServiceCountTest @Autowired constructor(
    val helloService: HelloService, var helloRepository: HelloRepository
) {

    @Test
    fun sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach {
            helloService.sayHello("Toby")
            Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(it)
        }
    }
}
