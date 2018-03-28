package com.sim.server.game.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @author liwen 2017年10月27日 上午11:24:11 Function: 集合工具类
 * @version 1.0
 */
public class CollectionUtil {

	/**
	 * 获取泛型是基本+string类型的List集合的大小
	 * 
	 * @param objs
	 *            集合对象
	 * @return 集合字节的大小
	 */
	public static int getSize(List objs) {
		int len = 0;
		try {
			for (Object obj : objs) {
				Class clazz = obj.getClass();
				// 基本数据类型
				if (BeanUtil.isBaseDataType(clazz)) {
					String type = clazz.getTypeName();
					if ("java.lang.Short".equals(type)) {
						len += 2;
					} else if ("java.lang.Integer".equals(type)) {
						len += 4;
					} else if ("java.lang.Byte".equals(type)) {
						len += 1;
					} else if ("java.lang.String".equals(type)) {
						String str = (String) obj;
						// 这个加的是short
						len += 2;
						len += str.length();
					} else if ("java.lang.Long".equals(type)) {
						len += 8;
					} 
				} else {
					// 复杂数据类型
					Object newObj = clazz.newInstance();

					Class newClazz = newObj.getClass();
					Field[] fields = clazz.getFields();

					for (Field field : fields) {
						String newType = field.getType().getName();
						if ("java.lang.Short".equals(newType)) {
							len += 2;
						} else if ("java.lang.Integer".equals(newType)) {
							len += 4;
						} else if ("java.lang.Byte".equals(newType)) {
							len += 1;
						} else if ("java.lang.String".equals(newType)) {
							String name = field.getName();
							name = BeanUtil.getGetName(name);
							Method method = clazz.getMethod(name);

							String str = (String) method.invoke(obj);
							// 这个加的是short
							len += 2;
							len += str == null ? 0 : str.length();
						} else if ("java.lang.Long".equals(newType)) {
							len += 8;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return len;
	}

	/**
	 * 获取该字节码的所占用的字节大小
	 * 
	 * @param clazz
	 * @return
	 */
	public static int getSize(Object obj) {
		int len = 0;
		try {
			Class clazz = obj.getClass();
			len = 0;
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Class subClazz = field.getType();
				String type = subClazz.getTypeName();
				String name = field.getName();
				name = BeanUtil.getGetName(name);
				if (BeanUtil.isInt(type)) {
					len += 4;
				} else if (BeanUtil.isByte(type)) {
					len += 1;
				} else if (BeanUtil.isShort(type)) {
					len += 2;
				} else if (BeanUtil.isLong(type)) {
					len += 8;
				} else if (BeanUtil.isString(type)) {
					Method method = clazz.getMethod(name);
					String str = (String) method.invoke(obj);
					len += 2;
					len += str == null ? 0 : str.length() ;
				} else {
					// List数据类型
					Method method = clazz.getMethod(name);
					List list = (List) method.invoke(obj);
					int size = getSize(list);
					len += size;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return len;
	}

}
