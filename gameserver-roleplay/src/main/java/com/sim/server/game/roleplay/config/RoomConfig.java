package com.sim.server.game.roleplay.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CyclicBarrier;

import com.sim.server.game.utils.LoggerUtil;

/**
 * @author liwen
 * @date:2017年11月21日 下午1:32:02
 * @Function: 房间配置
 * @version 1.0
 */
public class RoomConfig {

	public static CyclicBarrier cyclicBarrier;

	private RoomConfig() {
	}

	private static RoomConfig config = new RoomConfig();

	public static RoomConfig getInstance() {
		if (config == null) {
			config = new RoomConfig();
		}
		return config;
	}

	/**
	 * 每个房间的队伍数量
	 */
	public static int TEAM_COUNT;
	/**
	 * 两个队伍的玩家数量
	 */
	public static int TEAM_PLAYER_COUNT;

	/**
	 * 每个队伍的玩家数量
	 */
	public static int SINGLE_TEAM_PLAYER_COUNT;
	/**
	 * 每个房间的总人数
	 */
	public static int ROOM_PLAYER_COUNT;

	/**
	 *  5大总监
	 */
	public static int PRODUCTOR_MANAGER;
	public static int HR_MANAGER ;
	public static int FINANCE_MANAGER ;
	public static int PURCHASE_MANAGER ;
	public static int BAZAAR_MANAGER ;
	
	/**
	 *  生产产品的时间间隔
	 */
	public static Integer PRODUCT_CREATE_INTERVAL;

	/**
	 * 加载配置文件
	 * 
	 * @param path
	 *            配置文件路径
	 */
	private void loadConf(String path) {
		try {
			Properties prop = new Properties();
			// 注意:这里需要使用getClassLoader(),否则读取不到配置文件
			InputStream in = RoomConfig.class.getClassLoader().getResourceAsStream(path);
			try {
				prop.load(in);
				TEAM_COUNT = Integer.parseInt((String) prop.get("TEAM_COUNT"));
				TEAM_PLAYER_COUNT = Integer.parseInt((String) prop.get("TEAM_PLAYER_COUNT"));
				ROOM_PLAYER_COUNT = Integer.parseInt((String) prop.get("ROOM_PLAYER_COUNT"));
				SINGLE_TEAM_PLAYER_COUNT = TEAM_PLAYER_COUNT / TEAM_COUNT;
				PRODUCTOR_MANAGER = Integer.parseInt((String) prop.get("PRODUCTOR_MANAGER"));
				HR_MANAGER = Integer.parseInt((String) prop.get("HR_MANAGER"));
				FINANCE_MANAGER = Integer.parseInt((String) prop.get("FINANCE_MANAGER"));
				PURCHASE_MANAGER = Integer.parseInt((String) prop.get("PURCHASE_MANAGER"));
				BAZAAR_MANAGER = Integer.parseInt((String) prop.get("BAZAAR_MANAGER"));
				PRODUCT_CREATE_INTERVAL = Integer.parseInt((String) prop.get("PRODUCT_CREATE_INTERVAL"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.getLogger(RoomConfig.class).info("读取房间配置文件失败");
		}
		LoggerUtil.getLogger(RoomConfig.class).info("加载房间配置文件成功");
	}

	/**
	 * 初始化配置文件
	 */
	public void initConfig() {
		loadConf("properties/room.properties");
		cyclicBarrier = new CyclicBarrier(RoomConfig.ROOM_PLAYER_COUNT);
	}

	public void resetBarrier() {
		this.cyclicBarrier.reset();
	}

}
