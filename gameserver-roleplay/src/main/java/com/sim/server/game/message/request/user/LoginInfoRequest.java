package com.sim.server.game.message.request.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen 2017��11��2�� ����4:08:15 ����Ĺ���: ��¼�ɹ��������
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Regist(id = RolePlayProtocolConstant.LOGIN_SUCCESS_REQUEST_PROTOCOL, clazz = LoginInfoRequest.class)
public class LoginInfoRequest extends BaseRequest {

	
	private short requestId = RolePlayProtocolConstant.LOGIN_SUCCESS_REQUEST_PROTOCOL;
	
	public LoginInfoRequest() {
	}
	
	public LoginInfoRequest(ByteBuf buf) {
		super(buf);
		this.len = buf.readableBytes() ;
	}
	

}
