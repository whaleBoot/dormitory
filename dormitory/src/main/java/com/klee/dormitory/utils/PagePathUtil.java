package com.klee.dormitory.utils;

import com.klee.dormitory.domain.PagePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PagePathUtil {
    PagePath pagePath=new PagePath();

    public PagePath myPage(String path){
        pagePath.setMypath(path);
        return pagePath;
    }

}
