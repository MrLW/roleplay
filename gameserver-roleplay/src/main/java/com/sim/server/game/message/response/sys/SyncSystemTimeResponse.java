package com.sim.server.game.message.response.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018��1��31�� ����6:40:56
 * @Function:
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SyncSystemTimeResponse extends BaseResponse {

	private short responseId = RolePlayProtocolConstant.SYNCT_SYSTEMTIME_RESPONSE_PROTOCOL;

	// ��ʼ��Ϸ�Ƿ�ɹ�
	private byte result;
	
	public SyncSystemTimeResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeShort(responseId);
		buf.writeByte(result);
	}

}
