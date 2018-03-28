package com.sim.server.game.message.response.room;

import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018年3月27日 下午2:34:06
 * @Function: 抢地主响应
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class GlabLandlordResponse extends BaseResponse{

	// 协议号
	private short responseId = 1; 
	// 玩家ID
	private int userId ;
	// 玩家为userId抢地主的结果
	private byte result ;
	
	public GlabLandlordResponse(Channel channel) {
		super(channel);
	}
	
	@Override
	public void write() {
		buf.writeShort(responseId);
		buf.writeInt(userId);
		buf.writeByte(result);
	}

}
