package com.klee.dormitory.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Dormitory {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer bid;
    private Integer did;
    private Integer canlive;
    private String gender;
    private Integer price;
    private String repair;


}
