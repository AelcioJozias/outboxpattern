package com.jozzias.outboxpattern.entities;


import com.jozzias.outboxpattern.dto.BookRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "book")
@Data
@Setter
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private UUID UUID;

    private String description;

    private String title;

    private LocalDateTime year;

    @PrePersist
    private void generateUUID() {
        this.UUID = (java.util.UUID.randomUUID());
    }

    public Book(BookRequest bookRequest) {
        this.title = bookRequest.title();
        this.year = bookRequest.year();
        this.description = bookRequest.description();
    }

}


