package com.sim.server.game.data.service;

import java.util.List;

import com.sim.server.game.data.db.pojo.TbFriend;

public interface FriendSservice {

	/** 
	 * 添加好友关系
	 * @param userId 玩家ID
	 * @param friendId 好友ID
	 * @return
	 */
	void insert(int userId, int friendId);

	/** 根据玩家id查找玩家列表
	 * @param userId
	 * @return
	 */
	List<TbFriend> findByUserId(int userId);
	
	TbFriend isFriends(int friendId, int userId);

}
