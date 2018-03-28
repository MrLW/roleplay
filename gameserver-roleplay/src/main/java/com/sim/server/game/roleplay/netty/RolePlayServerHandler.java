package com.sim.server.game.roleplay.netty;

import java.util.concurrent.Executors;

import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.engine.netty.DefaultInboundHandler;
import com.sim.server.game.roleplay.manager.RoomManager;
import com.sim.server.game.roleplay.manager.UserManager;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
/**
 * @author liwen
 * @date:2017年12月14日 下午2:49:29
 * @Function:
 * @version 1.0
 */
public class RolePlayServerHandler extends DefaultInboundHandler {
	
	
	public RolePlayServerHandler(String modelName) {
		super(modelName);
	}
	
	@Override
	protected void messageHandler(BaseHandler handle) {
		Executors.newFixedThreadPool(5).execute(handle);
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		Channel channel = ctx.channel();
		RoomManager.removeFromRoom(channel);
		UserManager.drop(ctx);
	}
}
