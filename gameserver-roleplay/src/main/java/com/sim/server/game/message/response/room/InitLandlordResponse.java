package com.sim.server.game.message.response.room;

import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018��3��27�� ����2:30:55
 * @Function: �ս��뷿���ʼ��һ��������Ӧ
 * @version 1.0
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class InitLandlordResponse extends BaseResponse {

	// Э���
	private short responseId = 1; 
	
	public InitLandlordResponse(Channel ctx) {
		super(ctx);
	}
	
	@Override
	public void write() {
		buf.writeShort(responseId);
	}

}