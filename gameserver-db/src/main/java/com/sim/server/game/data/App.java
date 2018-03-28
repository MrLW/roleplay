package com.sim.server.game.data;

import com.sim.server.game.data.handler.DBServerHandler;

/**
 * @author liwen
 * @date:2017年12月4日 下午2:50:44
 * @Function: 数据库/缓存-模块
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {
		new Thread(new DBServerHandler()).start();
	}
}
