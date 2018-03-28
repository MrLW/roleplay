package com.sim.server.game.message.request.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017��11��13�� ����3:29:19
 * @Function: ��ʼ��Ϸ��Ӧ
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
