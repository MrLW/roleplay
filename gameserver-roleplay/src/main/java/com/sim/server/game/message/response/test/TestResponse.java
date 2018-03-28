package com.sim.server.game.message.response.test;

import java.util.List;

import com.sim.server.game.message.response.BaseResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class TestResponse extends BaseResponse {
	// –≠“È∫≈
	private Short responseId = 2;
	
	private List<String> list ;

	public TestResponse(Channel ctx) {
		super(ctx);
	}

	@Override
	public void write() {
		buf.writeShort(responseId);
		buf.writeArray(list);
	}

}
