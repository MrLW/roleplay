package com.sim.server.game.roleplay.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sim.server.game.data.db.pojo.TbUser;
import com.sim.server.game.roleplay.player.Session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

/**
 * @author liwen
 * @date:2017��11��20�� ����6:25:02
 * @Function: �û�������
 * @version 1.0
 */
public class UserManager {

	/**
	 * socket��user��map����,�൱����һ������,��¼�˵�ǰ���߿ͻ���
	 */
	public static Map<Channel, TbUser> userSocketMap = new ConcurrentHashMap<Channel, TbUser>();
	
	private static Map<Integer, Session> sessionMap = new ConcurrentHashMap<Integer, Session>() ;
	
	/**
	 * socket��context��mapӳ��,��Ҫ������:Ϊ�˹㲥��Ϣ�ǿ�
	 */
	

	public static void setSession(int sessionId,Session session) {
		sessionMap.put(sessionId, session);
	}
	
	public static Map<Integer, Session> getSessionMap() {
		return sessionMap;
	}
	/**
	 *  �ͻ����˳�
	 */
	public static void drop(ChannelHandlerContext ctx) {
		Channel channel =  ctx.channel();
		userSocketMap.remove(channel);
	}
}
