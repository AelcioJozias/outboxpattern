package com.jozzias.outboxpattern.repository;

import com.jozzias.outboxpattern.entities.BookOutbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookOutboxRepository extends JpaRepository<BookOutbox, UUID> {
}
