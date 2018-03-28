package com.sim.server.game.engine.source.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * 
 * @author liwen	
 *
 */
public class HelloClient {

	public static String HOST = "127.0.0.1";
	public static int PORT = 8080;

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					// ���ó�ʼ��handler
					.handler(new HelloClientInitializer());
			ChannelFuture future = b.connect(HOST, PORT);
			// ���ӷ����
			final SocketChannel ch =(SocketChannel) future.sync().channel();
			
			// ����̨���ֽ��� ����
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			future.addListener(new GenericFutureListener<Future<? super Void>>() {

				public void operationComplete(Future<? super Void> future) throws Exception {
					ch.writeAndFlush("test\n");
				}
			}) ;
			
			for (;;) {
				String line = in.readLine();
				System.out.println("�������������:" + line);
				if (line == null) {
					continue;
				}
				line += "\n";
				InetSocketAddress localAddress = ch.localAddress();
				ch.writeAndFlush(line);
			}
		} finally {
			group.shutdownGracefully();
		}
	}
}
