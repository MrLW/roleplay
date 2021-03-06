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
	public static final short REGISTE_RESPONSE_PROTOCOL = 1001;
	/**
	 * 登录请求协议号
	 */
	public static final short LOGIN_REQUEST_PROTOCOL = 1002;
	public static final short LOGIN_RESPONSE_PROTOCOL = 1003;

	/**
	 * 获取登录用户信息的请求
	 */
	public static final short LOGIN_SUCCESS_REQUEST_PROTOCOL = 1004;
	public static final short LOGIN_SUCCESS_RESPONSE_PROTOCOL = 1005;
	

	/**
	 * 角色列表请求
	 */
	public static final short ROLELIST_REQUEST_PROTOCOL = 1006;
	public static final short ROLELIST_RESPONSE_PROTOCOL = 1007;
	
	/**
	 *  是否能选择角色
	 */
	public static final short ROLE_WEATHER_REQUEST_PROTOCOL = 1008;
	public static final short ROLE_WEATHER_RESPONSE_PROTOCOL = 1009;
	
	/**
	 * 角色请求
	 */
	public static final short ROLE_REQUEST_PROTOCOL = 1010;
	public static final short ROLE_RESPONSE_PROTOCOL = 1011;
	
	/**
	 * 匹配游戏请求
	 */
	public static final short MATCH_REQUEST_PROTOCOL = 1012;
	public static final short MATCH_RESPONSE_PROTOCOL = 1013;
	
	/**
	 * 开始游戏请求
	 */
	public static final short STARTGAME_REQUEST_PROTOCOL = 1014;
	public static final short STARTGAME_RESPONSE_PROTOCOL = 1015;
	
	/**
	 * 心跳检测请求协议号
	 */
	public static final short HEARTBEAT_REQUEST_PROTOCOL = 1016;
	public static final short HEARTBEAT_RESPONSE_PROTOCOL = 1017;
	

	/**
	 * 开始匹配超时请求
	 */
	public static final short MATCH_TIMEOUT_REQUEST_PROTOCOL = 1018;

	public static final short MATCH_TIMEOUT_RESPONSE_PROTOCOL = 1019;
	/**
	 *  所有玩家都选择角色后
	 */
	public static final short ROLE_ALL_SELECT_RESPONSE_PROTOCOL = 1021;
	
	/**
	 * 公司总金额请求
	 */
	public static final short TOTAL_INCOME_REQUEST_PROTOCOL = 2000;
	/**
	 * 公司总金额响应
	 */
	public static final short TOTAL_INCOME_RESPONSE_PROTOCOL = 2001;
	/**
	 * 仓库数量是否足够
	 */
	public static final short CHECK_WAREHOUSE_REQUEST_PROTOCOL = 2002;
	public static final short CHECK_WAREHOUSE_RESPONSE_PROTOCOL = 2003;
	
	/**
	 *  商品列表
	 */
	public static final short DB_COMMODITIES_REQUEST_PROTOCOL = 2004 ;
	public static final short DB_COMMODITIES_RESPONSE_PROTOCOL = 2005 ;
	
	/**
	 *  查看物品数量
	 */
	public static final short COMMODITY_VIEW_REQUEST_PROTOCOL = 2006 ;
	public static final short COMMODITY_VIEW_RESPONSE_PROTOCOL = 2007 ;

	/**
	 * 企业订单列表
	 */
	public static final short ORDERLIST_REQUEST_PROTOCOL = 2008;
	public static final short ORDERLIST_RESPONSE_PROTOCOL = 2009;
	/**
	 *  初始化HR配置相关
	 */
	public static final short HRCONFIG_REQUEST_PROTOCOL = 2010;
	public static final short HRCONFIG_RESPONSE_PROTOCOL = 2011;
	/**
	 *  同步系统时间
	 */
	public static final short SYNCT_SYSTEMTIME_REQUEST_PROTOCOL = 2012;
	public static final short SYNCT_SYSTEMTIME_RESPONSE_PROTOCOL = 2013;
	
	/**
	 * 生产线列表
	 */
	public static final short PRODUCTLINE_LIST_REQUEST_PROTOCOL = 3000;
	public static final short PRODUCTLINE_LIST_RESPONSE_PROTOCOL = 3001;
	/**
	 * 更新员工状态
	 */
	public static final short EMPLOYEE_STATE_REQUEST_PROTOCOL = 3002;
	public static final short EMPLOYEE_STATE_RESPONSE_PROTOCOL = 3003;
	
	/**
	 * 开始生产
	 */
	public static final short START_PRODUCTLINE_REQUEST_PROTOCOL = 3004;
	public static final short START_PRODUCTLINE_RESPONSE_PROTOCOL = 3005;
	
	
	/**
	 * 生产线停止生产响应
	 */
	public static final short PRODUCTLINE_STOP_REQUEST_PROTOCOL = 3006;
	public static final short PRODUCTLINE_STOP_RESPONSE_PROTOCOL = 3007;
	
	/**
	 * 选择生产A/B
	 */
	public static final short PRODUCTLINE_TYPE_REQUEST_PROTOCOL = 3008;
	public static final short PRODUCTLINE_TYPE_RESPONSE_PROTOCOL = 3009;
	
	/**
	 * 原料不够响应
	 */
	public static final short CHECK_MATERIAL_REQUEST_PROTOCOL = 3010;
	public static final short CHECK_MATERIAL_RESPONSE_PROTOCOL = 3011;
	
	/**
	 * 检查是否有正在工作的员工
	 */
	public static final short CHECK_EMPLOYEE_REQUEST_PROTOCOL = 3012;
	public static final short CHECK_EMPLOYEE_RESPONSE_PROTOCOL = 3013;
	
	/**
	 * 产品列表
	 */
	public static final short PRODUCT_LIST_REQUEST_PROTOCOL = 3014;
	public static final short PRODUCT_LIST_RESPONSE_PROTOCOL = 3015;
	

	/**
	 *  生产线工作状态
	 */
	public static final short PRODUCTLINE_STATE_REQUEST_PROTOCOL = 3016;
	public static final short PRODUCTLINE_STATE_RESPONSE_PROTOCOL = 3017;
	
	
	/**
	 * 修改订单状态
	 */
	public static final short ORDERTYPE_REQUEST_PROTOCOL = 3018;
	public static final short ORDERTYPE_RESPONSE_PROTOCOL = 3019;
	
	/**
	 *  为生产线配置员工
	 */
	public static final short EMPLOYEEProductLine_REQUEST_PROTOCOL = 3020;
	public static final short EMPLOYEEProductLine_RESPONSE_PROTOCOL = 3021;
	public static final short EMPLOYEEPRODUCTLINESTATE_RESPONSE_PROTOCOL = 3023;
	
	/**
	 * 添加生产线
	 */
	public static final short PRODUCTLINE_ADD_REQUEST_PROTOCOL = 3024;
	public static final short PRODUCTLINE_ADD_RESPONSE_PROTOCOL = 3025;
	
	public static final short EMPLOYEE_DIE_RESPONSE_PROTOCOL = 3027;
	
	/**
	 * 获取求职者列表请求
	 */
	public static final short DB_JOBHUNTER__REQUEST_PROTOCOL = 4000;
	public static final short DB_JOBHUNTER__RESPONSE_PROTOCOL = 4001;
	
	/**
	 * 招聘求职者请求
	 */
	public static final short INVITE_JOBHUNTER__REQUEST_PROTOCOL = 4002;
	public static final short INVITE_JOBHUNTER__RESPONSE_PROTOCOL = 4003;
	
	/**
	 * 招聘求职者请求
	 */
	public static final short EMPLOYEE_LIST_REQUEST_PROTOCOL = 4004;
	public static final short EMPLOYEE_LIST_RESPONSE_PROTOCOL = 4005;
	
	/**
	 * 刷新求职者列表
	 */
	public static final short JOBHUNTER_FLUSH_REQUEST_PROTOCOL = 4006;
	public static final short JOBHUNTER_FLUSH_RESPONSE_PROTOCOL = 4007;
	/**
	 * 工作中的员工
	 */
	public static final short EMPLOYEE_WORK_REQUEST_PROTOCOL = 4008;
	public static final short EMPLOYEE_WORK_RESPONSE_PROTOCOL = 4009;
	/**
	 *  员工辞退
	 */
	public static final short EMPLOYEE_DISMISS_REQUEST_PROTOCOL = 4010;
	public static final short EMPLOYEE_DISMISS_RESPONSE_PROTOCOL = 4011;
	
	/**
	 *  员工血量同步
	 */
	public static final short EMPLOYEESYNCHP_REQUEST_PROTOCOL = 4012;
	public static final short EMPLOYEESYNCHP_RESPONSE_PROTOCOL = 4013;
	
	/**
	 *  洽谈
	 */
	public static final short EMPLOYEE_TALK_REQUEST_PROTOCOL = 4014;
	public static final short EMPLOYEE_TALK_RESPONSE_PROTOCOL = 4015;
	/**
	 * 
	 */
	public static final short EMPLOYEE_SALARY_REQUEST_PROTOCOL = 4016;
	public static final short EMPLOYEE_SALARY_RESPONSE_PROTOCOL = 4017;
	/**
	 *  员工薪水改变
	 */
	public static final short EMPLOYEE_SALARY_CHANGE_RESPONSE_PROTOCOL = 4019 ;
	
	/**
	 *  支付薪水
	 */
	public static final short PAY_REQUEST_PROTOCOL = 4020 ;
	public static final short PAY_RESPONSE_PROTOCOL = 4021 ;
	
	/**
	 * 财务请款列表
	 */
	public static final short FINANCIALLIST_REQUEST_PROTOCOL = 5000;
	public static final short FINANCIALLIST_RESPONSE_PROTOCOL = 5001;
	
	/**
	 * 请款状态
	 */
	public static final short FINANCIALSTATE_REQUEST_PROTOCOL = 5002;
	public static final short FINANCIALSTATE_RESPONSE_PROTOCOL = 5003;
	//请款成功
	public static final short FINANCIALSUCCESS_RESPONSE_PROTOCOL = 5005;
	
	//财务部收到市场部的请求
	public static final short APPLYFOR_MONEY_RESPONSE_PROTOCOL = 5007;
	
	/**
	 *  报表列表
	 */
	public static final short REPORTITEM_LIST_REQUEST_PROTOCOL = 5008;
	public static final short REPORTITEM_LIST_RESPONSE_PROTOCOL = 5009;
	
	/**
	 * 刷新订单结果请求
	 */
	public static final short DB_FLUSH_RESULT_ORDER_REQUEST_PROTOCOL = 6000;
	public static final short DB_FLUSH_RESULT_ORDER_RESPONSE_PROTOCOL = 6001;
	
	/**
	 * 服务器订单
	 */
	public static final short DB_FLUSH_ORDER_REQUEST_PROTOCOL = 6002;
	public static final short DB_FLUSH_ORDER_RESPONSE_PROTOCOL = 6003;
	
	/**
	 * 接收订单请求
	 */
	public static final short ACCEPT_ORDER_REQUEST_PROTOCOL = 6004;
	public static final short ACCEPT_ORDER_RESPONSE_PROTOCOL = 6005;
	
	/**
	 * 申请金额请求
	 */
	public static final short APPLYFOR_MONEY_REQUEST_PROTOCOL = 6006;
	
	

	/**
	 * 申请金额结果请求
	 */
	public static final short APPLYFOR_MONEY_RESULT_REQUEST_PROTOCOL = 6008;

	/**
	 * 申请金额结果响应
	 */
	public static final short APPLYFOR_MONEY_RESULT_RESPONSE_PROTOCOL = 6009;
	
	/**
	 * 市场总监的小金库
	 */
	public static final short COFFERS_REQUEST_PROTOCOL = 6010;

	public static final short COFFERS_RESPONSE_PROTOCOL = 6011;

	/**
	 * 交付订单
	 */
	public static final short DELIVERYORDER_REQUEST_PROTOCOL = 6012;
	public static final short DELIVERYORDER_RESPONSE_PROTOCOL = 6013;
	
	
	
	/**
	 *  购买商品
	 */
	public static final short PURCHASE_COMMODITY_REQUEST_PROTOCOL = 7000 ;

	public static final short PURCHASE_COMMODITY_RESPONSE_PROTOCOL = 7001 ;
	
	/**
	 * 
	 */
	public static final short SALE_COMMODITY_REQUEST_PROTOCOL = 7002 ;
	public static final short SALE_COMMODITY_RESPONSE_PROTOCOL = 7003 ;
	
	
	
	
}
