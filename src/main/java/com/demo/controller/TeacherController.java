package com.demo.controller;

import com.demo.pojo.multi2.Teacher;
import com.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:19:51
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询全部列表测试
     * @return
     */
    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

}
