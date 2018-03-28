package com.lw.demo2.handler;

import com.lw.demo2.bean.Person;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * 
 * @author liwen
 *
 */
public class ClientInitHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Person person = new Person();
		person.setName("ÀîÎÄ");
		person.setSex("ÄÐ");
		person.setAge(22);
		ctx.write(person);
		ctx.flush();
	}
	
}

