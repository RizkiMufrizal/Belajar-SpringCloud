package org.rizki.mufrizal.book.service.BookCatalogService.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import javax.sql.DataSource

/**
 * Created by rizkimufrizal on 6/14/17.
 */
@Configuration
class DataSourceConfiguration @Autowired constructor(val environment: Environment) {

    @Value("\${spring.datasource.url}")
    val url: String? = null

    @Value("\${spring.datasource.username}")
    val username: String? = null

    @Value("\${spring.datasource.password}")
    val password: String? = null

    @Bean(destroyMethod = "close")
    fun dataSource(): DataSource {
        val dataSourceConfig = HikariConfig()
        dataSourceConfig.driverClassName = environment.getRequiredProperty("spring.datasource.driver-class-name")
        dataSourceConfig.jdbcUrl = url
        dataSourceConfig.username = username
        dataSourceConfig.password = password
        dataSourceConfig.maximumPoolSize = environment.getRequiredProperty("spring.datasource.maximumPoolSize").toInt()
        dataSourceConfig.minimumIdle = environment.getRequiredProperty("spring.datasource.minimumIdle").toInt()
        dataSourceConfig.connectionTimeout = environment.getRequiredProperty("spring.datasource.connectionTimeout").toLong()
        dataSourceConfig.idleTimeout = environment.getRequiredProperty("spring.datasource.idleTimeout").toLong()
        dataSourceConfig.addDataSourceProperty("poolName", environment.getRequiredProperty("spring.datasource.poolName"))
        dataSourceConfig.addDataSourceProperty("cachePrepStmts", true)
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", 250)
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048)
        return HikariDataSource(dataSourceConfig)
    }
}