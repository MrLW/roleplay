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
		// ��¼����-------------start
		System.out.println("�ͻ��˶�ȡ��������");
		ByteBuf buf = (ByteBuf)obj;
		// �ܳ���
		int totalLen = buf.readInt();
		System.out.println(totalLen);
		// Э��
        short len = buf.readShort();
        // ���
        byte result = buf.readByte() ;
        if(result == 1 ) {
        	System.out.println("��¼�ɹ�");
        } else {
        	System.out.println("��¼ʧ��");
        }
        // ��¼����-------------end
		
		//���뷿�����
		/*
		ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		byte result = buf.readByte();
		System.out.println("result:" + result + ";" +totalLen);
		if( 1==result ) {
			System.out.println("��ϲ��,����ɹ�,��ǰ��������");
		} else if( 0 == result ) {
			System.out.println("������˼,����ʧ��,������");
		} else if( -1 == result ) {
			System.out.println("������˼,�����ķ����Ѿ�����~~~");
		}
		*/
		/*
		// ��������
		ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		System.out.println("ID:" + protocolId);*/
		/*ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		System.out.println("�ͻ��˶�ȡ����:" + totalLen + ";" + protocolId);*/
		/*
		ByteBuf buf = (ByteBuf)obj;
		int totalLen = buf.readInt();
		short protocolId = buf.readShort();
		System.out.println(totalLen + "---" + protocolId);*/
		
	}
	/**
	 *  ���ͻ������ӳɹ���,��ͻ��˷�������
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		UnpooledByteBufAllocator allocator = new UnpooledByteBufAllocator(false);
		ByteBuf buffer = allocator.buffer(20);
		// ע�����----------start
//		String name = "aa" ;
//		String password = "123456" ;
//		String email = "aa@qq.com";
//		buffer.writeInt(25);
//		buffer.writeShort(1000);
//		// �û���
//		buffer.writeShort(name.length());
//		buffer.writeBytes(name.getBytes());
//		// ����
//		buffer.writeShort(password.length());
//		buffer.writeBytes(password.getBytes());
//		// ����
//		buffer.writeShort(email.length()); 
//		buffer.writeBytes(email.getBytes()) ;
		// ע�����----------end
		
		// ��¼����-----start
		String name = "aabbcc" ;
		String password = "123456" ;
		buffer.writeInt(18) ;
		buffer.writeShort(1002) ;
		buffer.writeShort(name.length()) ;
		buffer.writeBytes(name.getBytes()) ;
		buffer.writeShort(password.length()) ;
		buffer.writeBytes(password.getBytes());
		ctx.writeAndFlush(buffer);
		// ��¼����-----end
		
		// ���뷿�����
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
		// ��������
		buffer.writeInt(2) ;
		buffer.writeShort(1006);
		ctx.writeAndFlush(buffer) ;*/
		// ��Ϣ����
		/*buffer.writeInt(14) ;
		buffer.writeShort(1008);
		buffer.writeFloat((Float)1.0f);
		buffer.writeFloat((Float)2.0f);
		buffer.writeFloat((Float)3.0f);
		ctx.writeAndFlush(buffer);*/
		
		// ���Լ��Ϸ���
		/*
		buffer.writeInt(24) ;
		buffer.writeShort(1020) ;
		buffer.writeShort(2) ;
		// һ��Person 8���ֽ�
		buffer.writeInt(20) ;
		buffer.writeShort(2);
		buffer.writeBytes("zs".getBytes());
		
		buffer.writeInt(20) ;
		buffer.writeShort(2);
		buffer.writeBytes("ls".getBytes());
		
		ctx.writeAndFlush(buffer) ;*/
		
		
		// �ƶ�Э��
		/*buffer.writeInt(18) ;
		buffer.writeShort(4000);
		buffer.writeInt(1) ;
		buffer.writeInt(2) ;
		buffer.writeInt(3) ;
		buffer.writeInt(4) ;
		ctx.writeAndFlush(buffer) ;*/
		
	}
}
