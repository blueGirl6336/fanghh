/**
 * 
 */
package hitwh.fanghh.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.bean.UserBean;
import hitwh.fanghh.dao.UsersDao;
import hitwh.fanghh.manager.LoginManager;
import hitwh.fanghh.pojo.Users;
import hitwh.fanghh.service.UserService;
import hitwh.fanghh.util.RandomUtil;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private LoginManager loginManager;

	@Autowired
	private HttpSession session;

	@Autowired
	private UsersDao usersDao;

	@Override
	public UserBean loginWithUserName(String userName, String password, String checkCode)
	{
		UserBean userBean = new UserBean();
		int res = 0;
		userBean.setLoginResult(res);

		Object tmpCheckCode = session.getAttribute("checkCode");
		session.removeAttribute("checkCode");
		if (checkCode == null || !checkCode.equals(tmpCheckCode))
		{
			userBean.setLoginResult(3);// 验证码错误
			return userBean;
		}

		Users users = usersDao.selectByUserName(userName);
		if (users != null && password != null)
		{
			if (password.equals(users.getPassword()))
			{
				res = loginManager.userRegister(users.getUserId().toString());
				session.setAttribute("role", users.getRole());
				session.setAttribute("cityId", 1);

				userBean.setPortrait(users.getPortrait());
				userBean.setUserId(users.getUserId());
				userBean.setUserName(users.getUserName());
				userBean.setLoginResult(res);
				userBean.setRole(users.getRole());
				userBean.setCityId(1);//默认威海市（测试使用）
			}
		}

		return userBean;
	}

	@Override
	public boolean logout()
	{
		return loginManager.userUnRegister();
	}

	@Override
	public ByteArrayOutputStream getCheckCode(int width, int height, int stringSize)
	{
		if (width <= 0 || height <= 0 || stringSize <= 0)
		{
			width = 100;
			height = 40;
			stringSize = 20;
		}

		BufferedImage image = RandomUtil.getRandomCheckCodeImage(width, height, 10, stringSize, session);
		ByteArrayOutputStream byteArrayOutputStream = null;
		try
		{
			byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "png", byteArrayOutputStream);
			byteArrayOutputStream.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return byteArrayOutputStream;
	}

}
