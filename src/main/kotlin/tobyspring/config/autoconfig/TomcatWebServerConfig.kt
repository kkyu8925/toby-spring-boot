package tobyspring.config.autoconfig

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import tobyspring.config.ConditionalMyOnClass
import tobyspring.config.EnableMyConfigurationProperties
import tobyspring.config.MyAutoConfiguration

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties::class)
class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(properties: ServerProperties): ServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()

        factory.contextPath = properties.contextPath

        return factory
    }
}
