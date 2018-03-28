package com.sim.server.game.message.request.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017年11月13日 下午3:26:17
 * @Function:匹配游戏请求
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Regist(id = RolePlayProtocolConstant.MATCH_REQUEST_PROTOCOL, clazz = MatchRequest.class)
public class MatchRequest extends BaseRequest{

	
	private short requestId = RolePlayProtocolConstant.MATCH_REQUEST_PROTOCOL ;
	
	public MatchRequest() {
	}
	
	public MatchRequest(ByteBuf buf) {
		super(buf);
		this.len = buf.readableBytes() ;
	}

	
	
}
