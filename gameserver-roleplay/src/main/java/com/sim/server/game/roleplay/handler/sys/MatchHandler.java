package com.sim.server.game.roleplay.handler.sys;

import java.util.List;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.common.State;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.response.sys.MatchResponse;
import com.sim.server.game.roleplay.manager.HallManager;
import com.sim.server.game.roleplay.manager.RoomManager;
import com.sim.server.game.roleplay.room.Room;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
/**
 * @author liwen
 * @date:2017年12月18日 下午6:05:13
 * @Function: 匹配请求处理
 * @version 1.0
 */
@HandlerEntity(id=RolePlayProtocolConstant.MATCH_REQUEST_PROTOCOL,desc="匹配请求处理")
public class MatchHandler extends BaseHandler{

	public void run() {
		
		MatchResponse tempResponse = new MatchResponse(channel);
		// 自动组队
		Room room = RoomManager.joinOrCreateRoom(channel);
		
		// 2、判断当前匹配队列中的玩家人数是否可以完成组队
		if (RoomManager.isComplete(room)) {
			room.setState((byte) 2);
			// 创建房间
			tempResponse.setResult((byte) State.SUCCESS);
		} else {
			// 正在匹配的人数不够
			tempResponse.setResult((byte) State.FAIL);
		}
		String roomId = RoomManager.getNewRoomIdByCtx(channel);
		List<Channel> channels = RoomManager.getContextsByRoomId(roomId);
		for (Channel channel : channels) {
			MatchResponse response = new MatchResponse(channel);
			response.setResult(tempResponse.getResult());
			response.writeAndFlush();
			
		}
	}

	@Override
	public Object clone() {
		MatchHandler handler = new MatchHandler(); 
		handler.baseRequest = this.baseRequest ;
		handler.channel = this.channel;
		return handler;
	}

}
