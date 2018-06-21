package com.klee.dormitory.service;

import com.klee.dormitory.domain.Result;
import com.klee.dormitory.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList();

    Page<Student> findAll(Pageable pageable);

    Student finStudentByName(String name);

    Result<Student> getStudentListJson();

    Student findStudentByNum(String num);

    Result<Student> save(Student student);

    void edit(Student student);

    void delete(String sid);

    void updata(Student student);


}
