package com.sim.server.game.common;

/**
 * 
 * @author liwen 2017年10月26日 下午12:57:33 Function: 协议ID和对应的数据结构类
 * @version 1.0
 */
public class RolePlayProtocolConstant {

	/**
	 * 协议包头长度的值,因为用的是int,所以字节长是4
	 */
	public static final Integer PACK_LEN = 4;

	/**
	 * 注册请求协议号
	 */
	public static final short REGISTE_REQUEST_PROTOCOL = 1000;
	/**
	 * 注册响应协议号
	 */
	public static final short REGISTE_RESPONSE_PROTOCOL = 1001;
	/**
	 * 登录请求协议号
	 */
	public static final short LOGIN_REQUEST_PROTOCOL = 1002;

	/**
	 * 登录响应协议号,登录结果
	 */
	public static final short LOGIN_RESPONSE_PROTOCOL = 1003;

	/**
	 * 获取登录用户信息的请求
	 */
	public static final short LOGIN_SUCCESS_REQUEST_PROTOCOL = 1004;

	/**
	 * 获取登录用户信息的响应
	 */
	public static final short LOGIN_SUCCESS_RESPONSE_PROTOCOL = 1005;

	/**
	 * 登录成功后房间列表请求
	 */
	public static final short LOGIN_ROOMLIST_REQUEST_PROTOCOL = 1006;

	/**
	 * 登录成功后的房间列表响应
	 */
	public static final short LOGIN_ROOMLIST_RESPONSE_PROTOCOL = 1007;

	/**
	 * 获取登录成功后返回的
	 */

	/**
	 * 新加入房间的请求协议号
	 */
	public static final short ROOM_REQUEST_PROTOCOL = 2000;
	/**
	 * 新加入房间的响应协议号
	 */
	public static final short ROOM_RESPONSE_PROTOCOL = 2001;
	/**
	 * 新加玩家,发给房间里旧玩家的响应协议号
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
	 * 心跳检测请求协议号
	 */
	public static final short HEARTBEAT_REQUEST_PROTOCOL = 3000;
	/**
	 * 心跳检测响应协议号
	 */
	public static final short HEARTBEAT_RESPONSE_PROTOCOL = 3001;
	public static final short TESTLIST_PROTOCOL = 1020;
	/**
	 * 获取市场中所有仓库请求
	 */
	public static final short DB_WAREHOUSE_REQUEST_PROTOCOL = 4000;

	/**
	 * 获取市场中所有仓库响应
	 */
	public static final short DB_WAREHOUSE_RESPONSE_PROTOCOL = 4001;

	/**
	 * 市场中所有原材料请求
	 */
	public static final short DB_MATERIALS_REQUEST_PROTOCOL = 4002;

	/**
	 * 市场中所有原材料响应
	 */
	public static final short DB_MATERIALS_RESPONSE_PROTOCOL = 4003;
	/**
	 * # 市场中所有设备请求
	 */
	public static final short DB_EQUIPMENT_REQUEST_PROTOCOL = 4004;
	/**
	 * # 市场中所有设备响应
	 */
	public static final short DB_EQUIPMENT_RESPONSE_PROTOCOL = 4005;

	/**
	 * 采购仓库(暂时由客户端计算出总费用)
	 */
	public static final short PURCHASE_WAREHOUSE_REQUEST_PROTOCOL = 4006;

	/**
	 * 采购仓库(财务经理接收)
	 */
	public static final short PURCHASE_WAREHOUSE_RESPONSE_PROTOCOL = 4007;

	/**
	 * 采购生产桌(暂时由客户端计算出总费用)
	 */
	public static final short PURCHASE_PRODUCTTABLE_REQUEST_PROTOCOL = 4008;

	/**
	 * 采购生产桌(财务经理接收)
	 */
	public static final short PURCHASE_PRODUCTTABLE_RESPONSE_PROTOCOL = 4009;

	/**
	 * 采购材料
	 */
	public static final short PURCHASE_MATERIAL_REQUEST_PROTOCOL = 4010;

	/**
	 * 采购材料
	 */
	public static final short PURCHASE_MATERIAL_RESPONSE_PROTOCOL = 4011;

	/**
	 * 财务经理同意/拒绝请求
	 */
	public static final short PURCHASE_RESULT_REQUEST_PROTOCOL = 4012;

