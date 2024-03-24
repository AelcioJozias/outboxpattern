package com.jozzias.outboxpattern.swagger;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.dto.BookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Books", description = "Endpoints for book operations")
public interface BookControllerSwagger {
    @Operation(summary = "Save a book")
    BookResponse save(@RequestBody BookRequest bookRequest);
}
