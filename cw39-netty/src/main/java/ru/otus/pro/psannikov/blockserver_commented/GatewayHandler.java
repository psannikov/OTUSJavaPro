package ru.otus.pro.psannikov.blockserver_commented;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Arrays;

// Стоит после SecondHandler
public class GatewayHandler extends ChannelInboundHandlerAdapter {
    Runnable a;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        a = () -> {
            System.out.println(ctx);
        };
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        int sum = 0;
        byte[] arr = (byte[]) msg;
        for (int i = 0; i < 3; i++) {
            sum += arr[i];
        }
        if (sum == 66) {
            ctx.fireChannelRead(arr);
        } else {
            System.out.println("Сообщение сломано: " + Arrays.toString(arr));
            // Отправляем клиенту в обратную сторону сообщение об ошибке
            ctx.writeAndFlush("Битое сообщение\n");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
