package org.rizki.mufrizal.book.service.BookCatalogService.helpers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created by rizkimufrizal on 6/14/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundRestHelper(id: Any, message: String) : RuntimeException("$message $id")