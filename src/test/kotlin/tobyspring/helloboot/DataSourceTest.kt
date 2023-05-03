package tobyspring.helloboot

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import javax.sql.DataSource

@JdbcTest
class DataSourceTest @Autowired constructor(
    private val dataSource: DataSource
) {

    @Test
    fun connect() {
        val connection = dataSource.connection
        connection.close()
    }
}
