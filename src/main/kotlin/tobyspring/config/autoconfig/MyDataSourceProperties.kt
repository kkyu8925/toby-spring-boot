package tobyspring.config.autoconfig

import tobyspring.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "data")
data class MyDataSourceProperties(
    val driverClassName: String?,
    val url: String?,
    val username: String?,
    val password: String?,
)
