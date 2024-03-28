package com.demo.controller;

import com.demo.pojo.multi1.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:19:23
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 查询列表
     * @return
     */
    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
