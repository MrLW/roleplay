package com.sim.server.game.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.server.game.data.db.mapper.TbUserMapper;
import com.sim.server.game.data.db.pojo.TbUser;
import com.sim.server.game.data.db.pojo.TbUserExample;
import com.sim.server.game.data.service.UserService;


@Service
public class UserServiceImpl implements UserService ,InitializingBean{
	
	@Autowired
	private TbUserMapper tbUserMapper;

	public List<TbUser> listUsers() {
		System.out.println(tbUserMapper);
		TbUserExample example = new TbUserExample();
		List<TbUser> users = tbUserMapper.selectByExample(example);
		return users;
	}

	public int saveUser(TbUser user) {
		int i = tbUserMapper.insert(user);
		return i;
	}

	public TbUser findUserById(int userId) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andIdEqualTo(userId);
		List<TbUser> users = tbUserMapper.selectByExample(example);
		if(null != users && users.size() > 0 ) {
			return users.get(0);
		}
		return null;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("�û�service:" + tbUserMapper);
		
	}

	public int regist(TbUser user) {
		int i = tbUserMapper.insert(user);
		return i;
	}

	public TbUser findUserByUserNameOrEmailAndPassword(String username, String password) {
		TbUserExample example = new TbUserExample();
		TbUserExample.Criteria criteria = example.createCriteria();
		// ͨ���û���/�����ѯ
		criteria.andNameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<TbUser> users = tbUserMapper.selectByExample(example);
		if(users != null && users.size() > 0 ) {
			return users.get(0); 
		}
		return null;
	}

}