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

    /**
     * 查询一个
     * @param teacherId
     * @return
     */
    Object findOne(Integer teacherId);

    /**
     * 查询Xml的List
     * @return
     */
    String findXmlList();

    /**
     * 将查询到的列表输出到本地的文件目录
     */
    void getXmlFile();

    /**
     * 返回为xml的数据
     * @return
     */
    String getCommonXml();
}
