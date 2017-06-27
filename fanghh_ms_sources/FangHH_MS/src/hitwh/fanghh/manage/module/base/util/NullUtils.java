package hitwh.fanghh.manage.module.base.util;

import java.lang.reflect.Field;


/**
 * 该类实现将类中的字符串null值全部变为""
 * @author Michael Miao
 *
 */
public class NullUtils {
	/**
	 * 把对象p中所有String类型的变量值为null的变为""
	 * @param p 对象名
	 */
	public static <T> void clearNulls(T p){
		if(p==null)return;
		Class<? extends Object> c=p.getClass();
		Field[] fs;
		try {
			fs=c.getDeclaredFields();
			for(Field f:fs){
				//System.out.println(f.getType().getName());
				if(!f.getType().getName().equals("java.lang.String"))
					continue;
				f.setAccessible(true);
				Object n=f.get(p);
				if(n==null)
					f.set(p, "");
				n=f.get(p);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
