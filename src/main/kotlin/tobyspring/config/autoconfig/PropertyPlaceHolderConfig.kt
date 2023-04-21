package tobyspring.config.autoconfig

import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import tobyspring.config.MyAutoConfiguration

@MyAutoConfiguration
class PropertyPlaceHolderConfig {

    @Bean
    fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }
}
