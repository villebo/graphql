package com.zcw.repository;

import com.zcw.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 获取作者数据访问dao
 * @createTime : 2020/4/22-2:55 下午
 * @copyright : ville
 * @modify : ville
 **/
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
