package com.lw3.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class BusinessServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		int length = buf.readInt();
		System.out.println("-----------------" + length);
		assert length == (8);

		byte[] head = new byte[4];
		buf.readBytes(head);
		String headString = new String(head);
		System.out.println("-----------------" + headString);
		assert "head".equals(headString);

		byte[] body = new byte[4];
		buf.readBytes(body);
		String bodyString = new String(body);
		System.out.println("-----------------" + bodyString);
		assert "body".equals(bodyString);
	}
}
