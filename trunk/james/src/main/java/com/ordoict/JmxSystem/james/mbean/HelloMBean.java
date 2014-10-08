package com.ordoict.JmxSystem.james.mbean;

import java.util.Map;

public interface HelloMBean 
{
    public void restartBean() throws Exception; 
    public void endBean() throws Exception;
    public void reloadAllBean() throws Exception;
	public void invokeMethod(String packageName, String className, String methodName, Map<Class<?>, Object> parameter) throws Exception;
}