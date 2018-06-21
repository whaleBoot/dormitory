package com.klee.dormitory.controller;

import com.klee.dormitory.domain.Admin;
import com.klee.dormitory.utils.PagePathUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class WelcomeController {

    @Resource
    private PagePathUtil pagePathUtil;
    @GetMapping("/index")
    public ModelAndView Welcome(Map<String, Object> map,
                                HttpSession httpSession){
        map.put("pagepath",pagePathUtil.myPage("about/about.ftl"));
        Admin admin=(Admin) httpSession.getAttribute("user");
        map.put("myuser",admin.getUsername());
        return new ModelAndView("index",map);
    }
}
