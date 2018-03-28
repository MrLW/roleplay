package com.sim.server.game.engine.handler;

import com.sim.server.game.message.request.BaseRequest;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
/**
 * @author liwen
 * @date:2017年11月29日 下午5:25:45
 * @Function: the base class of handler and it is a runnable obj
 * @version 1.0
 */
public abstract class BaseHandler implements Runnable {
	
	// base request 
	public BaseRequest baseRequest ;
	
	public Channel channel ;
	
	public void setRequest(BaseRequest request) {
		this.baseRequest = request ;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public abstract Object clone();
}
