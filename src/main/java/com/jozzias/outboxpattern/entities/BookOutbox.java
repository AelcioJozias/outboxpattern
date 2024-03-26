package com.jozzias.outboxpattern.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class BookOutbox  {
    @Id
    private UUID id;
    private String description;
    private String title;
    private LocalDateTime year;
    @Enumerated(EnumType.STRING)
    private OutboxTransactionStatus transactionStatus = OutboxTransactionStatus.WAITING;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
