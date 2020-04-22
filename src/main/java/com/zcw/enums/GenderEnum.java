package com.zcw.enums;

import lombok.Getter;

/**
 * @author : ville
 * @version :
 * @description :
 * @createTime :2020/4/22-11:55 上午
 * @copyright :
 * @modify : ville
 **/
@Getter
public enum GenderEnum implements CodeEnum {
    UNKNOWN(0, "未知"),
    MAN(1, "男"),
    WOMAN(2, "女");
    private final int index;
    private final String name;

    GenderEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
