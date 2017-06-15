package org.rizki.mufrizal.book.service.BookCatalogService.controller

import org.rizki.mufrizal.book.service.BookCatalogService.domain.BookCatalog
import org.rizki.mufrizal.book.service.BookCatalogService.helpers.HateoasResource
import org.rizki.mufrizal.book.service.BookCatalogService.helpers.NotFoundRestHelper
import org.rizki.mufrizal.book.service.BookCatalogService.helpers.ValidationIdHelper
import org.rizki.mufrizal.book.service.BookCatalogService.repository.BookCatalogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created by rizkimufrizal on 6/14/17.
 */
@CrossOrigin(
        methods = arrayOf(RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS),
        origins = arrayOf("*"),
        maxAge = 3600,
        allowedHeaders = arrayOf("accept", "authorization", "x-requested-with", "content-type")
)
@RestController
@RequestMapping(value = "/api")
class BookCatalogController @Autowired constructor(val bookCatalogRepository: BookCatalogRepository) : ValidationIdHelper {

    @GetMapping(value = "/books")
    fun getBooks(): ResponseEntity<*> {
        val hateoasResource = HateoasResource(bookCatalogRepository.findAll())
        hateoasResource.add(linkTo(methodOn(BookCatalogController::class.java).getBooks()).withSelfRel())
        return ResponseEntity(hateoasResource, HttpStatus.OK)
    }

    @PostMapping(value = "/books")
    fun saveBook(@RequestBody @Valid bookCatalog: BookCatalog): ResponseEntity<*> {
        val bookCatalog1 = bookCatalogRepository.save(
                BookCatalog(
                        bookName = bookCatalog.bookName,
                        bookDescription = bookCatalog.bookDescription,
                        bookPrice = bookCatalog.bookPrice,
                        bookTotal = bookCatalog.bookTotal
                )
        )

        val hateoasResource = HateoasResource(bookCatalog1)
        hateoasResource.add(linkTo(methodOn(BookCatalogController::class.java).getBook(bookCatalog1.id)).withSelfRel())
        return ResponseEntity(hateoasResource, HttpStatus.CREATED)
    }

    @GetMapping(value = "/books/{id}")
    fun getBook(@PathVariable("id") id: Long): BookCatalog {
        this.validateSelf(id)
        return bookCatalogRepository.findOne(id) ?: throw NotFoundRestHelper(id, "Data Catalog Tidak Tersedia")
    }

    @PutMapping(value = "/books/{id}")
    fun updateBook(@RequestBody @Valid bookCatalog: BookCatalog, @PathVariable("id") id: Long): ResponseEntity<*> {
        this.validateSelf(id)
        val bookCatalog1 = bookCatalogRepository.save(
                BookCatalog(
                        id = id,
                        bookName = bookCatalog.bookName,
                        bookDescription = bookCatalog.bookDescription,
                        bookPrice = bookCatalog.bookPrice,
                        bookTotal = bookCatalog.bookTotal
                )
        )

        val hateoasResource = HateoasResource(bookCatalog1)
        hateoasResource.add(linkTo(methodOn(BookCatalogController::class.java).getBook(bookCatalog1.id)).withSelfRel())
        return ResponseEntity(hateoasResource, HttpStatus.OK)
    }

    @DeleteMapping(value = "/books/{id}")
    fun deleteApdtools(@PathVariable("id") id: Long): ResponseEntity<*> {
        this.validateSelf(id)
        bookCatalogRepository.delete(id)
        return ResponseEntity(HateoasResource(null), HttpStatus.OK)
    }

    override fun validateSelf(id: Long) {
        bookCatalogRepository.findOne(id) ?: throw NotFoundRestHelper(id, "Data Catalog Tidak Tersedia")
    }
}