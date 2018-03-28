package com.sim.server.game.message.request.test;

import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
@Regist(id = 1, clazz = TestRequest.class)
public class TestRequest extends BaseRequest {
	// «Î«Û–≠“È∫≈
	private short requestId = 1;
	
	public TestRequest() {
	}
	public TestRequest(ByteBuf buf) {
		super(buf);
	}
}
