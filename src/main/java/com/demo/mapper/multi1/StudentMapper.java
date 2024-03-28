package com.demo.mapper.multi1;

import com.demo.pojo.multi1.Student;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 11:25:08
 */
public interface StudentMapper {

    /**
     * 查询列表
     * @return
     */
    List<Student> findList();

}
