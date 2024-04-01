package com.demo.pojo.multi2;

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
 * @date 2024/3/28 10:04:55
 */
@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 老师唯一标识
     */
    private Integer teacherId;

    /**
     * 老师姓名
     */
    private String teacherName;

    /**
     * 老师性别
     */
    private String teacherGender;

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
        student.addAttribute(new Attribute("TeacherId", fillNull(teacherId.toString())));
        student.addAttribute(new Attribute("TeacherName", fillNull(teacherName)));
        student.addAttribute(new Attribute("TeacherGender", fillNull(teacherGender)));
        student.addAttribute(new Attribute("CreateTime", (createTime == null) ? "1900-01-01T00:00:00"
                : fillNull(DateUtils.dateToString(createTime, "yyyy-MM-dd'T'HH:mm:ss"))));
        student.addAttribute(new Attribute("UpdateTime", (createTime == null) ? "1900-01-01T00:00:00"
                : fillNull(DateUtils.dateToString(createTime, "yyyy-MM-dd'T'HH:mm:ss"))));
        return student;
    }

    @Override
    public String toString() {
        return "Teacher[" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherGender='" + teacherGender + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ']';
    }
}
