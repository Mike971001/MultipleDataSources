package com.demo.service.impl;

import com.demo.pojo.xml.PersonXml;
import com.demo.service.XmlService;
import com.sun.deploy.net.MessageHeader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: 今天不加班
 * @date: 2024/4/3 11:37:09
 * @description: xml对象的业务实现层，用来生成测试数据
 */
@Service
public class XmlServiceImpl implements XmlService {

    private static List<PersonXml> personXmlList = new ArrayList<>();


    static {
        PersonXml personXml = new PersonXml();
        personXml.setIdCard("11001");
        personXml.setAddress("北京昌平");
        personXml.setName("钟鸣");
        personXml.setGender("男");
        personXmlList.add(personXml);

        PersonXml personXml1 = new PersonXml();
        personXml1.setIdCard("11002");
        personXml1.setAddress("江西南昌");
        personXml1.setName("张三");
        personXml1.setGender("男");
        personXmlList.add(personXml);

        PersonXml personXml2 = new PersonXml();
        personXml2.setIdCard("11003");
        personXml2.setAddress("江苏南京");
        personXml2.setName("李四");
        personXml2.setGender("男");
        personXmlList.add(personXml);

        PersonXml personXml3 = new PersonXml();
        personXml3.setIdCard("11004");
        personXml3.setAddress("江苏南京");
        personXml3.setName("王五");
        personXml3.setGender("女");

        // 添加数据
        personXmlList.add(personXml);
        personXmlList.add(personXml1);
        personXmlList.add(personXml2);
        personXmlList.add(personXml3);
    }


    @Override
    public List<PersonXml> getPersonList() {
        return XmlServiceImpl.personXmlList;
    }

    @Override
    public PersonXml getRandomPerson() {
        List<PersonXml> personList = this.getPersonList();
        //随机数
        Random random = new Random();
        return personList.get(random.nextInt(personList.size()));
    }
}
