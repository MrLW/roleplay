package com.sim.server.game.roleplay.handler.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.response.sys.SyncSystemTimeResponse;
import com.sim.server.game.roleplay.manager.RoomManager;
import com.sim.server.game.roleplay.room.Room;

import io.netty.channel.ChannelHandlerContext;
/**
 * @author liwen
 * @date:2018年1月31日 下午6:31:27
 * @Function: 同步系统时间
 * @version 1.0
 */
@HandlerEntity(id=RolePlayProtocolConstant.SYNCT_SYSTEMTIME_REQUEST_PROTOCOL,desc="同步系统时间")
public class SyncSystemTimeHandler extends BaseHandler {
	

	@Override
	public void run() {
		Room room = RoomManager.getNewRoomByCtx(channel);
		SyncSystemTimeResponse response = new SyncSystemTimeResponse(channel); 
		response.setResult((byte)1);
		response.writeAndFlush();
	}

	@Override
	public Object clone() {
		SyncSystemTimeHandler handler = new SyncSystemTimeHandler(); 
		handler.baseRequest = this.baseRequest ;
		handler.channel = this.channel; 
		return handler;
	}

}
