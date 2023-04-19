package tobyspring.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigurationTest {

    @Test
    fun configuration() {
        val ac = AnnotationConfigApplicationContext()
        ac.register(MyConfig::class.java)
        ac.refresh()

        val bean1 = ac.getBean(Bean1::class.java)
        val bean2 = ac.getBean(Bean2::class.java)

        Assertions.assertThat(bean1.common).isSameAs(bean2.common)
    }

    @Test
    fun proxyCommonMethod() {
        val myConfigProxy = MyConfigProxy()

        val bean1: Bean1 = myConfigProxy.bean1()
        val bean2: Bean2 = myConfigProxy.bean2()

        Assertions.assertThat(bean1.common).isSameAs(bean2.common)
    }

    internal class MyConfigProxy : MyConfig() {
        private var common: Common? = common()

        final override fun common(): Common {
            if (common == null) common = super.common()
            return common!!
        }
    }

    @Configuration
    internal class MyConfig {

        @Bean
        fun common(): Common {
            return Common()
        }

        @Bean
        fun bean1(): Bean1 {
            return Bean1(common())
        }

        @Bean
        fun bean2(): Bean2 {
            return Bean2(common())
        }
    }

    internal class Bean1(val common: Common)
    internal class Bean2(val common: Common)
    internal class Common
}
