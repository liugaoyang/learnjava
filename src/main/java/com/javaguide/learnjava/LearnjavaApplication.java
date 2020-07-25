package com.javaguide.learnjava;

import com.javaguide.learnjava.netty.NettyServer;
import com.javaguide.learnjava.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

@SpringBootApplication
public class LearnjavaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearnjavaApplication.class, args);
        SpringContextUtil.setApplicationContext(context);
    }

}
