package com.klee.dormitory.repository;

import com.klee.dormitory.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsernameAndPassword(String user,String pwd);
}
