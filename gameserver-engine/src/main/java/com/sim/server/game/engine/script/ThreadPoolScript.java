package com.sim.server.game.engine.script;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liwen
 * @date:2017��11��30�� ����2:10:25
 * @Function: thread pool manager
 * @version 1.0
 */
public class ThreadPoolScript {

	/**
	 * corePoolSize ������������߳��������������̡߳�
	 */
	private static final int corePoolSize = 16;
	
	/**
	 * maximumPoolSize - �������������߳���(����LinkedBlockingQueueʱû������)��
	 */
	private static final int maximumPoolSize = 32;
	
	/**
	 * keepAliveTime -���߳������ں���ʱ����Ϊ��ֹǰ����Ŀ����̵߳ȴ���������ʱ�䣬�̳߳�ά���߳�������Ŀ���ʱ��
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