	/**
	 * 采购经理接收到财务返回结果
	 */
	public static final short PURCHASE_RESULT_RESPONSE_PROTOCOL = 4013;
	/**
	 * 财务经理收到材料请求
	 */
	public static final short PURCHASE_MATERIAL_RESULT_REQUEST_PROTOCOL = 4020;
	/**
	 * 财务经理收到材料响应
	 */
	public static final short PURCHASE_MATERIAL_RESULT_RESPONSE_PROTOCOL = 4021;
	/**
	 * 财务经理收到设备请求
	 */
	public static final short PURCHASE_EQUIPMENT_RESULT_REQUEST_PROTOCOL = 4022;
	/**
	 * 财务经理收到设备响应
	 */
	public static final short PURCHASE_EQUIPMENT_RESULT_RESPONSE_PROTOCOL = 4023;

	/**
	 * 已拥有的仓库请求
	 */
	public static final short OWNED_WAREHOUSE_REQUEST_PROTOCOL = 4014;

	/**
	 * 已拥有的仓库响应
	 */
	public static final short OWNED_WAREHOUSE_RESPONSE_PROTOCOL = 4015;

	/**
	 * 已拥有的原料请求
	 */
	public static final short OWNED_MATERIAL_REQUEST_PROTOCOL = 4016;

	/**
	 * 已拥有的原料响应
	 */
	public static final short OWNED_MATERIAL_RESPONSE_PROTOCOL = 4017;

	/**
	 * 已拥有的原料请求
	 */
	public static final short OWNED_EQUIPMENT_REQUEST_PROTOCOL = 4018;

	/**
	 * 已拥有的原料响应
	 */
	public static final short OWNED_EQUIPMENT_RESPONSE_PROTOCOL = 4019;
	/**
	 * 财务请款列表
	 */
	public static final short FINANCIALLIST_REQUEST_PROTOCOL = 4024;

	public static final short FINANCIALLIST_RESPONSE_PROTOCOL = 4025;

	/**
	 * 请款状态
	 */
	public static final short FINANCIALSTATE_REQUEST_PROTOCOL = 4026;

	public static final short FINANCIALSTATE_RESPONSE_PROTOCOL = 4027;
	/**
	 * 请款成功
	 */
	public static final short FINANCIALSUCCESS_RESPONSE_PROTOCOL = 4029;

	/**
	 * 检查仓库数量
	 */
	public static final short WAREHOUSE_CHECK_REQUEST_PROTOCOL = 4030;

	public static final short WAREHOUSE_CHECK_RESPONSE_PROTOCOL = 4031;
	/**
	 * 卖出原料
	 */
	public static final short SALE_MATERIAL_REQUEST_PROTOCOL = 4032;

	public static final short SALE_MATERIAL_RESPONSE_PROTOCOL = 4033;
	/**
	 * 卖出设备
	 */
	public static final short SALE_EQUIPMENT_REQUEST_PROTOCOL = 4034;

	public static final short SALE_EQUIPMENT_RESPONSE_PROTOCOL = 4035;
	/**
	 * 卖出仓库
	 */
	public static final short SALE_WAREHOUSE_REQUEST_PROTOCOL = 4036;

	public static final short SALE_WAREHOUSE_RESPONSE_PROTOCOL = 4037;

	/**
	 * 原料类型
	 */
	public static final short MATERIALTYPES_REQUEST_PROTOCOL = 4038;

	public static final short MATERIALTYPES_RESPONSE_PROTOCOL = 4039;

	/**
	 * 退出协议
	 */
	public static final short DROPOUT_REQUEST_PROTOCOL = 5000;

	/**
	 * 退出响应
	 */
	public static final short DROPOUT_RESPONSE_PROTOCOL = 5001;
	/**
	 * 死亡请求
	 */
	public static final short DIE_REQUEST_PROTOCOL = 5002;
	/**
	 * 死亡响应
	 */
	public static final short DIE_RESPONSE_PROTOCOL = 5003;
	/**
	 * 游戏结束响应
	 */
	public static final short GAMEOVER_RESPONSE_PROTOCOL = 5005;
	/**
	 * 订单请求
	 */
	public static final short DB_ORDER_REQUEST_PROTOCOL = 6000;
	/**
	 * 订单响应
	 */
	public static final short DB_ORDER_RESPONSE_PROTOCOL = 6001;
	/**
	 * 刷新订单结果请求
	 */
	public static final short DB_FLUSH_RESULT_ORDER_REQUEST_PROTOCOL = 6002;

