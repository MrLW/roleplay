package com.sim.server.game.utils;

import java.util.Random;
/**
 * @author liwen
 * @date:2018年2月1日 下午2:20:51
 * @Function: ID工具类
 * @version 1.0
 */
public class IdUtil {
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}
