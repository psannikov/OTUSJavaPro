package ru.otus.pro.psannikov.new_slice_server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Arrays;

public class SliceHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        if (buf.readableBytes() < 5) {
            buf.release();
            return;
        }
        byte[] data = new byte[5];
        buf.readBytes(data);
        System.out.println(buf.readerIndex());
        System.out.println(buf.readableBytes());
        // buf.release();
        System.out.println(buf.getClass().getName());
        System.out.println(Arrays.toString(data));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
