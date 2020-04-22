package com.zcw.service;

import com.zcw.entity.AuthorEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 作者服务
 * @createTime : 2020/4/22-3:52 下午
 * @copyright : ville
 * @modify : ville
 **/
public interface IAuthorService {
    AuthorEntity findById(@NotNull Long id);
}
