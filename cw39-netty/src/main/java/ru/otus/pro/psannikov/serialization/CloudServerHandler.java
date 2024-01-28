package ru.otus.pro.psannikov.serialization;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CloudServerHandler extends SimpleChannelInboundHandler<MyMessage> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client connected...");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client disconnected...");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
        System.out.println("Client text message: " + msg.getText());
        ctx.writeAndFlush(new MyMessage("Hello Client!"));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
