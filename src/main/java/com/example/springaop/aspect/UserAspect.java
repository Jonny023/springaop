package com.example.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: Jonny
 * @date: 2021-01-19
 */
@Aspect
@Component
public class UserAspect {

    /**
     * 定义切入点
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("@annotation(com.example.springaop.annotation.Auto)")
    public void cut() {}

    /**
     * @description 使用环绕通知
     */
    @Around("cut()")
    public Object doAroundGameData(ProceedingJoinPoint pjp) {
        try {

            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            String uid = requestAttributes.getRequest().getParameter("uid");

            Object target = pjp.proceed();
            //获取父类属性
            Field field = target.getClass().getSuperclass().getDeclaredField("userId");
            field.setAccessible(true);//如果是私有的 先要设置可访问

            //给指定的属性赋值
            field.set(target, uid);
            return target;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
