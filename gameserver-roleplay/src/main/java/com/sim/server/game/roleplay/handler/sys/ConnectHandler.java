package com.sim.server.game.roleplay.handler.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.response.sys.ConnectResponse;
import com.sim.server.game.roleplay.manager.HallManager;
/**
 * @author liwen
 * @date:2018��1��4�� ����3:17:13
 * @Function: ����
 * @version 1.0
 */
@HandlerEntity(id=RolePlayProtocolConstant.HEARTBEAT_REQUEST_PROTOCOL,desc="����")
public class ConnectHandler extends BaseHandler {

	public void run() {
		ConnectResponse response = new ConnectResponse(channel);
		response.writeAndFlush();
	}

	@Override
	public Object clone() {
		ConnectHandler handler = new ConnectHandler(); 
		handler.baseRequest = this.baseRequest ;
		handler.channel = this.channel;
		return handler;
	}

}
