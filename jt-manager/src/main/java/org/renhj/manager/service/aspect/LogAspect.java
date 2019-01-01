package org.renhj.manager.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.REPEATABLE_READ)
public class LogAspect {

    @Pointcut("@annotation(org.renhj.manager.service.aspect.annotation.LogAspect)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object logAroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        Long start = System.currentTimeMillis();
        Object result = jp.proceed();
        Long end = System.currentTimeMillis();
        Long time = end - start;
        saveLog(jp, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint jp, Long time) {
    }

}
