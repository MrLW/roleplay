package com.sim.server.game.roleplay.room;

import com.sim.server.game.data.db.pojo.TbUser;

import io.netty.channel.Channel;
import lombok.Data;
/**
 * @author liwen
 * @date:2018年2月8日 下午4:08:10
 * @Function: 当前玩家客户端
 * @version 1.0
 */
@Data	
public class Client {
	
	// 补位null,说明当前客户端已经连接到服务器
	private Channel socket;
	// 不为null说明当前客户端已经登录成功
	private TbUser user;

}
