package com.demo.service.impl;

import com.demo.mapper.multi1.StudentMapper;
import com.demo.pojo.multi1.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:48:34
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> findAll() {
        return studentMapper.findList();
    }
}
