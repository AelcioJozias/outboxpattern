package com.jozzias.outboxpattern.infrastructure.job.bookoutbox;

import com.jozzias.outboxpattern.entities.BookOutbox;
import com.jozzias.outboxpattern.entities.OutboxTransactionStatus;
import com.jozzias.outboxpattern.infrastructure.rabbitMQ.QueueName;
import com.jozzias.outboxpattern.infrastructure.rabbitMQ.service.RabbitMQService;
import com.jozzias.outboxpattern.repository.BookOutboxRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledBookOutbox {

    private final RabbitMQService rabbitMQService;
    private final BookOutboxRepository bookOutboxRepository;


    public ScheduledBookOutbox(RabbitMQService rabbitMQService, BookOutboxRepository bookOutboxRepository) {
        this.rabbitMQService = rabbitMQService;
        this.bookOutboxRepository = bookOutboxRepository;
    }

    @Transactional
    @Scheduled(fixedDelay = 3000)
    public void execute() {
        List<BookOutbox> bookOutboxList = bookOutboxRepository.findBookOutboxByTransactionStatus(OutboxTransactionStatus.WAITING);
        bookOutboxList.forEach(this::send);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(BookOutbox bookOutbox) {
        Map<String, Object> bookOutboxMap = Map.of(
                "id", bookOutbox.getId(),
                "description", bookOutbox.getDescription(),
                "title", bookOutbox.getTitle(),
                "year", bookOutbox.getYear()
        );
        rabbitMQService.send(QueueName.BOOKS_QUEUE, bookOutboxMap);
        bookOutbox.setTransactionStatus(OutboxTransactionStatus.PROCESSED);
    }

}
