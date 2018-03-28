package com.sim.server.game.roleplay.room;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import com.sim.server.game.common.State;
import com.sim.server.game.message.response.room.InitLandlordResponse;
import com.sim.server.game.model.model.PlayerInfo;
import com.sim.server.game.roleplay.config.RoomConfig;
import com.sim.server.game.roleplay.manager.RoomManager;
import com.sim.server.game.roleplay.player.Session;
import com.sim.server.game.utils.LoggerUtil;

import io.netty.channel.Channel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017��11��20�� ����11:07:11
 * @Function: ��ҷ���,�ڱ���Ϸ�൱�ڹ�˾
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Room {

	// �����
	private String roomId;
	// ����״̬ 1:�����ڴ���ʱ��,�����������;2:����������,�ڽ��뿪ʼ��Ϸ֮ǰ;3:������������Ϸ
	public static final int ROOM_STATE_INIT = 1 ;
	public static final int ROMM_STATE_FINISH = 2; 
	public static final int ROOM_STATE_PLAY = 3 ;
	private byte state =ROOM_STATE_INIT ;
	// �����Ƿ���ӳɹ�
	private boolean complete;
	
	// �����Ϣ
	private BlockingQueue<PlayerInfo> playerInfos = new LinkedBlockingQueue<PlayerInfo>();
	
	// �ͻ�������
	private List<Session> sessions = new CopyOnWriteArrayList<>();
	
	private static byte[] cs = new byte[] {
		0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x0A,0x0B,0x0C,0x0D,0x0E,// ����A~����K,����
		0x11,0x12,0x13,0x14,0x15,0x16,0x17,0x18,0x19,0x1A,0x1B,0x1C,0x1D,0x1E,// �t��A~�t��K,С��
		0x21,0x22,0x23,0x24,0x25,0x26,0x27,0x28,0x29,0x2A,0x2B,0x2C,0x2D,// ÷��A~÷��K
		0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x39,0x3A,0x3B,0x3C,0x3D,// ��ƬA~��ƬK
	} ;
	// 54����
	private static List<Byte> cards = new LinkedList<>() ;
	// ��Ҵ������
	private static List<Byte> garbage = new LinkedList<>() ;
	// �Ƿ���
	private volatile boolean license = false ;
	// �������Ƿ����
	private volatile boolean rob = false ;
	// ��ǰ����������ڼ��ϵ�λ��
	private int robIndex = 0 ;
	// ��ǰ�������
	private Session landlord ;
	// ��������
	private static final int UNDER_CARD_COUNT = 3 ;
	// ϴ�ƴ���
	private static final int SHUFFLE_COUNT = 5 ;
	
	
	/**
	 * �����һ�δ���ʱ����
	 */
	public void onCreate() {
		LoggerUtil.getLogger(Room.class).info("��ʼ��������Ϣ��ʼ");
		System.out.println("��ǰ�������:" + this.hashCode() + ";��������ƶ���: " + cards.hashCode());
		cards.clear();
		for(byte c:cs) {
			cards.add(c);
		}
		// ϴ��
		for(int i = 0 ; i < SHUFFLE_COUNT ;i++) {
			Collections.shuffle(cards);
		}
		LoggerUtil.getLogger(Room.class).info("��ʼ����������Ϣ����");
	}
	
	


	/**
	 * �жϷ����Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return getPlayerInfos().isEmpty();
	}
	/**
	 * �����Ƿ��� ��
	 * @return
	 */
	public boolean isAllSelected() {
		return sessions.size() == RoomConfig.ROOM_PLAYER_COUNT ? true : false;
	}

	public boolean isComplete() {
		complete = getPlayerInfos().size() == RoomConfig.ROOM_PLAYER_COUNT ? true : false;
		return complete;
	}

	/**
	 * ��������ʱ����
	 */
	public void onDestroy() {
		LoggerUtil.getLogger(Room.class).info("��������...");
		RoomManager.newRoomsList.remove(this);
	}

	public void join(PlayerInfo playerInfo) {
		this.playerInfos.add(playerInfo);
		if (playerInfos.size() >= RoomConfig.ROOM_PLAYER_COUNT) {
			state = ROMM_STATE_FINISH;
		}
	}
	/**
	 *  ��������һ�����
	 * @param session ���session
	 */
	public void addSession(Session session) {
		sessions.add(session);
	}



	/**
	 *  Ϊÿ����ҷ���
	 */
	public synchronized void license() {
		if( !license ) {
			LinkedList<Byte> ll = (LinkedList<Byte>) cards ;
			Iterator<Session> sessionIterator = sessions.iterator();
			Session session = null ;
			int count = cs.length - UNDER_CARD_COUNT;
			for(int i = 1 ; i <= count ; i++ ) {
				byte c = ll.poll();
				if(i % 17 == 1) {
					session = sessionIterator.next();
				}
				session.getCards().add(c);
			}
		}
		license = true ;
		System.out.println("����Ϊ:"+ cards );
	}
	
	/**
	 *  �������ӻ�ȡ�Ƽ���
	 * @param channel ����
	 * @return �Ƽ���
	 */
	public List<Byte> getCardsByChannel(Channel channel){
		List<Byte> cards = null; 
		for (Session session : sessions) {
			Channel c = session.getChannel();
			if(channel == c) {
				cards = session.getCards() ;
			}
		}
		return cards ;
	}
	
	private Random random = new Random() ;
	
	/**
	 *  ѡ��һ������
	 */
	public void shffuleLandlord() {
		if(sessions!=null && sessions.size()>0) {
			landlord = sessions.get(0);
		}
		robIndex++ ;
		initLandlord(landlord.getChannel());
	}
	
	/**
	 *  ��ʼ��������Ӧ
	 */
	private void initLandlord(Channel channel) {
		InitLandlordResponse response = new InitLandlordResponse(landlord.getChannel());
//		response.writeAndFlush();
	}



	/**
	 *  ������
	 * @param channel
	 * @param result
	 */
	public void glabLandlor(Channel channel, byte result) {
		for(int i = 1 ; i <= sessions.size() ; i++ ) {
			Session session = sessions.get(i-1);
			if(session.getChannel() == channel) {
				if(result == State.SUCCESS) {
					session.setLandlord(true);
					robIndex = i ;
					rob = true ;
					landlord = session ;
				}else {
					session.setLandlord(false);
					robIndex++;
					if(robIndex == 3) {
						session.setLandlord(true);
						rob = true ;
					}
				}
			}
		}
		if(rob) {
			// ��ʼ������Ϸ
			System.out.println("������ѡ��,Ϊ:" + sessions.get(robIndex) + ";���Կ�ʼ������Ϸ");
		} else {
			// ֪ͨ��һ������Ƿ�������
			Session session = sessions.get(robIndex-1);
			initLandlord(session.getChannel());
		}
	}

	
}