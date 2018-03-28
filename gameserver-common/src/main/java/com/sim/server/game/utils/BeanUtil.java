package com.sim.server.game.utils;
/**
 * 
 * @author liwen
 * 2017��10��30��
 * TODO:java bean�Ĺ�����
 * @version
 */
public class BeanUtil {
	
	/**
	 *  ��ȡһ����Ϥ��set����
	 * @param name �ַ���
	 * @return set�����ַ���
	 */
	public static String getSetName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return   name;
	}
	
	/**
	 *  ��ȡһ����Ϥ��set����
	 * @param name �ַ���
	 * @return set�����ַ���
	 */
	public static String getGetName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return "get" + name;
	}
	
	/**
	 *  �жϸ������Ƿ����ַ���
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isString(String type) {
		if("class java.lang.String".equals(type) || "java.lang.String".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ���boolean
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isBoolean(String type) {
		if("class java.lang.Boolean".equals(type) || "java.lang.Boolean".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ�int
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isInt(String type) {
		if("class java.lang.Integer".equals(type) || "java.lang.Integer".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ�byte
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isByte(String type) {
		if("class java.lang.Byte".equals(type) || "java.lang.Byte".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ�char
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isChar(String type) {
		if("class java.lang.Character".equals(type) || "java.lang.Char".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	/**
	 *  �жϸ������Ƿ�long
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isLong(String type) {
		if("class java.lang.Long".equals(type) || "java.lang.Long".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ�float
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isFloat(String type) {
		if("class java.lang.Float".equals(type) || "java.lang.Float".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ�short
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isShort(String type) {
		if("class java.lang.Short".equals(type) || "java.lang.Short".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  �жϸ������Ƿ�List
	 * @param type ��Ӧ�����ַ���
	 * @return ��/��
	 */
	public static boolean isList(String type) {
		if(type.contains("java.util.List")) {
			return true; 
		} else {
			return false;
		}
	}
	
	
	/**
	 *  �ж�һ�����������Ƿ��ǻ�����������+String
	 */
	public static  boolean isBaseDataType(Class clazz)  throws Exception 
	 {   
	     return 
	     (   
	         clazz.equals(String.class) ||   
	         clazz.equals(Integer.class)||   
	         clazz.equals(Byte.class) ||   
	         clazz.equals(Long.class) ||   
	         clazz.equals(Double.class) ||   
	         clazz.equals(Float.class) ||   
	         clazz.equals(Character.class) ||   
	         clazz.equals(Short.class) ||   
	         clazz.equals(Boolean.class) ||   
	         clazz.isPrimitive()   
	     );   
	 }
	
}
