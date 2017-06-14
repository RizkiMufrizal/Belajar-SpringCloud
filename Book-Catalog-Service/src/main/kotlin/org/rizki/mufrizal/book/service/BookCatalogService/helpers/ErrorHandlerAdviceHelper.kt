package org.rizki.mufrizal.book.service.BookCatalogService.helpers

import org.springframework.hateoas.VndErrors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


/**
 * Created by rizkimufrizal on 6/14/17.
 */
@ControllerAdvice
class ErrorHandlerAdviceHelper {

    @ResponseBody
    @ExceptionHandler(NotFoundRestHelper::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun idNotFoundExceptionHandler(notFoundRestHelper: NotFoundRestHelper) = VndErrors("error", notFoundRestHelper.message)

}