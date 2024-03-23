package com.jozzias.outboxpattern.repository;

import com.jozzias.outboxpattern.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
