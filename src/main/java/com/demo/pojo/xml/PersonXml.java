package com.demo.pojo.xml;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 今天不加班
 * @date: 2024/4/3 11:30:12
 * @description: person实体类，用于测试xml功能
 */
@Data
public class PersonXml implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 年龄
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 住址
     */
    private String address;
}
