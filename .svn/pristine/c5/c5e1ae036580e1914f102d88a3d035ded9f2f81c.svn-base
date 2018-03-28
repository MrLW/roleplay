package com.sim.server.game.data.db.mapper;

import com.sim.server.game.data.db.pojo.TbFriend;
import com.sim.server.game.data.db.pojo.TbFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFriendMapper {
    int countByExample(TbFriendExample example);

    int deleteByExample(TbFriendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFriend record);

    int insertSelective(TbFriend record);

    List<TbFriend> selectByExample(TbFriendExample example);

    TbFriend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFriend record, @Param("example") TbFriendExample example);

    int updateByExample(@Param("record") TbFriend record, @Param("example") TbFriendExample example);

    int updateByPrimaryKeySelective(TbFriend record);

    int updateByPrimaryKey(TbFriend record);
    
	void insertFriend(@Param("userId1")int userId1, @Param("userId2")int userId2);
    
    List<TbFriend> selectFriends(int userId);
	/** 
	 * 判断是否是好友关系
	 * @param friendId
	 * @param userId
	 * @return
	 */
	TbFriend isFriend(@Param("friendId")int friendId, @Param("userId")int userId);
}