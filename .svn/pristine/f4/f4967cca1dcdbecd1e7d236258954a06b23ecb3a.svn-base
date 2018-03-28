package com.sim.server.game.roleplay.pool;

import java.util.concurrent.Executors;

/**
 * @author liwen
 * @date:2018年1月11日 上午10:41:39
 * @Function: 线程池管理类
 * @version 1.0
 */
public class ThreadPoolManager {
	
	/**
	 *  使用缓存的线程池执行任务
	 * @param task 任务Runnable对象
	 */
	public static void executeTaskUseCachedThreadPool(Runnable task) {
		Executors.newCachedThreadPool().execute(task);
	}
	/**
	 *  使用固定线程池数量执行任务
	 * @param task 任务Runnable对象
	 */
	public static void executeTaskUseFixedThreadPool(Runnable task) {
		Executors.newFixedThreadPool(20).execute(task);
	}
}
