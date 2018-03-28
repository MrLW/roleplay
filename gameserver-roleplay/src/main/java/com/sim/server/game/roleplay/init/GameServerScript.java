package com.sim.server.game.roleplay.init;

import com.sim.server.game.engine.script.MessageScript;
import com.sim.server.game.roleplay.config.RoomConfig;
import com.sim.server.game.roleplay.manager.PlayerManager;
import com.sim.server.game.utils.LoggerUtil;

/**
 * @author liwen
 * @date:2017��11��20�� ����11:27:31
 * @Function: ��Ϸ��������ʼ���ű�
 * @version 1.0
 */
public class GameServerScript {

	/**
	 * ��Ϸ��ʼ������
	 * 
	 * @return true:��ʼ���ɹ�;false:��ʼ��ʧ��
	 */
	public static boolean init() {
		LoggerUtil.getLogger(GameServerScript.class).info("��ʼ����������Դ��ʼ...");
		try {
			// ��ʼ�������ļ�
			RoomConfig.getInstance().initConfig();
			MessageScript.getInstance().init("roleplay");
			// ��ʼ����Դ
			ResourceDataLoader.getInstance().initData();
		} catch (Exception e) {
			LoggerUtil.getLogger(GameServerScript.class).error("��ʼ���쳣...");
			return false;
		}
		LoggerUtil.getLogger(GameServerScript.class).info("��ʼ����������Դ����...");
		return true;
	}
}