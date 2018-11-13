package org.renhj.aspect;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.lang.reflect.Method;
import java.util.Date;


@Aspect
@Component
public class RequestLogAspect {

    private final SysLogsDao sysLogsDao;
    private final IPUtils ipUtils;

    @Autowired
    public RequestLogAspect(SysLogsDao sysLogsDao, IPUtils ipUtils) {
        this.sysLogsDao = sysLogsDao;
        this.ipUtils = ipUtils;
    }

    @Pointcut("@annotation(org.renhj.annotation.RequestLog)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
        // 记录业务运行时间
        long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        // 保存日志
        saveLog(jp, time);
        return result;
    }

    /**
     * 将日志记录保存到数据库
     * 1、获取目标数据
     *     1.1 获取全方法名
     *     1.2 获取注解值
     *     1.3 获取方法参数
     * 2、构造日志对象
     * 3、将日志存储到数据库
     *
     * @param jp 起点
     * @param time 执行时间
     * @throws NoSuchMethodException 异常
     */
    private void saveLog(ProceedingJoinPoint jp, long time) throws NoSuchMethodException, JsonProcessingException {
        // 1.1 获取全方法名
        MethodSignature ms = (MethodSignature) jp.getSignature();
        Class<?> clz = jp.getTarget().getClass();
        String methodName = ms.getName();
        // 通过类全名和方法名构造全方法名
        String clzMethod = clz.getName() + "." + methodName;

        // 1.2 获取目标方法上的注解的值
        Method method = clz.getDeclaredMethod(methodName, ms.getParameterTypes());
        RequestLog requestLog = method.getDeclaredAnnotation(RequestLog.class);
        String operation = requestLog.value();

        // 1.3 获取参数
        Object[] args = jp.getArgs();
        String argsString = new ObjectMapper().writeValueAsString(args);

        // 2、构造日志对象
        SysLogs logs = new SysLogs();
        logs.setOperation(operation);
        logs.setCreatedTime(new Date());
        logs.setMethod(clzMethod);
        logs.setParams(argsString);
        logs.setTime(time);
        // TODO:从session中获取用户名
        logs.setUsername("admin");
        logs.setIp(ipUtils.getIP());

        // 3、将日志对象存储到数据库中
        sysLogsDao.saveLogs(logs);
    }

}
