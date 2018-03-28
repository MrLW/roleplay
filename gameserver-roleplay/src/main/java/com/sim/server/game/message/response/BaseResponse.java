package com.sim.server.game.message.response;

import com.sim.server.game.common.EnhancedByteBuf;
import com.sim.server.game.common.RolePlayProtocolConstant;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
/**
 * @author liwen
 * @date:2017年11月29日 下午5:52:46
 * @Function:消息响应的基类
 * @version 1.0
 */
@Data
public abstract class BaseResponse {
	
	private Channel channel ;
	
	
	public EnhancedByteBuf buf;
	
	public BaseResponse() {
	}
	
	public BaseResponse(Channel channel) {
		this.channel = channel;
		buf = new EnhancedByteBuf(channel.alloc().buffer());
		// set write index 
		buf.writeIndex(RolePlayProtocolConstant.PACK_LEN) ;
	}
	/**
	 *  write and flush buffer
	 */
	public void writeAndFlush() {
		write();
		flush();
	}
	/**
	 *  flush data
	 */
	public void flush() {
		ByteBuf byteBuf = buf.getBuf();
		// total length
		int totalTen = byteBuf.writerIndex();
		// sub the head-len
		totalTen -= RolePlayProtocolConstant.PACK_LEN;
		
		byteBuf.setInt(0, totalTen);
		
		channel.writeAndFlush(buf.getBuf());
	}
	/**
	 *  write buffer,sub class implements do something
	 */
	public abstract void write();
	
	
}
