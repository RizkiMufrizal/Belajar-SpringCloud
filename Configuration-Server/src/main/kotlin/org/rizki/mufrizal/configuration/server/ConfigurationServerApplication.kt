package org.rizki.mufrizal.configuration.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
class ConfigurationServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ConfigurationServerApplication::class.java, *args)
}
