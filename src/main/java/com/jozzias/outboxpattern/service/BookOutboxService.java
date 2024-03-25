package com.jozzias.outboxpattern.service;

import com.jozzias.outboxpattern.entities.Book;

public interface BookOutboxService {
    void save(Book book);
}
