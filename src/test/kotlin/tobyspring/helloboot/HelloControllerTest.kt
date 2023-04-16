package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HelloControllerTest {

    @Test
    fun helloController() {
        val helloController = HelloController { it }
        val ret = helloController.hello("Test")
        Assertions.assertThat(ret).isEqualTo("Test")
    }

    @Test
    fun failsHelloController() {
        val helloController = HelloController { it }
        Assertions.assertThatThrownBy { helloController.hello(" ") }.isInstanceOf(IllegalStateException::class.java)
        Assertions.assertThatThrownBy { helloController.hello("") }.isInstanceOf(IllegalStateException::class.java)
    }
}
