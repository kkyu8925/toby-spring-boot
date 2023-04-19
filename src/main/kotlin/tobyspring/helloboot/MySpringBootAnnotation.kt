package tobyspring.helloboot

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(value = AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.TYPE, AnnotationTarget.CLASS])
@Configuration
@ComponentScan
annotation class MySpringBootAnnotation
