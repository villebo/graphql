package com.zcw.datafetcher;

import com.zcw.entity.BookEntity;
import com.zcw.service.IAuthorService;
import com.zcw.service.IBookService;
import com.zcw.util.MapToBeanUtil;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.LinkedHashMap;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书数据获取器
 * @createTime : 2020/4/22-6:54 下午
 * @copyright : ville
 * @modify : ville
 **/
@Component
public class BookDataFetcher {
    @Autowired
    private IBookService bookService;
   @Autowired
    private IAuthorService authorService;


    /**
     * 添加
     */
    public DataFetcher createBook() {
        return dataFetchingEnv -> {
            LinkedHashMap  bookMap = dataFetchingEnv.getArgument("book");
            BookEntity book = (BookEntity) MapToBeanUtil.entity(new Book(), bookMap);
            bookService.create(book);
            return book;
        };
    }

    /**
     * 根据id删除
     */
    public DataFetcher deleteBook() {
        return dataFetchingEnvironment -> {
            Long bookId = dataFetchingEnvironment.getArgument("id");
            bookService.delete(bookId);
            return  null;
        };
    }


    /**
     * 修改
     */
    public DataFetcher modifyBook() {
        return dataFetcherEvn -> {
            Long id = dataFetcherEvn.getArgument("id");
            LinkedHashMap hashMap = dataFetcherEvn.getArgument("book");
            BookEntity book = bookService.findById(id);
            BookEntity booked = (BookEntity) MapToBeanUtil.entity(book, hashMap);
            bookService.create(booked);
            return book;
        };
    }

    /**
     * 查询所有
     */
    public DataFetcher books() {
        return evn -> bookService.findAll();
    }

    /**
     * 分页查询
     */
    public DataFetcher booksPaging() {
        return dataFetchingEvn -> {
            Integer page = dataFetchingEvn.getArgument("page");
            Integer pageSize = dataFetchingEvn.getArgument("pageSize");
            Page bookPage = bookService.bookByPage(page, pageSize);
            return bookPage.getContent();
        };
    }

    /**
     * 根据条件分页查询
     */
    public DataFetcher booksPagingByPageCount() {
        return dataFetchingEnvironment -> {
            Integer pageCount = dataFetchingEnvironment.getArgument("pageCount");
            Integer page = dataFetchingEnvironment.getArgument("page");
            Integer pageSize = dataFetchingEnvironment.getArgument("pageSize");
            return bookService.booksPagingByPageCount(page, pageSize,pageCount).getContent();
        };
    }


    /**
     * 根据条件模糊查询
     */
    public DataFetcher booksLikeByName() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return bookService.booksLikeByName(name);
        };
    }

    /**
     * 多条件查询
     */
    public DataFetcher bookByPageCountAndId() {
        return dataFetchingEnvironment -> {
            Integer pageCount = dataFetchingEnvironment.getArgument("pageCount");
            Long bookId = dataFetchingEnvironment.getArgument("id");
            return bookService.findByIdAndPageCount(bookId, pageCount);
        };
    }

    /**
     * 根据id查询
     */
    public DataFetcher bookById() {

        return dataFetchingEnvironment -> {
            Long bookId = dataFetchingEnvironment.getArgument("id");
            return bookService.findById(bookId);
        };
    }

    public DataFetcher author() {
        return dataFetchingEnvironment -> {
            BookEntity book = dataFetchingEnvironment.getSource();
            Long authorId = book.getAuthorId();
            return  authorService.findById(authorId);
        };
    }

}
