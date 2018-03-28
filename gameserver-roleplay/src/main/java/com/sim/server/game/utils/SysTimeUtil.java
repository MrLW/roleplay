package com.sim.server.game.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liwen
 * @date:2018��1��31�� ����5:21:39
 * @Function: ��Ϸʱ�乤����
 * @version 1.0
 */
public class SysTimeUtil {

	public static int GAMEOVER_TIME = 10 * 60;
	public static Calendar c;
	public static long endTime;
	public static Date date;
	public static long startTime;
	public static long midTime;

	public static void main(String[] args) {
		startTime();
	}

	/**
	 * ��ʼ��Ϸ
	 */
	private static void startTime() {

		new Thread() {
			public void run() {
				long endTime;
				long startTime;
				long midTime;
				Calendar c = Calendar.getInstance();
				Date date = new Date();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH);
				int day = c.get(Calendar.DAY_OF_MONTH);
				int hour = c.get(Calendar.HOUR);
				int minute = c.get(Calendar.MINUTE);
				int second = c.get(Calendar.SECOND);
				c.set(year, month, day, hour, minute, second);
				endTime = c.getTimeInMillis();
				startTime = date.getTime();
				midTime = (endTime - startTime) / 1000;
				while (GAMEOVER_TIME > 0) {
					GAMEOVER_TIME--;
					try {
						Thread.sleep(1000);
						int mm = GAMEOVER_TIME / 60 % 60;
						int ss = GAMEOVER_TIME % 60;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			};
		}.start();
	}
}
