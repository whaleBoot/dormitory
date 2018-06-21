package com.klee.dormitory.service.impl;

import com.klee.dormitory.domain.Result;
import com.klee.dormitory.domain.User;
import com.klee.dormitory.repository.UserRepository;
import com.klee.dormitory.service.UserService;
import com.klee.dormitory.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean findUserByUserName(String user, String pwd) {

        if (userRepository.findByUserNameAndPassWord(user, pwd) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Result<User> save(User user) {
        return ResultUtil.success(userRepository.save(user));

    }
}
