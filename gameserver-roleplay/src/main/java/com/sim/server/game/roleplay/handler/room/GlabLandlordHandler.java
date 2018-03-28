package com.sim.server.game.roleplay.handler.room;

import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.request.room.GlabLandlordRequest;
import com.sim.server.game.roleplay.manager.RoomManager;
import com.sim.server.game.roleplay.room.Room;

/**
 * @author liwen
 * @date:2018��3��27�� ����5:38:41
 * @Function: ������
 * @version 1.0
 */
@HandlerEntity(id=1,desc="����")
public class GlabLandlordHandler extends BaseHandler {

	@Override
	public void run() {
		GlabLandlordRequest request = (GlabLandlordRequest) baseRequest ;
		// �� �������
		byte result = request.getResult();
		Room room = RoomManager.getNewRoomByCtx(channel);
		room.glabLandlor(channel,result);
	}

	@Override
	public Object clone() {
		GlabLandlordHandler handler = new GlabLandlordHandler(); 
		handler.baseRequest = this.baseRequest ;
		handler.channel = this.channel;
		return handler;
	}

}