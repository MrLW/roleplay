package com.sim.server.game.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import io.netty.buffer.ByteBuf;

public class ByteBufUtil {

	public static void readString(ByteBuf in, Object obj  ,String name)
			throws Exception {
		short len = in.readShort() ;
		byte[] bodys = new byte[len];
		in.readBytes(bodys);
		Method method = obj.getClass().getMethod("set"+name,String.class);
		method.invoke(obj, new String(bodys));
	}
	
	public static void readFloat(ByteBuf in, Object obj, String name)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		float readFloat = in.readFloat();
		Method method = obj.getClass().getMethod("set"+name,Float.class);
		method.invoke(obj, readFloat);
	}
	
	public static void readLong(ByteBuf in, Object obj, String name)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		long readLong = in.readLong();
		Method method = obj.getClass().getMethod("set"+name,Long.class);
		method.invoke(obj, readLong);
	}
	
	public static void readByte(ByteBuf in, Object obj, String name)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		byte readByte = in.readByte();
		Method method = obj.getClass().getMethod("set"+name,Byte.class);
		method.invoke(obj, readByte );
	}

	public static void readInt(ByteBuf in, Object obj, String name)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		int readInt = in.readInt();
		Method method = obj.getClass().getMethod("set"+name,Integer.class);
		method.invoke(obj, readInt);
	}
	
	public static void readInt(Object obj, String name, int readInt)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = obj.getClass().getMethod("set"+name,Integer.class);
		method.invoke(obj, readInt);
	}
	
	public static void readInt(int totalLen, Object obj, String name)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		 Method method = obj.getClass().getMethod("set"+name,Integer.class);
		 method.invoke(obj, totalLen);
	}
	
	public static void readShort(short protocolId,  Object obj, String name)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		 Method method = obj.getClass().getMethod("set"+name, Short.class);
		 method.invoke(obj, protocolId);
	}
	
	
	
	public static void writeShort(ByteBuf out, Object sub)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method;
		method = out.getClass().getMethod("writeShort", int.class); 
		method.invoke(out, sub) ;
	}
	
	public static void writeByte(ByteBuf out,  Object sub)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method;
		method = out.getClass().getMethod("writeByte", int.class);
		method.invoke(out, sub) ;
	}
	
	public static void writeString(ByteBuf out, String str)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method;
		method = out.getClass().getMethod("writeBytes", byte[].class) ;
		 // ×Ö·û´®ÌØÊâ´¦Àí
		 out.writeShort(str.length()) ;
		 method.invoke(out, str.getBytes()) ;
	}
	
	public static void writeInt(ByteBuf out,  Object o)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method;
		method = out.getClass().getMethod("writeInt", int.class);
		 method.invoke(out, o);
	}

	
	
}
