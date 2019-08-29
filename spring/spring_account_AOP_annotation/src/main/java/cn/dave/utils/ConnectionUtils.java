package cn.dave.utils;

import cn.dave.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @program: spring_account
 * @description:
 * @author: dave
 * @create: 2019-06-30 23:08
 **/

@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;


    /**
     * 获取线程上的连接
     * @return
     */
    public Connection getConnection(){
        try{
            //1.先从ThreadLocal上获取
            Connection connection = tl.get();
            //2.判断当前线程上是否有连接
            if(connection == null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 解绑线程上的连接
     */
    public void removeConnection(){
        tl.remove();
    }
}
