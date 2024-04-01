package com.demo.pojo;

import lombok.Data;
import nu.xom.Element;

import java.io.Serializable;

/**
 * @author 今天不加班
 * @date 2024/4/1 15:06:55
 */
@Data
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private T data;

    /**
     * CommonResult标签
     * @return
     */
    public Element getCommonResultElement(){
        Element commonResultElement = new Element("CommonResult");
        return commonResultElement;
    }

    /**
     * Message标签
     * @return
     */
    public Element getMessageElement(){
        Element messageElement = new Element("Message");
        // 给标签中添加数据
        messageElement.appendChild(message);
        return messageElement;
    }

    /**
     * Code标签
     * @return
     */
    public Element getCodeElement() {
        Element codeElement = new Element("Code");
        // 给标签中添加数据
        codeElement.appendChild(String.valueOf(code));
        return codeElement;
    }

    /**
     * data标签数据
     * @return
     */
    public Element getDataElement() {
        // 由于Data数据类型特殊，需要手动添加
        Element dataElement = new Element("Data");
        return dataElement;
    }

    @Override
    public String toString() {
        return "CommonResult[" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ']';
    }


}
