package com.sim.server.game.engine.netty.http;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.CharsetUtil;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	

	private static final String BASE_DIR = System.getProperty("user.dir") +  "/src/main/resources";

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
		// 400
		if (!request.decoderResult().isSuccess()) {
			sendError(ctx, HttpResponseStatus.BAD_REQUEST);
			return;
		}
		// 405
		if (request.method() != GET) {
			sendError(ctx, HttpResponseStatus.METHOD_NOT_ALLOWED);
			return;
		}

		// 404
		String uri = request.uri();
		uri = URLDecoder.decode(uri, "UTF-8");
		uri = uri.replace('/', File.separatorChar);
		File file = new File(BASE_DIR + uri);
		if (!file.exists() || !file.isFile()) {
			sendError(ctx, HttpResponseStatus.NOT_FOUND);
			return;
		}

		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.OK);

		FileChannel channel = new FileInputStream(file).getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (channel.read(buffer) != -1) {
			buffer.flip();
			response.content().writeBytes(buffer);
			buffer.clear();
		}
		channel.close();

		response.headers().set(CONTENT_TYPE, "application/json ; charset=UTF-8");
		long fileLength = response.content().readableBytes();
		HttpUtil.setContentLength(response, fileLength);
		
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		if (ctx.channel().isActive()) {
			sendError(ctx, HttpResponseStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, status,
				Unpooled.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));
		response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

}
