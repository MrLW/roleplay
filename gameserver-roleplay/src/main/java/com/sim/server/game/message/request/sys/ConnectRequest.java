package com.sim.server.game.message.request.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2018��1��4�� ����3:04:42
 * @Function: �������
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Regist(id = RolePlayProtocolConstant.HEARTBEAT_REQUEST_PROTOCOL, clazz = ConnectRequest.class)
public class ConnectRequest extends BaseRequest {
	// ����Э���
	private short requestId = RolePlayProtocolConstant.HEARTBEAT_REQUEST_PROTOCOL;
	
	public ConnectRequest() {
		// TODO Auto-generated constructor stub
	}
	public ConnectRequest(ByteBuf buf) {
		this.len = buf.readableBytes();
	}

}
