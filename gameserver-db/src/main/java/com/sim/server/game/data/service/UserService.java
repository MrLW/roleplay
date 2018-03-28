package com.sim.server.game.data.service;

import java.util.List;

import com.sim.server.game.data.db.pojo.TbUser;


public interface UserService {
	
	/**
	 *  ��ѯ�û��б�
	 * @return �û�����
	 */
	List<TbUser> listUsers() ;
	/**
	 * ����û�
	 * @param user �û�
	 * @return 
	 */
	int saveUser(TbUser user1);
	/**
	 *  �����û�id�����û�
	 * @param userId �û�id
	 * @return �û�����
	 */
	TbUser findUserById(int userId);
	
	int regist(TbUser user) ;
	
	TbUser findUserByUserNameOrEmailAndPassword(String username,String password);
	
}
