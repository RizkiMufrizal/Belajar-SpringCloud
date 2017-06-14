package org.rizki.mufrizal.book.service.BookCatalogService

import org.rizki.mufrizal.book.service.BookCatalogService.domain.BookCatalog
import org.rizki.mufrizal.book.service.BookCatalogService.repository.BookCatalogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import java.math.BigDecimal

@SpringBootApplication
@EnableDiscoveryClient
class BookCatalogServiceApplication @Autowired constructor(val bookCatalogRepository: BookCatalogRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        bookCatalogRepository.deleteAll()
        for (i in 1..10) {
            bookCatalogRepository.save(
                    BookCatalog(
                            bookName = "Buku ke $i",
                            bookTotal = i,
                            bookPrice = BigDecimal(i * 10),
                            bookDescription = "buku ini merupakan buku dengan deskripsi $i"
                    )
            )
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BookCatalogServiceApplication::class.java, *args)
}
