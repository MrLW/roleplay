package com.sim.server.game.message.response.sys;

import com.sim.server.game.common.RolePlayProtocolConstant;

/**
 * @author liwen
 * @date:2017��11��13�� ����4:40:55
 * @Function: ƥ�䳬ʱ��Ӧ
 * @version 1.0
 */
public class MatchTimeOutResponse {

	private Integer len;

	private Short responseId = RolePlayProtocolConstant.MATCH_TIMEOUT_RESPONSE_PROTOCOL;

	public Integer getLen() {
		return len;
	}

	public void setLen(Integer len) {
		this.len = len;
	}
	
	public Short getResponseId() {
		return responseId;
	}

	public void setResponseId(Short responseId) {
		this.responseId = responseId;
	}
	
	
}
