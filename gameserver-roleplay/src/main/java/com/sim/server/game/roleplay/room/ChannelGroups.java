package com.sim.server.game.roleplay.room;

import java.util.HashMap;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
/**
 * @author liwen
 * 2017年11月3日 下午1:57:46
 * 此类的功能:管理channel
 * @version 1.0
 */
public class ChannelGroups {
	
	public static final Map<String, ChannelGroup> channelGroupRoomMap = new HashMap<String, ChannelGroup>() ;
	
	/**
	 * @param channel socket连接
	 * @param roomId 房间号
	 */
	public static void add(Channel channel,String roomId) {
		ChannelGroup channelGroup = channelGroupRoomMap.get(roomId);
		if(channelGroup != null ) {
			channelGroup.add(channel);
		}
	}

	public static ChannelGroupFuture broadcast(Object msg,String roomId) {
		return channelGroupRoomMap.get(roomId).writeAndFlush(msg);
	}

	public static ChannelGroupFuture broadcast(Object msg, ChannelMatcher matcher,String roomId) {
		return channelGroupRoomMap.get(roomId).writeAndFlush(msg, matcher);
	}

	public static ChannelGroup flush(String roomId) {
		return channelGroupRoomMap.get(roomId).flush();
	}

	public static boolean discard(Channel channel,String roomId) {
		return channelGroupRoomMap.get(roomId).remove(channel);
	}

	public static ChannelGroupFuture disconnect(String roomId) {
		return channelGroupRoomMap.get(roomId).disconnect();
	}

	public static ChannelGroupFuture disconnect(ChannelMatcher matcher,String roomId) {
		return channelGroupRoomMap.get(roomId).disconnect(matcher);
	}

	public static boolean contains(Channel channel,String roomId) {
		return channelGroupRoomMap.get(roomId).contains(channel);
	}

	public static int size(String roomId) {
		return channelGroupRoomMap.get(roomId).size();
	}
	
	/**
	 *  发送消息给除当前客户端之外的所有客户端
	 * @param obj 消息
	 * @param channel socket通道
	 */
	public static void writeOthersClient(Object obj, final SocketChannel socketChannel,String roomId) {
		
		channelGroupRoomMap.get(roomId).writeAndFlush(obj, new ChannelMatcher() {
			
			public boolean matches(Channel channel) {
				SocketChannel socket = (SocketChannel) channel;
				return socket!= socketChannel ;
			}
		}) ;
		
	}
	
}
