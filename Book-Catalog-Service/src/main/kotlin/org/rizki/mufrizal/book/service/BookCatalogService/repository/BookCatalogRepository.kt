package org.rizki.mufrizal.book.service.BookCatalogService.repository

import org.rizki.mufrizal.book.service.BookCatalogService.domain.BookCatalog
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 * Created by rizkimufrizal on 6/14/17.
 */
interface BookCatalogRepository : PagingAndSortingRepository<BookCatalog, Long> {
    fun findByIdBookCatalog(id: Long): Optional<BookCatalog>
}