package tobyspring.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalTest {

    @Test
    fun conditional() {
        // true
        val contextRunner = ApplicationContextRunner()
        contextRunner.withUserConfiguration(Config1::class.java).run {
            Assertions.assertThat(it).hasSingleBean(MyBean::class.java)
            Assertions.assertThat(it).hasSingleBean(Config1::class.java)
        }

        // false
        ApplicationContextRunner().withUserConfiguration(Config2::class.java).run {
            Assertions.assertThat(it).doesNotHaveBean(MyBean::class.java)
            Assertions.assertThat(it).doesNotHaveBean(Config1::class.java)
        }
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    internal annotation class BooleanConditional(
        val value: Boolean
    )

    @Configuration
    @BooleanConditional(true)
    internal class Config1 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    @Configuration
    @BooleanConditional(false)
    internal class Config2 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    internal class MyBean

    internal class BooleanCondition : Condition {

        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            val annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional::class.java.name)
            if (annotationAttributes != null) {
                return annotationAttributes["value"] as Boolean
            }
            return false
        }
    }
}
