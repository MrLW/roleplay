package com.sim.server.game.message.response.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class ConnectResponse extends BaseResponse {
	// 总长度
	private int len ;
	// 协议号
	private short responseId = RolePlayProtocolConstant.HEARTBEAT_RESPONSE_PROTOCOL;

	public ConnectResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeShort(responseId);
	}

}
