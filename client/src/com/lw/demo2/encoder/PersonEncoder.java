package com.lw.demo2.encoder;

import com.lw.demo2.bean.Person;
import com.lw.utils.ByteObjConverter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
/**
 * 
 * @author liwen
 *
 */
public class PersonEncoder extends  MessageToByteEncoder<Person> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {
		byte[] datas = ByteObjConverter.objectToByte(msg);  
        out.writeBytes(datas);  
        ctx.flush();  
	}

}
