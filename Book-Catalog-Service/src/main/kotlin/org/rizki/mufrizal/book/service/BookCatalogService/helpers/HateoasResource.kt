package org.rizki.mufrizal.book.service.BookCatalogService.helpers

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.ResourceSupport

/**
 * Created by rizkimufrizal on 6/14/17.
 */
data class HateoasResource @JsonCreator constructor(@JsonProperty("content") val content: Any?) : ResourceSupport()