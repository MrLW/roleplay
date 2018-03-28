package com.sim.server.game.message.response.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * 2017年11月2日 下午4:14:03
 * 此类的功能:登录成功后的响应
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginInfoResponse extends BaseResponse {

	
	private Short responseId = RolePlayProtocolConstant.LOGIN_SUCCESS_RESPONSE_PROTOCOL ;
	
	private Integer userId ;
	
	public LoginInfoResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeShort(responseId);
		buf.writeInt(userId);
	}
}
