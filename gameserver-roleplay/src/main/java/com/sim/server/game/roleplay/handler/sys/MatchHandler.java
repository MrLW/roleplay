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
 * @date:2017��12��18�� ����6:05:13
 * @Function: ƥ��������
 * @version 1.0
 */
@HandlerEntity(id=RolePlayProtocolConstant.MATCH_REQUEST_PROTOCOL,desc="ƥ��������")
public class MatchHandler extends BaseHandler{

	public void run() {
		
		MatchResponse tempResponse = new MatchResponse(channel);
		// �Զ����
		Room room = RoomManager.joinOrCreateRoom(channel);
		
		// 2���жϵ�ǰƥ������е���������Ƿ����������
		if (RoomManager.isComplete(room)) {
			room.setState((byte) 2);
			// ��������
			tempResponse.setResult((byte) State.SUCCESS);
		} else {
			// ����ƥ�����������
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
