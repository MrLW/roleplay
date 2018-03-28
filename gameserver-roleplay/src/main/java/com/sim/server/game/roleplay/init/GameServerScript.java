package com.sim.server.game.roleplay.init;

import com.sim.server.game.engine.script.MessageScript;
import com.sim.server.game.roleplay.config.RoomConfig;
import com.sim.server.game.roleplay.manager.PlayerManager;
import com.sim.server.game.utils.LoggerUtil;

/**
 * @author liwen
 * @date:2017年11月20日 上午11:27:31
 * @Function: 游戏服务器初始化脚本
 * @version 1.0
 */
public class GameServerScript {

	/**
	 * 游戏初始化数据
	 * 
	 * @return true:初始化成功;false:初始化失败
	 */
	public static boolean init() {
		LoggerUtil.getLogger(GameServerScript.class).info("初始化服务器资源开始...");
		try {
			// 初始化配置文件
			RoomConfig.getInstance().initConfig();
			MessageScript.getInstance().init("roleplay");
			// 初始化资源
			ResourceDataLoader.getInstance().initData();
		} catch (Exception e) {
			LoggerUtil.getLogger(GameServerScript.class).error("初始化异常...");
			return false;
		}
		LoggerUtil.getLogger(GameServerScript.class).info("初始化服务器资源结束...");
		return true;
	}
}
