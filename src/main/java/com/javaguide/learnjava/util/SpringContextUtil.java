package com.javaguide.learnjava.util;

import org.springframework.context.ApplicationContext;

/**
 * @ClassName SpringContextUtil
 * @Description: TODO
 * @Author liugaoyang
 * @Date 2020/4/2 17:04
 **/

public class SpringContextUtil {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name){
        return (T)applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}

