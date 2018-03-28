package com.sim.server.game.message.response.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author liwen 2017��10��25�� ����10:27:32 Function: ע����Ӧ
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RegisterResponse extends BaseResponse {
	// ��ӦID
	private short responseId = RolePlayProtocolConstant.REGISTE_RESPONSE_PROTOCOL;
	// ע��ķ��ؽ��
	private byte result;
	
	public RegisterResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeByte(result);
	}
}
