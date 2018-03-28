package com.sim.server.game.roleplay.init;

import java.util.Random;
/**
 * @author liwen
 * @date:2017年11月30日 下午2:04:56
 * @Function:
 * @version 1.0
 */
public abstract class BaseLoader implements IDataLoader {
	
	protected static Random random = new Random();
	
	public abstract boolean initData() ;
	
}
