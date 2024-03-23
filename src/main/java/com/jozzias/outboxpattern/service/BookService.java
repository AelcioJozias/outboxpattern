package com.jozzias.outboxpattern.service;

import com.jozzias.outboxpattern.dto.BookRequest;
import com.jozzias.outboxpattern.entities.Book;

public interface BookService {

    Book save(BookRequest bookDTO);
}
