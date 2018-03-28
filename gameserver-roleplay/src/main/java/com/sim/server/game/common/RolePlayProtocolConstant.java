package com.sim.server.game.common;

/**
 * 
 * @author liwen 2017��10��26�� ����12:57:33 Function: Э��ID�Ͷ�Ӧ�����ݽṹ��
 * @version 1.0
 */
public class RolePlayProtocolConstant {

	/**
	 * Э���ͷ���ȵ�ֵ,��Ϊ�õ���int,�����ֽڳ���4
	 */
	public static final Integer PACK_LEN = 4;

	/**
	 * ע������Э���
	 */
	public static final short REGISTE_REQUEST_PROTOCOL = 1000;
	public static final short REGISTE_RESPONSE_PROTOCOL = 1001;
	/**
	 * ��¼����Э���
	 */
	public static final short LOGIN_REQUEST_PROTOCOL = 1002;
	public static final short LOGIN_RESPONSE_PROTOCOL = 1003;

	/**
	 * ��ȡ��¼�û���Ϣ������
	 */
	public static final short LOGIN_SUCCESS_REQUEST_PROTOCOL = 1004;
	public static final short LOGIN_SUCCESS_RESPONSE_PROTOCOL = 1005;
	

	/**
	 * ��ɫ�б�����
	 */
	public static final short ROLELIST_REQUEST_PROTOCOL = 1006;
	public static final short ROLELIST_RESPONSE_PROTOCOL = 1007;
	
	/**
	 *  �Ƿ���ѡ���ɫ
	 */
	public static final short ROLE_WEATHER_REQUEST_PROTOCOL = 1008;
	public static final short ROLE_WEATHER_RESPONSE_PROTOCOL = 1009;
	
	/**
	 * ��ɫ����
	 */
	public static final short ROLE_REQUEST_PROTOCOL = 1010;
	public static final short ROLE_RESPONSE_PROTOCOL = 1011;
	
	/**
	 * ƥ����Ϸ����
	 */
	public static final short MATCH_REQUEST_PROTOCOL = 1012;
	public static final short MATCH_RESPONSE_PROTOCOL = 1013;
	
	/**
	 * ��ʼ��Ϸ����
	 */
	public static final short STARTGAME_REQUEST_PROTOCOL = 1014;
	public static final short STARTGAME_RESPONSE_PROTOCOL = 1015;
	
	/**
	 * �����������Э���
	 */
	public static final short HEARTBEAT_REQUEST_PROTOCOL = 1016;
	public static final short HEARTBEAT_RESPONSE_PROTOCOL = 1017;
	

	/**
	 * ��ʼƥ�䳬ʱ����
	 */
	public static final short MATCH_TIMEOUT_REQUEST_PROTOCOL = 1018;

	public static final short MATCH_TIMEOUT_RESPONSE_PROTOCOL = 1019;
	/**
	 *  ������Ҷ�ѡ���ɫ��
	 */
	public static final short ROLE_ALL_SELECT_RESPONSE_PROTOCOL = 1021;
	
	/**
	 * ��˾�ܽ������
	 */
	public static final short TOTAL_INCOME_REQUEST_PROTOCOL = 2000;
	/**
	 * ��˾�ܽ����Ӧ
	 */
	public static final short TOTAL_INCOME_RESPONSE_PROTOCOL = 2001;
	/**
	 * �ֿ������Ƿ��㹻
	 */
	public static final short CHECK_WAREHOUSE_REQUEST_PROTOCOL = 2002;
	public static final short CHECK_WAREHOUSE_RESPONSE_PROTOCOL = 2003;
	
	/**
	 *  ��Ʒ�б�
	 */
	public static final short DB_COMMODITIES_REQUEST_PROTOCOL = 2004 ;
	public static final short DB_COMMODITIES_RESPONSE_PROTOCOL = 2005 ;
	
	/**
	 *  �鿴��Ʒ����
	 */
	public static final short COMMODITY_VIEW_REQUEST_PROTOCOL = 2006 ;
	public static final short COMMODITY_VIEW_RESPONSE_PROTOCOL = 2007 ;

	/**
	 * ��ҵ�����б�
	 */
	public static final short ORDERLIST_REQUEST_PROTOCOL = 2008;
	public static final short ORDERLIST_RESPONSE_PROTOCOL = 2009;
	/**
	 *  ��ʼ��HR�������
	 */
	public static final short HRCONFIG_REQUEST_PROTOCOL = 2010;
	public static final short HRCONFIG_RESPONSE_PROTOCOL = 2011;
	/**
	 *  ͬ��ϵͳʱ��
	 */
	public static final short SYNCT_SYSTEMTIME_REQUEST_PROTOCOL = 2012;
	public static final short SYNCT_SYSTEMTIME_RESPONSE_PROTOCOL = 2013;
	
