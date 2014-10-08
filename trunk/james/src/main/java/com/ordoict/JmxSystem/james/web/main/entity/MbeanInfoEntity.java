package com.ordoict.JmxSystem.james.web.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MbeanInfoEntity {
  
    @XmlElement
    private List<String> mbeanAttributeInfo;
    @XmlElement
    private List<String> mbeanNameList;

    public MbeanInfoEntity()
    {
        mbeanAttributeInfo = new ArrayList<String>();
        mbeanNameList = new ArrayList<String>();
    }

    public List<String> getMbeanNameList() {
        return mbeanNameList;
    }

    public void setMbeanNameList(List<String> mbeanNameList) {
        this.mbeanNameList = mbeanNameList;
    }

    public List<String> getMbeanAttributeInfo() {
        return mbeanAttributeInfo;
    }

    public void setMbeanAttributeInfo(List<String> mbeanAttributeInfo) {
        this.mbeanAttributeInfo = mbeanAttributeInfo;
    }
}
