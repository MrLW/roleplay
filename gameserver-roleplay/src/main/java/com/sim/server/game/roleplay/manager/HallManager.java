package com.sim.server.game.roleplay.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.sim.server.game.data.db.pojo.TbUser;
import com.sim.server.game.model.model.PlayerInfo;
import com.sim.server.game.roleplay.player.Session;
import com.sim.server.game.roleplay.room.ChannelGroups;
import com.sim.server.game.roleplay.room.Client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author liwen
 * @date:2017��11��21�� ����10:01:58
 * @Function: ��Ϸ����
 * @version 1.0
 */
public class HallManager {

	private HallManager() {

	}

	private volatile static HallManager instance = new HallManager();

	public static HallManager getInstance() {
		if (instance == null) {
			synchronized (HallManager.class) {
				if (instance == null) {
					instance = new HallManager();
				}
			}
		}
		return instance;
	}

	// ��ʼ��n������,���ҳ�ʼ��n��channel��
	static {
		ChannelGroup group = null;
		List<PlayerInfo> infos = null;
		String roomId;
		for (int i = 1; i <= 1; i++) {
			roomId = "A10" + i;
			infos = new ArrayList<PlayerInfo>();
			// ����ChannelGroup
			group = new DefaultChannelGroup(roomId, GlobalEventExecutor.INSTANCE);
			ChannelGroups.channelGroupRoomMap.put(roomId, group);
		}
	}

	/**
	 * ���socket��user�Ĺ�ϵ,��map���Ƴ�
	 * 
	 * @param socket
	 *            �ͻ�������
	 * @return �Ƿ��Ƴ��ɹ�
	 */
	public static boolean removeClientFromHall(SocketChannel socket) {
		if (UserManager.userSocketMap != null) {
			if (UserManager.userSocketMap.containsKey(socket)) {
				TbUser user = UserManager.userSocketMap.remove(socket);
				if (user != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * �ж��û��Ƿ��Ѿ�����
	 * 
	 * @param socket
	 *            �ͻ���socket����
	 * @return true:����;false:������
	 */
	public static boolean isOnline(TbUser user) {
		if (user != null) {
			Integer userId = user.getId();
			return isOnline(userId);
		}
		return false;
	}

	/**
	 * �ж��û��Ƿ�����
	 * 
	 * @param userId
	 *            �û�ID
	 * @return
	 */
	public static boolean isOnline(Integer userId) {
		Set<Channel> sockets = UserManager.userSocketMap.keySet();
		for (Channel socket : sockets) {
			TbUser onlineUser = UserManager.userSocketMap.get(socket);
			if (onlineUser != null) {
				if (userId == onlineUser.getId()) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * ��ȡͬ��ǰctx��������һ���ͻ��˵�������Ҽ���
	 * 
	 * @param ctx
	 *            ��ǰctx������
	 * @return ��ǰctx��������һ���ͻ��˵�������Ҽ���
	 */
	public static List<Client> getSameRoomIdClients(ChannelHandlerContext ctx) {
		// String roomId = getRoomIdByCtx(ctx);
		// List<Client> list = roomsMap.get(roomId);
		return null;
	}

	

	/**
	 * �����û�ID ��ȡ socket����
	 * 
	 * @param userId
	 *            ���ID
	 * @return �û�socket
	 */
	public static Channel getSocketByUserId(Integer userId) {
		for (Entry<Channel, TbUser> entry : UserManager.userSocketMap.entrySet()) {
			TbUser user = entry.getValue();
			if (user != null) {
				if (user.getId() == userId) {
					Channel socket = entry.getKey();
					return socket;
				}
			}
		}
		return null;
	}

	/**
	 * �����û�ID ��ȡ Context
	 * 
	 * @param userId
	 *            ���ID
	 * @return �û�socket
	 */
	public static Channel getContextByUserId(int userId) {
		Session session = UserManager.getSessionMap().get(userId);
		return session.getChannel();
	}

	public static int getUserIdByCtx(ChannelHandlerContext ctx) {
		SocketChannel socket = (SocketChannel) ctx.channel();
		return getUserIdBySocket(socket);
	}
	
	public static int getUserIdByCtx(Channel channel) {
		return getUserIdBySocket((SocketChannel)channel);
	}

	private static int getUserIdBySocket(Channel socket) {
		for (Entry<Channel, TbUser> entry : UserManager.userSocketMap.entrySet()) {
			Channel key = entry.getKey();
			TbUser user = entry.getValue();
			if (key == socket) {
				return user.getId();
			}
		}
		return -1;
	}

}
