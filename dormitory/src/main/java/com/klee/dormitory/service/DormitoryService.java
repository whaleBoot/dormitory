package com.klee.dormitory.service;

import com.klee.dormitory.domain.Dormitory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author coco
 * @date 2018/6/18 11:58
 */
public interface DormitoryService {

    Page<Dormitory> findAll(Pageable pageable);

    void edit(Dormitory dormitory);

    void delete(String id);
}
