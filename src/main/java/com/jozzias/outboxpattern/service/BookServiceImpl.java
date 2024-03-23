package com.jozzias.outboxpattern.service;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.entities.Book;
import com.jozzias.outboxpattern.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(BookRequest bookDTO) {
        return bookRepository.save(new Book(bookDTO));
    }
}
