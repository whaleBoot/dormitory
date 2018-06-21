package com.klee.dormitory.controller;

import com.klee.dormitory.constant.CookieConstant;
import com.klee.dormitory.constant.RedisConstant;
import com.klee.dormitory.domain.Admin;
import com.klee.dormitory.domain.Result;
import com.klee.dormitory.service.impl.AdminServiceImpl;
import com.klee.dormitory.utils.CookieUtil;
import com.klee.dormitory.utils.ResultUtil;
import org.apache.catalina.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @PostMapping("/dologin")
    public Result login(Admin admin, HttpSession httpSession,
                        HttpServletResponse response){
        logger.info("用户输入的用户名={}",admin.getUsername());
        logger.info("用户输入的密码={}",admin.getPassword());

        Boolean result=adminService.findUserByUserNameAndPwd(admin.getUsername().trim(),admin.getPassword().trim());

        logger.info(result.toString());
        if(result){
            httpSession.setAttribute("user",admin);
            httpSession.setMaxInactiveInterval(60*60);
            // 将token存入redis
            String token = UUID.randomUUID().toString();
            Integer expire = RedisConstant.EXPIRE;
            stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),admin.getUsername(),expire,TimeUnit.SECONDS);
            CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.EXPIRE);
            return ResultUtil.success(admin);
        } else {
            return ResultUtil.error(1,"用户名或密码错误");
        }
    }

    @GetMapping("/login")
    private String mlogin(){
        return "login";
    }

    @GetMapping("/logout")
    private String mlogout(HttpSession httpSession,
                           HttpServletResponse response,
                           HttpServletRequest request){
        httpSession.removeAttribute("user");
        //1 从cookie中查询
       Cookie cookie= CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie!=null){
            stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        }
        //2 cookie
         CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        return "login";
    }
}
