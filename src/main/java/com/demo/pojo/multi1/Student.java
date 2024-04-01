package com.demo.pojo.multi1;

import com.demo.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import nu.xom.Attribute;
import nu.xom.Element;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 今天不加班
 * @date 2024/3/28 10:04:36
 */
@Data
public class Student implements Serializable {

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别
     */
    private String studentGender;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**
     * str填充
     * @param str 字符串
     * @return
     */
    private String fillNull(String str) {
        return (str == null) ? "/" : str;
    }

    /**
     * 获取XML文件
     * @return
     */
    public Element getXML(){
        Element student = new Element("Student");
        student.addAttribute(new Attribute("StudentId", fillNull(studentId.toString())));
        student.addAttribute(new Attribute("StudentName", fillNull(studentName)));
        student.addAttribute(new Attribute("StudentGender", fillNull(studentGender)));
        student.addAttribute(new Attribute("CreateTime", (createTime == null) ? "1900-01-01T00:00:00"
                : fillNull(DateUtils.dateToString(createTime, "yyyy-MM-dd'T'HH:mm:ss"))));
        student.addAttribute(new Attribute("UpdateTime", (createTime == null) ? "1900-01-01T00:00:00"
                : fillNull(DateUtils.dateToString(createTime, "yyyy-MM-dd'T'HH:mm:ss"))));
        return student;
    }
}
