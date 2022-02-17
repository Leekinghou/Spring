package com.spring.ioc.context;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lijinhao
 * @date: 2022/02/16 21:51
 */

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map iocContainer = new HashMap();

    public ClassPathXmlApplicationContext(){
        try{
            // 获得配置文件的物理地址 getResource()用于从Class下获取指定的资源，getPath()用于得到资源文件的物理路径
            String filePath = this.getClass().getResource("/ApplicationContext.xml").getPath();
            // 防止路径名有中文，使用函数将其解码
            filePath = new URLDecoder().decode(filePath, "UTF-8");
            // 对文件路径进行解析
           SAXReader reader = new SAXReader();
           Document document = reader.read(new File(filePath));
           List<Node> beans = document.getRootElement().selectNodes("bean");
           for(Node node: beans){
               // 接收List中的对象
               Element ele = (Element) node;
               // 当前节点对应的属性
               String id = ele.attributeValue("id");
               String className = ele.attributeValue("class");
               // 反射技术
               Class c = Class.forName(className);
               // newInstance()调用默认构造方法创建Apple类的实例对象，使用Object对象进行接收
               Object obj = c.newInstance();

               List<Node> properties = ele.selectNodes("property");
               for(Node pro: properties){
                   Element property = (Element) pro;
                   String propName = property.attributeValue("name");
                   String propValue = property.attributeValue("value");
                   // 反射构造
                   String setMethodName = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
                   System.out.println("准备执行" + setMethodName + "方法注入数据");
                   Method setMethod = c.getMethod(setMethodName, String.class);
                   // 通过setter方法注入数据
                   setMethod.invoke(obj, propValue);
               }
               iocContainer.put(id, obj);
           }
           System.out.println(iocContainer);
           System.out.println("IoC容器初始化完毕");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanId) {
        return iocContainer.get(beanId);
    }
}
