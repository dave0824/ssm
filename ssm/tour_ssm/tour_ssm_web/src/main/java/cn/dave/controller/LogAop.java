package cn.dave.controller;

import cn.dave.domain.SysLog;
import cn.dave.service.ISysLogService;
import cn.dave.utils.CommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-06 16:13
 **/

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date startTime; // 访问时间
    private Class executionClass;// 访问的类
    private Method executionMethod; // 访问的方

    // 主要获取访问时间、访问的类、访问的方法
    @Before("execution(* cn.dave.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {

        startTime = new Date();//获取访问时间
        executionClass = jp.getTarget().getClass();//获取访问的类
        String methodName = jp.getSignature().getName();//获取访问的方法名

        Object[] params = jp.getArgs();//获取访问方法的参数
        if (params == null || params.length == 0) {
            executionMethod = executionClass.getMethod(methodName);//只能获取无参
        } else {
            Class[] classes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                classes[i] = params[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, classes);
        }
    }

    // 主要获取日志中其它信息，时长、ip、url..
    @After("execution(* cn.dave.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        Long time = new Date().getTime() - startTime.getTime();//获取访问时长

        String url = "";
        if (executionMethod != null && executionClass != LogAop.class) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setId(CommonUtils.getUuid());
                    sysLog.setExecutionTime(time); //执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod( executionClass.getName() + executionMethod.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(startTime);

                    //调用Service完成操作
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
