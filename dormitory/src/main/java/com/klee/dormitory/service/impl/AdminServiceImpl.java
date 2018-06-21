package com.klee.dormitory.service.impl;

import com.klee.dormitory.domain.Admin;
import com.klee.dormitory.repository.AdminRepository;
import com.klee.dormitory.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Boolean findUserByUserNameAndPwd(String user, String pwd) {

        if(adminRepository.findByUsernameAndPassword(user,pwd)!=null){
            return true;
        }
        return false;
    }


}