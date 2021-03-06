package com.sim.server.game.message.response.room;

import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018年3月27日 下午2:30:55
 * @Function: 刚进入房间初始化一个地主响应
 * @version 1.0
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class InitLandlordResponse extends BaseResponse {

	// 协议号
	private short responseId = 1; 
	
	public InitLandlordResponse(Channel ctx) {
		super(ctx);
	}
	
	@Override
	public void write() {
		buf.writeShort(responseId);
	}

}
