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
 * @date:2017��11��29�� ����2:52:19
 * @Function: ��¼������
 * @version 1.0
 */
@HandlerEntity(id = RolePlayProtocolConstant.LOGIN_REQUEST_PROTOCOL,desc="��¼������")
public class LoginHandler extends BaseHandler  {
	
	@Autowired
	private UserService userService;
	
	public void run() {
		byte result ;
		LoginRequest req = (LoginRequest) baseRequest;
		// �������ݿ��,ͨ��1001��ѯ���ݿ�
		TbUser user = userService.findUserByUserNameOrEmailAndPassword(req.getUsername(), req.getPassword());
		// ��ȡ���ӵ�socket����
		SocketChannel socket = (SocketChannel) channel;
		// ����û�������,���Ե�¼
		if (!HallManager.isOnline(user)) {
			if (null == user) {
				result = 0 ;
			} else {
				// ��¼�ɹ�,��Ҫ�������������client����
				UserManager.userSocketMap.put(socket, user);
				// ����session
				Session session = new Session() ;
				int sessionId = user.getId();
				session.setSessionId(sessionId);
				session.setChannel(channel);
				session.setCards(new LinkedList<>());
				UserManager.setSession(sessionId, session);
				// ���������Ϣ
				PlayerInfo info = new PlayerInfo();
				info.setUserId(user.getId());
				PlayerManager.playerInfoList.add(info);
				result = 1 ;
			}
		} else {
			// �û�����,��ʾ�û��Ѿ���¼
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