package com.ordoict.JmxSystem.james.web.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ordoict.JmxSystem.james.mbean.AbstractBean;
import com.ordoict.JmxSystem.james.mbean.Hello;
import com.ordoict.jmxapi.background.ExecuteThread;
import com.ordoict.jmxapi.entity.InputEntity;

@WebListener
public class ContextListener implements ServletContextListener 
{
    public static Map<String, ExecuteThread> map = new HashMap<String, ExecuteThread>();
    private ApplicationContext context = null;
    private ExecuteThread executor = null;
    private Thread daemonThread = null;
    public static List<String> jmxList = new ArrayList<String>();
    
    public void contextInitialized(final ServletContextEvent sce) 
    {
        try{
        	Class<?> param[] = {String.class, float.class};
        	Object p[] = {"dd", new Float(9.2f)};
        	Map<Class<?>, Object> a = new HashMap<Class<?>, Object>();
        	
        	for(int i=0; i<p.length; i++)
    		{
    			a.put(param[i], p[i]);
    		}
        	
            Hello.setObject();
            AbstractBean.invoke("", "", "aa", a);
            AbstractBean.loadBean();
            
            context = new ClassPathXmlApplicationContext("/spring/dispatcher-servlet.xml");
            InputEntity input = (InputEntity)context.getBean("JmxEntityList");
                        
            for(InputEntity iEntity : input.getArrayListEntity()){
                jmxList.add(iEntity.getEntityId());
                executor = new ExecuteThread(iEntity);
                daemonThread = new Thread(executor);
                daemonThread.setDaemon(true);
                
                if(!daemonThread.isAlive())
                {
                    daemonThread.start();
                }
                map.put(iEntity.getEntityId(), executor); 
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }
 
    public void contextDestroyed(final ServletContextEvent sce) 
    {
        try {
            AbstractBean.unloadBean();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
