package tobyspring.config.autoconfig

import org.springframework.boot.context.properties.ConstructorBinding
import tobyspring.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "server")
data class ServerProperties(
    val contextPath: String
)
