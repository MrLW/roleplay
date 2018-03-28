package com.lw.demo1.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * 
 * @author liwen
 *
 */
public class HelloServer {

	/**
	 * ����˼����Ķ˿ڵ�ַ
	 */
	private static final int PORT = 8080;

	public static void main(String[] args) throws InterruptedException {

		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new HelloServerInitializer());

			// �������󶨶˿ڼ���
			ChannelFuture f = b.bind(PORT).sync();
			// �����������رռ���
			f.channel().closeFuture().sync();
			// ���Լ�дΪ
			/* b.bind(portNumber).sync().channel().closeFuture().sync(); */
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
