package com.ordoict.JmxSystem.james.web.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsageEntity {
  
    @XmlElement
    private List<String> usageList;

    public UsageEntity()
    {
        usageList = new ArrayList<String>();
    }

    public List<String> getUsageList() {
        return usageList;
    }

    public void setUsageList(List<String> usageList) {
        this.usageList = usageList;
    }
    
}
/*@XmlRootElement(name = "usage")
public class UsageEntity {
    
    private String cpu;
    private String heapMemory;
    private String nonHeapMemory;
    private String physicalMemory;
    private String totalPhysicalMemory;
    private String swapSpace;
    private String totalSwapSpace;
    private String classCount;
    private String totalClassCount;
    private String daemonThread;
    private String peakThread;
    private String totalStartedThread;
    private String osInfo;
        
    public UsageEntity(){}
    
    public UsageEntity returnOutputEntity(UsageEntity output, ArrayList<String> list) throws Exception
    {
        int index = 0;
        for(Field field : output.getClass().getDeclaredFields())
        {
            PropertyDescriptor proDescriptor = new PropertyDescriptor(field.getName(), UsageEntity.class);
            Method setter = proDescriptor.getWriteMethod();
            setter.invoke(output, list.get(index));
            index++;
        }
        return output;
    }

    public String getCpu() {
        return cpu;
    }
    @XmlElement
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHeapMemory() {
        return heapMemory;
    }
    @XmlElement
    public void setHeapMemory(String heapMemory) {
        this.heapMemory = heapMemory;
    }

    public String getNonHeapMemory() {
        return nonHeapMemory;
    }
    @XmlElement
    public void setNonHeapMemory(String nonHeapMemory) {
        this.nonHeapMemory = nonHeapMemory;
    }

    public String getPhysicalMemory() {
        return physicalMemory;
    }
    @XmlElement
    public void setPhysicalMemory(String physicalMemory) {
        this.physicalMemory = physicalMemory;
    }

    public String getTotalPhysicalMemory() {
        return totalPhysicalMemory;
    }
    @XmlElement
    public void setTotalPhysicalMemory(String totalPhysicalMemory) {
        this.totalPhysicalMemory = totalPhysicalMemory;
    }

    public String getClassCount() {
        return classCount;
    }
    @XmlElement
    public void setClassCount(String classCount) {
        this.classCount = classCount;
    }
    
    public String getTotalClassCount() {
        return totalClassCount;
    }
    @XmlElement
    public void setTotalClassCount(String totalClassCount) {
        this.totalClassCount = totalClassCount;
    }

    public String getSwapSpace() {
        return swapSpace;
    }
    @XmlElement
    public void setSwapSpace(String swapSpace) {
        this.swapSpace = swapSpace;
    }

    public String getTotalSwapSpace() {
        return totalSwapSpace;
    }
    @XmlElement
    public void setTotalSwapSpace(String totalSwapSpace) {
        this.totalSwapSpace = totalSwapSpace;
    }

    public String getDaemonThread() {
        return daemonThread;
    }
    @XmlElement
    public void setDaemonThread(String daemonThread) {
        this.daemonThread = daemonThread;
    }

    public String getPeakThread() {
        return peakThread;
    }
    @XmlElement
    public void setPeakThread(String peakThread) {
        this.peakThread = peakThread;
    }

    public String getTotalStartedThread() {
        return totalStartedThread;
    }
    @XmlElement
    public void setTotalStartedThread(String totalStartedThread) {
        this.totalStartedThread = totalStartedThread;
    }

    public String getOsInfo() {
        return osInfo;
    }
    @XmlElement
    public void setOsInfo(String osInfo) {
        this.osInfo = osInfo;
    }
    }
    */