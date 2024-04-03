package com.demo.service;

import com.demo.pojo.xml.PersonXml;

import java.util.List;

/**
 * @author: 今天不加班
 * @date: 2024/4/3 11:36:28
 * @description: xml的Service
 */
public interface XmlService {

    /**
     * 返回一个列表
     * @return
     */
    List<PersonXml> getPersonList();

    /**
     * 返回一个随机的Person对象
     * @return
     */
    PersonXml getRandomPerson();
}
