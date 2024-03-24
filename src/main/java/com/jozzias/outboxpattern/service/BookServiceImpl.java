package com.jozzias.outboxpattern.service;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.dto.BookResponse;
import com.jozzias.outboxpattern.entities.Book;
import com.jozzias.outboxpattern.infrastructure.rabbitMQ.QueueName;
import com.jozzias.outboxpattern.infrastructure.rabbitMQ.service.RabbitMQService;
import com.jozzias.outboxpattern.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    final private BookRepository bookRepository;

    final private RabbitMQService rabbitMQService;

    public BookServiceImpl(BookRepository bookRepository, RabbitMQService rabbitMQService) {
        this.bookRepository = bookRepository;
        this.rabbitMQService = rabbitMQService;
    }

    @Override
    public Book save(BookRequest bookDTO) {
        var bookResponse = bookRepository.save(new Book(bookDTO));
        rabbitMQService.send(QueueName.BOOKS_QUEUE, new BookResponse(bookResponse));
        return bookResponse;
    }
}
