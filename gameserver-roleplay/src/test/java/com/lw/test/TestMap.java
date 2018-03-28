package com.lw.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map  = new HashMap<>(); 
		map.put("a", "1");
		// Map��֧��һ�߱���һ���޸�
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String value = entry.getValue();
			map.put(entry.getKey(), "2");
		}
		System.out.println(map);
		// ����Map��,���valueΪObject,��ÿ��ȡ�����Ķ����µ�ʵ����?
		Map<String, Object> test = new HashMap<>() ;
		
		test.put("1", new TestMap());
		System.out.println("��һ��ȡ:" + test.get("1").hashCode());
		System.out.println("�ڶ���ȡ:" + test.get("1").hashCode());
		System.out.println("������ȡ:" + test.get("1").hashCode());
		// ����
		Object object = test.get("2");
		System.out.println(object);
	}
}