	/**
	 * �������б�
	 */
	public static final short PRODUCTLINE_LIST_REQUEST_PROTOCOL = 3000;
	public static final short PRODUCTLINE_LIST_RESPONSE_PROTOCOL = 3001;
	/**
	 * ����Ա��״̬
	 */
	public static final short EMPLOYEE_STATE_REQUEST_PROTOCOL = 3002;
	public static final short EMPLOYEE_STATE_RESPONSE_PROTOCOL = 3003;
	
	/**
	 * ��ʼ����
	 */
	public static final short START_PRODUCTLINE_REQUEST_PROTOCOL = 3004;
	public static final short START_PRODUCTLINE_RESPONSE_PROTOCOL = 3005;
	
	
	/**
	 * ������ֹͣ������Ӧ
	 */
	public static final short PRODUCTLINE_STOP_REQUEST_PROTOCOL = 3006;
	public static final short PRODUCTLINE_STOP_RESPONSE_PROTOCOL = 3007;
	
	/**
	 * ѡ������A/B
	 */
	public static final short PRODUCTLINE_TYPE_REQUEST_PROTOCOL = 3008;
	public static final short PRODUCTLINE_TYPE_RESPONSE_PROTOCOL = 3009;
	
	/**
	 * ԭ�ϲ�����Ӧ
	 */
	public static final short CHECK_MATERIAL_REQUEST_PROTOCOL = 3010;
	public static final short CHECK_MATERIAL_RESPONSE_PROTOCOL = 3011;
	
	/**
	 * ����Ƿ������ڹ�����Ա��
	 */
	public static final short CHECK_EMPLOYEE_REQUEST_PROTOCOL = 3012;
	public static final short CHECK_EMPLOYEE_RESPONSE_PROTOCOL = 3013;
	
	/**
	 * ��Ʒ�б�
	 */
	public static final short PRODUCT_LIST_REQUEST_PROTOCOL = 3014;
	public static final short PRODUCT_LIST_RESPONSE_PROTOCOL = 3015;
	

	/**
	 *  �����߹���״̬
	 */
	public static final short PRODUCTLINE_STATE_REQUEST_PROTOCOL = 3016;
	public static final short PRODUCTLINE_STATE_RESPONSE_PROTOCOL = 3017;
	
	
	/**
	 * �޸Ķ���״̬
	 */
	public static final short ORDERTYPE_REQUEST_PROTOCOL = 3018;
	public static final short ORDERTYPE_RESPONSE_PROTOCOL = 3019;
	
	/**
	 *  Ϊ����������Ա��
	 */
	public static final short EMPLOYEEProductLine_REQUEST_PROTOCOL = 3020;
	public static final short EMPLOYEEProductLine_RESPONSE_PROTOCOL = 3021;
	public static final short EMPLOYEEPRODUCTLINESTATE_RESPONSE_PROTOCOL = 3023;
	
	/**
	 * ����������
	 */
	public static final short PRODUCTLINE_ADD_REQUEST_PROTOCOL = 3024;
	public static final short PRODUCTLINE_ADD_RESPONSE_PROTOCOL = 3025;
	
	public static final short EMPLOYEE_DIE_RESPONSE_PROTOCOL = 3027;
	
	/**
	 * ��ȡ��ְ���б�����
	 */
	public static final short DB_JOBHUNTER__REQUEST_PROTOCOL = 4000;
	public static final short DB_JOBHUNTER__RESPONSE_PROTOCOL = 4001;
	
	/**
	 * ��Ƹ��ְ������
	 */
	public static final short INVITE_JOBHUNTER__REQUEST_PROTOCOL = 4002;
	public static final short INVITE_JOBHUNTER__RESPONSE_PROTOCOL = 4003;
	
	/**
	 * ��Ƹ��ְ������
	 */
	public static final short EMPLOYEE_LIST_REQUEST_PROTOCOL = 4004;
	public static final short EMPLOYEE_LIST_RESPONSE_PROTOCOL = 4005;
	
