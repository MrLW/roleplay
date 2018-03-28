package com.sim.server.game.utils;

import java.lang.reflect.Method;

/**
 * 
 * @author liwen
 * 2017年11月4日 下午1:34:43
 * Function: 协议工具类
 * @version 1.0
 */
public class ProtocolUtil {

	public static Short getResponseId(Object obj) throws Exception {
		Short responseId = -1;
		try {
			Class clazz = obj.getClass();
			Method method = clazz.getMethod("getResponseId");
			responseId = (Short) method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseId ;
	}
	
	public static Short getRequestId(Object obj) throws Exception {
		Class clazz = obj.getClass();
		Method method = clazz.getMethod("getRequestId");
		Short requestId = (Short) method.invoke(obj);
		return requestId ;
	}
}
