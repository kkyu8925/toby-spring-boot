package tobyspring.helloboot

import org.springframework.dao.EmptyResultDataAccessException

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class HelloRepositoryJdbc(
    private val jdbcTemplate: JdbcTemplate
) : HelloRepository {

    override fun findHello(name: String): Hello? {
        return try {
            jdbcTemplate.queryForObject("select * from hello where name = '$name'") { rs: ResultSet, rowNum: Int ->
                Hello(rs.getString("name"), rs.getInt("count"))
            }
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

    override fun increaseCount(name: String) {
        val hello = findHello(name)
        if (hello == null) jdbcTemplate.update("insert into hello values(?, ?)", name, 1)
        else jdbcTemplate.update("update hello set count = ? where name = ?", hello.count + 1, name)
    }
}
