package com.zcw.entity;

import com.zcw.enums.GenderEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 用户
 * @createTime : 2020/4/22-11:50 上午
 * @copyright : ville
 * @modify : ville
 **/

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@Data
public class UserEntity extends BaseEntity implements Serializable {

    /** 平台用户姓名 */
    @Column(name = "user_name",length = 50)
    private String userName;

    /** 平台用户密码 */
    @Column(name = "password",length = 50)
    private String password;

    /** 性别 默认未知 0 男 1 女 2*/
    @Column(name = "gender",length = 2)
    private Integer gender = GenderEnum.UNKNOWN.getCode();

    /** 手机号 */
    @Column(name = "phone", length = 14)
    private String phone;
}
