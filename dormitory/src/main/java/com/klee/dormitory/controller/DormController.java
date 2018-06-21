package com.klee.dormitory.controller;

import com.klee.dormitory.domain.Admin;
import com.klee.dormitory.domain.Dormitory;
import com.klee.dormitory.domain.Student;
import com.klee.dormitory.repository.AdminRepository;
import com.klee.dormitory.service.DormitoryService;
import com.klee.dormitory.utils.PagePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author coco
 * @date 2018/6/18 14:31
 */
@Controller
public class DormController {

    @Resource
    PagePathUtil pagePathUtil;

    @Autowired
    private DormitoryService dormitoryService;

    /**
     * @param page
     * @param size
     * @param map
     * @return stuedit.ftl 管理界面（包含所有学生信息列表 删除修改跳转）
     */

    @GetMapping("/dormlist")
    public ModelAndView stuEdit(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size,
                                Map<String, Object> map,
                                HttpSession httpSession) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<Dormitory>  dormPage  = dormitoryService.findAll(request);
        map.put("pagepath", pagePathUtil.myPage("dorm/dorminfo.ftl"));
        map.put("dormPage", dormPage);
        map.put("currentPage", page);
        map.put("size", size);
        Admin admin = (Admin) httpSession.getAttribute("user");
        map.put("myuser", admin.getUsername());
        return new ModelAndView("index", map);
    }

    /**
     * 点击提交按钮
     *
     * @param
     * @return
     */
    @RequestMapping("/dormedit")
    public String edit(Dormitory dormitory) {
//        studentService.updata(student);
        dormitoryService.edit(dormitory);
        return "redirect:dormlist";
    }


    @RequestMapping("/delete")
    public String delete(String id) {
        dormitoryService.delete(id);
        return "redirect:dormlist";
    }

    @GetMapping("/dormadd")
    public ModelAndView toAdd(Map<String, Object> map,
                              HttpSession httpSession) {
        Dormitory dormitory = new Dormitory();
        map.put("dorm", dormitory);
        map.put("pagepath", pagePathUtil.myPage("dorm/dormupdata.ftl"));
        Admin admin = (Admin) httpSession.getAttribute("user");
        map.put("myuser", admin.getUsername());

        return new ModelAndView("index", map);
    }

}
