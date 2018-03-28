package com.sim.server.game.message.response.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017��11��29�� ����6:10:10
 * @Function:  login response
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginResponse extends BaseResponse {

	// Э���
	private short responseId = RolePlayProtocolConstant.LOGIN_RESPONSE_PROTOCOL;
	// ��¼���ؽ��
	private byte result;


	public LoginResponse(Channel ctx) {
		super(ctx);
	}

	
	public void write() {
		buf.writeShort(responseId);
		buf.writeByte(result);
	}
	
	
}
