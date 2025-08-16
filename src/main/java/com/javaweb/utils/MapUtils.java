package com.javaweb.utils;

import java.util.Map;

public class MapUtils {
//	public static <T> T getObject(Map<String,Object> maps, String key, Class<T> tClass) {
//		Object obj = maps.getOrDefault(key, null);
//		if(obj != null) {
//			if(tClass.getTypeName().equals("java.lang.Long")) {
//				obj = obj != "" ? Long.valueOf(obj.toString()) : null;
//			}
//			else if(tClass.getTypeName().equals("java.lang.Integer")) {
//				obj = obj != "" ? Integer.valueOf(obj.toString()) : null;
//			}
//			else if(tClass.getTypeName().equals("java.lang.String")) {
//				obj = obj.toString();
//			}
//			return tClass.cast(obj);
//		}
//		return null;
//	}

//	public static <T> T getObject(Object item, Class<T> tClass) {
//		if(item != null) {
//			if(tClass.getTypeName().equals("java.lang.Long")) {
//				item = item != "" ? Long.valueOf(item.toString()) : null;
//			}
//			else if(tClass.getTypeName().equals("java.lang.Integer")) {
//				item = item != "" ? Integer.valueOf(item.toString()) : null;
//			}
//			else if(tClass.getTypeName().equals("java.lang.String")) {
//				item = item.toString();
//			}
//			return tClass.cast(item);
//		}
//		return null;
//	}
	public static <T> T getObject(Map<String, Object> buildingsParams, String key, Class<T> tClass) {
		Object obj = buildingsParams.getOrDefault(key, null);

		if (obj != null) {
			String str = obj.toString().trim();
			if (str.isEmpty()) return null;

			try {
				if (tClass == Long.class) {
					obj = Long.valueOf(str);
				} else if (tClass == Float.class) {
					obj = Float.valueOf(str);
				} else if (tClass == Integer.class) {
					obj = Integer.valueOf(str);
				} else if (tClass == Double.class) {
					obj = Double.valueOf(str);
				} else if (tClass == Boolean.class) {
					obj = Boolean.valueOf(str);
				} else if (tClass == String.class) {
					obj = str;
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Giá trị không hợp lệ cho kiểu " + tClass.getSimpleName() + ": " + str);
			}

			return tClass.cast(obj);
		}

		return null;
	}
}
