package com.sim.server.game.roleplay.handler.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.data.db.pojo.TbUser;
import com.sim.server.game.data.service.UserService;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.request.user.RegistRequest;
import com.sim.server.game.message.response.user.RegisterResponse;
/**
 * @author liwen
 * @date:2017��12��14�� ����7:01:57
 * @Function: ע��������
 * @version 1.0
 */
@HandlerEntity(id=RolePlayProtocolConstant.REGISTE_REQUEST_PROTOCOL,desc="ע��������")
public class RegistHandler extends BaseHandler{

	@Autowired
	private UserService userService;
	
	public void run() {
		RegistRequest request = (RegistRequest) baseRequest;
		TbUser tbUser = new TbUser() ;
		tbUser.setName(request.getUserName());
		tbUser.setPassword(request.getPassword());
		tbUser.setEmail(request.getEmail());
		int i = userService.regist(tbUser);
		RegisterResponse response = new RegisterResponse(channel) ;
		response.setResult((byte)i);
		// ˢ��
		response.writeAndFlush();
	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return null;
	}

}