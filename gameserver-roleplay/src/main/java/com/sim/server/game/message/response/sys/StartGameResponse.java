package com.sim.server.game.message.response.sys;

import java.util.List;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017��11��13�� ����3:31:07
 * @Function: ��ʼƥ����Ϸ��Ӧ
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class StartGameResponse extends BaseResponse {

	private short responseId = RolePlayProtocolConstant.STARTGAME_RESPONSE_PROTOCOL;
	// ��ʼ��Ϸ�Ƿ�ɹ�
	private byte result;
	// ����
	private int playerCount;
	// ��ҵ���
	private List<Byte> cards ;
	
	public StartGameResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeShort(responseId);
		buf.writeByte(result);
		buf.writeInt(playerCount);
		buf.writeArray(cards);
	}

}