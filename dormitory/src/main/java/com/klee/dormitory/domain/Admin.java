package com.klee.dormitory.domain;

import com.klee.dormitory.enums.PermissionEnum;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;

    /**  用户名username. */
    private String username;

    /**密码password.  */
    private String password;

    /**权限permission.0 系统管理员 1 宿舍管理员  */
    private Integer permission;


}
