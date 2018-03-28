package com.sim.server.game.data.service;

import java.util.List;

import com.sim.server.game.data.db.pojo.TbFriend;

public interface FriendSservice {

	/** 
	 * ��Ӻ��ѹ�ϵ
	 * @param userId ���ID
	 * @param friendId ����ID
	 * @return
	 */
	void insert(int userId, int friendId);

	/** �������id��������б�
	 * @param userId
	 * @return
	 */
	List<TbFriend> findByUserId(int userId);
	
	TbFriend isFriends(int friendId, int userId);

}
