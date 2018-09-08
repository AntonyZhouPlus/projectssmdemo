package com.zhouhang.aop;

import com.zhouhang.domain.SysLog;
import com.zhouhang.service.ILogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhouhang
 * @project_name projectssmdemo
 * @package com.zhouhang.aop
 * @date 2018/9/7
 */
@Component
@Aspect
public class LogAOP {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ILogService logService;

    private Class targetClass;
    private Date startTime;
    private Method targetMethod;


    @Before("execution(* com.zhouhang.controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) throws NoSuchMethodException {
        startTime = new Date();

        String methodName= joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        targetClass = joinPoint.getTarget().getClass();

        if (args == null || args.length == 0) {
            targetMethod = targetClass.getMethod(methodName);
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < classes.length; i++) {
                classes[i] = args[i].getClass();
            }
            targetMethod = targetClass.getMethod(methodName,classes);
        }
    }

    @After("execution(* com.zhouhang.controller.*.*(..))")
    public void finalAdvice(JoinPoint joinPoint) {
        SysLog sysLog = new SysLog();
//        System.err.println(targetClass);
//        System.err.println(targetMethod);
        if (targetMethod != null && targetClass != null && !targetClass.equals(LogAOP.class)) {
            // 获取executionTime
            long executionTime;
            executionTime = new Date().getTime() - startTime.getTime();
            //获取url
            String url = "";
            RequestMapping classUrl = (RequestMapping) targetClass.getAnnotation(RequestMapping.class);
            RequestMapping methodUrl = targetMethod.getAnnotation(RequestMapping.class);
            if (classUrl != null && methodUrl != null) {
                url = classUrl.value()[0] + methodUrl.value()[0];
            }
            //获取ip
            String ip = request.getRemoteAddr();
            //获取用户名
            String username = SecurityContextHolder.getContext().getAuthentication().getName();


            sysLog.setVisitTime(startTime);
            sysLog.setUsername(username);
            sysLog.setIp(ip);
            sysLog.setUrl(url);
            sysLog.setExecutionTime(executionTime);
            sysLog.setMethod(targetMethod.getName());

            logService.saveLog(sysLog);
        }

    }
}
