package com.jozzias.outboxpattern.dto;

import com.jozzias.outboxpattern.entities.Book;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookResponse(UUID id, String description, String title, LocalDateTime year) implements Serializable {
    public BookResponse(Book book) {
        this(book.getId(), book.getDescription(), book.getTitle(), book.getYear());
    }
}
