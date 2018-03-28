package com.sim.server.game.roleplay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sim.server.game.engine.netty.http.HttpFileServer;
import com.sim.server.game.roleplay.init.GameServerScript;
import com.sim.server.game.roleplay.pool.ThreadPoolManager;
import com.sim.server.game.roleplay.server.RolePlayServer;

/**
 * @author liwen
 * @date:2017年12月18日 下午4:40:27
 * @Function: 角色扮演游戏App
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
	 *  开启文件服务器
	 */
	private static void startFileServer() {
		try {
			new HttpFileServer().run(7879);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 启动服务器
	 */
	private static void startRolePlayServer() {
		new Thread(new RolePlayServer()).start();
	}

	/**
	 * 加载服务器资源
	 */
	private static void loadResource() {
		ac = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		GameServerScript.init();
	}
	
	public static ApplicationContext getAppContext() {
		return ac ;
	}
}
