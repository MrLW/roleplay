package com.sim.server.game.engine.source.protocol;

/**
 * 
 * @author liwen
 *
 */
public class LoginProtocol {

	/**
	 * �����½
	 */
	public static final int AREA_LOGINREQUEST = 0;
	/**
	 * ��½��Ӧ
	 */
	public static final int AREA_LOGINRESPONSE = 1;
	/**
	 * ��Ч��Ϣ
	 */
	public static final int LOGIN_INVALIDMESSAGE = 0;
	/**
	 * ��Ч�û���
	 */
	public static final int LOGIN_INVALIDUSERNAME = 1;
	/**
	 * �������
	 */
	public static final int LOGIN_INVALIDPASSWORD = 2;
	/**
	 * ��½�ɹ�
	 */
	public static final int LOGIN_SUCCEED = 10;
}
