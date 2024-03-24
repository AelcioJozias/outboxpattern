package com.jozzias.outboxpattern.dto;

import com.jozzias.outboxpattern.entities.Book;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public record BookRequest(
        @Schema(description = "Description of the book", example = "Great book", nullable = false, requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank String description,
        @Schema(description = "Title of the book", example = "Awesome Book", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank String title,
        @Schema(description = "Year of the book", requiredMode = Schema.RequiredMode.REQUIRED
        ,type = "string",  example = "2024-02-24T07:57:45"
        )
        @NotNull LocalDateTime year
) implements Serializable {
    public BookRequest(Book book) {
        this(book.getDescription(), book.getTitle(), book.getYear());
    }
}