package com.sim.server.game.roleplay.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sim.server.game.model.model.PlayerInfo;
import com.sim.server.game.roleplay.config.RoomConfig;
import com.sim.server.game.roleplay.player.Session;
import com.sim.server.game.roleplay.room.Room;
import com.sim.server.game.utils.LoggerUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author liwen
 * @date:2017��11��20�� ����10:30:23
 * @Function:room mamager
 * @version 1.0
 */
public class RoomManager {

	/**
	 * ����map,ÿ�������Ӧ��������
	 */
	public static BlockingQueue<Room> newRoomsList = new LinkedBlockingQueue<Room>();

	/**
	 * �����Ƿ�ɹ�
	 * 
	 * @param room
	 * @return
	 */
	public static boolean isComplete(Room room) {
		return room.isComplete();
	}

	/**
	 * ��ȡ�����
	 * 
	 * @param ctx
	 * @return
	 */
	public static String getNewRoomIdByCtx(Channel channel) {
		int userId = HallManager.getUserIdByCtx(channel);
		for (Room room : newRoomsList) {
			BlockingQueue<PlayerInfo> playerInfos = room.getPlayerInfos();
			for (PlayerInfo info : playerInfos) {
				if (userId == info.getUserId()) {
					return room.getRoomId();
				}
			}
		}

		return "-1";
	}
	/**
	 *  ��ȡ����
	 * @param ctx
	 * @return
	 */
	public static Room getNewRoomByCtx(Channel channel) {
		String roomId = getNewRoomIdByCtx(channel);
		Room room = getRoomByRoomId(roomId);
		return room;
	}

	
	/**
	 * ��ȡ����
	 * 
	 * @param ctx
	 * @return
	 */
	public static Room getRoomByCtx(Channel ctx) {
		int userId = HallManager.getUserIdByCtx(ctx);
		for (Room room : newRoomsList) {
			BlockingQueue<PlayerInfo> playerInfos = room.getPlayerInfos();
			for (PlayerInfo info : playerInfos) {
				if (info.getUserId() == userId)
					return room;
			}
		}

		return null;
	}

	/**
	 * ���ݷ���ŷ��ط���
	 * 
	 * @param roomId
	 *            �����
	 * @return ����
	 */
	public static Room getRoomByRoomId(String roomId) {
		for (Room room : newRoomsList) {
			if (roomId.equals(room.getRoomId()))
				return room;
		}

		return null;
	}

	

