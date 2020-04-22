package com.zcw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 图书
 * @createTime : 2020/4/22-11:26 上午
 * @copyright : ville
 * @modify : ville
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "book")
@Data
public class BookEntity extends BaseEntity implements Serializable {

    @Column(name = "book_name", length = 200)
    private String bookName;
    @Column(name = "page_count", length = 5)
    private Integer pageCount;
    @Column(name = "author_id", length = 10)
    private Long authorId;

}
