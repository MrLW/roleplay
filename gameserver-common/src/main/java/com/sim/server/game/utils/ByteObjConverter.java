package com.sim.server.game.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *  
 * @author liwen
 * 2017��10��25��  ����11:35:34   
 * Function: ������ֽ�ת��
 * @version 1.0
 */
public class ByteObjConverter {

	/**
	 * �ֽ�����ת��Ϊ����
	 * 
	 * @param bytes
	 *            �ֽ�����
	 * @return java����
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
	 * ����ת��Ϊ�ֽ�����
	 * 
	 * @param obj
	 *            ����
	 * @return �ֽ�����
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
