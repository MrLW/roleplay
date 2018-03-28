package com.sim.server.game.utils;
/**
 * 
 * @author liwen
 * 2017年10月30日
 * TODO:java bean的工具类
 * @version
 */
public class BeanUtil {
	
	/**
	 *  获取一个熟悉的set方法
	 * @param name 字符串
	 * @return set方法字符串
	 */
	public static String getSetName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return   name;
	}
	
	/**
	 *  获取一个熟悉的set方法
	 * @param name 字符串
	 * @return set方法字符串
	 */
	public static String getGetName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return "get" + name;
	}
	
	/**
	 *  判断该类型是否是字符串
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isString(String type) {
		if("class java.lang.String".equals(type) || "java.lang.String".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否是boolean
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isBoolean(String type) {
		if("class java.lang.Boolean".equals(type) || "java.lang.Boolean".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否int
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isInt(String type) {
		if("class java.lang.Integer".equals(type) || "java.lang.Integer".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否byte
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isByte(String type) {
		if("class java.lang.Byte".equals(type) || "java.lang.Byte".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否char
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isChar(String type) {
		if("class java.lang.Character".equals(type) || "java.lang.Char".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	/**
	 *  判断该类型是否long
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isLong(String type) {
		if("class java.lang.Long".equals(type) || "java.lang.Long".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否float
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isFloat(String type) {
		if("class java.lang.Float".equals(type) || "java.lang.Float".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否short
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isShort(String type) {
		if("class java.lang.Short".equals(type) || "java.lang.Short".equals(type)) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 *  判断该类型是否List
	 * @param type 对应类型字符串
	 * @return 是/否
	 */
	public static boolean isList(String type) {
		if(type.contains("java.util.List")) {
			return true; 
		} else {
			return false;
		}
	}
	
	
	/**
	 *  判断一个数据类型是否是基本数据类型+String
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
