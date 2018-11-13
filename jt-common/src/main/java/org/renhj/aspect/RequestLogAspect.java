package org.renhj.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.renhj.annotation.RequestLog;
import org.renhj.dao.SysLogsDao;
import org.renhj.entity.SysLogs;
import org.renhj.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;


@Aspect
@Component
@Transactional
public class RequestLogAspect {

    private final SysLogsDao sysLogsDao;

    @Autowired
    public RequestLogAspect(SysLogsDao sysLogsDao) {
        this.sysLogsDao = sysLogsDao;
    }

    @Pointcut("@annotation(org.renhj.annotation.RequestLog)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object arrountMehtod(ProceedingJoinPoint jp) throws Throwable {
        // 记录业务运行时间
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        // 保存日志
        saveLog(jp, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint jp, long time) throws NoSuchMethodException {
        // 1、获取目标数据
        Class<?> clz = jp.getTarget().getClass(); // 目标对象
        MethodSignature methodSignature = (MethodSignature) jp.getSignature(); // 获取执行方法的签名信息
        String methodName = methodSignature.getName();
        Method method = methodSignature.getMethod();
        Method method1 = clz.getDeclaredMethod(methodName, methodSignature.getParameterTypes());

        // 获取目标方法上的注解
        RequestLog requestLog = method1.getDeclaredAnnotation(RequestLog.class);
        // 获取注解的值
        String operation = requestLog.operation();
        // 获取参数
        Object[] args = jp.getArgs();

        SysLogs logs = new SysLogs();
        logs.setCreatedTime(new Date());
        logs.setMethod(methodName);
        logs.setParams(Arrays.toString(args));
        logs.setTime(time);
        // TODO:从session中获取用户名
        logs.setUsername("admin");
        logs.setIp(IPUtils.getIP());

        sysLogsDao.saveLogs(logs);
    }

}
