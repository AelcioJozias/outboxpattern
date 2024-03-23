package com.jozzias.outboxpattern.controller;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.dto.BookResponse;
import com.jozzias.outboxpattern.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookResponse save(@RequestBody BookRequest bookRequest) {
        var book = bookService.save(bookRequest);
        return new BookResponse(book);
    }
}
