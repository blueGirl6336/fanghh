package hitwh.fanghh.service;

import java.io.ByteArrayOutputStream;

import hitwh.fanghh.bean.UserBean;

/**
 * 用户相关服务接口
 *
 * @ClassName: UserService
 * @Description: TODO
 * @author: ZY
 * @date: 2016年11月14日 下午3:59:16
 *
 */
public interface UserService
{
	/**
	 * 用户使用用户名密码登录
	 *
	 * @Title: loginWithUserName
	 * @version:
	 * @author: ZY
	 * 
	 * @param userName
	 * @param password
	 * @param checkCode验证码
	 * @return 0：用户名/密码错误；1：登录成功；2：登录成功，账号多地登陆；3：验证码错误
	 */
	public UserBean loginWithUserName(String userName, String password, String checkCode);

	/**
	 * 用户登出
	 *
	 * @Title: logout
	 * @version:
	 * @author: ZY
	 * 
	 * @return boolean
	 */
	public boolean logout();

	/**
	 * 获取验证码（加减型）
	 *
	 * @Title: getCheckCode
	 * @version:
	 * @author: ZY
	 * 
	 * @param width图片高度
	 * @param height图片宽度
	 * @param stringSize字体大小
	 * @return 图片字节输出流
	 */
	public ByteArrayOutputStream getCheckCode(int width, int height, int stringSize);
}
