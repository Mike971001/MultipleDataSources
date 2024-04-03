package com.demo.controller;

import com.demo.pojo.xml.PersonXml;
import com.demo.service.XmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 今天不加班
 * @date: 2024/4/3 11:35:20
 * @description: 相应xml数据类型的controller,用来测试xml数据的接收和响应
 */
@RestController
@RequestMapping("/xmlTest")
@Slf4j
public class XmlController {

    @Autowired
    private XmlService xmlService;

    /**
     * 接收PersonXml对象类型的数据 发送数据参考图3
     * @param personXml
     */
    @PostMapping("/receivePerson")
    public void acceptXml(@RequestBody PersonXml personXml){
        log.info("personXml info {}",personXml.toString());
    }

    /**
     * 返回一个personList的xml列表数据
     * @return
     */
    @GetMapping(value = "/personList", produces = MediaType.APPLICATION_XML_VALUE)
    public List<PersonXml> getPersonList() {
        return xmlService.getPersonList();
    }

    /**
     * 返回一个随机的person对象
     * @return
     */
    @GetMapping(value = "/randomPerson",produces = MediaType.APPLICATION_XML_VALUE)
    public PersonXml getRandomPerson(){
        return xmlService.getRandomPerson();
    }
}
