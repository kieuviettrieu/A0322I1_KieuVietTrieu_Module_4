package com.codegym.service.book;

import com.codegym.model.Book;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService extends IGeneralService<Book> {
}
