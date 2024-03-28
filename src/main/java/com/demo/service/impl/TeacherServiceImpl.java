package com.demo.service.impl;

import com.demo.mapper.multi2.TeacherMapper;
import com.demo.pojo.multi2.Teacher;
import com.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:47:32
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findList();
    }
}
