package tobyspring.helloboot

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [HellobootApplication::class])
@TestPropertySource("classpath:/application.properties")
@Transactional
annotation class HellobootTest
