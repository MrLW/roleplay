package com.sim.server.game.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *  
 * @author liwen
 * 2017年10月25日  上午11:35:34   
 * Function: 对象和字节转换
 * @version 1.0
 */
public class ByteObjConverter {

	/**
	 * 字节数组转换为对象
	 * 
	 * @param bytes
	 *            字节数组
	 * @return java对象
	 */
	public static Object byteToObject(byte[] bytes) {
		Object obj = null;
		ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
		ObjectInputStream oi = null;
		try {
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (oi != null) {
					oi.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	/**
	 * 对象转换为字节数组
	 * 
	 * @param obj
	 *            对象
	 * @return 字节数组
	 */
	public static byte[] objectToByte(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			bytes = bo.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				oo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (bytes);
	}
}
