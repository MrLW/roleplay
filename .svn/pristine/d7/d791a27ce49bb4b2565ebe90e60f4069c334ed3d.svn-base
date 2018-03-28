package com.sim.server.game.engine.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * @author liwen
 * 2017年10月26日  下午2:16:01   
 * Function:  分发请求
 * @version 1.0
 */
public class Dispatcher {
	
	// 一个协议对应的动作集合
	private static Map<Short, Action> actionMap = new HashMap<Short, Action>();
	
	/**
	 *  根据协议,到action中查找对应的方法,然后执行
	 * @param key 协议
	 * @param args 可选参数
	 * @return 请求完成返回的对象
	 * @throws Exception
	 */
	public static Object invote(Short key, Object... args) throws Exception {
		Action action = actionMap.get(key);
		if (action != null) {
			Method method = action.getMethod();
			try {
				return method.invoke(action.getObject(), args);
			} catch (Exception e) {
				System.out.println("Dispatcher发射异常:" + e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 *  将一个协议和动作存入map
	 * @param key 协议
	 * @param action 动作集合
	 */
	public static void put(Short key, Action action) {
		actionMap.put(key, action);
	}
}
