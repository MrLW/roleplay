package com.lw.test;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

public class A {

	public static void main(String[] args) {
		// 假设这个是从数据库查询的对象
		Map<String,String> map = new HashMap<String,String>(); 
		// 要存在session中的对象
		Student stu = new Student() ;
		for(Map.Entry<String,String> entry:map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if(stu.name.equals(key)) {
				stu.setAddress(value);
			}
		}
	}
	
}
@Data
class Student{
	// 这里的字段分别对应Map中的Key,字段对应的值对应Map的value
	String name ;
	String address ;
}

