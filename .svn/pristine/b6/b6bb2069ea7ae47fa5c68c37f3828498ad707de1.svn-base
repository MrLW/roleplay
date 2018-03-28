package com.lw.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liwen
 * @date:2018年1月12日 下午5:57:44
 * @Function: 测试封装
 * @version 1.0
 */
public class TestFZ {

	public static void main(String[] args) {
		List<ToObj> objs = new ArrayList<ToObj>();
		List<Integer> ss = new ArrayList<Integer>() ;
		for (int i = 0; i < 10; i++) {
			ToObj obj = new ToObj();
			obj.setAge(i);
			obj.setName("name-" + i);
			objs.add(obj);
			ss.add(i);
		}

		TestFZ testFZ = new TestFZ();

//		testFZ.writeArray(objs);
		testFZ.writeArray(ss);
	}
	
	public <T> void writeArray(List<T> list) {
		for (T t : list) {
			Class<? extends Object> clazz = t.getClass();
			String typeName = clazz.getTypeName();
			
			System.out.println("集合类型:" + typeName);
			
//			IByteTo byteFrom = (IByteTo) t;
//			byteFrom.toData();
		}
	}
	
	
}

class FromObj implements IByteFrom {
	public int age;
	public String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fromData() {
		
	}
}

class ToObj implements IByteTo {
	
	public int age;
	public String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void toData() {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}
}

interface IByteFrom {
	void fromData();
}

interface IByteTo {
	void toData() ;
}
