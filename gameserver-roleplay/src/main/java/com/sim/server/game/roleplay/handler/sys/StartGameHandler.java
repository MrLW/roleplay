package com.sim.server.game.roleplay.handler.sys;

import java.util.List;
import java.util.Queue;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.response.sys.StartGameResponse;
import com.sim.server.game.roleplay.config.RoomConfig;
import com.sim.server.game.roleplay.manager.RoomManager;
import com.sim.server.game.roleplay.player.Session;
import com.sim.server.game.roleplay.room.Room;

/**
 * @author liwen
 * @date:2017��12��18�� ����6:10:43
 * @Function:��ʼ��Ϸ��Ӧ
 * @version 1.0
 */
@HandlerEntity(id = RolePlayProtocolConstant.STARTGAME_REQUEST_PROTOCOL, desc = "��ʼ��Ϸ��Ӧ")
public class StartGameHandler extends BaseHandler {

	public void run() {

		try {
			RoomConfig.cyclicBarrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Room room = RoomManager.getNewRoomByCtx(channel);
		
		List<Session> sessions = room.getSessions();
		for (Session session : sessions) {
			StartGameResponse response = new StartGameResponse(session.getChannel());
			response.setPlayerCount(RoomConfig.SINGLE_TEAM_PLAYER_COUNT);
			response.setResult((byte) 1);
			response.setCards(room.getCardsByChannel(session.getChannel()));
			response.writeAndFlush();
		}
		// ����
		room.license();
		// ���ѡ��һ������
		room.shffuleLandlord();
	}

	@Override
	public Object clone() {
		StartGameHandler handler = new StartGameHandler();
		handler.baseRequest = this.baseRequest;
		handler.channel = this.channel;
		return handler;
	}

}