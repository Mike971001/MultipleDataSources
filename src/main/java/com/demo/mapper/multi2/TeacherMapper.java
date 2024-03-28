package com.demo.mapper.multi2;

import com.demo.pojo.multi2.Teacher;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 11:26:04
 */
public interface TeacherMapper {

    /**
     * 查询列表成功
     * @return
     */
    List<Teacher> findList();
}
