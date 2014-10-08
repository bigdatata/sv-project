package com.ordoict.JmxSystem.james.web.main.controller;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ordoict.JmxSystem.james.web.main.entity.ConnectedJmxList;
import com.ordoict.JmxSystem.james.web.main.entity.MbeanInfoEntity;
import com.ordoict.JmxSystem.james.web.main.entity.UsageEntity;
import com.ordoict.jmxapi.entity.InputEntity;

@Controller
public class MainController {
	
	//private Logger logger = Logger.getLogger(this.getClass());
	private UsageEntity usageEntity = new UsageEntity();
	private MbeanInfoEntity mbean = new MbeanInfoEntity();
	private ConnectedJmxList conntectedList = new ConnectedJmxList();
	
    @RequestMapping(value="/usage", method=RequestMethod.GET)
    public @ResponseBody UsageEntity getOutputEntity(@ModelAttribute InputEntity inputEntity)
    {
        usageEntity.setUsageList(ContextListener.map.get(inputEntity.getEntityId()).getUsage());
        return usageEntity; 
    }
    
	@RequestMapping(value="/mbean", method=RequestMethod.GET)
    public @ResponseBody MbeanInfoEntity getMbeanInfo(@ModelAttribute InputEntity inputEntity) throws Exception
    {   
	    mbean.setMbeanAttributeInfo(ContextListener.map.get(
                inputEntity.getEntityId()).getMbeanAttribute(inputEntity.getObjectName()));
        return mbean;
    }
	
	@RequestMapping(value="/getMbeanList", method=RequestMethod.GET)
	public @ResponseBody MbeanInfoEntity getMbeanList(@ModelAttribute InputEntity inputEntity) throws Exception
	{
	    mbean.setMbeanNameList(ContextListener.map.get(inputEntity.getEntityId()).getMbeanName());
        return mbean;
	}
	
	@RequestMapping("/start")
	public @ResponseBody ConnectedJmxList main()
	{
	    conntectedList.setJmxList(ContextListener.jmxList);
	    return conntectedList;
	}
	
    @RequestMapping("")
	public String home(){
	    return "redirect:main.do";
	}
	
	@RequestMapping("/main.do")
	public String HelloWorld(){
	    return "main/index";
	}
}