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
 * @description : 图书作者
 * @createTime : 2020/4/22-11:11 上午
 * @copyright : ville
 * @modify : ville
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity implements Serializable {
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
}
