package com.lw2;

import org.junit.Test;

public class NettyTest {

	@Test
	public void test() {
		NettyTelnetServer nettyTelnetServer = new NettyTelnetServer();
		try {
			nettyTelnetServer.open();
		} catch (InterruptedException e) {
			nettyTelnetServer.close();
		}
	}

}
