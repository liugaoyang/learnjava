package com.javaguide.learnjava.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

@Component
@Order(2)
public class NettyClient implements CommandLineRunner {
    @Value("${server.netty.host}")
    private String host;
    @Value("${server.netty.port}")
    private int port;

    public static volatile Channel channel;

    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap  = new Bootstrap()
                    .group(group)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer());
            ChannelFuture f = bootstrap.connect().sync();
            channel =f.channel();

            //f.channel().closeFuture().sync();
            //发送心跳
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Executors.newFixedThreadPool(1).execute(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        channel.writeAndFlush("<heartbeat>hello,i'm a client</heartbeat>"+"\n");
                        try {
                            Thread.sleep(26000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            f.channel().closeFuture().sync();
            //发送消息
            /*while(true){
                channel.write(in.readLine() + "\r\n");
                channel.flush();
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("客户端启动======");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

