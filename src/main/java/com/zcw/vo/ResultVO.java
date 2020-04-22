package com.zcw.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author : ville
 * @version : 1.0.0
 * @description : 结果
 * @createTime : 2020/4/22-5:59 下午
 * @copyright : ville
 * @modify : ville
 **/
@Data
public class ResultVO<T> {
    /** 错误码 */
    private int code;

    /** 提示信息 */
    private String message;

    /** 返回的数据 */
    @JsonProperty("data")
    private T data;
}
