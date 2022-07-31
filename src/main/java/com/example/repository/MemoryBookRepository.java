package com.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public class MemoryBookRepository implements BookRepository {

    private Map<String, Book> booksMap;

    public MemoryBookRepository(){
        booksMap = new HashMap<>();
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.addAll(booksMap.values());
        return books;
    }

    @Override
    public Book get(String bookId) {
        return booksMap.get(bookId);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        
        return booksMap.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().indexOf(author.toLowerCase())  >= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        
        return booksMap.values().stream()
        .filter(book -> book.getTitle().toLowerCase().indexOf(title.toLowerCase())  >= 0)
        .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorAndTitle(String author, String title) {
        
        return booksMap.values().stream()
        .filter(book -> book.getAuthor().toLowerCase().indexOf(author.toLowerCase())  >= 0)
        .filter(book -> book.getTitle().toLowerCase().indexOf(title.toLowerCase())  >= 0)
        .collect(Collectors.toList());
    }
    

    @Override
    public Book save(Book book) {
        if(book.getBookId() == null){
            book.setBookId(String.valueOf(System.currentTimeMillis()));
        }
        booksMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Book delete(String bookId) {
        return booksMap.remove(bookId);
    }

}
