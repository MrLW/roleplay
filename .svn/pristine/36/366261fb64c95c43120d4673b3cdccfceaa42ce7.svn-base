package com.sim.server.game.engine.script;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liwen
 * @date:2017年11月30日 下午2:10:25
 * @Function: thread pool manager
 * @version 1.0
 */
public class ThreadPoolScript {

	/**
	 * corePoolSize 池中所保存的线程数，包括空闲线程。
	 */
	private static final int corePoolSize = 16;
	
	/**
	 * maximumPoolSize - 池中允许的最大线程数(采用LinkedBlockingQueue时没有作用)。
	 */
	private static final int maximumPoolSize = 32;
	
	/**
	 * keepAliveTime -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，线程池维护线程所允许的空闲时间
	 */
	private static final int keepAliveTime = 60;

	private static ThreadPoolScript manager = null;

	private ThreadPoolScript() {
	}

	public static ThreadPoolScript getInstance() {
		if (manager == null) {
			synchronized (ThreadPoolScript.class) {
				if (manager == null) {
					manager = new ThreadPoolScript();
				}
			}
		}
		return manager;
	}

	private ThreadPoolExecutor executor = null;
	
	/**
	 * get thread pool
	 * 
	 * @return threadpool
	 */
	/*public ThreadPoolExecutor getExecutor() {
		if (executor == null) {
			synchronized (ThreadPoolExecutor.class) {
				if (executor == null) {
					executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
							TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
				}
			}
		}
		return executor;
	}*/
}
