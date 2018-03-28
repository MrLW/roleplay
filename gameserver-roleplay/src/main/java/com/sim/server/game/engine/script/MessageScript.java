package com.sim.server.game.engine.script;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.request.BaseRequest;
import com.sim.server.game.utils.LoggerUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liwen
 * @date:2017年11月29日 下午5:51:37
 * @Function: 消息脚本,维护协议系统
 * @version 1.0
 */
public class MessageScript {

	public static Map<Short, BaseHandler> haldlerMap = new ConcurrentHashMap<Short, BaseHandler>();

	private static MessageScript pool = new MessageScript();
	/**
	 * 服务器名字和协议的映射关系,key:服务器名称,value:协议map
	 */
	private static Map<String, Map<Short, Class<? extends BaseRequest>>> modelProtocolMap = new ConcurrentHashMap<String, Map<Short, Class<? extends BaseRequest>>>();
	@Getter
	@Setter
	private Map<Short, Class<? extends BaseRequest>> protocolIdMap = new ConcurrentHashMap<Short, Class<? extends BaseRequest>>();

	/**
	 * 初始化一个模块
	 */
	public void init(String modelName) {
		LoggerUtil.getLogger(getClass()).info("初始化协议信息开始...");
		// 添加到全局中心
		modelProtocolMap.put(modelName, protocolIdMap);
		LoggerUtil.getLogger(getClass()).info("初始化协议信息结束");
	}


	public static MessageScript getInstance() {
		return pool;
	}

	public void put(String modelName, Map<Short, Class<? extends BaseRequest>> map) {
		modelProtocolMap.put(modelName, map);
	}

	public Map<Short, Class<? extends BaseRequest>> get(String modelName) {
		return modelProtocolMap.get(modelName);
	}

	public static BaseHandler getHaldlerMap(Short id) {
		BaseHandler handler = haldlerMap.get(id);
		handler.clone();
		return handler;
	}
}
