package com.codegym.service.book;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
