package org.rizki.mufrizal.configuration.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ConfigurationServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ConfigurationServerApplication::class.java, *args)
}
