package com.lw.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map  = new HashMap<>(); 
		map.put("a", "1");
		// Map可支持一边遍历一边修改
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String value = entry.getValue();
			map.put(entry.getKey(), "2");
		}
		System.out.println(map);
		// 测试Map中,如果value为Object,则每次取出来的都是新的实例吗?
		Map<String, Object> test = new HashMap<>() ;
		
		test.put("1", new TestMap());
		System.out.println("第一次取:" + test.get("1").hashCode());
		System.out.println("第二次取:" + test.get("1").hashCode());
		System.out.println("第三次取:" + test.get("1").hashCode());
		// 测试
		Object object = test.get("2");
		System.out.println(object);
	}
}
