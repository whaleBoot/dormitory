package com.klee.dormitory.utils;

import com.klee.dormitory.enums.PermissionEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;


import java.lang.annotation.Annotation;

@Configuration
public class StringToPermissionEnums implements Converter<String, PermissionEnum> {

    @Override
    public PermissionEnum convert(String s) {
        System.out.println("s = [" + s + "]");
        String value = s.trim();
        if ("".equals(value)) {
            return null;
        }
        return PermissionEnum.get(Integer.parseInt(value));
    }
}
