package com.jozzias.outboxpattern.dto;

import com.jozzias.outboxpattern.entities.Book;

import java.time.LocalDateTime;

public record BookRequest(String description, String title, LocalDateTime year) {
    public BookRequest(Book book) {
        this(book.getDescription(), book.getTitle(), book.getYear());
    }
}
