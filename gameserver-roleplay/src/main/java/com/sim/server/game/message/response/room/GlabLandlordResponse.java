package com.sim.server.game.message.response.room;

import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liwen
 * @date:2018��3��27�� ����2:34:06
 * @Function: ��������Ӧ
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class GlabLandlordResponse extends BaseResponse{

	// Э���
	private short responseId = 1; 
	// ���ID
	private int userId ;
	// ���ΪuserId�������Ľ��
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