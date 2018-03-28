package com.lw.test;

public class TestClone implements Cloneable {

	public static void main(String[] args) throws Exception {
		TestClone obj = new TestClone();
		TestClone ectype = obj.clone();
		System.out.println("obj:" + obj.hashCode());
		System.out.println("ectype:" + ectype.hashCode());
	}

	@Override
	protected TestClone clone() throws CloneNotSupportedException {
		TestClone ectype = (TestClone) super.clone();
		return ectype;
	}
}
