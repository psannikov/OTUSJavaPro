package ru.otus.pro.psannikov.proto_file;

import ru.otus.pro.psannikov.offtop_callbacks.Callback;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class DemoHandler extends ChannelInboundHandlerAdapter {
    private Callback onReceivedCallback;

    public void setOnReceivedCallback(Callback onReceivedCallback) {
        this.onReceivedCallback = onReceivedCallback;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // file receiving
        onReceivedCallback.callback();
    }
}
