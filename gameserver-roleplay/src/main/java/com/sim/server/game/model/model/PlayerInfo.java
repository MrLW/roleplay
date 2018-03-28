package com.sim.server.game.model.model;

import lombok.Data;

/**
 * @author liwen
 * 2017年11月6日 下午12:13:15
 * Function: 玩家的信息
 * @version 1.0
 */
@Data
public class PlayerInfo {
	
	private int userId ;
	private int roleType = -1; 
}
