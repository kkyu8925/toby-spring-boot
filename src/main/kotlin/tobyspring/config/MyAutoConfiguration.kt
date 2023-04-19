package tobyspring.config

import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.TYPE, AnnotationTarget.CLASS])
@Configuration(proxyBeanMethods = false)
annotation class MyAutoConfiguration
