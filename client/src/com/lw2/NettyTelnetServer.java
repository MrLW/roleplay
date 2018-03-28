package com.lw2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyTelnetServer {

	// ָ���˿ں�
	private static final int PORT = 7878;
	private ServerBootstrap serverBootstrap;

	private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
	private EventLoopGroup workerGroup = new NioEventLoopGroup();

	public void open() throws InterruptedException {

		serverBootstrap = new ServerBootstrap();
		// ָ��socket��һЩ����
		serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
		serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // ָ����һ��NIO����ͨ��
				.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new NettyTelnetInitializer());

		// �󶨶�Ӧ�Ķ˿ں�,��������ʼ�����˿��ϵ�����
		Channel ch = serverBootstrap.bind(PORT).sync().channel();

		// �ȴ��ر�,ͬ���˿�
		ch.closeFuture().sync();
	}

	public void close() {
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}

}
