package com.klee.dormitory.service.impl;


import com.klee.dormitory.domain.Dormitory;
import com.klee.dormitory.repository.DormitoryRepository;
import com.klee.dormitory.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author coco
 * @date 2018/6/18 11:58
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryRepository dormitoryRepository;

    @Override
    public Page<Dormitory> findAll(Pageable pageable) {
        return dormitoryRepository.findAll(pageable);
    }

    @Override
    public void edit(Dormitory dormitory) {
        dormitoryRepository.save(dormitory);
    }

    @Override
    public void delete(String id) {
        dormitoryRepository.delete(id);
    }
}
