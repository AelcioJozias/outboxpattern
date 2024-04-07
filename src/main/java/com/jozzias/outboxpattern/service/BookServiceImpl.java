package com.jozzias.outboxpattern.service;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.dto.BookResponse;
import com.jozzias.outboxpattern.entities.Book;
import com.jozzias.outboxpattern.infrastructure.rabbitMQ.QueueName;
import com.jozzias.outboxpattern.infrastructure.rabbitMQ.service.RabbitMQService;
import com.jozzias.outboxpattern.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{

    final private BookRepository bookRepository;

    final private BookOutboxService bookOutboxService;

    public BookServiceImpl(BookRepository bookRepository, BookOutboxService bookOutboxService) {
        this.bookRepository = bookRepository;
        this.bookOutboxService = bookOutboxService;
    }

    @Transactional
    @Override
    public Book save(BookRequest bookDTO) {
        var book = bookRepository.save(new Book(bookDTO));
        bookOutboxService.save(book);
        return book;
    }

    @Override
    public synchronized void testSyncronized() {

    }
}
