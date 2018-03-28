package com.sim.server.game.roleplay.handler.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.response.sys.ConnectResponse;
import com.sim.server.game.roleplay.manager.HallManager;
/**
 * @author liwen
 * @date:2018年1月4日 下午3:17:13
 * @Function: 心跳
 * @version 1.0
 */
@HandlerEntity(id=RolePlayProtocolConstant.HEARTBEAT_REQUEST_PROTOCOL,desc="心跳")
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
