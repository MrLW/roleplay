package com.sim.server.game.message.request.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017年11月29日 下午5:35:39
 * @Function: login request
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Regist(id=RolePlayProtocolConstant.LOGIN_REQUEST_PROTOCOL,clazz=LoginRequest.class)
public class LoginRequest extends BaseRequest{
	// 请求协议号
	private short requestId = RolePlayProtocolConstant.LOGIN_REQUEST_PROTOCOL;
	// 消息体
	private String username;
	// 密码
	private String password;
	
	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginRequest(ByteBuf buf) {
		super(buf);
		this.len = buf.readableBytes() ;
		this.username = byteBuf.readString();
		this.password = byteBuf.readString();
	}
	
}
