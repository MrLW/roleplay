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
 * 2017年10月23日  下午6:58:41   
 * Function: 消息初始化
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
		// 添加心跳机制
		pipeline.addLast(new IdleStateHandler(6, 6, 0));
		pipeline.addLast(new AcceptorIdleStateTrigger());
		// 添加编码和解码的类
		pipeline.addLast(new LengthFieldBasedFrameDecoder(1024*1024, 0, 4,0,4)) ;
		// 添加心跳检查
		pipeline.addLast(new IdleStateHandler(HeartBeatConstant.READER_IDLETIME_SECONDS, HeartBeatConstant.WRITE_IDLETIME_SECONDS, HeartBeatConstant.READ_AND_WRITE_IDLETIME_SECONDS)); 
		//添加处理业务的类
		pipeline.addLast(defaultInboundHandler);
	}

}
