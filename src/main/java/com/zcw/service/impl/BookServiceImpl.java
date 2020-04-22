package com.zcw.service.impl;

import com.zcw.entity.BookEntity;
import com.zcw.repository.BookRepository;
import com.zcw.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书服务实现
 * @createTime : 2020/4/22-4:14 下午
 * @copyright : ville
 * @modify : ville
 **/
@Service(value = "bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page bookByPage(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return bookRepository.findAll(pageRequest);
    }

    @Override
    public void create(BookEntity book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(@NotNull Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookEntity findById(@NotNull Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public BookEntity findByIdAndPageCount(Long id, Integer pageCount) {
        return bookRepository.findByIdAndPageCount(id, pageCount);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<BookEntity> booksPagingByPageCount(Integer page, Integer pageSize,
                                                   Integer pageCount) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return bookRepository.findByPageCount(pageCount, pageRequest);
    }

    @Override
    public List<BookEntity> booksLikeByName(String name) {
        return bookRepository.findByNameLike("%" + name + "%");
    }
}
