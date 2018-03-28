package com.sim.server.game.message.request.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017年11月13日 下午3:29:19
 * @Function: 开始游戏响应
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Regist(id = RolePlayProtocolConstant.STARTGAME_REQUEST_PROTOCOL, clazz = StartGameRequest.class)
public class StartGameRequest extends BaseRequest{


	private short requestId = RolePlayProtocolConstant.STARTGAME_REQUEST_PROTOCOL;
	public StartGameRequest() {
	}
	
	public StartGameRequest(ByteBuf buf) {
		super(buf);
	}
}
