package tobyspring.config

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.TYPE, AnnotationTarget.CLASS])
@Component
annotation class MyConfigurationProperties(
    val prefix: String
)
