package com.sim.server.game.message.request.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen 
 * 2017年10月25日 上午10:24:09 
 * Function: 注册请求
 * @version 1.0
 */
@Data@EqualsAndHashCode(callSuper=false)
@Regist(id=RolePlayProtocolConstant.REGISTE_REQUEST_PROTOCOL,clazz=RegistRequest.class)
public class RegistRequest extends BaseRequest{
	
	// 注册的协议ID
	private short requestId = RolePlayProtocolConstant.REGISTE_REQUEST_PROTOCOL;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 邮箱
	private String email;
	
	public RegistRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public RegistRequest(ByteBuf buf) {
		super(buf);
		this.len = buf.readableBytes();
		this.userName = byteBuf.readString();
		this.password = byteBuf.readString();
	}
	

}
