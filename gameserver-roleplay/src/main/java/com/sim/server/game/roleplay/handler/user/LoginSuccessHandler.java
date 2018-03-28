package com.sim.server.game.roleplay.handler.user;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.data.db.pojo.TbUser;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.response.user.LoginInfoResponse;
import com.sim.server.game.roleplay.manager.UserManager;

import io.netty.channel.Channel;
/**
 * @author liwen
 * @date:2017��12��14�� ����7:19:55
 * @Function: ��¼�ɹ�����
 * @version 1.0
 */
@HandlerEntity(id = RolePlayProtocolConstant.LOGIN_SUCCESS_REQUEST_PROTOCOL, desc = "��¼�ɹ�����")
public class LoginSuccessHandler extends BaseHandler {

	public void run() {
		LoginInfoResponse response = new LoginInfoResponse(channel);
		TbUser user = UserManager.userSocketMap.get(channel);
		response.setUserId(user.getId());
		response.writeAndFlush();
	}

	@Override
	public Object clone() {
		LoginSuccessHandler handler = new LoginSuccessHandler(); 
		handler.baseRequest = this.baseRequest ;
		handler.channel = this.channel;
		return handler;
	}

}