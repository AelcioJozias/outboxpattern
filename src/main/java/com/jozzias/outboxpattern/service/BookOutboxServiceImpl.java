package com.jozzias.outboxpattern.service;

import com.jozzias.outboxpattern.entities.Book;
import com.jozzias.outboxpattern.entities.BookOutbox;
import com.jozzias.outboxpattern.repository.BookOutboxRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookOutboxServiceImpl implements BookOutboxService{

    private final BookOutboxRepository bookOutboxRepository;

    BookOutboxServiceImpl(BookOutboxRepository bookOutboxRepository) {
        this.bookOutboxRepository = bookOutboxRepository;
    }

    @Transactional
    @Override
    public void save(Book book) {
    BookOutbox bookOutbox = new BookOutbox();
    BeanUtils.copyProperties(book, bookOutbox);
    bookOutboxRepository.save(bookOutbox);
    }
}
