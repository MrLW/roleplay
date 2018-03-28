package com.lw.demo1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lw.utils.ByteObjConverter;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

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
					// 设置初始化handler
					.handler(new HelloClientInitializer());
			ChannelFuture future = b.connect(HOST, PORT);
			// 连接服务端
			Channel ch =future.sync().channel();

			// 控制台以字节流 输入
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			for (;;) {
				String line = in.readLine();
				System.out.println("你输入的数据是:" + line);
				if (line == null) {
					continue;
				}

				line += "\n";

				ch.writeAndFlush(line);
			}
		} finally {
			group.shutdownGracefully();
		}
	}
}
