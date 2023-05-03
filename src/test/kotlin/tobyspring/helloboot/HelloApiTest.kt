package tobyspring.helloboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HelloApiTest {

    @Test
    fun helloApi() {
        val rest = TestRestTemplate()

        val result = rest.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, "Spring")

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.headers.getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE)
        assertThat(result.body).isEqualTo("*Hello Spring*")
    }

    @Test
    fun failsHelloApi() {
        val rest = TestRestTemplate()
        val res = rest.getForEntity(
            "http://localhost:8080/hello?name=", String::class.java
        )
        assertThat(res.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
