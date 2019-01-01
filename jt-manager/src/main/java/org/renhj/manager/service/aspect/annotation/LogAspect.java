package org.renhj.manager.service.aspect.annotation;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAspect {
    String value() default "";
}
