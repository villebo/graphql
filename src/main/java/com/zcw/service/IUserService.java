package com.zcw.service;

import com.zcw.entity.UserEntity;

import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 用户服务
 * @createTime : 2020/4/22-4:08 下午
 * @copyright : ville
 * @modify : ville
 **/
public interface IUserService {

    UserEntity save(UserEntity user);

    UserEntity findByUserNameAndPassword(String userName, String password);

    UserEntity findByUserName(String userName);

    UserEntity findById(Long userId);

    List<UserEntity> userByGender(int gender);
}
