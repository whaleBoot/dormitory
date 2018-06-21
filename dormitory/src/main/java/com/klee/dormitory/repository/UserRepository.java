package com.klee.dormitory.repository;

import com.klee.dormitory.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndPassWord(String user, String pwd);
}
