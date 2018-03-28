package com.sim.server.game.message.request.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.engine.core.Regist;
import com.sim.server.game.message.request.BaseRequest;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen 
 * 2017��10��25�� ����10:24:09 
 * Function: ע������
 * @version 1.0
 */
@Data@EqualsAndHashCode(callSuper=false)
@Regist(id=RolePlayProtocolConstant.REGISTE_REQUEST_PROTOCOL,clazz=RegistRequest.class)
public class RegistRequest extends BaseRequest{
	
	// ע���Э��ID
	private short requestId = RolePlayProtocolConstant.REGISTE_REQUEST_PROTOCOL;
	// �û���
	private String userName;
	// ����
	private String password;
	// ����
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
