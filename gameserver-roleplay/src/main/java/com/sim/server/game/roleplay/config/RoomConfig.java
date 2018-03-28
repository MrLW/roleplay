package com.sim.server.game.roleplay.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CyclicBarrier;

import com.sim.server.game.utils.LoggerUtil;

/**
 * @author liwen
 * @date:2017��11��21�� ����1:32:02
 * @Function: ��������
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
	 * ÿ������Ķ�������
	 */
	public static int TEAM_COUNT;
	/**
	 * ����������������
	 */
	public static int TEAM_PLAYER_COUNT;

	/**
	 * ÿ��������������
	 */
	public static int SINGLE_TEAM_PLAYER_COUNT;
	/**
	 * ÿ�������������
	 */
	public static int ROOM_PLAYER_COUNT;

	/**
	 *  5���ܼ�
	 */
	public static int PRODUCTOR_MANAGER;
	public static int HR_MANAGER ;
	public static int FINANCE_MANAGER ;
	public static int PURCHASE_MANAGER ;
	public static int BAZAAR_MANAGER ;
	
	/**
	 *  ������Ʒ��ʱ����
	 */
	public static Integer PRODUCT_CREATE_INTERVAL;

	/**
	 * ���������ļ�
	 * 
	 * @param path
	 *            �����ļ�·��
	 */
	private void loadConf(String path) {
		try {
			Properties prop = new Properties();
			// ע��:������Ҫʹ��getClassLoader(),�����ȡ���������ļ�
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
			LoggerUtil.getLogger(RoomConfig.class).info("��ȡ���������ļ�ʧ��");
		}
		LoggerUtil.getLogger(RoomConfig.class).info("���ط��������ļ��ɹ�");
	}

	/**
	 * ��ʼ�������ļ�
	 */
	public void initConfig() {
		loadConf("properties/room.properties");
		cyclicBarrier = new CyclicBarrier(RoomConfig.ROOM_PLAYER_COUNT);
	}

	public void resetBarrier() {
		this.cyclicBarrier.reset();
	}

}