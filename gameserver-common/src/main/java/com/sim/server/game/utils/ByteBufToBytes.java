package com.sim.server.game.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
 *  
 * @author liwen
 * 2017��10��25��  ����11:35:01   
 * Function: ByteBuf���ֽ�ת��.
 * @version 1.0
 */
public class ByteBufToBytes {

	private ByteBuf temp;

	private boolean end = true;

	public ByteBufToBytes() {
	}

	public ByteBufToBytes(int length) {
		temp = Unpooled.buffer(length);
	}

	public void reading(ByteBuf datas) {
		datas.readBytes(temp, datas.readableBytes());
		if (this.temp.writableBytes() != 0) {
			end = false;
		} else {
			end = true;
		}
	}

	public boolean isEnd() {
		return end;
	}

	public byte[] readFull() {
		if (end) {
			byte[] contentByte = new byte[this.temp.readableBytes()];
			this.temp.readBytes(contentByte);
			this.temp.release();
			return contentByte;
		} else {
			return null;
		}
	}

	public byte[] read(ByteBuf datas) {
		byte[] bytes = new byte[datas.readableBytes()];
		datas.readBytes(bytes);
		return bytes;
	}
}