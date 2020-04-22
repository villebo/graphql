package com.zcw.service.impl;

import com.zcw.entity.UserEntity;
import com.zcw.repository.UserRepository;
import com.zcw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 用户
 * @createTime : 2020/4/22-4:42 下午
 * @copyright : ville
 * @modify : ville
 **/
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository  userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName,password);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserEntity findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<UserEntity> userByGender(int gender) {
        return userRepository.findByGender(gender);
    }
}
