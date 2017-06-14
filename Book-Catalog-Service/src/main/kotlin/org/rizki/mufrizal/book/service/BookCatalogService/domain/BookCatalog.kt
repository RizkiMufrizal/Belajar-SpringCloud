package org.rizki.mufrizal.book.service.BookCatalogService.domain

import com.relops.snowflake.Snowflake
import org.hibernate.validator.constraints.NotEmpty
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

/**
 * Created by rizkimufrizal on 6/14/17.
 */

@Entity
@Table(name = "tb_book_catalog")
data class BookCatalog(
        @Id
        val id: Long = Snowflake(1).next(),
        @NotEmpty
        @NotNull
        val bookName: String? = null,
        @NotNull
        @Min(1)
        val bookPrice: BigDecimal? = null,
        @NotNull
        @Min(1)
        val bookTotal: Int? = null,
        @NotEmpty
        @NotNull
        @Lob
        val bookDescription: String? = null
)