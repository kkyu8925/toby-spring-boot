package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.stream.IntStream

@HellobootTest
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