	/**
	 * ˢ����ְ���б�
	 */
	public static final short JOBHUNTER_FLUSH_REQUEST_PROTOCOL = 4006;
	public static final short JOBHUNTER_FLUSH_RESPONSE_PROTOCOL = 4007;
	/**
	 * �����е�Ա��
	 */
	public static final short EMPLOYEE_WORK_REQUEST_PROTOCOL = 4008;
	public static final short EMPLOYEE_WORK_RESPONSE_PROTOCOL = 4009;
	/**
	 *  Ա������
	 */
	public static final short EMPLOYEE_DISMISS_REQUEST_PROTOCOL = 4010;
	public static final short EMPLOYEE_DISMISS_RESPONSE_PROTOCOL = 4011;
	
	/**
	 *  Ա��Ѫ��ͬ��
	 */
	public static final short EMPLOYEESYNCHP_REQUEST_PROTOCOL = 4012;
	public static final short EMPLOYEESYNCHP_RESPONSE_PROTOCOL = 4013;
	
	/**
	 *  Ǣ̸
	 */
	public static final short EMPLOYEE_TALK_REQUEST_PROTOCOL = 4014;
	public static final short EMPLOYEE_TALK_RESPONSE_PROTOCOL = 4015;
	/**
	 * 
	 */
	public static final short EMPLOYEE_SALARY_REQUEST_PROTOCOL = 4016;
	public static final short EMPLOYEE_SALARY_RESPONSE_PROTOCOL = 4017;
	/**
	 *  Ա��нˮ�ı�
	 */
	public static final short EMPLOYEE_SALARY_CHANGE_RESPONSE_PROTOCOL = 4019 ;
	
	/**
	 *  ֧��нˮ
	 */
	public static final short PAY_REQUEST_PROTOCOL = 4020 ;
	public static final short PAY_RESPONSE_PROTOCOL = 4021 ;
	
	/**
	 * ��������б�
	 */
	public static final short FINANCIALLIST_REQUEST_PROTOCOL = 5000;
	public static final short FINANCIALLIST_RESPONSE_PROTOCOL = 5001;
	
	/**
	 * ���״̬
	 */
	public static final short FINANCIALSTATE_REQUEST_PROTOCOL = 5002;
	public static final short FINANCIALSTATE_RESPONSE_PROTOCOL = 5003;
	//���ɹ�
	public static final short FINANCIALSUCCESS_RESPONSE_PROTOCOL = 5005;
	
	//�����յ��г���������
	public static final short APPLYFOR_MONEY_RESPONSE_PROTOCOL = 5007;
	
	/**
	 *  �����б�
	 */
	public static final short REPORTITEM_LIST_REQUEST_PROTOCOL = 5008;
	public static final short REPORTITEM_LIST_RESPONSE_PROTOCOL = 5009;
	
	/**
	 * ˢ�¶����������
	 */
	public static final short DB_FLUSH_RESULT_ORDER_REQUEST_PROTOCOL = 6000;
	public static final short DB_FLUSH_RESULT_ORDER_RESPONSE_PROTOCOL = 6001;
	
	/**
	 * ����������
	 */
	public static final short DB_FLUSH_ORDER_REQUEST_PROTOCOL = 6002;
	public static final short DB_FLUSH_ORDER_RESPONSE_PROTOCOL = 6003;
	
	/**
	 * ���ն�������
	 */
	public static final short ACCEPT_ORDER_REQUEST_PROTOCOL = 6004;
	public static final short ACCEPT_ORDER_RESPONSE_PROTOCOL = 6005;
	
	/**
	 * ����������
	 */
	public static final short APPLYFOR_MONEY_REQUEST_PROTOCOL = 6006;
	
	

	/**
	 * ������������
	 */
	public static final short APPLYFOR_MONEY_RESULT_REQUEST_PROTOCOL = 6008;

	/**
	 * ����������Ӧ
	 */
	public static final short APPLYFOR_MONEY_RESULT_RESPONSE_PROTOCOL = 6009;
	
	/**
	 * �г��ܼ��С���
	 */
	public static final short COFFERS_REQUEST_PROTOCOL = 6010;

	public static final short COFFERS_RESPONSE_PROTOCOL = 6011;

	/**
	 * ��������
	 */
	public static final short DELIVERYORDER_REQUEST_PROTOCOL = 6012;
	public static final short DELIVERYORDER_RESPONSE_PROTOCOL = 6013;
	
	
	
	/**
	 *  ������Ʒ
	 */
	public static final short PURCHASE_COMMODITY_REQUEST_PROTOCOL = 7000 ;

	public static final short PURCHASE_COMMODITY_RESPONSE_PROTOCOL = 7001 ;
	
	/**
	 * 
	 */
	public static final short SALE_COMMODITY_REQUEST_PROTOCOL = 7002 ;
	public static final short SALE_COMMODITY_RESPONSE_PROTOCOL = 7003 ;
	
	
	
	
}