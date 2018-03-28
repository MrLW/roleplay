package com.sim.server.game.engine.core;

import com.sim.server.game.common.EnhancedByteBuf;

/**
 * @author liwen
 * @date:2018年1月12日 下午6:19:52
 * @Function: ByteBuf写集合时集合元素需要实现的接口
 * @version 1.0
 */
public interface IByteTo {
	/**
	 *  写集合元素
	 * @param buf 读写数据的ByteBuf
	 */
	void toData(EnhancedByteBuf buf) ;
}
