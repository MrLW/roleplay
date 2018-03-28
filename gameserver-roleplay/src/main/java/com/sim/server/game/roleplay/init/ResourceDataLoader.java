package com.sim.server.game.roleplay.init;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwen
 * @date:2017��12��21�� ����10:53:04
 * @Function: �ֿ⡢ԭ���ϡ��豸�ĳ�ʼ��,�൱�����ݿ�
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
		// ��ʼ����Ʒ���ͱ�
		try {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
}
