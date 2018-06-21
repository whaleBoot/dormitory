package com.klee.dormitory.domain;


import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 无用
 */
@Entity
@Data
public class SystemMenu {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String url;
    private String icon_id;
    private Integer level;
    private String module;
    private Integer weight;
    private Integer pid;

}
