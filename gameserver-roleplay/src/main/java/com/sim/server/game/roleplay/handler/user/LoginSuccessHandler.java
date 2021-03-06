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
 * @date:2017年12月14日 下午7:19:55
 * @Function: 登录成功返回
 * @version 1.0
 */
@HandlerEntity(id = RolePlayProtocolConstant.LOGIN_SUCCESS_REQUEST_PROTOCOL, desc = "登录成功处理")
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
