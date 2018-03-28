package com.sim.server.game.message.request;

import com.sim.server.game.common.EnhancedByteBuf;

import io.netty.buffer.ByteBuf;
/**
 * @author liwen
 * @date:2017年12月15日 下午5:22:37
 * @Function: 消息请求的基类
 * @version 1.0
 */
public class BaseRequest {
	
	public Integer len;
	
	public EnhancedByteBuf byteBuf;
	
	public BaseRequest() {
		
	}

	public BaseRequest(ByteBuf buf) {
		byteBuf = new EnhancedByteBuf(buf);
		len = buf.readableBytes();
	}

	public Integer getLen() {
		return len;
	}

	public void setLen(Integer len) {
		this.len = len;
	}
	
	
}
