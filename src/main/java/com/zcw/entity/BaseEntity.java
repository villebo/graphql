package com.zcw.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 实体基类
 * @createTime : 2020/4/22-11:06 上午
 * @copyright : ville
 * @modify : ville
 **/
@Data
@DynamicUpdate
@MappedSuperclass
public class BaseEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long  id;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    protected Date createTime;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",insertable = false)
    protected Date updateTime;
}
