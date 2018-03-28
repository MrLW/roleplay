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
 * @date:2017��11��29�� ����5:51:37
 * @Function: ��Ϣ�ű�,ά��Э��ϵͳ
 * @version 1.0
 */
public class MessageScript {

	public static Map<Short, BaseHandler> haldlerMap = new ConcurrentHashMap<Short, BaseHandler>();

	private static MessageScript pool = new MessageScript();
	/**
	 * ���������ֺ�Э���ӳ���ϵ,key:����������,value:Э��map
	 */
	private static Map<String, Map<Short, Class<? extends BaseRequest>>> modelProtocolMap = new ConcurrentHashMap<String, Map<Short, Class<? extends BaseRequest>>>();
	@Getter
	@Setter
	private Map<Short, Class<? extends BaseRequest>> protocolIdMap = new ConcurrentHashMap<Short, Class<? extends BaseRequest>>();

	/**
	 * ��ʼ��һ��ģ��
	 */
	public void init(String modelName) {
		LoggerUtil.getLogger(getClass()).info("��ʼ��Э����Ϣ��ʼ...");
		// ��ӵ�ȫ������
		modelProtocolMap.put(modelName, protocolIdMap);
		LoggerUtil.getLogger(getClass()).info("��ʼ��Э����Ϣ����");
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
