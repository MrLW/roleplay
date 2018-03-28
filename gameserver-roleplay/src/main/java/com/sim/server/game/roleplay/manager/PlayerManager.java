package com.sim.server.game.roleplay.manager;

import java.util.ArrayList;
import java.util.List;

import com.sim.server.game.model.model.PlayerInfo;
import com.sim.server.game.utils.LoggerUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author liwen
 * @date:2018年3月5日 下午4:34:58
 * @Function:玩家管理
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
	 * 玩家信息列表,包括没有进入游戏的玩家信息
	 */
	public static List<PlayerInfo> playerInfoList = new ArrayList<PlayerInfo>();

	/**
	 * 根据上下文获取玩家信息
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
	 * 根据上下文获取玩家信息
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
	 * 从内存中移除玩家
	 * 
	 * @param ctx
	 *            玩家上下文
	 * @return 是否成功
	 */
	public boolean remove(ChannelHandlerContext ctx) {
		PlayerInfo playerInfo = getPlayerInfoByCtx(ctx);
		try {
			playerInfoList.remove(playerInfo);
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.getLogger(getClass()).error("从内存中移除玩家失败");
			return false;
		}
		LoggerUtil.getLogger(getClass()).info("从内存中移除玩家成功");
		return true;
	}

}
