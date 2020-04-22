package com.zcw.enums;

import lombok.Getter;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 结果
 * @createTime :2020/4/22-2:30 下午
 * @copyright : ville
 * @modify : ville
 **/

@Getter
public enum ResultEnum {
    REGISTER_FAIL(120, "注册失败"),
    REGISTER_SUCCESS(121, "注册成功"),
    USER_EXIST(122, "用户已存在"),
    USER_IS_NOT_EXIST(123, "用户不存在"),

    LOGIN_ERROR_USER_NOT_EXIST(130, "账号或密码错误"),
    LOGIN_SUCCESS(133, "登录成功"),
    LOGOUT_SUCCESS(131, "退出成功"),
    LOGOUT(132, "已经退出"),
    AUTHORIZE_FAIL(140, "认证失败，请重新登录！");

    private final int code;

    private final String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
