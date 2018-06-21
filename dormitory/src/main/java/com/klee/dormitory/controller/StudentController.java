package com.klee.dormitory.controller;

import com.klee.dormitory.domain.Admin;
import com.klee.dormitory.domain.Result;
import com.klee.dormitory.domain.ResultAndPage;
import com.klee.dormitory.domain.Student;
import com.klee.dormitory.repository.StudentRepository;
import com.klee.dormitory.service.StudentService;
import com.klee.dormitory.utils.PagePathUtil;
import com.klee.dormitory.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Struct;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/stuinfo")
@Slf4j
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;
    @Resource
    private PagePathUtil pagePathUtil;

    @Resource
    StudentService studentService;

    @GetMapping("/stuadd")
    public ModelAndView toAdd(Map<String, Object> map,
                              HttpSession httpSession) {
        Student student = new Student();
        map.put("stu", student);
        map.put("pagepath", pagePathUtil.myPage("stuinfo/stuupdata.ftl"));
        Admin admin = (Admin) httpSession.getAttribute("user");
        map.put("myuser", admin.getUsername());

        return new ModelAndView("index", map);
    }


    /**
     * @param num 学号
     * @param map student
     * @return stuupdata.ftl（学生信息修改界面）
     */

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(String num, Map<String, Object> map,
                               HttpSession httpSession) {
        Student student = studentService.findStudentByNum(num);
        map.put("pagepath", pagePathUtil.myPage("stuinfo/stuupdata.ftl"));
        map.put("stu", student);
        Admin admin = (Admin) httpSession.getAttribute("user");
        map.put("myuser",admin.getUsername());
        return new ModelAndView("index", map);
    }

    @RequestMapping("/delete")
    public String delete(String sid) {
        studentService.delete(sid);
        return "redirect:stulist";
    }

    /**
     * 点击提交按钮
     *
     * @param student
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Student student) {
//        studentService.updata(student);
        studentService.edit(student);
        return "redirect:stulist";
    }

    /**
     * @param page
     * @param size
     * @param map
     * @return stuedit.ftl 管理界面（包含所有学生信息列表 删除修改跳转）
     */

    @GetMapping("/stulist")
    public ModelAndView stuEdit(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size,
                                Map<String, Object> map,
                                HttpSession httpSession) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<Student> studentPage = studentService.findAll(request);
        map.put("pagepath", pagePathUtil.myPage("stuinfo/stuinfo.ftl"));
        map.put("studentPage", studentPage);
        map.put("currentPage", page);
        map.put("size", size);
        Admin admin = (Admin) httpSession.getAttribute("user");
        map.put("myuser", admin.getUsername());
        log.info("myuser={}", httpSession.getAttribute("user"));
        return new ModelAndView("index", map);
    }

    @PostMapping("/findbyname")
    @ResponseBody
    public Result<Student> finbyname(String sid){
        log.info("------------------findbyname={}",sid);
      return   ResultUtil.success(studentService.findStudentByNum(sid));

    }



}
