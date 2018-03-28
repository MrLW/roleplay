package com.sim.server.game.utils;

/**
 * @author liwen
 * @date:2018年1月18日 下午6:18:58
 * @Function: 商品工具类
 * @version 1.0
 */
public class CommodityUtil {
	/**
	 *  默认空的仓库类型后缀
	 */
	public static final int DEfault_EMPTY_BEH_TYPE = 1000 ;
	/**
	 * 暂时仓库只有一种类型
	 */
	public static final int WAREHOUSE_PRE_TYPE = 3001 * 10000;
	/**
	 * 默认仓库不存放商品的类型
	 */
	public static final int DEFAULT_WAREHOUSE_PRE_TYPE = 30011000;
	/**
	 *  默认生产桌没使用的类型
	 */
	public static final int DEFAULT_PROTABLE_PRE_TYPE = 20011000;
	/**
	 *  使用中的设备
	 */
	public static final int BUSY_PROTABLE_PRE_TYPE = 20011001;
	/**
	 *  产品A仓库
	 */
	public static final int PRODUCTA_WAREHOUSE_TYPE = 40011000;
	/**
	 *  产品A类型
	 */
	public static final int PRODUCTA_TYPE = 40011000 ;
	/**
	 *  产品B类型
	 */
	public static final int PRODUCTB_TYPE = 40021000 ;
	/**
	 *  产品B仓库
	 */
	public static final int PRODUCTB_WAREHOUSE_TYPE = 40021000;
	public static final int APPLYFOR_MONEY_TYPE = 10000000;
	/**
	 *  获取商品类型
	 * @param type
	 * @return
	 */
	public static int getType(int type) {
		return type / 10000000;
	}

	/**
	 * 根据原料类型获取仓库类型
	 * 
	 * @param materialType
	 *            原料类型
	 * @return 仓库类型
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
	 * 根据原料类型获取产品类型
	 * 
	 * @param materialType
	 *            原料类型
	 * @return 产品类型
	 */
	public static int getProductTypeByMaterialType(int materialType) {
		int pre4 = getPre4(materialType);
		int productType = (pre4 - 1000 + 4000) * 10000 + 1000;
		return productType;
	}

	/**
	 * 根据产品类型获取原料类型
	 * 
	 * @param productType
	 *            产品类型
	 * @return 原料类型
	 */
	public static int getMaterialTypeByProductType(int productType) {
		int pre4 = getPre4(productType);
		int materialType = (pre4 - 4000 + 1000) * 10000 + 1000;
		return materialType;
	}
	

	/**
	 * 获取某个商品类型的前4位
	 * 
	 * @param comodityType
	 *            某个商品的类型
	 * @return 某个商品类型的前4位
	 */
	public static int getPre4(int comodityType) {
		return comodityType / 10000;
	}

	/**
	 * 获取某个商品类型的后4位
	 * 
	 * @param comodityType
	 *            某个商品的类型
	 * @return 某个商品类型的后4位
	 */
	public static int getBeh4(int comodityType) {
		return comodityType - comodityType / 10000 * 10000;
	}

	/**
	 * 判断某个商品是否为仓库
	 * 
	 * @param comodityType
	 *            某个商品的类型
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
	 * 判断某个商品是否为原料
	 * 
	 * @param comodityType
	 *            某个商品的类型
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
	 * 判断某个类型是否是产品仓库
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
	 * 判断某个商品是否为产品
	 * 
	 * @param comodityType
	 *            某个商品的类型
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
	 * 判断某个商品是否为操作桌
	 * 
	 * @param comodityType
	 *            某个商品的类型
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
