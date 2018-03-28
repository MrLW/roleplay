package com.sim.server.game.message.response.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author liwen 2017年10月25日 上午10:27:32 Function: 注册响应
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RegisterResponse extends BaseResponse {
	// 响应ID
	private short responseId = RolePlayProtocolConstant.REGISTE_RESPONSE_PROTOCOL;
	// 注册的返回结果
	private byte result;
	
	public RegisterResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeByte(result);
	}
}
