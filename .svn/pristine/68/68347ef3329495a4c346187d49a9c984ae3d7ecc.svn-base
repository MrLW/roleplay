package com.sim.server.game.engine.core;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.engine.script.MessageScript;

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
		HandlerEntity entity = bean.getClass().getAnnotation(HandlerEntity.class);
		if(entity!=null) {
			short id = entity.id();
			BaseHandler handler = (BaseHandler) bean ;
			MessageScript.haldlerMap.put(id, handler);
		}
		return bean;
	}

}
