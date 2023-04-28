package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HelloServiceTest {

    @Test
    fun simpleHelloService() {
        val helloService = SimpleHelloService(helloRepositoryStub)
        val ret = helloService.sayHello("Test")
        Assertions.assertThat(ret).isEqualTo("Hello Test")
    }

    @Test
    fun helloDecorator() {
        val decorator = HelloDecorator { it }
        val ret = decorator.sayHello("Test")
        Assertions.assertThat(ret).isEqualTo("*Test*")
    }

    companion object {
        private val helloRepositoryStub: HelloRepository = object : HelloRepository {
            override fun findHello(name: String): Hello? {
                return null
            }

            override fun increaseCount(name: String) {}
        }
    }
}
