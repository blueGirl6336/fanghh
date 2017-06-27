package hitwh.fanghh.manage.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DecryptUtil {

	public static String getEncryptUtil(String initString){
		String	afterDecrypt = null;
		try {
			afterDecrypt =Base64Util.encryptBASE64(initString.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return afterDecrypt;
	}
	
	public static String gb2312ToUtf8(String str) {

        String urlEncode = "" ;

        try {

            urlEncode = URLEncoder.encode (str, "UTF-8" );

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return urlEncode;

}

}
