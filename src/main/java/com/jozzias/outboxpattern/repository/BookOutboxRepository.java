package com.jozzias.outboxpattern.repository;

import com.jozzias.outboxpattern.entities.BookOutbox;
import com.jozzias.outboxpattern.entities.OutboxTransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookOutboxRepository extends JpaRepository<BookOutbox, UUID> {
    List<BookOutbox> findBookOutboxByTransactionStatus(OutboxTransactionStatus status);
}
