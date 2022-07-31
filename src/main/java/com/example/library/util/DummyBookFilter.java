package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Component
public class DummyBookFilter {

    private final BookService bookService;

    public DummyBookFilter(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    public void init(){
        bookService.addBook(new Book(null, "A Game of Thrones", "Publicado en 1996", "George R. R. Martin", 25, 3));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "A Clash of Kings", "Publicado en 1998", "George R. R. Martin", 25, 3));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "A Storm of Swords ", "Publicado en 2000", "George R. R. Martin", 30, 5));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "A Feast for Crows", "Publicado en 2005", "George R. R. Martin", 35, 8));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "A Dance with Dragons", "Publicado en 2011", "George R. R. Martin", 40, 8));
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        bookService.addBook(new Book(null, "The Shining", "Publicado en 1977", "Stephen King", 50, 5));
        

    }
    
}
