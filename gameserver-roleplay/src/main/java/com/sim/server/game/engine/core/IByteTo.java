package com.sim.server.game.engine.core;

import com.sim.server.game.common.EnhancedByteBuf;

/**
 * @author liwen
 * @date:2018��1��12�� ����6:19:52
 * @Function: ByteBufд����ʱ����Ԫ����Ҫʵ�ֵĽӿ�
 * @version 1.0
 */
public interface IByteTo {
	/**
	 *  д����Ԫ��
	 * @param buf ��д���ݵ�ByteBuf
	 */
	void toData(EnhancedByteBuf buf) ;
}
