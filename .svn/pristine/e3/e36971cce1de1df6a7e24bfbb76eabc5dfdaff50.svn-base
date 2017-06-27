/**
 * 
 */
package hitwh.fanghh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yxy
 *
 */
public class Md5Util
{
	public static String encrypt(String original) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest)
		{
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
}
