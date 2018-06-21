package com.klee.dormitory.aspect;

import com.klee.dormitory.constant.CookieConstant;
import com.klee.dormitory.constant.RedisConstant;
import com.klee.dormitory.exception.AdminAuthorizeException;
import com.klee.dormitory.utils.CookieUtil;
import io.netty.util.internal.StringUtil;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * AOP 对controller 进行拦截
 * 进行登陆校验
 */
@Aspect
@Component
@Slf4j
public class AdminAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * controller下的所有文件均拦截（除了LoginController）
     */
    @Pointcut("execution(public  * com.klee.dormitory.controller.*.*(..))" +
            "&& !execution(public  * com.klee.dormitory.controller.LoginController.*(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //1 查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            //cookies 中查询不到token 抛出自定义的异常（没有使用return 为了逻辑清晰 解耦和）
            log.warn("【登录校验】Cookie中查不到token");
            throw new AdminAuthorizeException();

        }
        //2 去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new AdminAuthorizeException();
        }
    }

}
