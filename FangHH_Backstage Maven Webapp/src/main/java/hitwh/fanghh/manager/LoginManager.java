package hitwh.fanghh.manager;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hitwh.fanghh.util.Md5Util;

@Component
public class LoginManager
{
	@Autowired
	private HttpSession session;
	// 已登录的用户放在这个map里面
	private Map<String, String> loginMap = new ConcurrentHashMap<String, String>();

	/**
	 * 用户登录注册
	 *
	 * @Title: userRegister
	 * @version:
	 * @author: ZY
	 * 
	 * @param id
	 *            唯一的用户id，为保证兼容使用String
	 * @return 0：注册失败，1：注册成功，2：相同用户在不同端登录
	 */
	public int userRegister(String id)
	{
		StringBuffer stringBuffer = new StringBuffer("token");
		stringBuffer.append(id);
		stringBuffer.append(String.valueOf(System.currentTimeMillis()));
		String token = null;
		try
		{
			token = Md5Util.encrypt(stringBuffer.toString());
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return 0;
		}
		if (!checkRegister())
		{
			session.setAttribute("token", token);
			session.setAttribute("userId", id);
			loginMap.put(id, token);
			return 1;
		} else
		{
			session.setAttribute("token", token);
			session.setAttribute("userId", id);
			loginMap.put(id, token);
			return 2;
		}
	}

	/**
	 * 检查用户是否登录
	 *
	 * @Title: checkRegister
	 * @version:
	 * @author: ZY
	 * 
	 * @return boolean
	 */
	public boolean checkRegister()
	{
		boolean res = false;
		Object id = session.getAttribute("userId");
		Object token = session.getAttribute("token");
		if ((token != null) && (id != null))
		{
			res = token.toString().equals(loginMap.get(id));
		}
		// System.out.println(loginMap.values());
		return res;
	}

	/**
	 * 用户登出
	 *
	 * @Title: userUnRegister
	 * @version:
	 * @author: ZY
	 * 
	 * @return boolean
	 */
	public boolean userUnRegister()
	{
		Object token = session.getAttribute("token");
		Object id = session.getAttribute("userId");
		boolean res = false;
		if ((token != null) && (id != null))
		{
			res = loginMap.remove(id) != null ? true : false;
			session.invalidate();
		}

		return res;
	}
}
