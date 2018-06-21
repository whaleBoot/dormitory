package com.klee.dormitory.repository;

import com.klee.dormitory.domain.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.util.KeyUtil;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;

    @Test
        public void save() {
        Admin admin = new Admin();
        admin.setId(123);
        admin.setUsername("user");
        admin.setPassword("User");
        admin.setPermission(1);
        Admin result = adminRepository.save(admin);
        Assert.assertNotNull(result);
    }


}