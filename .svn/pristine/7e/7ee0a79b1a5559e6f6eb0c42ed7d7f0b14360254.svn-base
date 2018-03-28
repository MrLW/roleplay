package com.sim.server.game.engine.handler;

import com.sim.server.game.message.request.BaseRequest;

import io.netty.channel.ChannelHandlerContext;

public abstract class IBaseHandler {

	// base request
	public BaseRequest request;
	// client context
	public ChannelHandlerContext ctx;
	
	public void setRequest(BaseRequest request) {
		this.request = request;
	}

	public void setCtx(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}
	
	public abstract void handle() ;
}
