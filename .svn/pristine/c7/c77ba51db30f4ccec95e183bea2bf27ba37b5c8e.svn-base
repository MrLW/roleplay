package com.sim.server.game.roleplay.manager;

import java.util.List;

import com.sim.server.game.model.model.PlayerInfo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

/**
 * @author liwen
 * @date:2017年11月22日 下午1:38:44
 * @Function: 对ChannelHandlerContext的管理
 * @version 1.0
 */
public class ContextManager {
	
	private ContextManager() {
	}
	
	private static ContextManager manager ;
	
	public static ContextManager getInstance() {
		if(manager == null ) {
			synchronized (ContextManager.class) {
				if (manager == null ) {
					manager = new ContextManager() ;
				}
			}
		}
		return manager ;
	}
	/**
	 *  根据上下文获取ByteBuf
	 * @param ctx 上下文对象
	 * @return 缓冲对象
	 */
	public ByteBuf getByteBuf(ChannelHandlerContext ctx) {
		ByteBufAllocator alloc = ctx.alloc();
		ByteBuf buf = alloc.buffer();
		return buf ;
	}
	
	/**
	 *  根据socket获取ByteBuf
	 * @param socket socket对象
	 * @return 缓冲对象
	 */
	public ByteBuf getByteBuf(SocketChannel ctx) {
		ByteBufAllocator alloc = ctx.alloc();
		ByteBuf buf = alloc.buffer();
		return buf ;
	}
	
	
	
}
