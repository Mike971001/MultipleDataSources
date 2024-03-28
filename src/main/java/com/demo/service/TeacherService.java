package com.demo.service;

import com.demo.pojo.multi2.Teacher;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:21:08
 */
public interface TeacherService {

    /**
     * 查询列表
     * @return
     */
    List<Teacher> findAll();
}
