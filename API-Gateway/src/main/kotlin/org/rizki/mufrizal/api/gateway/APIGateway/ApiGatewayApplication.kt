package org.rizki.mufrizal.api.gateway.APIGateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ApiGatewayApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiGatewayApplication::class.java, *args)
}
