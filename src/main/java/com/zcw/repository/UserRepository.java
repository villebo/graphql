package com.zcw.repository;

import com.zcw.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 用户dao
 * @createTime : 2020/4/22-4:38 下午
 * @copyright : ville
 * @modify : ville
 **/
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserNameAndPassword(String userName, String password);

    UserEntity findByUserName(String username);

    List<UserEntity> findByGender(int gender);
}
