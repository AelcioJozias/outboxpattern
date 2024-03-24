package com.jozzias.outboxpattern.controller;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.dto.BookResponse;
import com.jozzias.outboxpattern.service.BookService;
import com.jozzias.outboxpattern.swagger.BookControllerSwagger;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController implements BookControllerSwagger {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookResponse save(@Valid @RequestBody BookRequest bookRequest) {
        var book = bookService.save(bookRequest);
        return new BookResponse(book);
    }
}
