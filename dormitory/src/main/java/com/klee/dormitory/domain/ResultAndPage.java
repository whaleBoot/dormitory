package com.klee.dormitory.domain;

import lombok.Data;

@Data
public class ResultAndPage<T> {
    /**
     * 错误码
     **/
    private Integer code;

    /**
     * 提示信息
     **/
    private String msg;

    /**
     * 具体内容
     **/
    private T data;
    /**
     * 页面
     */
    private String page;


}
