package com.lw.test;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

public class A {

	public static void main(String[] args) {
		// ��������Ǵ����ݿ��ѯ�Ķ���
		Map<String,String> map = new HashMap<String,String>(); 
		// Ҫ����session�еĶ���
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
	// ������ֶηֱ��ӦMap�е�Key,�ֶζ�Ӧ��ֵ��ӦMap��value
	String name ;
	String address ;
}

