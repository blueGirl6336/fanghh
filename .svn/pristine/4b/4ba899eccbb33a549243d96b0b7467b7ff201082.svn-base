package hitwh.fanghh.manage.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;

public class StringUtils {

	/**
	 * 带编码的trim函数
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String trim(String str) throws UnsupportedEncodingException {
		return str == null ? "" : URLDecoder.decode(str, "UTF-8").trim();
	}

	/**
	 * MD5加密函数 可以对密码进行加密
	 * 
	 * @param password
	 * @return
	 */
	public static String encrypt_MD5(String password) {
		try {
			byte[] btInput = password.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean isBlank(String s) {
		return org.apache.commons.lang.StringUtils.isBlank(s);
	}

	// 比较2个字符串的大小，先把字符串转换为数字，然后再比较大小,前者比后者大返回1，小返回-1，相等返回0
	public static int compare(String str1, String str2) {
		int val1;
		int val2;
		val1 = Integer.parseInt(str1);
		val2 = Integer.parseInt(str2);
		if (val1 > val2)
			return 1;
		else if (val1 == val2)
			return 0;
		else
			return -1;
	}

	public static void main(String[] args) {
		// System.out.println(StringUtils.encrypt_MD5("hrms1234"));
		// System.out.println(StringUtils.encrypt_MD5("mz1234"));
		System.out.println(StringUtils.encrypt_MD5("t7111111"));
		System.out.println(StringUtils.encrypt_MD5("t8111111"));
	}
}
