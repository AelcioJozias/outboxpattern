package com.jozzias.outboxpattern.dto;

import com.jozzias.outboxpattern.entities.Book;

import java.time.LocalDateTime;

public record BookResponse(Long id, String description, String title, LocalDateTime year) {
    public BookResponse(Book book) {
        this(book.getId(), book.getDescription(), book.getTitle(), book.getYear());
    }
}
