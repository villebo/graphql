package com.zcw.repository;

import com.zcw.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书信息数据访问层
 * @createTime : 2020/4/22-3:00 下午
 * @copyright : ville
 * @modify : ville
 **/
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    BookEntity findByIdAndPageCount(Long id, Integer pageCount);

    Page<BookEntity> findByPageCount(Integer pageCount, Pageable pageable);

    List<BookEntity> findByNameLike(String name);
}
