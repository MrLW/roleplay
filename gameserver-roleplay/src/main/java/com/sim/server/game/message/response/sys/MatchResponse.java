package com.sim.server.game.message.response.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017年11月13日 下午3:30:06
 * @Function: 匹配响应
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MatchResponse extends BaseResponse{
	
	private short responseId = RolePlayProtocolConstant.MATCH_RESPONSE_PROTOCOL ;
	// 是否匹配成功
	private byte result ;
	
	public MatchResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeShort(responseId);
		buf.writeByte(result);
	}
	
	
}
