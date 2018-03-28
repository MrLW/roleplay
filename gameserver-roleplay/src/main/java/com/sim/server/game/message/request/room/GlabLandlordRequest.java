package com.sim.server.game.message.request.room;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018��3��27�� ����2:39:21
 * @Function: ����������
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Regist(id = RolePlayProtocolConstant.HEARTBEAT_REQUEST_PROTOCOL, clazz = GlabLandlordRequest.class)
public class GlabLandlordRequest extends BaseRequest {

	// ����Э���
	private short requestId ;
	
	private byte result ;
	
	public GlabLandlordRequest() {
	}
	
	public GlabLandlordRequest(ByteBuf buf) {
		super(buf);
		this.len = buf.readableBytes();
		this.result = buf.readByte() ;
	}
		
}
