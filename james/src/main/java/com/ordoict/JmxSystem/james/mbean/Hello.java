package com.ordoict.JmxSystem.james.mbean;

import java.util.Map;

import javax.management.ObjectName;

public class Hello extends AbstractBean implements HelloMBean{

    public static ObjectName objectName;
    public static HelloMBean obj;
    
    public Hello() throws Exception
    {
        objectName = setObjectName(getClass().getPackage().getName(), getClass().getSimpleName());
    }
    
    public static void setObject() throws Exception
    {
        obj = new Hello();
        classList.add(Hello.class.newInstance());
    }
    
    public void restartBean() throws Exception
    {
        mbeanServer.unregisterMBean(objectName);
        Thread.sleep(1000);
        mbeanServer.registerMBean(obj, objectName);
        System.out.println("restarBean!!!!!!");
    }

    public void endBean() throws Exception
    {
        mbeanServer.unregisterMBean(objectName);
        System.out.println("endBean!!!!!!");
    }
    
    public void reloadAllBean() throws Exception
    {
        super.reloadBean();
    }
    
    public void invokeMethod(String packageName, String className,String methodName, Map<Class<?>, Object> parameter) throws Exception
    {
    	super.invoke(packageName, className, methodName, parameter);
    }
    
    public void aa(String str, char c)
    {
    	System.out.println("!");
    }
    
    public void aa(String ss, float s)
    {
    	System.out.println("@");
    }
}
