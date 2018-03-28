package com.sim.server.game.data.service;

import java.util.List;

import com.sim.server.game.data.db.pojo.TbUser;


public interface UserService {
	
	/**
	 *  查询用户列表
	 * @return 用户集合
	 */
	List<TbUser> listUsers() ;
	/**
	 * 添加用户
	 * @param user 用户
	 * @return 
	 */
	int saveUser(TbUser user1);
	/**
	 *  根据用户id查找用户
	 * @param userId 用户id
	 * @return 用户对象
	 */
	TbUser findUserById(int userId);
	
	int regist(TbUser user) ;
	
	TbUser findUserByUserNameOrEmailAndPassword(String username,String password);
	
}
