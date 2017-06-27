package hitwh.fanghh.manage.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** * BASE64加密解密 */
public class Base64Util {
	/** * BASE64解密 * @param key * @return * @throws Exception */
	public static byte[] decryptBASE64(String key) throws Exception {
		String  decrypt = key.replace("!", "+");
		String  decrypt1 = decrypt.replace("-", "/");
		return (new BASE64Decoder()).decodeBuffer(decrypt1);
		
	}
	/** * BASE64加密 * @param key * @return * @throws Exception */
	public static String encryptBASE64(byte[] key) throws Exception {
		String encrypt = new BASE64Encoder().encodeBuffer(key);
		String encrypt1 = encrypt.replace("+","!");
		String encrypt2 = encrypt1.replace("/","-");
		return encrypt2;
	}
}