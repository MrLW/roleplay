package com.sim.server.game.roleplay.room;

import com.sim.server.game.data.db.pojo.TbUser;

import io.netty.channel.Channel;
import lombok.Data;
/**
 * @author liwen
 * @date:2018��2��8�� ����4:08:10
 * @Function: ��ǰ��ҿͻ���
 * @version 1.0
 */
@Data	
public class Client {
	
	// ��λnull,˵����ǰ�ͻ����Ѿ����ӵ�������
	private Channel socket;
	// ��Ϊnull˵����ǰ�ͻ����Ѿ���¼�ɹ�
	private TbUser user;

}
