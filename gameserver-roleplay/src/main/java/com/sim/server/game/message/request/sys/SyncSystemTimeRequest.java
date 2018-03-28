package com.sim.server.game.message.request.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018年1月31日 下午6:35:37
 * @Function:
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Regist(id = RolePlayProtocolConstant.SYNCT_SYSTEMTIME_REQUEST_PROTOCOL, clazz = SyncSystemTimeRequest.class)
public class SyncSystemTimeRequest extends BaseRequest {

	private short requestId = RolePlayProtocolConstant.SYNCT_SYSTEMTIME_REQUEST_PROTOCOL;
	public SyncSystemTimeRequest() {
	}
	public SyncSystemTimeRequest(ByteBuf buf) {
		super(buf);
	}

}
