package com.klee.dormitory.utils;

public interface PasswordEncoder {

    // 对密码进行加密
    String encode(CharSequence var1);
    // 对密码进行判断匹配
    boolean matches(CharSequence var1, String var2);
}
