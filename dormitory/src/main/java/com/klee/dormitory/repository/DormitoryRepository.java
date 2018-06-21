package com.klee.dormitory.repository;

import com.klee.dormitory.domain.Dormitory;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author coco
 * @date 2018/6/17 15:59
 */
public interface DormitoryRepository  extends JpaRepository<Dormitory,Integer> {

    /**
     * 通过sid删除学生信息
     * @param id
     */
    @Modifying
    @Query("delete from Dormitory where id=:id")
    public void delete(@Param("id") String id);

}
