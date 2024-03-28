package com.demo.pojo.multi2;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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

}
