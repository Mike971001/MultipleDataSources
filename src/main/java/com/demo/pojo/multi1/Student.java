package com.demo.pojo.multi1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
}
