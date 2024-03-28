package com.demo.service;

import com.demo.pojo.multi1.Student;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:21:33
 */
public interface StudentService {

    /**
     * 查询列表
     * @return
     */
    List<Student> findAll();
}
