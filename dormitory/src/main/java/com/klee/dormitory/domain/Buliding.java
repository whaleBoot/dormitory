package com.klee.dormitory.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Buliding {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer bid;
    private Integer floor;
    private Integer room;
    private Integer gender;

}
