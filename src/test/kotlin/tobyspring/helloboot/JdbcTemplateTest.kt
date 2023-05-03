package tobyspring.helloboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate

@JdbcTest
class JdbcTemplateTest @Autowired constructor(
    val jdbcTemplate: JdbcTemplate
) {

    @BeforeEach
    fun init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)")
    }

    @Test
    fun insertAndQuery() {
        jdbcTemplate.update("insert into hello values(?, ?)", "Toby", 3)
        jdbcTemplate.update("insert into hello values(?, ?)", "Spring", 1)
        val count = jdbcTemplate!!.queryForObject("select count(*) from hello", Long::class.java)
        assertThat(count).isEqualTo(2)
    }
}
