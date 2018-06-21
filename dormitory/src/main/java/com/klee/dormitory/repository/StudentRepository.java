package com.klee.dormitory.repository;

import com.klee.dormitory.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findBySid(String sid);

    Student findByName(String name);

    /**
     *
     * @param sid
     * @param bid
     * @param did
     */
    @Modifying
    @Query("update Student set bid=:bid,did=:did where sid = :sid")
    public  void updata(@Param("sid") String sid,
                        @Param("bid") Integer bid,
                        @Param("did") Integer did);

    /**
     * 通过sid删除学生信息
     * @param sid 学号
     */
    @Modifying
    @Query("delete from Student where sid=:sid")
    public void delete(@Param("sid") String sid);

}
