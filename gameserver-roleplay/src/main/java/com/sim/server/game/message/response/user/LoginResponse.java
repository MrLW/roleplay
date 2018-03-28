package com.sim.server.game.message.response.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017年11月29日 下午6:10:10
 * @Function:  login response
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginResponse extends BaseResponse {

	// 协议号
	private short responseId = RolePlayProtocolConstant.LOGIN_RESPONSE_PROTOCOL;
	// 登录返回结果
	private byte result;


	public LoginResponse(Channel ctx) {
		super(ctx);
	}

	
	public void write() {
		buf.writeShort(responseId);
		buf.writeByte(result);
	}
	
	
}
