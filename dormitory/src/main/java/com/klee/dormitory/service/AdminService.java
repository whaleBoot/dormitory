package com.klee.dormitory.service;

import com.klee.dormitory.domain.Admin;

public interface AdminService {

     Boolean findUserByUserNameAndPwd(String user,String pwd);


}
