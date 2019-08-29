package cn.dave.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: factoryModel
 * @description:
 *  * 一个创建Bean对象的工厂
 *  *
 *  * Bean：在计算机英语中，有可重用组件的含义。
 *  * JavaBean：用java语言编写的可重用组件。
 *  *      javabean >  实体类
 *  *
 *  *   它就是创建我们的service和dao对象的。
 *  *
 *  *   第一个：需要一个配置文件来配置我们的service和dao
 *  *           配置的内容：唯一标识=全限定类名（key=value)
 *  *   第二个：通过读取配置文件中配置的内容，反射创建对象
 *  *
 *  *   我的配置文件可以是xml也可以是properties
 *  *
 * @author: dave
 * @create: 2019-06-28 23:34
 **/

public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个Map来存放要创建的对象，称之为容器
    private static Map<String,Object>beans;

    //使用静态代码块为properties对象赋值
    static{
        try {
            //实例化properties对象
            props = new Properties();
            //加载配置文件
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的Key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个Key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties对象失败");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
