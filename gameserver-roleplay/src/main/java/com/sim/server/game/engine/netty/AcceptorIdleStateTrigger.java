package com.sim.server.game.engine.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
/**
 * @author liwen
 * @date:2018年1月10日 下午3:20:42
 * @Function: 心跳检查机制
 * @version 1.0
 */
@Sharable
public class AcceptorIdleStateTrigger extends ChannelInboundHandlerAdapter {
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleState state = ((IdleStateEvent) evt).state();
			/*if (state == IdleState.READER_IDLE) {
				System.out.println("服务端读超时~");
			} else if (state == IdleState.WRITER_IDLE) {
				System.out.println("服务端写超时~");
			} else if (state == IdleState.ALL_IDLE) {
				System.out.println("服务端读写超时~");
			}*/
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}
}
