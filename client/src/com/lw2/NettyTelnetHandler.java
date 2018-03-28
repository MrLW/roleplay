package com.lw2;

import java.net.InetAddress;
import java.util.Date;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyTelnetHandler extends SimpleChannelInboundHandler<String> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
		ctx.write("It is " + new Date() + " now.\r\n");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		System.out.println("�쳣");
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {
		System.out.println("�ѽ��յ�������.........");
		String response;
		boolean close = false;
		if (request.isEmpty()) {
			response = "Please type something.\r\n";
		} else if ("bye".equals(request.toLowerCase())) {
			response = "Have a good day!\r\n";
			close = true;
		} else {
			response = "Did you say '" + request + "'?\r\n";
		}

		ChannelFuture future = ctx.write(response.getBytes());
		
		ctx.flush();
		if (close) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}

}
