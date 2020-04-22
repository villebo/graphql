package com.zcw.provider;

import com.zcw.datafetcher.BookDataFetcher;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书提供者
 * @createTime : 2020/4/22-6:53 下午
 * @copyright : ville
 * @modify : ville
 **/

@Component
public class BookProvider {
    @Autowired
    public BookDataFetcher bookDataFetcher;

    public final String schema_path = "static/schema/schema-book.graphql";

    //查询
    public TypeRuntimeWiring.Builder buildQueryRuntimeWiring() {
        return newTypeWiring("Query")
                .dataFetcher("books", bookDataFetcher.books())
                .dataFetcher("bookById", bookDataFetcher.bookById())
                .dataFetcher("bookByPageCountAndId", bookDataFetcher.bookByPageCountAndId())
                .dataFetcher("booksPaging", bookDataFetcher.booksPaging())
                .dataFetcher("booksPagingByPageCount", bookDataFetcher.booksPagingByPageCount())
                .dataFetcher("booksLikeByName", bookDataFetcher.booksLikeByName());
    }

    //更新
    public TypeRuntimeWiring.Builder buildMutationRuntimeWiring() {
        return newTypeWiring("Mutation")
                .dataFetcher("modifyBook", bookDataFetcher.modifyBook())
                .dataFetcher("createBook", bookDataFetcher.createBook())
                .dataFetcher("deleteBook", bookDataFetcher.deleteBook());
    }

    public TypeRuntimeWiring.Builder buildBookRuntimeWiring() {
        return newTypeWiring("Book")
                .dataFetcher("author", bookDataFetcher.author());
    }
}
