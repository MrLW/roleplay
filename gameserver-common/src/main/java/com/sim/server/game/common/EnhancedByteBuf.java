package com.sim.server.game.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.sim.server.game.utils.BeanUtil;

import io.netty.buffer.ByteBuf;

/**
 * @author liwen
 * @date:2017��11��22�� ����6:55:48
 * @Function: ��չByteBuf
 * @version 1.0
 */
public class EnhancedByteBuf {

	/**
	 * �м�,ByteBuf����д�ɾ�̬,����ᵼ�¶���ͻ��˶�ȡ����ʱ���ִ�һ��ByteBuffy��ȡ����!!!!!!
	 */
	private ByteBuf buf;

	public static EnhancedByteBuf enhancedByteBuf = new EnhancedByteBuf();

	public static EnhancedByteBuf getInstance() {
		if (enhancedByteBuf == null)
			enhancedByteBuf = new EnhancedByteBuf();
		return enhancedByteBuf;
	}

	public EnhancedByteBuf() {
		super();
	}

	public EnhancedByteBuf(ByteBuf buf) {
		this.buf = buf;
	}

	public int readerIndex() {
		return this.buf.readerIndex();
	}

	/**
	 * ��ȡ�ַ���
	 * 
	 * @param in
	 * @return
	 */
	public String readString() {
		short len = this.buf.readShort();
		byte[] b = new byte[len];
		buf.readBytes(b);
		return new String(b);
	}

	public short readShort() {
		short len = buf.readShort();
		return len;
	}

	public boolean isWritable() {
		return buf.isWritable();
	}

	public boolean isReadable() {
		return buf.isReadable();
	}

	public int readInt() {
		return buf.readInt();
	}

	public void writeByte(byte b) {
		buf.writeByte(b);
	}

	public void writeInt(Integer value) {
		buf.writeInt(value);
	}

	public void writeString(String value) {
		try {
			if (value != null && value.length() > 0) {
				buf.writeShort(value.getBytes("utf-8").length);
				buf.writeBytes(value.getBytes("utf-8"));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ByteBuf getBuf() {
		return buf;
	}

	public void setBuf(ByteBuf buf) {
		this.buf = buf;
	}

	public void writeShort(Short value) {
		buf.writeShort(value);
	}

	public void writeLong(long lValue) {
		buf.writeLong(lValue);
	}

	/**
	 * д�뼯��
	 * 
	 * @param objs
	 */
	public void writeList(List objs) {
		//if(objs.size() > 0 )
			// 1����д���ϵĳ���
			this.writeInt(objs.size());
		// 2��дlist�о�������
		try {
			for (int i = 0; i < objs.size(); i++) {
				Object obj = objs.get(i);
				// ������������
				if (!BeanUtil.isBaseDataType(obj.getClass())) {
					writeObj(obj);
				} else {
					// ������������
					writeBaseObj(obj);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeObj(Object obj) {
		try {
			Class clazz = obj.getClass();
			Field[] fields = clazz.getFields();
			for (Field field : fields) {
				String type = field.getType().getName();
				String name = field.getName();
				name = BeanUtil.getGetName(name);
				Method method = clazz.getMethod(name);
				Object o = method.invoke(obj);
				if (BeanUtil.isShort(type)) {
					short sValue = (Short) o;
					this.writeShort(sValue);
				} else if (BeanUtil.isByte(type)) {
					byte bValue = (Byte) o;
					this.writeByte((byte) bValue);
				} else if (BeanUtil.isInt(type)) {
					Integer iValue = (Integer) o;
					this.writeInt(iValue);
				} else if (BeanUtil.isString(type)) {
					String sValue = (String) o;
					this.writeString(sValue);
				} else if (BeanUtil.isLong(type)) {
					long lValue = (Long) o;
					this.writeLong(lValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * д�������������
	 * 
	 * @param obj
	 */
	public void writeBaseObj(Object obj) {
		Class clazz = obj.getClass();
		if (clazz.equals(String.class) || clazz.isPrimitive()) {
			String sValue = (String) obj;
			this.writeString(sValue);
		} else if (clazz.equals(Integer.class) || clazz.isPrimitive()) {
			Integer iValue = (Integer) obj;
			buf.writeInt(iValue);
		} else if (clazz.equals(Short.class) || clazz.isPrimitive()) {
			Short sValue = (Short) obj;
			buf.writeShort(sValue);
		} else if (clazz.equals(Byte.class) || clazz.isPrimitive()) {
			Byte bValue = (Byte) obj;
			buf.writeByte(bValue);
		} else if (clazz.equals(Float.class) || clazz.isPrimitive()) {
			Float fValue = (Float) obj;
			buf.writeFloat(fValue);
		} else if (clazz.equals(Double.class) || clazz.isPrimitive()) {
			Double dValue = (Double) obj;
			buf.writeDouble(dValue);
		} else if (clazz.equals(Character.class) || clazz.isPrimitive()) {
			Character cValue = (Character) obj;
			buf.writeChar(cValue);
		} else if (clazz.equals(Long.class) || clazz.isPrimitive()) {
			Long lValue = (Long) obj;
			buf.writeLong(lValue);
		} else if (clazz.equals(Boolean.class) || clazz.isPrimitive()) {
			Boolean bValue = (Boolean) obj;
			buf.writeBoolean(bValue);
		}
	}

	public void clear() {
		buf.clear();
	}

	public byte readByte() {
		return buf.readByte();
	}

	public void markWriterIndex() {
		buf.markWriterIndex();
	}

	public void writeIndex(Integer value) {
		buf.writerIndex(value);
	}

	public void skipBytes(int length) {
		buf.skipBytes(length);
	}
}