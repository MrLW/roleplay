package com.lw3.client;

import java.util.ArrayList;
import java.util.List;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SocketClientHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
		// 登录测试-------------start
		System.out.println("客户端读取到了数据");
		ByteBuf buf = (ByteBuf)obj;
		// 总长度
		int totalLen = buf.readInt();
		System.out.println(totalLen);
		// 协议
        short len = buf.readShort();
        // 结果
        byte result = buf.readByte() ;
        if(result == 1 ) {
        	System.out.println("登录成功");
        } else {
        	System.out.println("登录失败");
        }
        // 登录测试-------------end
		
		//加入房间测试
		/*
		ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		byte result = buf.readByte();
		System.out.println("result:" + result + ";" +totalLen);
		if( 1==result ) {
			System.out.println("恭喜你,加入成功,当前房间有人");
		} else if( 0 == result ) {
			System.out.println("不好意思,加入失败,请重试");
		} else if( -1 == result ) {
			System.out.println("不好意思,你加入的房间已经满了~~~");
		}
		*/
		/*
		// 心跳测试
		ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		System.out.println("ID:" + protocolId);*/
		/*ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		System.out.println("客户端读取数据:" + totalLen + ";" + protocolId);*/
		/*
		ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		System.out.println(totalLen + "---" + protocolId);*/
		
	}
	/**
	 *  当客户端连接成功后,向客户端发送数据
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		UnpooledByteBufAllocator allocator = new UnpooledByteBufAllocator(false);
		ByteBuf buffer = allocator.buffer(20);
		// 注册测试----------start
//		String name = "aa" ;
//		String password = "123456" ;
//		String email = "aa@qq.com";
//		buffer.writeInt(25);
//		buffer.writeShort(1000);
//		// 用户名
//		buffer.writeShort(name.length());
//		buffer.writeBytes(name.getBytes());
//		// 密码
//		buffer.writeShort(password.length());
//		buffer.writeBytes(password.getBytes());
//		// 邮箱
//		buffer.writeShort(email.length()); 
//		buffer.writeBytes(email.getBytes()) ;
		// 注册测试----------end
		
		// 登录测试-----start
		String name = "aabbcc" ;
		String password = "123456" ;
		buffer.writeInt(18) ;
		buffer.writeShort(1002) ;
		buffer.writeShort(name.length()) ;
		buffer.writeBytes(name.getBytes()) ;
		buffer.writeShort(password.length()) ;
		buffer.writeBytes(password.getBytes());
		ctx.writeAndFlush(buffer);
		// 登录测试-----end
		
		// 加入房间测试
		/*
		String roomId = "A101" ;
		buffer.writeInt(8);
		buffer.writeShort(1004) ;
		buffer.writeShort(roomId.length()) ;
		buffer.writeBytes(roomId.getBytes()) ;
		ctx.writeAndFlush(buffer);
		*/
//		for(int i = 1 ; i <= 6 ; i++ ) {
//			buffer.writeInt(2) ;
//			buffer.writeShort(1006);
//			ctx.writeAndFlush(buffer) ;
//			Thread.sleep(i*1000);
//		}
		/*
		// 心跳测试
		buffer.writeInt(2) ;
		buffer.writeShort(1006);
		ctx.writeAndFlush(buffer) ;*/
		// 消息长度
		/*buffer.writeInt(14) ;
		buffer.writeShort(1008);
		buffer.writeFloat((Float)1.0f);
		buffer.writeFloat((Float)2.0f);
		buffer.writeFloat((Float)3.0f);
		ctx.writeAndFlush(buffer);*/
		
		// 测试集合发送
		/*
		buffer.writeInt(24) ;
		buffer.writeShort(1020) ;
		buffer.writeShort(2) ;
		// 一个Person 8个字节
		buffer.writeInt(20) ;
		buffer.writeShort(2);
		buffer.writeBytes("zs".getBytes());
		
		buffer.writeInt(20) ;
		buffer.writeShort(2);
		buffer.writeBytes("ls".getBytes());
		
		ctx.writeAndFlush(buffer) ;*/
		
		
		// 移动协议
		/*buffer.writeInt(18) ;
		buffer.writeShort(4000);
		buffer.writeInt(1) ;
		buffer.writeInt(2) ;
		buffer.writeInt(3) ;
		buffer.writeInt(4) ;
		ctx.writeAndFlush(buffer) ;*/
		
	}
}
