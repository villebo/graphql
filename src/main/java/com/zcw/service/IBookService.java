package com.zcw.service;

import com.zcw.entity.BookEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书接口
 * @createTime : 2020/4/22-3:58 下午
 * @copyright : ville
 * @modify : ville
 **/
public interface IBookService {
    Page bookByPage(Integer page, Integer pageSize);

    void   create(BookEntity book);

    void delete(Long id);

    BookEntity findById(Long id);

    BookEntity findByIdAndPageCount(Long id, Integer pageCount);

    List<BookEntity> findAll();

    Page<BookEntity> booksPagingByPageCount(Integer page, Integer pageSize, Integer pageCount);

    List<BookEntity> booksLikeByName(String name);
}
