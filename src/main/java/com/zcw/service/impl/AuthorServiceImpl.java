package com.zcw.service.impl;

import com.zcw.entity.AuthorEntity;
import com.zcw.repository.AuthorRepository;
import com.zcw.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书作者实现
 * @createTime : 2020/4/22-4:09 下午
 * @copyright : ville
 * @modify : ville
 **/
@Service(value = "authorService")
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public AuthorEntity findById(@NotNull Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}
