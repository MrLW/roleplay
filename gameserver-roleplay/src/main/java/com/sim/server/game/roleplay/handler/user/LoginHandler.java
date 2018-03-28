package com.sim.server.game.roleplay.handler.user;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;

import com.sim.server.game.common.RolePlayProtocolConstant;
import com.sim.server.game.data.db.pojo.TbUser;
import com.sim.server.game.data.service.UserService;
import com.sim.server.game.engine.core.HandlerEntity;
import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.message.request.user.LoginRequest;
import com.sim.server.game.message.response.user.LoginResponse;
import com.sim.server.game.model.model.PlayerInfo;
import com.sim.server.game.roleplay.manager.HallManager;
import com.sim.server.game.roleplay.manager.PlayerManager;
import com.sim.server.game.roleplay.manager.UserManager;
import com.sim.server.game.roleplay.player.Session;

import io.netty.channel.socket.SocketChannel;
/**
 * @author liwen
 * @date:2017年11月29日 下午2:52:19
 * @Function: 登录请求处理
 * @version 1.0
 */
@HandlerEntity(id = RolePlayProtocolConstant.LOGIN_REQUEST_PROTOCOL,desc="登录请求处理")
public class LoginHandler extends BaseHandler  {
	
	@Autowired
	private UserService userService;
	
	public void run() {
		byte result ;
		LoginRequest req = (LoginRequest) baseRequest;
		// 访问数据库层,通过1001查询数据库
		TbUser user = userService.findUserByUserNameOrEmailAndPassword(req.getUsername(), req.getPassword());
		// 获取连接的socket对象
		SocketChannel socket = (SocketChannel) channel;
		// 如果用户不在线,可以登录
		if (!HallManager.isOnline(user)) {
			if (null == user) {
				result = 0 ;
			} else {
				// 登录成功,需要创建进入大厅的client对象
				UserManager.userSocketMap.put(socket, user);
				// 创建session
				Session session = new Session() ;
				int sessionId = user.getId();
				session.setSessionId(sessionId);
				session.setChannel(channel);
				session.setCards(new LinkedList<>());
				UserManager.setSession(sessionId, session);
				// 创建玩家信息
				PlayerInfo info = new PlayerInfo();
				info.setUserId(user.getId());
				PlayerManager.playerInfoList.add(info);
				result = 1 ;
			}
		} else {
			// 用户在线,提示用户已经登录
			result = -1 ;
		}
		LoginResponse response = new LoginResponse(channel);
		response.setResult(result);;
		response.writeAndFlush();
	}

	@Override
	public Object clone() {
		LoginHandler handler = new LoginHandler(); 
		handler.userService = this.userService;
		handler.baseRequest = this.baseRequest ;
		handler.channel = this.channel;
		return handler;
	}
	
}
