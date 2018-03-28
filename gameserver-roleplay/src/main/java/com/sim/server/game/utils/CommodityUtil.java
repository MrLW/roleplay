package com.sim.server.game.utils;

/**
 * @author liwen
 * @date:2018��1��18�� ����6:18:58
 * @Function: ��Ʒ������
 * @version 1.0
 */
public class CommodityUtil {
	/**
	 *  Ĭ�ϿյĲֿ����ͺ�׺
	 */
	public static final int DEfault_EMPTY_BEH_TYPE = 1000 ;
	/**
	 * ��ʱ�ֿ�ֻ��һ������
	 */
	public static final int WAREHOUSE_PRE_TYPE = 3001 * 10000;
	/**
	 * Ĭ�ϲֿⲻ�����Ʒ������
	 */
	public static final int DEFAULT_WAREHOUSE_PRE_TYPE = 30011000;
	/**
	 *  Ĭ��������ûʹ�õ�����
	 */
	public static final int DEFAULT_PROTABLE_PRE_TYPE = 20011000;
	/**
	 *  ʹ���е��豸
	 */
	public static final int BUSY_PROTABLE_PRE_TYPE = 20011001;
	/**
	 *  ��ƷA�ֿ�
	 */
	public static final int PRODUCTA_WAREHOUSE_TYPE = 40011000;
	/**
	 *  ��ƷA����
	 */
	public static final int PRODUCTA_TYPE = 40011000 ;
	/**
	 *  ��ƷB����
	 */
	public static final int PRODUCTB_TYPE = 40021000 ;
	/**
	 *  ��ƷB�ֿ�
	 */
	public static final int PRODUCTB_WAREHOUSE_TYPE = 40021000;
	public static final int APPLYFOR_MONEY_TYPE = 10000000;
	/**
	 *  ��ȡ��Ʒ����
	 * @param type
	 * @return
	 */
	public static int getType(int type) {
		return type / 10000000;
	}

	/**
	 * ����ԭ�����ͻ�ȡ�ֿ�����
	 * 
	 * @param materialType
	 *            ԭ������
	 * @return �ֿ�����
	 */
	public static int getWarehouseTypeByMaterialType(int materialType) {
		int warehouseType = 3001 * 10000 + getPre4(materialType);
		return warehouseType;
	}
	
	public static int getWarehouseTypeByProductType(int productType) {
		int warehouseType = 3001 * 10000 + getPre4(productType);
		return warehouseType;
	}

	/**
	 * ����ԭ�����ͻ�ȡ��Ʒ����
	 * 
	 * @param materialType
	 *            ԭ������
	 * @return ��Ʒ����
	 */
	public static int getProductTypeByMaterialType(int materialType) {
		int pre4 = getPre4(materialType);
		int productType = (pre4 - 1000 + 4000) * 10000 + 1000;
		return productType;
	}

	/**
	 * ���ݲ�Ʒ���ͻ�ȡԭ������
	 * 
	 * @param productType
	 *            ��Ʒ����
	 * @return ԭ������
	 */
	public static int getMaterialTypeByProductType(int productType) {
		int pre4 = getPre4(productType);
		int materialType = (pre4 - 4000 + 1000) * 10000 + 1000;
		return materialType;
	}
	

	/**
	 * ��ȡĳ����Ʒ���͵�ǰ4λ
	 * 
	 * @param comodityType
	 *            ĳ����Ʒ������
	 * @return ĳ����Ʒ���͵�ǰ4λ
	 */
	public static int getPre4(int comodityType) {
		return comodityType / 10000;
	}

	/**
	 * ��ȡĳ����Ʒ���͵ĺ�4λ
	 * 
	 * @param comodityType
	 *            ĳ����Ʒ������
	 * @return ĳ����Ʒ���͵ĺ�4λ
	 */
	public static int getBeh4(int comodityType) {
		return comodityType - comodityType / 10000 * 10000;
	}

	/**
	 * �ж�ĳ����Ʒ�Ƿ�Ϊ�ֿ�
	 * 
	 * @param comodityType
	 *            ĳ����Ʒ������
	 */
	public static boolean isWarehouse(int comodityType) {
		int pre4 = getPre4(comodityType);
		if (pre4 >= 3001 && pre4 <= 3999) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж�ĳ����Ʒ�Ƿ�Ϊԭ��
	 * 
	 * @param comodityType
	 *            ĳ����Ʒ������
	 */
	public static boolean isMaterial(int comodityType) {
		int pre4 = getPre4(comodityType);
		if (pre4 >= 1001 && pre4 <= 1999) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * �ж�ĳ�������Ƿ��ǲ�Ʒ�ֿ�
	 */
	public static boolean isProductWarehouse(int comodityType) {
		int beh4 = getBeh4(comodityType);
		if (beh4 >= 4001 && beh4 <= 4999) {
			return true;
		} else {
			return false;
		}
	}
	public static int getProductTypeByWarehouseType(int comodityType) {
		int beh4 = getBeh4(comodityType);
		return beh4 * 10000+1000 ;
	}
	
	

	/**
	 * �ж�ĳ����Ʒ�Ƿ�Ϊ��Ʒ
	 * 
	 * @param comodityType
	 *            ĳ����Ʒ������
	 */
	public static boolean isProduct(int comodityType) {
		int pre4 = getPre4(comodityType);
		if (pre4 >= 4001 && pre4 <= 4999) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж�ĳ����Ʒ�Ƿ�Ϊ������
	 * 
	 * @param comodityType
	 *            ĳ����Ʒ������
	 */
	public static boolean isProTable(int comodityType) {
		int pre4 = getPre4(comodityType);
		if (pre4 >= 2001 && pre4 <= 2999) {
			return true;
		} else {
			return false;
		}
	}
	
}