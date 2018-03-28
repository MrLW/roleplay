package com.sim.server.game.roleplay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sim.server.game.engine.netty.http.HttpFileServer;
import com.sim.server.game.roleplay.init.GameServerScript;
import com.sim.server.game.roleplay.pool.ThreadPoolManager;
import com.sim.server.game.roleplay.server.RolePlayServer;

/**
 * @author liwen
 * @date:2017��12��18�� ����4:40:27
 * @Function: ��ɫ������ϷApp
 * @version 1.0
 */
public class RolePlayApp {

	private static ApplicationContext ac;

	public static void main(String[] args) {
		loadResource();
		startRolePlayServer();
		startFileServer(); 
	}
	/**
	 *  �����ļ�������
	 */
	private static void startFileServer() {
		try {
			new HttpFileServer().run(7879);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����������
	 */
	private static void startRolePlayServer() {
		new Thread(new RolePlayServer()).start();
	}

	/**
	 * ���ط�������Դ
	 */
	private static void loadResource() {
		ac = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		GameServerScript.init();
	}
	
	public static ApplicationContext getAppContext() {
		return ac ;
	}
}
