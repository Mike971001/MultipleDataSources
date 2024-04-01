package com.demo.controller;

import com.demo.pojo.multi2.Teacher;
import com.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:19:51
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询全部列表测试
     * @return
     */
    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

    /**
     * 查询全部列表
     * @return
     */
    @GetMapping(value = "/findAllXml",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Teacher> findALlXml(){
        return teacherService.findAll();
    }

    /**
     * 查询一个元素
     * @param teacherId 教师Id
     * @return
     */
    @GetMapping(value = "/findOne/{teacherId}")
    public Object findOne(@PathVariable("teacherId") Integer teacherId){
        return teacherService.findOne(teacherId);
    }

    /**
     * 查询列表输出为Xml 输出内容 /resources/picture/图1
     * @return
     */
    @GetMapping(value = "/findXmlList",produces = MediaType.APPLICATION_XML_VALUE)
    public String findXmlList(){
        return teacherService.findXmlList();
    }

    /**
     * 发送请求，将文件保存到本地路径,D盘下的20240401.xml中
     */
    @GetMapping(value = "/getXmListFile")
    public void getXmlFile(){
        // 获取Xml到本地文件目录
        teacherService.getXmlFile();
    }

    /**
     * 以CommonResult的格式返回为xml类型的数据 如图2
     * @return
     */
    @GetMapping(value = "/getCommonXml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getCommonXml() {
        return teacherService.getCommonXml();
    }
}
