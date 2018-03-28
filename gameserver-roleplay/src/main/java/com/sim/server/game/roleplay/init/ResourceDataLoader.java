package com.sim.server.game.roleplay.init;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017年12月21日 上午10:53:04
 * @Function: 仓库、原材料、设备的初始化,相当于数据库
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceDataLoader extends BaseLoader {

	private static ResourceDataLoader loader = new ResourceDataLoader();
	private static final String dataPath = System.getProperty("user.dir") + "/src/main/resources/data/setting.json";

	private ResourceDataLoader() {
	}

	public static ResourceDataLoader getInstance() {
		return loader;
	}

	@Override
	public boolean initData() {
		// 初始化商品类型表
		try {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
}
