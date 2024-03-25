package com.jozzias.outboxpattern.entities;


import com.jozzias.outboxpattern.dto.BookRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "book")
@Data
@Setter
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    private String title;

    private LocalDateTime year;

    public Book(BookRequest bookRequest) {
        this.title = bookRequest.title();
        this.year = bookRequest.year();
        this.description = bookRequest.description();
    }

}


