package tobyspring.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.TYPE, AnnotationTarget.CLASS])
@Configuration
@ComponentScan
@EnableMyAutoConfiguration
annotation class MySpringBootApplication
