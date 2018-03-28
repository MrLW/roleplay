package com.sim.server.game.roleplay.manager;

import java.util.ArrayList;
import java.util.List;

import com.sim.server.game.model.model.PlayerInfo;
import com.sim.server.game.utils.LoggerUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author liwen
 * @date:2018��3��5�� ����4:34:58
 * @Function:��ҹ���
 * @version 1.0
 */
public class PlayerManager {

	private static PlayerManager playerManager;

	private PlayerManager() {
	}

	public static PlayerManager getInstance() {
		if (playerManager == null) {
			synchronized (PlayerManager.class) {
				if (playerManager == null)
					playerManager = new PlayerManager();
			}
		}
		return playerManager;
	}

	/**
	 * �����Ϣ�б�,����û�н�����Ϸ�������Ϣ
	 */
	public static List<PlayerInfo> playerInfoList = new ArrayList<PlayerInfo>();

	/**
	 * ���������Ļ�ȡ�����Ϣ
	 * 
	 * @param ctx
	 * @return
	 */
	public PlayerInfo getPlayerInfoByCtx(ChannelHandlerContext ctx) {
		int userId = HallManager.getUserIdByCtx(ctx);
		for (PlayerInfo info : playerInfoList) {
			if (userId == info.getUserId())
				return info;
		}
		return null;
	}
	
	/**
	 * ���������Ļ�ȡ�����Ϣ
	 * 
	 * @param ctx
	 * @return
	 */
	public PlayerInfo getPlayerInfoByCtx(Channel channel) {
		int userId = HallManager.getUserIdByCtx(channel);
		for (PlayerInfo info : playerInfoList) {
			if (userId == info.getUserId())
				return info;
		}
		return null;
	}
	



	/**
	 * ���ڴ����Ƴ����
	 * 
	 * @param ctx
	 *            ���������
	 * @return �Ƿ�ɹ�
	 */
	public boolean remove(ChannelHandlerContext ctx) {
		PlayerInfo playerInfo = getPlayerInfoByCtx(ctx);
		try {
			playerInfoList.remove(playerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.getLogger(getClass()).error("���ڴ����Ƴ����ʧ��");
			return false;
		}
		LoggerUtil.getLogger(getClass()).info("���ڴ����Ƴ���ҳɹ�");
		return true;
	}

}
