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
 * @date:2017年11月13日 下午3:31:07
 * @Function: 开始匹配游戏响应
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class StartGameResponse extends BaseResponse {

	private short responseId = RolePlayProtocolConstant.STARTGAME_RESPONSE_PROTOCOL;
	// 开始游戏是否成功
	private byte result;
	// 人数
	private int playerCount;
	// 玩家的牌
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
