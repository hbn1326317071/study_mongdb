package com.hbn.study.mongodblearning.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.channels.SocketChannel;

/**
 * @ClassNmae Netty
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/22 16:23
 * @Version 1.0
 */
public class Netty {


    public void start(int port) throws Exception{}
//    {
//        ServerBootstrap strap = new ServerBootstrap();
//        //主线程
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        //从线程
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try {
//            strap.group(bossGroup, workerGroup).
//                    //主线程监听通道
//                            channel(NioServerSocketChannel.class).
//                    option(ChannelOption.SO_BACKLOG, 1024).
//                    //定义从线程的handler链，责任链模式
//                            childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new NettyServerHandler());
//                        }
//                    });
//            ChannelFuture future=strap.bind(port).sync();
//            future.channel().closeFuture().sync();
//        }finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//
//    }

    public static void main(String[] args) throws Exception {
        System.out.println("start server");
        new Netty().start(8000);
    }

}
