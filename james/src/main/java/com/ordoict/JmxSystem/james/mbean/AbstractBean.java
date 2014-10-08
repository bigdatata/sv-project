package com.ordoict.JmxSystem.james.mbean;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class AbstractBean {

    public static MBeanServer mbeanServer = ManagementFactory
            .getPlatformMBeanServer();
    public static ArrayList<Object> classList = new ArrayList<Object>();
    private static ObjectName object = null;

    public static ObjectName setObjectName(String packageName, String className)
            throws Exception {
        object = new ObjectName(packageName + ":type=" + className);
        return object;
    }

    public static void setObject() throws Exception {
    }

    public static void registerBean(Object obj, ObjectName objn)
            throws Exception {
        mbeanServer.registerMBean(obj, objn);
    }

    public static void unregisterBean(ObjectName objn) throws Exception {
        mbeanServer.unregisterMBean(objn);
    }

    public static void loadBean() throws Exception {
        for (int i = 0; i < classList.size(); i++)
            registerBean(classList.get(i), object);
    }

    public static void unloadBean() throws Exception {

        for (int i = 0; i < classList.size(); i++)
            unregisterBean(object);
    }

    public static void reloadBean() throws Exception {

        unloadBean();
        Thread.sleep(1000);
        loadBean();
    }
    
    @SuppressWarnings("rawtypes")
    public static void invoke(String packageName, String className, String methodName, Map<Class<?>, Object> parameter)
    {
    	Method method = null;
    	
		Set paramClass = parameter.keySet();
    	Class cls[] = new Class[paramClass.size()];
    	Object param[] = new Object[paramClass.size()];
  	
    	int i=0;
    	for (Iterator iterator = paramClass.iterator(); iterator.hasNext();)
    	{
    		Object keyName =  iterator.next();
            param[i] = parameter.get(keyName);
            cls[i] = paramClassType(keyName);System.out.println(cls[i].toString());
            i++;
    	}
    	
		try {
			method = Hello.class.getMethod(methodName, cls);
			method.invoke(Hello.class.newInstance(), param);
		} 
		catch (Exception e){
			e.printStackTrace();
		}
    }
    
    public static Class<?> paramClassType(Object obj)
    {
    	Class<?> cls = null;
    	
    	switch(obj.toString())
    	{
	    	case "class java.lang.String":
	    		cls = String.class;
	    		break;
	    		
	    	case "byte":
	    		cls = byte.class;
	    		break;
	    		
	    	case "short":
	    		cls = short.class;
	    		break;
	    		
	    	case "int":
	    		cls = int.class;
	    		break;
	    		
	    	case "float":
	    		cls = float.class;
	    		break;
	    		
	    	case "double":
	    		cls = double.class;
	    		break;
	    		
	    	case "char":
	    		cls = char.class;
	    		break;
	    		
	    	case "boolean":
	    		cls = boolean.class;
	    		break;
    	}
    	return cls;
    }

    /*@SuppressWarnings("rawtypes")
    public static void invoke(String packageName, String className,
            String methodName, String parameter) throws Exception {

        String[] param = parameter.split(",");
        Object[] object = new Object[param.length];
        List<Class[]> list = new ArrayList<Class[]>();
        Object obj = null;
        Method invokeMethod = null;
        
        try {
            for (Class cls : getClasses(packageName)) {
                if (cls.getSimpleName().equals(className)) {
                    obj = cls.newInstance();

                    for (Method method : cls.getDeclaredMethods()) {
                        if (method.getName().equals(methodName)) {
                            invokeMethod = method;
                            Class[] temp = new Class[method.getParameterTypes().length];
                            int index = 0;

                            for (Class type : method.getParameterTypes()) {
                                System.out.println(type.getTypeName());
                            	temp[index] = type;

                                index++;
                                if (index == method.getParameterTypes().length)
                                    list.add(temp);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            Class[] cls = list.get(i);
            int j = 0;
            System.out.println(list.size());
            for (Class c : cls) {
                try {
                    switch (c.getName()) {
                    case "java.lang.String":
                        object[j] = (Object) param[j];
                        break;

                    case "byte":
                        object[j] = (Object) Byte.parseByte(param[j]);
                        break;

                    case "boolean":
                        object[j] = (Object) Boolean.parseBoolean(param[j]);
                        break;

                    case "char":
                        object[j] = (Object) param[j].charAt(0);
                        break;

                    case "double":
                        object[j] = (Object) Double.parseDouble(param[j]);
                        break;

                    case "int":
                        object[j] = (Object) Integer.parseInt(param[j]);
                        break;

                    case "long":
                        object[j] = (Object) Long.parseLong(param[j]);
                        break;

                    case "short":
                        object[j] = (Object) Short.parseShort(param[j]);
                        break;

                    default:
                        return;
                    }
                } catch (Exception e) {
                    return;
                }invokeMethod.invoke(obj, object);
                System.out.println(object[j]);
                System.out.println(object[j] instanceof Integer);
                System.out.println(object[j] instanceof String);
                j++;
                
            }
        }
    }*/

    /*@SuppressWarnings("rawtypes")
    private static Class[] getClasses(String pckgname)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();

        File directory = null;
        try {
            String packagePath = "" + pckgname.replace('.', '/');

            URL path = Thread.currentThread().getContextClassLoader()
                    .getResource("");
            String resource = path + packagePath;
            try {
                resource = URLDecoder.decode(resource, "UTF-8");
                resource = resource.substring("file:/".length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            directory = new File(resource);
        } catch (NullPointerException x) {
            throw new ClassNotFoundException(pckgname
                    + " does not appear to be a valid package");
        }
        if (directory.exists()) {
            String[] files = directory.list();
            for (int i = 0; i < files.length; i++) {
                if (files[i].endsWith(".class")) {
                    classes.add(Class.forName(pckgname + '.'
                            + files[i].substring(0, files[i].length() - 6)));
                }
            }
        } else {
            throw new ClassNotFoundException(pckgname
                    + " does not appear to be a valid package");
        }
        Class[] listClass = new Class[classes.size()];
        classes.toArray(listClass);
        return listClass;
    }*/
}