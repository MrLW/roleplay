package com.lw.test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<String> queue = new ConcurrentLinkedQueue<>(); 
		queue.add("a");
		queue.add("b");
		queue.add("c");
		for (String string : queue) {
			if(string.equals("a")) {
				queue.remove(string);
			}
		}
		System.out.println(queue);
	}
}
