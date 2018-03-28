package com.sim.server.game.engine.netty;

import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sim.server.game.engine.handler.BaseHandler;
import com.sim.server.game.engine.script.MessageScript;
import com.sim.server.game.message.request.BaseRequest;
import com.sim.server.game.utils.LoggerUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author liwen
 * @date:2017年10月23日 下午6:58:14
 * @Function: 消息处理器
 * @version 1.0
 */
@Sharable
@Service
public abstract class DefaultInboundHandler extends SimpleChannelInboundHandler<ByteBuf> {
	
	private String modelName ;
	
	public DefaultInboundHandler(String modelName) {
		this.modelName = modelName; 
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LoggerUtil.getLogger(DefaultInboundHandler.class).info("channelActive...");
		ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName());
		ctx.flush();
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) throws Exception {
		// 获取当前请求的协议号,以便下面分发
		short protocolId = buf.readShort();
		Channel channel = ctx.channel();
		try {
			Map<Short, Class<? extends BaseRequest>> map = MessageScript.getInstance().get(modelName);
			Class<? extends BaseRequest> clazz = map.get(protocolId);
			Constructor<? extends BaseRequest> constructor = clazz.getConstructor(ByteBuf.class);
			BaseRequest request = constructor.newInstance(buf);
			BaseHandler baseHandler = MessageScript.haldlerMap.get(protocolId);
			baseHandler = (BaseHandler) baseHandler.clone();
			baseHandler.setRequest(request);
			baseHandler.setChannel(channel);
			messageHandler(baseHandler);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("异常协议ID:" + protocolId);
		}
	}
	
	/**
	 *  线程池处理
	 */
	protected abstract void messageHandler(BaseHandler handle);
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		LoggerUtil.getLogger(DefaultInboundHandler.class).info("-----------网络交互发生异常-----------");
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		super.userEventTriggered(ctx, evt);
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			switch (e.state()) {
			case READER_IDLE:
				handleReaderIdle(ctx);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
	}
	
	/**
	 * 处理长时间未读到client的请求
	 */
	private void handleReaderIdle(ChannelHandlerContext ctx) {
		// SocketChannel socket = (SocketChannel) ctx.channel();
		// LoggerUtil.getLogger(NettyHandler.class).info("client,网络可能存在问题,server端强制关闭连接!!!...:"
		// );
		// TbUser user = HallManager.userSocketMap.get(socket);
		// 如果网络延时,将其存在断开连接的表中
		// HallManager.disconnectSocketUsers.put(socket, user) ;
		// ctx.close() ;
	}

}
