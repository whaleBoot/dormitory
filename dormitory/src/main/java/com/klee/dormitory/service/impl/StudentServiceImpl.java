package com.klee.dormitory.service.impl;

import com.klee.dormitory.domain.Result;
import com.klee.dormitory.domain.Student;
import com.klee.dormitory.repository.StudentRepository;
import com.klee.dormitory.service.StudentService;
import com.klee.dormitory.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 查询所有学生
     *
     * @return list
     */
    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student finStudentByName(String name) {
        Student student = new Student();
        student = studentRepository.findByName(name);
        return student;
    }

    /**
     * 查询所有学生
     *
     * @return json
     */
    @Override
    public Result<Student> getStudentListJson() {
        return ResultUtil.success(studentRepository.findAll());
    }

    /**
     * 查询指定sid的学生信息
     *
     * @param sid 学号
     * @return json
     */
    @Override
    public Student findStudentByNum(String sid) {
        return studentRepository.findBySid(sid);
    }

    /**
     * 添加一个学生信息
     *
     * @param student 学生对象
     */
    @Override
    public Result<Student> save(Student student) {
        return ResultUtil.success(studentRepository.save(student));
    }

    /**
     * 修改一个学生信息
     *
     * @param student
     */
    @Override
    public void edit(Student student) {

        studentRepository.save(student);

    }

    /**
     * 删除
     *
     * @param sid
     */
    @Override
    public void delete(String sid) {
        studentRepository.delete(sid);
    }

    @Override
    public void updata(Student student) {
        studentRepository.updata(student.getSid(), student.getBid(), student.getDid());
    }
}
