package org.rizki.mufrizal.book.service.BookCatalogService

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class BookCatalogServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(BookCatalogServiceApplication::class.java, *args)
}
