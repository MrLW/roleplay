package com.sim.server.game.roleplay.player;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import io.netty.channel.Channel;
import lombok.Data;

/**
 * @author liwen
 * @date:2017��12��5�� ����5:09:41
 * @Function: �û�session
 * @version 1.0
 */
@Data
public class Session {
	
	// ���sessionID,�򵥵����ʹ��userId
	private int sessionId;
	// ��Ҷ�Ӧ��socket����
	private Channel channel;
	// ������ڵķ����,��δ���뷿��ʱΪ""
	private String roomId ;
	// ��ҳ��е���
	private List<Byte> cards ; 
	// �Ƿ��ǵ���
	private boolean landlord; 
}