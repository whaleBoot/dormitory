package com.klee.dormitory.utils;

import com.klee.dormitory.domain.Result;
import com.klee.dormitory.domain.ResultAndPage;

/**
 * code:
 * data:
 * msg:
 */

//优化
public class ResultAndPageUtil {

    public static ResultAndPage success(Object object,String page) {

        ResultAndPage resultAndPage = new ResultAndPage();
        resultAndPage.setCode(0);
        resultAndPage.setMsg("成功");
        resultAndPage.setData(object);
        resultAndPage.setPage(page);
        return resultAndPage;
    }

    public static ResultAndPage success(String page) {
        return success(null, page);
    }

    public static ResultAndPage error(Integer code, String msg) {
        ResultAndPage resultAndPage = new ResultAndPage();
        resultAndPage.setCode(code);
        resultAndPage.setMsg(msg);
        return resultAndPage;
    }

}
