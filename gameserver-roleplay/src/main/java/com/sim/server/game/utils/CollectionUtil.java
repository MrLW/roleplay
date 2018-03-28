package com.sim.server.game.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @author liwen 2017��10��27�� ����11:24:11 Function: ���Ϲ�����
 * @version 1.0
 */
public class CollectionUtil {

	/**
	 * ��ȡ�����ǻ���+string���͵�List���ϵĴ�С
	 * 
	 * @param objs
	 *            ���϶���
	 * @return �����ֽڵĴ�С
	 */
	public static int getSize(List objs) {
		int len = 0;
		try {
			for (Object obj : objs) {
				Class clazz = obj.getClass();
				// ������������
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
						// ����ӵ���short
						len += 2;
						len += str.length();
					} else if ("java.lang.Long".equals(type)) {
						len += 8;
					} 
				} else {
					// ������������
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
							// ����ӵ���short
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
	 * ��ȡ���ֽ������ռ�õ��ֽڴ�С
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
					// List��������
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