	/**
	 * 刷新订单结果响应
	 */
	public static final short DB_FLUSH_RESULT_ORDER_RESPONSE_PROTOCOL = 6003;

	/**
	 * 
	 */
	public static final short DB_FLUSH_ORDER_REQUEST_PROTOCOL = 6004;
	/**
	 * 刷新订单响应
	 */
	public static final short DB_FLUSH_ORDER_RESPONSE_PROTOCOL = 6005;

	/**
	 * 接收订单请求
	 */
	public static final short ACCEPT_ORDER_REQUEST_PROTOCOL = 6006;
	/**
	 * 接收订单响应
	 */
	public static final short ACCEPT_ORDER_RESPONSE_PROTOCOL = 6007;

	/**
	 * 申请金额请求
	 */
	public static final short APPLYFOR_MONEY_REQUEST_PROTOCOL = 6008;

	/**
	 * 申请金额响应
	 */
	public static final short APPLYFOR_MONEY_RESPONSE_PROTOCOL = 6009;

	/**
	 * 申请金额结果请求
	 */
	public static final short APPLYFOR_MONEY_RESULT_REQUEST_PROTOCOL = 6010;

	/**
	 * 申请金额结果响应
	 */
	public static final short APPLYFOR_MONEY_RESULT_RESPONSE_PROTOCOL = 6011;
	/**
	 * 市场总监的小金库
	 */
	public static final short COFFERS_REQUEST_PROTOCOL = 6012;

	public static final short COFFERS_RESPONSE_PROTOCOL = 6013;

	/**
	 * 交付订单
	 */
	public static final short DELIVERYORDER_REQUEST_PROTOCOL = 6014;

	public static final short DELIVERYORDER_RESPONSE_PROTOCOL = 6015;

	/**
	 * 获取求职者列表请求
	 */
	public static final short DB_JOBHUNTER__REQUEST_PROTOCOL = 7000;
	/**
	 * 获取求职者列表响应
	 */
	public static final short DB_JOBHUNTER__RESPONSE_PROTOCOL = 7001;

	/**
	 * 招聘求职者请求
	 */
	public static final short INVITE_JOBHUNTER__REQUEST_PROTOCOL = 7002;
	/**
	 * 招聘求职者响应
	 */
	public static final short INVITE_JOBHUNTER__RESPONSE_PROTOCOL = 7003;

	/**
	 * 招聘求职者请求
	 */
	public static final short EMPLOYEE_LIST_REQUEST_PROTOCOL = 7004;
	/**
	 * 招聘求职者响应
	 */
	public static final short EMPLOYEE_LIST_RESPONSE_PROTOCOL = 7005;
	/**
	 * 刷新求职者列表
	 */
	public static final short JOBHUNTER_FLUSH_REQUEST_PROTOCOL = 7006;

	public static final short JOBHUNTER_FLUSH_RESPONSE_PROTOCOL = 7007;
	/**
	 * 工作中的员工
	 */
	public static final short EMPLOYEE_WORK_REQUEST_PROTOCOL = 7008;

	public static final short EMPLOYEE_WORK_RESPONSE_PROTOCOL = 7009;
	
	/**
	 *  员工辞退
	 */
	public static final short EMPLOYEE_DISMISS_REQUEST_PROTOCOL = 7010;

	public static final short EMPLOYEE_DISMISS_RESPONSE_PROTOCOL = 7011;

	/**
	 * 匹配游戏请求
	 */
	public static final short MATCH_REQUEST_PROTOCOL = 8000;

	/**
	 * 匹配游戏响应
	 */
	public static final short MATCH_RESPONSE_PROTOCOL = 8001;

	/**
	 * 开始游戏请求
	 */
	public static final short STARTGAME_REQUEST_PROTOCOL = 8002;

	/**
	 * 开始游戏响应
	 */
	public static final short STARTGAME_RESPONSE_PROTOCOL = 8003;

	/**
	 * 开始匹配超时请求
	 */
	public static final short MATCH_TIMEOUT_REQUEST_PROTOCOL = 8004;

	/**
	 * 开始匹配超时响应
	 */
	public static final short MATCH_TIMEOUT_RESPONSE_PROTOCOL = 8005;

