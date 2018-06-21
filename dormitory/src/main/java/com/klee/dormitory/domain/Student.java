package com.klee.dormitory.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@ToString
public class Student {
    @Id
    /**  学号sid. */
    private String sid;

    /**  性别sex. */
    private String sex;

    /**  姓名. */
    private String name;

    /**  密码. */
    private String password;

    /**  年龄. */
    private Integer age;

    /**  手机号. */
    private String telephone;

    /**  学院. */
    private String department;

    /**  专业. */
    private String major;

    /**  入校日期. */
    private Date admissiondate;

    /**  楼号. */
    private Integer bid;

    /**  宿舍号. */
    private Integer did;

}
