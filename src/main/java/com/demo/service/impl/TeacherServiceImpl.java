package com.demo.service.impl;

import com.demo.mapper.multi2.TeacherMapper;
import com.demo.pojo.CommonResult;
import com.demo.pojo.multi2.Teacher;
import com.demo.service.TeacherService;
import nu.xom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * @author 今天不加班
 * @date 2024/3/28 12:47:32
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findList();
    }

    @Override
    public Object findOne(Integer teacherId) {
        List<Teacher> list = teacherMapper.findList();
        Optional<Teacher> teacherOptional
                = list.stream().filter(teacher -> teacher.getTeacherId() == teacherId).findFirst();
        if (!teacherOptional.isPresent()) {
            return "".toString();
        }
        Teacher teacher = teacherOptional.get();
        return teacher.getXML().toXML();
    }

    @Override
    public String findXmlList() {
        List<Teacher> teachers = teacherMapper.findList();
        // 顶级标签 相应最外层的标签 <commonResult></commonResult>
        Element commonResult = new Element("CommonResult");

        // 定义标签<Message></Message>
        Element message = new Element("Message");
        //<Message>成功</Message>
        message.appendChild("成功");
        commonResult.appendChild(message);

        //定义标签<Code></Code> 嵌套在<CommonResult>中
        Element code = new Element("Code");
        commonResult.appendChild(code);
        // <Code>200</Code>
        code.appendChild("200");

        //定义Code标签
        Element data = new Element("Data");
        commonResult.appendChild(data);
        // 循环遍历在Data标签中添加子元素
        teachers.stream().forEach(teacher -> {data.appendChild(teacher.getXML());});
        return commonResult.toXML();
    }

    @Override
    public void getXmlFile() {
        String dateStr = "20240401";
        String xmlFile = "D:\\" + dateStr +".xml";
        // 这里获取list并转换为Xml的方法同上,因此直接调用
        String commonResult = this.findXmlList();
        // 文件输出流到 d盘下的 20240401.xml中
        try {
            FileOutputStream outputStream = new FileOutputStream(xmlFile);
            outputStream.write(commonResult.getBytes(StandardCharsets.UTF_8));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String getCommonXml() {
        CommonResult<Object> result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("成功了");
        // 顶级标签 CommonResult
        Element commonResultElement = result.getCommonResultElement();

        // 获取 Code标签
        Element codeElement = result.getCodeElement();
        // 将Code 标签嵌套在CommonResult标签内
        commonResultElement.appendChild(codeElement);

        // 获取Message标签，并将其添加在 CommonResult的标签内
        Element messageElement = result.getMessageElement();
        commonResultElement.appendChild(messageElement);

        // 获取Data标签 并将其添加在CommonResult中
        Element dataElement = result.getDataElement();
        commonResultElement.appendChild(dataElement);
        // 查询数据列表
        List<Teacher> teachers = teacherMapper.findList();
        // 遍历并将每一个Teacher属性添加到 Data标签的内部
        teachers.stream().forEach(teacher -> dataElement.appendChild(teacher.getXML()));
        return commonResultElement.toXML();
    }
}
