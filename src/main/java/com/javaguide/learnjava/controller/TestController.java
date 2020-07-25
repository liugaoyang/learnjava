package com.javaguide.learnjava.controller;

import com.javaguide.learnjava.bean.ThreadSingle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description: TODO
 * @Author liugaoyang
 * @Date 2020/4/2 16:54
 **/
@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger("stash");
    @Autowired
    ApplicationContext applicationContext;


    @RequestMapping("/regist")
    public String testRegist(@RequestParam("beanname") String beanname){
        BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(ThreadSingle.class);
        beanDefinitionBuilder.addConstructorArgValue(beanname);
        BeanDefinition beanDefinition= beanDefinitionBuilder.getRawBeanDefinition();
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        BeanDefinitionRegistry beanFactory =  (BeanDefinitionRegistry)configurableApplicationContext.getBeanFactory();
        if(applicationContext.containsBean(beanname)){
            return "已经注册过";
        }
        beanFactory.registerBeanDefinition(beanname,beanDefinition);

        return "注册成功";
    }

    @RequestMapping("/get")
    public String testget(@RequestParam("beanname") String beanname){
        if(applicationContext.containsBean(beanname)){
            ThreadSingle bean = (ThreadSingle)applicationContext.getBean(beanname);
            return bean.getBeanName();
        }
        return "没有发现此bean";
    }

    @RequestMapping("/get2")
    public String testget(){

        return "hahaahah";
    }

    @RequestMapping("/testlog")
    public String testlog(){
        logger.info("生成日志了吗");
        return "生成日志了吗";
    }


}
