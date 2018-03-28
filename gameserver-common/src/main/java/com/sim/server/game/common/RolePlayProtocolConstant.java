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
	/**
	 * ע����ӦЭ���
	 */
	public static final short REGISTE_RESPONSE_PROTOCOL = 1001;
	/**
	 * ��¼����Э���
	 */
	public static final short LOGIN_REQUEST_PROTOCOL = 1002;

	/**
	 * ��¼��ӦЭ���,��¼���
	 */
	public static final short LOGIN_RESPONSE_PROTOCOL = 1003;

	/**
	 * ��ȡ��¼�û���Ϣ������
	 */
	public static final short LOGIN_SUCCESS_REQUEST_PROTOCOL = 1004;

	/**
	 * ��ȡ��¼�û���Ϣ����Ӧ
	 */
	public static final short LOGIN_SUCCESS_RESPONSE_PROTOCOL = 1005;

	/**
	 * ��¼�ɹ��󷿼��б�����
	 */
	public static final short LOGIN_ROOMLIST_REQUEST_PROTOCOL = 1006;

	/**
	 * ��¼�ɹ���ķ����б���Ӧ
	 */
	public static final short LOGIN_ROOMLIST_RESPONSE_PROTOCOL = 1007;

	/**
	 * ��ȡ��¼�ɹ��󷵻ص�
	 */

	/**
	 * �¼��뷿�������Э���
	 */
	public static final short ROOM_REQUEST_PROTOCOL = 2000;
	/**
	 * �¼��뷿�����ӦЭ���
	 */
	public static final short ROOM_RESPONSE_PROTOCOL = 2001;
	/**
	 * �¼����,�������������ҵ���ӦЭ���
	 */
	public static final short NEWJOIN_RESPONSE_PROTOCOL = 2002;

	/**
	 */
	public static final short PLAYERLIST_REQUEST_PROTOCOL = 2003;

	/**
	 * 
	 */
	public static final short PLAYERLIST_RESPONSE_PROTOCOL = 2004;

	/**
	 * �����������Э���
	 */
	public static final short HEARTBEAT_REQUEST_PROTOCOL = 3000;
	/**
	 * ���������ӦЭ���
	 */
	public static final short HEARTBEAT_RESPONSE_PROTOCOL = 3001;
	public static final short TESTLIST_PROTOCOL = 1020;
	/**
	 * ��ȡ�г������вֿ�����
	 */
	public static final short DB_WAREHOUSE_REQUEST_PROTOCOL = 4000;

	/**
	 * ��ȡ�г������вֿ���Ӧ
	 */
	public static final short DB_WAREHOUSE_RESPONSE_PROTOCOL = 4001;

	/**
	 * �г�������ԭ��������
	 */
	public static final short DB_MATERIALS_REQUEST_PROTOCOL = 4002;

	/**
	 * �г�������ԭ������Ӧ
	 */
	public static final short DB_MATERIALS_RESPONSE_PROTOCOL = 4003;
	/**
	 * # �г��������豸����
	 */
	public static final short DB_EQUIPMENT_REQUEST_PROTOCOL = 4004;
	/**
	 * # �г��������豸��Ӧ
	 */
	public static final short DB_EQUIPMENT_RESPONSE_PROTOCOL = 4005;

	/**
	 * �ɹ��ֿ�(��ʱ�ɿͻ��˼�����ܷ���)
	 */
	public static final short PURCHASE_WAREHOUSE_REQUEST_PROTOCOL = 4006;

	/**
	 * �ɹ��ֿ�(���������)
	 */
	public static final short PURCHASE_WAREHOUSE_RESPONSE_PROTOCOL = 4007;

	/**
	 * �ɹ�������(��ʱ�ɿͻ��˼�����ܷ���)
	 */
	public static final short PURCHASE_PRODUCTTABLE_REQUEST_PROTOCOL = 4008;

	/**
	 * �ɹ�������(���������)
	 */
	public static final short PURCHASE_PRODUCTTABLE_RESPONSE_PROTOCOL = 4009;

	/**
	 * �ɹ�����
	 */
	public static final short PURCHASE_MATERIAL_REQUEST_PROTOCOL = 4010;

	/**
	 * �ɹ�����
	 */
	public static final short PURCHASE_MATERIAL_RESPONSE_PROTOCOL = 4011;

	/**
	 * ������ͬ��/�ܾ�����
	 */
	public static final short PURCHASE_RESULT_REQUEST_PROTOCOL = 4012;

	/**
	 * �ɹ�������յ����񷵻ؽ��
	 */
	public static final short PURCHASE_RESULT_RESPONSE_PROTOCOL = 4013;
	/**
	 * �������յ���������
	 */
	public static final short PURCHASE_MATERIAL_RESULT_REQUEST_PROTOCOL = 4020;
	/**
	 * �������յ�������Ӧ
	 */
	public static final short PURCHASE_MATERIAL_RESULT_RESPONSE_PROTOCOL = 4021;
	/**
	 * �������յ��豸����
	 */
	public static final short PURCHASE_EQUIPMENT_RESULT_REQUEST_PROTOCOL = 4022;
	/**
	 * �������յ��豸��Ӧ
	 */
	public static final short PURCHASE_EQUIPMENT_RESULT_RESPONSE_PROTOCOL = 4023;

	/**
	 * ��ӵ�еĲֿ�����
	 */
	public static final short OWNED_WAREHOUSE_REQUEST_PROTOCOL = 4014;

	/**
	 * ��ӵ�еĲֿ���Ӧ
	 */
	public static final short OWNED_WAREHOUSE_RESPONSE_PROTOCOL = 4015;

	/**
	 * ��ӵ�е�ԭ������
	 */
	public static final short OWNED_MATERIAL_REQUEST_PROTOCOL = 4016;

	/**
	 * ��ӵ�е�ԭ����Ӧ
	 */
	public static final short OWNED_MATERIAL_RESPONSE_PROTOCOL = 4017;

	/**
	 * ��ӵ�е�ԭ������
	 */
	public static final short OWNED_EQUIPMENT_REQUEST_PROTOCOL = 4018;

	/**
	 * ��ӵ�е�ԭ����Ӧ
	 */
	public static final short OWNED_EQUIPMENT_RESPONSE_PROTOCOL = 4019;
	/**
	 * ��������б�
	 */
	public static final short FINANCIALLIST_REQUEST_PROTOCOL = 4024;

	public static final short FINANCIALLIST_RESPONSE_PROTOCOL = 4025;

	/**
	 * ���״̬
	 */
	public static final short FINANCIALSTATE_REQUEST_PROTOCOL = 4026;

	public static final short FINANCIALSTATE_RESPONSE_PROTOCOL = 4027;
	/**
	 * ���ɹ�
	 */
	public static final short FINANCIALSUCCESS_RESPONSE_PROTOCOL = 4029;

	/**
	 * ���ֿ�����
	 */
	public static final short WAREHOUSE_CHECK_REQUEST_PROTOCOL = 4030;

	public static final short WAREHOUSE_CHECK_RESPONSE_PROTOCOL = 4031;
	/**
	 * ����ԭ��
	 */
	public static final short SALE_MATERIAL_REQUEST_PROTOCOL = 4032;

	public static final short SALE_MATERIAL_RESPONSE_PROTOCOL = 4033;
	/**
	 * �����豸
	 */
	public static final short SALE_EQUIPMENT_REQUEST_PROTOCOL = 4034;

	public static final short SALE_EQUIPMENT_RESPONSE_PROTOCOL = 4035;
	/**
	 * �����ֿ�
	 */
	public static final short SALE_WAREHOUSE_REQUEST_PROTOCOL = 4036;

	public static final short SALE_WAREHOUSE_RESPONSE_PROTOCOL = 4037;

	/**
	 * ԭ������
	 */
	public static final short MATERIALTYPES_REQUEST_PROTOCOL = 4038;

	public static final short MATERIALTYPES_RESPONSE_PROTOCOL = 4039;

	/**
	 * �˳�Э��
	 */
	public static final short DROPOUT_REQUEST_PROTOCOL = 5000;

	/**
	 * �˳���Ӧ
	 */
	public static final short DROPOUT_RESPONSE_PROTOCOL = 5001;
	/**
	 * ��������
	 */
	public static final short DIE_REQUEST_PROTOCOL = 5002;
	/**
	 * ������Ӧ
	 */
	public static final short DIE_RESPONSE_PROTOCOL = 5003;
	/**
	 * ��Ϸ������Ӧ
	 */
	public static final short GAMEOVER_RESPONSE_PROTOCOL = 5005;
	/**
	 * ��������
	 */
	public static final short DB_ORDER_REQUEST_PROTOCOL = 6000;
	/**
	 * ������Ӧ
	 */
	public static final short DB_ORDER_RESPONSE_PROTOCOL = 6001;
	/**
	 * ˢ�¶����������
	 */
	public static final short DB_FLUSH_RESULT_ORDER_REQUEST_PROTOCOL = 6002;

	/**
	 * ˢ�¶��������Ӧ
	 */
	public static final short DB_FLUSH_RESULT_ORDER_RESPONSE_PROTOCOL = 6003;

	/**
	 * 
	 */
	public static final short DB_FLUSH_ORDER_REQUEST_PROTOCOL = 6004;
	/**
	 * ˢ�¶�����Ӧ
	 */
	public static final short DB_FLUSH_ORDER_RESPONSE_PROTOCOL = 6005;

	/**
	 * ���ն�������
	 */
	public static final short ACCEPT_ORDER_REQUEST_PROTOCOL = 6006;
	/**
	 * ���ն�����Ӧ
	 */
	public static final short ACCEPT_ORDER_RESPONSE_PROTOCOL = 6007;

	/**
	 * ����������
	 */
	public static final short APPLYFOR_MONEY_REQUEST_PROTOCOL = 6008;

	/**
	 * ��������Ӧ
	 */
	public static final short APPLYFOR_MONEY_RESPONSE_PROTOCOL = 6009;

	/**
	 * ������������
	 */
	public static final short APPLYFOR_MONEY_RESULT_REQUEST_PROTOCOL = 6010;

	/**
	 * ����������Ӧ
	 */
	public static final short APPLYFOR_MONEY_RESULT_RESPONSE_PROTOCOL = 6011;
	/**
	 * �г��ܼ��С���
	 */
	public static final short COFFERS_REQUEST_PROTOCOL = 6012;

	public static final short COFFERS_RESPONSE_PROTOCOL = 6013;

	/**
	 * ��������
	 */
	public static final short DELIVERYORDER_REQUEST_PROTOCOL = 6014;

	public static final short DELIVERYORDER_RESPONSE_PROTOCOL = 6015;

	/**
	 * ��ȡ��ְ���б�����
	 */
	public static final short DB_JOBHUNTER__REQUEST_PROTOCOL = 7000;
	/**
	 * ��ȡ��ְ���б���Ӧ
	 */
	public static final short DB_JOBHUNTER__RESPONSE_PROTOCOL = 7001;

	/**
	 * ��Ƹ��ְ������
	 */
	public static final short INVITE_JOBHUNTER__REQUEST_PROTOCOL = 7002;
	/**
	 * ��Ƹ��ְ����Ӧ
	 */
	public static final short INVITE_JOBHUNTER__RESPONSE_PROTOCOL = 7003;

	/**
	 * ��Ƹ��ְ������
	 */
	public static final short EMPLOYEE_LIST_REQUEST_PROTOCOL = 7004;
	/**
	 * ��Ƹ��ְ����Ӧ
	 */
	public static final short EMPLOYEE_LIST_RESPONSE_PROTOCOL = 7005;
	/**
	 * ˢ����ְ���б�
	 */
	public static final short JOBHUNTER_FLUSH_REQUEST_PROTOCOL = 7006;

	public static final short JOBHUNTER_FLUSH_RESPONSE_PROTOCOL = 7007;
	/**
	 * �����е�Ա��
	 */
	public static final short EMPLOYEE_WORK_REQUEST_PROTOCOL = 7008;

	public static final short EMPLOYEE_WORK_RESPONSE_PROTOCOL = 7009;
	
	/**
	 *  Ա������
	 */
	public static final short EMPLOYEE_DISMISS_REQUEST_PROTOCOL = 7010;

	public static final short EMPLOYEE_DISMISS_RESPONSE_PROTOCOL = 7011;

	/**
	 * ƥ����Ϸ����
	 */
	public static final short MATCH_REQUEST_PROTOCOL = 8000;

	/**
	 * ƥ����Ϸ��Ӧ
	 */
	public static final short MATCH_RESPONSE_PROTOCOL = 8001;

	/**
	 * ��ʼ��Ϸ����
	 */
	public static final short STARTGAME_REQUEST_PROTOCOL = 8002;

	/**
	 * ��ʼ��Ϸ��Ӧ
	 */
	public static final short STARTGAME_RESPONSE_PROTOCOL = 8003;

	/**
	 * ��ʼƥ�䳬ʱ����
	 */
	public static final short MATCH_TIMEOUT_REQUEST_PROTOCOL = 8004;

	/**
	 * ��ʼƥ�䳬ʱ��Ӧ
	 */
	public static final short MATCH_TIMEOUT_RESPONSE_PROTOCOL = 8005;

	/**
	 * ��ɫ�б�����
	 */
	public static final short ROLELIST_REQUEST_PROTOCOL = 8006;
	/**
	 * ��ɫ�б���Ӧ
	 */
	public static final short ROLELIST_RESPONSE_PROTOCOL = 8007;

	/**
	 * ��ɫ����
	 */
	public static final short ROLE_REQUEST_PROTOCOL = 8008;
	/**
	 * ��ɫ��Ӧ
	 */
	public static final short ROLE_RESPONSE_PROTOCOL = 8009;

	public static final short ROLE_ALL_SELECT_RESPONSE_PROTOCOL = 8010;
	/**
	 * ��˾�ܽ������
	 */
	public static final short TOTAL_INCOME_REQUEST_PROTOCOL = 8010;
	/**
	 * ��˾�ܽ����Ӧ
	 */
	public static final short TOTAL_INCOME_RESPONSE_PROTOCOL = 8011;

	/**
	 * ��ҵ�����б�
	 */
	public static final short ORDERLIST_REQUEST_PROTOCOL = 8012;
	public static final short ORDERLIST_RESPONSE_PROTOCOL = 8013;

	/**
	 * �ֿ��б�
	 */
	public static final short WAREHOUSE_LIST_REQUEST_PROTOCOL = 9002;
	public static final short WAREHOUSE_LIST_RESPONSE_PROTOCOL = 9003;
	/**
	 * �豸�б�
	 */
	public static final short EQUIPMENT_LIST_REQUEST_PROTOCOL = 9000;
	public static final short EQUIPMENT_LIST_RESPONSE_PROTOCOL = 9001;
	/**
	 * ԭ���б�
	 */
	public static final short MATERIAL_LIST_REQUEST_PROTOCOL = 9004;
	public static final short MATERIAL_LIST_RESPONSE_PROTOCOL = 9005;
	/**
	 * ���������
	 */
	public static final short PRODUCTLINE_ADD_REQUEST_PROTOCOL = 9006;
	public static final short PRODUCTLINE_ADD_RESPONSE_PROTOCOL = 9007;

	/**
	 * �������б�
	 */
	public static final short PRODUCTLINE_LIST_REQUEST_PROTOCOL = 9008;
	public static final short PRODUCTLINE_LIST_RESPONSE_PROTOCOL = 9009;

	/**
	 * ����Ա��״̬
	 */
	public static final short EMPLOYEE_STATE_REQUEST_PROTOCOL = 9010;
	public static final short EMPLOYEE_STATE_RESPONSE_PROTOCOL = 9011;
	/**
	 * ��Ʒ�����б�
	 */
	public static final short PRODUCTOR_LIST_REQUEST_PROTOCOL = 9012;
	public static final short PRODUCTOR_LIST_RESPONSE_PROTOCOL = 9013;

	/**
	 * ��ʼ����
	 */
	public static final short START_PRODUCTLINE_REQUEST_PROTOCOL = 9014;
	public static final short START_PRODUCTLINE_RESPONSE_PROTOCOL = 9015;
	/**
	 * ѡ������A/B
	 */
	public static final short PRODUCTLINE_TYPE_REQUEST_PROTOCOL = 9020;
	public static final short PRODUCTLINE_TYPE_RESPONSE_PROTOCOL = 9021;
	/**
	 * ԭ�ϲ�����Ӧ
	 */
	public static final short CHECK_MATERIAL_REQUEST_PROTOCOL = 9022;
	/**
	 * ԭ�ϲ�����Ӧ
	 */
	public static final short CHECK_MATERIAL_RESPONSE_PROTOCOL = 9023;

	/**
	 * ԭ�ϲ�����Ӧ
	 */
	public static final short CHECK_EMPLOYEE_REQUEST_PROTOCOL = 9024;
	/**
	 * ԭ�ϲ�����Ӧ
	 */
	public static final short CHECK_EMPLOYEE_RESPONSE_PROTOCOL = 9025;
	/**
	 * ��Ʒ�б�
	 */
	public static final short PRODUCT_LIST_REQUEST_PROTOCOL = 9026;
	public static final short PRODUCT_LIST_RESPONSE_PROTOCOL = 9027;

	/**
	 * �޸Ķ���״̬
	 */
	public static final short ORDERTYPE_REQUEST_PROTOCOL = 9031;
	public static final short ORDERTYPE_RESPONSE_PROTOCOL = 9032;
	/**
	 *  Ա��Ѫ��ͬ��
	 */
	public static final short EMPLOYEESYNCHP_REQUEST_PROTOCOL = 9033;
	public static final short EMPLOYEESYNCHP_RESPONSE_PROTOCOL = 9034;
}