	/**
	 * 角色列表请求
	 */
	public static final short ROLELIST_REQUEST_PROTOCOL = 8006;
	/**
	 * 角色列表响应
	 */
	public static final short ROLELIST_RESPONSE_PROTOCOL = 8007;

	/**
	 * 角色请求
	 */
	public static final short ROLE_REQUEST_PROTOCOL = 8008;
	/**
	 * 角色响应
	 */
	public static final short ROLE_RESPONSE_PROTOCOL = 8009;

	public static final short ROLE_ALL_SELECT_RESPONSE_PROTOCOL = 8010;
	/**
	 * 公司总金额请求
	 */
	public static final short TOTAL_INCOME_REQUEST_PROTOCOL = 8010;
	/**
	 * 公司总金额响应
	 */
	public static final short TOTAL_INCOME_RESPONSE_PROTOCOL = 8011;

	/**
	 * 企业订单列表
	 */
	public static final short ORDERLIST_REQUEST_PROTOCOL = 8012;
	public static final short ORDERLIST_RESPONSE_PROTOCOL = 8013;

	/**
	 * 仓库列表
	 */
	public static final short WAREHOUSE_LIST_REQUEST_PROTOCOL = 9002;
	public static final short WAREHOUSE_LIST_RESPONSE_PROTOCOL = 9003;
	/**
	 * 设备列表
	 */
	public static final short EQUIPMENT_LIST_REQUEST_PROTOCOL = 9000;
	public static final short EQUIPMENT_LIST_RESPONSE_PROTOCOL = 9001;
	/**
	 * 原料列表
	 */
	public static final short MATERIAL_LIST_REQUEST_PROTOCOL = 9004;
	public static final short MATERIAL_LIST_RESPONSE_PROTOCOL = 9005;
	/**
	 * 添加生产线
	 */
	public static final short PRODUCTLINE_ADD_REQUEST_PROTOCOL = 9006;
	public static final short PRODUCTLINE_ADD_RESPONSE_PROTOCOL = 9007;

	/**
	 * 生产线列表
	 */
	public static final short PRODUCTLINE_LIST_REQUEST_PROTOCOL = 9008;
	public static final short PRODUCTLINE_LIST_RESPONSE_PROTOCOL = 9009;

	/**
	 * 更新员工状态
	 */
	public static final short EMPLOYEE_STATE_REQUEST_PROTOCOL = 9010;
	public static final short EMPLOYEE_STATE_RESPONSE_PROTOCOL = 9011;
	/**
	 * 产品类型列表
	 */
	public static final short PRODUCTOR_LIST_REQUEST_PROTOCOL = 9012;
	public static final short PRODUCTOR_LIST_RESPONSE_PROTOCOL = 9013;

	/**
	 * 开始生产
	 */
	public static final short START_PRODUCTLINE_REQUEST_PROTOCOL = 9014;
	public static final short START_PRODUCTLINE_RESPONSE_PROTOCOL = 9015;
	/**
	 * 选择生产A/B
	 */
	public static final short PRODUCTLINE_TYPE_REQUEST_PROTOCOL = 9020;
	public static final short PRODUCTLINE_TYPE_RESPONSE_PROTOCOL = 9021;
	/**
	 * 原料不够响应
	 */
	public static final short CHECK_MATERIAL_REQUEST_PROTOCOL = 9022;
	/**
	 * 原料不够响应
	 */
	public static final short CHECK_MATERIAL_RESPONSE_PROTOCOL = 9023;

	/**
	 * 原料不够响应
	 */
	public static final short CHECK_EMPLOYEE_REQUEST_PROTOCOL = 9024;
	/**
	 * 原料不够响应
	 */
	public static final short CHECK_EMPLOYEE_RESPONSE_PROTOCOL = 9025;
	/**
	 * 产品列表
	 */
	public static final short PRODUCT_LIST_REQUEST_PROTOCOL = 9026;
	public static final short PRODUCT_LIST_RESPONSE_PROTOCOL = 9027;

	/**
	 * 修改订单状态
	 */
	public static final short ORDERTYPE_REQUEST_PROTOCOL = 9031;
	public static final short ORDERTYPE_RESPONSE_PROTOCOL = 9032;
	/**
	 *  员工血量同步
	 */
	public static final short EMPLOYEESYNCHP_REQUEST_PROTOCOL = 9033;
	public static final short EMPLOYEESYNCHP_RESPONSE_PROTOCOL = 9034;
}
