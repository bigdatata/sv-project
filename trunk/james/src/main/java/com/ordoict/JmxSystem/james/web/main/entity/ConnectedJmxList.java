package com.ordoict.JmxSystem.james.web.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectedJmxList {
  
    @XmlElement
    private List<String> jmxList;

    public ConnectedJmxList()
    {
        jmxList = new ArrayList<String>();
    }

    public List<String> getJmxList() {
        return jmxList;
    }

    public void setJmxList(List<String> jmxList) {
        this.jmxList = jmxList;
    }
}
