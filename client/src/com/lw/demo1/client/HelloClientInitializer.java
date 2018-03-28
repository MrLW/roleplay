package com.lw.demo1.client;

import com.lw2.NettyTelnetHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
/**
 * 
 * @author liwen
 *
 */
public class HelloClientInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {


        ChannelPipeline pipeline = ch.pipeline();
        
        // Add the text line codec combination first,
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // ��ӱ���ͽ������
    	pipeline.addLast("decoder", new StringDecoder());
		pipeline.addLast("encoder", new StringEncoder());
        
        // ��Ӵ���ҵ�����
        pipeline.addLast(new HelloClientHandler());

    
		
		/*
		
//		 * ����ط��� ����ͷ���˶�Ӧ�ϡ������޷���������ͱ���
//		 * 
//		 * ����ͱ��� �ҽ�������һ��Ϊ�����ϸ�Ľ��⡣�ٴ���ʱ������ϸ������
//		 * 
		 
		// ��\r����\r\n��Ϊ�ָ����Ϊ��Ϣ�ķָ��
		// pipeline.addLast(new DelimiterBasedFrameDecoder(512,
		// Delimiters.lineDelimiter()));
		// ������,ճ��
//		pipeline.addLast("framerDecoder", new LengthFieldBasedFrameDecoder(4096, 0, 4, 0, 4));
//		pipeline.addLast("framerEncoder", new LengthFieldPrepender(4, false));

		pipeline.addLast("decoder", new StringDecoder());
		pipeline.addLast("encoder", new StringEncoder());
//		pipeline.addLast("decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
//		pipeline.addLast("encoder", new ObjectEncoder());
		// �ͻ��˵��߼�
		pipeline.addLast("handler", new HelloClientHandler());
		
		*/
	}
}
