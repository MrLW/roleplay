package com.sim.server.game.utils;

import java.util.Random;
/**
 * @author liwen
 * @date:2018��2��1�� ����2:20:51
 * @Function: ID������
 * @version 1.0
 */
public class IdUtil {
	/**
	 * ��Ʒid����
	 */
	public static long genItemId() {
		// ȡ��ǰʱ��ĳ�����ֵ��������
		long millis = System.currentTimeMillis();
		// ������λ�����
		Random random = new Random();
		int end2 = random.nextInt(99);
		// ���������λǰ�油0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}
