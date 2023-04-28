package tobyspring.helloboot

import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import tobyspring.config.MySpringBootApplication
import javax.annotation.PostConstruct

@MySpringBootApplication
class HellobootApplication(
    private val jdbcTemplate: JdbcTemplate
) {
    @PostConstruct
    fun init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)")
    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
