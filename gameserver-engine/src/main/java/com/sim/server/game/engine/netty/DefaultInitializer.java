package com.sim.server.game.engine.netty;

import org.springframework.stereotype.Service;

import com.sim.server.game.common.HeartBeatConstant;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
/**
 *  
 * @author liwen
 * 2017��10��23��  ����6:58:41   
 * Function: ��Ϣ��ʼ��
 * @version 1.0
 */
@Sharable
@Service
public class DefaultInitializer extends ChannelInitializer<SocketChannel> {
	
	private DefaultInboundHandler defaultInboundHandler;
	
	public DefaultInitializer() {
	}
	
	public DefaultInitializer(DefaultInboundHandler defaultInboundHandler) {
		this.defaultInboundHandler = defaultInboundHandler ;
	}
	
	public void setDefaultInboundHandler(DefaultInboundHandler defaultInboundHandler) {
		this.defaultInboundHandler = defaultInboundHandler;
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		
		ChannelPipeline pipeline = channel.pipeline();
		// �����������
		pipeline.addLast(new IdleStateHandler(6, 6, 0));
		pipeline.addLast(new AcceptorIdleStateTrigger());
		// ��ӱ���ͽ������
		pipeline.addLast(new LengthFieldBasedFrameDecoder(1024*1024, 0, 4,0,4)) ;
		// ����������
		pipeline.addLast(new IdleStateHandler(HeartBeatConstant.READER_IDLETIME_SECONDS, HeartBeatConstant.WRITE_IDLETIME_SECONDS, HeartBeatConstant.READ_AND_WRITE_IDLETIME_SECONDS)); 
		//��Ӵ���ҵ�����
		pipeline.addLast(defaultInboundHandler);
	}

}
