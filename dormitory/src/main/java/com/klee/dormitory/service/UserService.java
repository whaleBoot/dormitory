package com.klee.dormitory.service;

import com.klee.dormitory.domain.Result;
import com.klee.dormitory.domain.User;

public interface UserService {

    public boolean findUserByUserName(String user, String pwd);

    public Result<User> save(User user);


}
