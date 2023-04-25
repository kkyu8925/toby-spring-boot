package tobyspring.config.autoconfig

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import tobyspring.config.ConditionalMyOnClass
import tobyspring.config.EnableMyConfigurationProperties
import tobyspring.config.MyAutoConfiguration
import java.sql.Driver
import javax.sql.DataSource

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties::class)
@EnableTransactionManagement
class DataSourceConfig {

    @Bean
    @ConditionalOnMissingBean
    fun hikariDataSource(properties: MyDataSourceProperties): @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource") DataSource {
        val dataSource = HikariDataSource()

        dataSource.driverClassName = properties.driverClassName
        dataSource.jdbcUrl = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = SimpleDriverDataSource()

        dataSource.setDriverClass(Class.forName(properties.driverClassName) as Class<out Driver>)
        dataSource.url = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource::class)
    @ConditionalOnMissingBean
    fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @ConditionalOnSingleCandidate(DataSource::class)
    @ConditionalOnMissingBean
    fun jdbcTransactionManager(dataSource: DataSource): JdbcTransactionManager {
        return JdbcTransactionManager(dataSource)
    }
}
