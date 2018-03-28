package com.sim.server.game.engine.core;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.engine.script.MessageScript;
import com.sim.server.game.message.request.BaseRequest;

/**
 * @author liwen
 * 2017年10月25日  下午2:38:00   
 * Function: 自定义管理bean
 * @version 1.0
 */
public class ActionBeanPostProcessor implements BeanPostProcessor {
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			ActionMap actionMap = method.getAnnotation(ActionMap.class);
			if (actionMap != null) {
				Action action = new Action();
				action.setMethod(method);
				action.setObject(bean);
				Dispatcher.put(actionMap.key(), action);
			}
		}
		// 获取处理注解
		HandlerEntity handle = bean.getClass().getAnnotation(HandlerEntity.class);
		if(handle!=null) {
			short id = handle.id();
			BaseHandler handler = (BaseHandler) bean ;
			MessageScript.haldlerMap.put(id, handler);
		}
		// 获取协议注解
		Regist regist = bean.getClass().getAnnotation(Regist.class);
		if(regist != null ) {
			short id = regist.id();
			Class<? extends BaseRequest> protocol = regist.clazz();
			Map<Short, Class<? extends BaseRequest>> protocolIdMap = MessageScript.getInstance().getProtocolIdMap();
			protocolIdMap.put(id, protocol);
		}
		return bean;
	}

}
