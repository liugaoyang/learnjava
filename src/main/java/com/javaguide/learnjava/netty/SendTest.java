package com.javaguide.learnjava.netty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Order(3)
public class SendTest implements CommandLineRunner {

    void testsend() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //发送消息
        while(true){
            try {
                NettyClient.channel.write(in.readLine() + "\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            NettyClient.channel.flush();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("测试发送消息");
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                testsend();
            }
        }).start();
    }
}
