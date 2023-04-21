package tobyspring.config

import org.springframework.context.annotation.Import
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(allowedTargets = [AnnotationTarget.TYPE, AnnotationTarget.CLASS])
@Import(MyConfigurationPropertiesImportSelector::class)
annotation class EnableMyConfigurationProperties(
    val value: KClass<*>
)
