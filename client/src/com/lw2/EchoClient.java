package com.lw2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
	private final String host;
	private final int port;

	public EchoClient() {
		this(0);
	}

	public EchoClient(int port) {
		this("localhost", port);
	}

	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group) // ע���̳߳�
					.channel(NioSocketChannel.class) // ʹ��NioSocketChannel����Ϊ�����õ�channel��
					.remoteAddress(new InetSocketAddress(this.host, this.port)) // �����Ӷ˿ں�host��Ϣ
					.handler(new ChannelInitializer<SocketChannel>() { // �����ӳ�ʼ����
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							System.out.println("connected...");
							ch.pipeline().addLast(new EchoClientHandler());
						}
					});
			System.out.println("created..");

			ChannelFuture cf = b.connect().sync(); // �첽���ӷ�����
			System.out.println("connected..."); // �������

			cf.channel().closeFuture().sync(); // �첽�ȴ��ر�����channel
			System.out.println("closed.."); // �ر����
		} finally {
			group.shutdownGracefully().sync(); // �ͷ��̳߳���Դ
		}
	}

	public static void main(String[] args) throws Exception {
		new EchoClient("127.0.0.1", 7878).start(); // ����127.0.0.1/65535��������
	}
}