	/**
	 * ��������
	 * 
	 * @return true:�����ɹ�,false:����ʧ��
	 */
	public static Room createRoom() {
		Room room = null;
		try {
			room = new Room();
			room.setRoomId("A10" + (RoomManager.newRoomsList.size() + 1));
			room.onCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RoomManager.newRoomsList.add(room);
		return room;

	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public static Room getIdleRoom() {
		for (Room room : RoomManager.newRoomsList) {
			if (room.getState() == 1) {
				// ����÷���������״̬,Ҳ���Ǵ��ڸմ���״̬,�򷵻�
				return room;
			}
		}
		return null;
	}

	/**
	 * ��ȡ�����ڵ����������Ϣ
	 * 
	 * @param roomId
	 *            �����
	 * @return ��Ҽ���
	 */
	public static List<PlayerInfo> getPlayerInfosByRoomId(String roomId) {
		List<PlayerInfo> playerInfos = new ArrayList<PlayerInfo>();
		for (Room room : newRoomsList) {
			if (room.getRoomId().equals(roomId)) {
				playerInfos.addAll(room.getPlayerInfos());
			}
		}
		return playerInfos;
	}

	

	/**
	 * get ctxs
	 * 
	 * @param roomId
	 *            room id
	 * @return ctx list
	 */
	public static List<Channel> getContextsByRoomId(String roomId) {
		List<Channel> channels = new ArrayList<Channel>();
		// ���ݷ�����ҵ����м���
		List<PlayerInfo> infos = getPlayerInfosByRoomId(roomId);
		for (PlayerInfo playerInfo : infos) {
			Channel channel = HallManager.getContextByUserId(playerInfo.getUserId());
			channels.add(channel);
		}
		return channels;
	}

	/**
	 * ����Ƿ��ڷ�����
	 * 
	 * @param ctx
	 * @return
	 */
	public static boolean isInRoom(ChannelHandlerContext ctx) {
		int userId = HallManager.getUserIdByCtx(ctx);
		for (Room room : newRoomsList) {
			BlockingQueue<PlayerInfo> playerInfos = room.getPlayerInfos();
			for (PlayerInfo playerInfo : playerInfos) {
				if (playerInfo.getUserId() == userId)
					return true;
			}
		}
		return false;
	}
	
	
	/**
	 * ���뷿��
	 * 
	 * @param ctx
	 *            ������
	 */
	public static Room joinOrCreateRoom(Channel channel) {
		Room room = getRoomByCtx(channel);
		if (room == null) {
			room = RoomManager.getIdleRoom();
			if (room == null)
				room = RoomManager.createRoom();
		}
		PlayerInfo playerInfo = PlayerManager.getInstance().getPlayerInfoByCtx(channel);
		room.join(playerInfo);
		Session session = UserManager.getSessionMap().get(playerInfo.getUserId());
		// ��ctx���ӵ�����
		room.addSession(session);
		return room;
	}

	
	

	/**
	 * ��ȡ�����ͬһ�����������Ҽ���
	 * 
	 * @param ctx
	 *            ���
	 * @return ���ID����
	 */
	public static List<Integer> getUserIdsInSameRoom(Channel ctx) {
		List<Integer> infos = new ArrayList<Integer>();
		// ��ȡ��Ҷ�Ӧ�ķ���
		Room room = getRoomByCtx(ctx);
		BlockingQueue<PlayerInfo> playerInfos = room.getPlayerInfos();
		for (PlayerInfo playerInfo : playerInfos) {
			infos.add(playerInfo.getUserId());
		}
		return infos;
	}

	public static boolean removeFromRoom(Channel ctx) {
		int userId = -1 ;
		try {
			userId = HallManager.getUserIdByCtx(ctx);
			PlayerInfo playerInfo = PlayerManager.getInstance().getPlayerInfoByCtx(ctx);
			if(playerInfo != null ) {
				playerInfo.setRoleType(-1);
			}
			Room room = getRoomByCtx(ctx);
			if (room != null) {
				BlockingQueue<PlayerInfo> playerInfos = room.getPlayerInfos();
				for (PlayerInfo info : playerInfos) {
					if (userId == info.getUserId()) {
						playerInfos.remove(info);
					}
				}
				if (isEmpty(room)) {
					room.onDestroy();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.getLogger(RoomManager.class).error("���"+userId+"�Ӷ�ս�����Ƴ����ʧ��");
			return false;
		}
		LoggerUtil.getLogger(RoomManager.class).error("���"+userId+"�Ӷ�ս�����Ƴ���ҳɹ�");
		return true;
	}

	/**
	 * �жϷ����Ƿ�Ϊ��
	 * 
	 * @param room
	 *            ����
	 * @return �Ƿ�Ϊ��
	 */
	public static boolean isEmpty(Room room) {
		return room.isEmpty();
	}

	/**
	 * �ж�ָ�������Ƿ��������ָ�����������
	 * 
	 * @param roomId
	 *            �����
	 * @param infos
	 *            ��Ҽ���
	 * @return �Ƿ��������
	 */
	public static boolean isAdd(String roomId, List<ChannelHandlerContext> ctxs) {
		List<PlayerInfo> roomPlayerInfos = getPlayerInfosByRoomId(roomId);
		int nowsize = roomPlayerInfos.size() + ctxs.size();
		return nowsize <= RoomConfig.TEAM_PLAYER_COUNT;
	}

}