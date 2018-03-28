package com.sim.server.game.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.server.game.data.db.mapper.TbFriendMapper;
import com.sim.server.game.data.db.pojo.TbFriend;
import com.sim.server.game.data.service.FriendSservice;

@Service
public class FriendServiceImpl implements FriendSservice {

	@Autowired
	private TbFriendMapper friendMapper;
	
	public void insert(int userId, int friendId) {
		int a = Math.max(userId, friendId);
		int b = Math.min(userId, friendId) ;
		friendMapper.insertFriend(a,b) ;
	}

	public List<TbFriend> findByUserId(int userId) {
		
		List<TbFriend> friends = friendMapper.selectFriends(userId) ;
		
		return friends;
	}

	public TbFriend isFriends(int friendId, int userId) {
		TbFriend tbFriend = friendMapper.isFriend(friendId,userId) ;
		return tbFriend;
	}
}
