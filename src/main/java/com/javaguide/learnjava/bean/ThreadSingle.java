package com.javaguide.learnjava.bean;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadSingle
 * @Description: TODO
 * @Author liugaoyang
 * @Date 2020/4/2 11:41
 **/

public class ThreadSingle {
    private String beanName;
    private ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(12);
    private ThreadSingle(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public ExecutorService getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ExecutorService threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }
}
