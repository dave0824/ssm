package cn.dave.mybatis.io;

import java.io.InputStream;

/**
 * @program: mybatis04design
 * @description:读取配置文件
 * @author: dave
 * @create: 2019-06-24 10:48
 **/

public class Resources {
     public static InputStream getResourceAsStream(String filePath){
         return Resources.class.getClassLoader().getResourceAsStream(filePath);
     }
}
