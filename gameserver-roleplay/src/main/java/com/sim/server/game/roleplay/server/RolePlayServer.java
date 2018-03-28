package com.sim.server.game.roleplay.server;

import com.sim.server.game.roleplay.init.ResourceDataLoader;
import com.sim.server.game.roleplay.netty.RolePlayServerHandler;
import com.sim.server.game.roleplay.netty.RolePlayServerInitializer;
import com.sim.server.game.utils.LoggerUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class RolePlayServer implements Runnable {
	/**
	 * ����˼����Ķ˿ڵ�ַ
	 */
	private static final int PORT = 7878;
	
	private static final String IP = "127.0.0.1"; 
	
	public void run() {

		LoggerUtil.getLogger(RolePlayServer.class).info("��ʼ����ɫ���ݷ�������ʼ...");
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup);
			b.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(64, 1024, 65536));
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new RolePlayServerInitializer(new RolePlayServerHandler("roleplay")));
			// �������󶨶˿ڼ���
			ChannelFuture f = b.bind(PORT).sync();
			// �����������رռ���
			LoggerUtil.getLogger(RolePlayServer.class).info("��ʼ����ɫ���ݷ���������...");
			f.channel().closeFuture().sync().channel();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
		
	}

}
