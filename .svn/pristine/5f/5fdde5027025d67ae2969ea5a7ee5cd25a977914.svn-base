package hitwh.fanghh.manage.service.impl;

import hitwh.fanghh.manage.constant.PersonInfoConstant;
import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.pojo.Dictionary;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.service.DictionaryService;
import hitwh.fanghh.manage.service.UserService;
import hitwh.fanghh.manage.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DictionaryService dictionaryService;

	// 在线用户列表，防止用户重复登录
	private Map<String, Integer> usernameLoginFailure = new ConcurrentHashMap<String, Integer>();

	// 在线用户列表，防止用户重复登录
	private Map<String, Integer> ipLoginFailure = new ConcurrentHashMap<String, Integer>();

	private void addFailure(String username, String ip) {
		if (!StringUtils.isBlank(username)) {
			if (usernameLoginFailure.containsKey(username)) {
				int t = usernameLoginFailure.get(username);
				usernameLoginFailure.remove(username);
				usernameLoginFailure.put(username, t + 1);
			} else {
				usernameLoginFailure.put(username, 1);
			}
		}
		if (!StringUtils.isBlank(ip)) {
			if (ipLoginFailure.containsKey(ip)) {
				int t = ipLoginFailure.get(ip);
				ipLoginFailure.remove(ip);
				ipLoginFailure.put(ip, t + 1);
			} else {
				ipLoginFailure.put(ip, 1);
			}
		}
	}

	/**
	 * 检查账号和ip是否已经达到错误次数
	 * @param username
	 * @param ip
	 * @return
	 */
	private int checkLoginFailure(String username, String ip) {
		if (usernameLoginFailure.containsKey(username)) {
			int t = usernameLoginFailure.get(username);
			if (t > PersonInfoConstant.LOGIN_FAILURE_USERNAME_RESTRICTION) {
				return -4;
			}
		}
		if (ipLoginFailure.containsKey(ip)) {
			int t = ipLoginFailure.get(ip);
			if (t > PersonInfoConstant.LOGIN_FAILURE_IP_RESTRICTION) {
				return -5;
			}
		}
		return 1;
	}

	
	@Override
	public void clearLoginFailureMap() {
		this.usernameLoginFailure.clear();
		this.ipLoginFailure.clear();
	}

	public void add(User u) {

		String username = u.getUsername();
		String password = (u.getPassword() == null || u.getPassword().length() == 0) ? "123456" : u.getPassword();
		//u.setStartTime(DateTime.getToday());
		u.setPassword(StringUtils.encrypt_MD5(username + password));

		Dictionary d = dictionaryService.getByCode(u.getRole());
		if (d != null)
			//u.setRoleName(d.getName());

		userDao.add(u);
	}

	public void update(User u) {
		Dictionary d = dictionaryService.getByCode(u.getRole());
		if (d != null)
			//u.setRoleName(d.getName());
		userDao.update(u);
	}

	public void delete(User u) {
		userDao.delete(u);
	}

	/**
	 * 登录验证
	 * 
	 * @return 1: 登录成功
	 * @return -1: 无此用户
	 * @return -2: 密码错误
	 * @return -3: 用户停用
	 * @return -4: 账号失败次数到达上限
	 * @return -5: ip失败次数到达上限
	 * 
	 */
	public int checkLogin(User u, String ip) {
		String username = u.getUsername();
		int result = this.checkLoginFailure(username, ip) ;
		if(result < 0){
			return result;
		}
		User dataUser = userDao.getByUsername(u.getUsername());
		if (dataUser == null) {
			return -1;
		}

		//String passwordMD5 = StringUtils.encrypt_MD5(u.getUsername() + u.getPassword());
		String passwordMD5=u.getPassword();
		if (!passwordMD5.equals(dataUser.getPassword())){
			//密码错误添加到记录中
			this.addFailure(username, ip);
			return -2;
		}
		/*if (dataUser.getStatus() == 0)
			// 已经停用
			return -3;
*/
		return 1;
	}

	/**
	 * 查询所有的用户
	 */
	public List<User> getAllUser() {
		return this.userDao.getAll();
	}

	/**
	 * 查询所有的用户数量
	 */
	public int getTotalCount() {
		User example = new User();
		return this.userDao.getCountByExample(example);
	}

	/**
	 * 通过用户名查找
	 */
	public User getByUsername(String username) {
		return this.userDao.getByUsername(username);
	}

	public List<User> getByRealname(String realName) {
		return this.userDao.getByRealName(realName);

	}

	/**
	 * 重置用户密码
	 * 
	 * @return 1: 修改成功
	 * @return -1: 无此用户
	 */
	@Override
	public int resetPassword(String username, String password) {
		User u = getByUsername(username);
		if (u == null)
			return -1;
		String pwd = username + password;
		u.setPassword(StringUtils.encrypt_MD5(pwd));
		update(u);
		return 1;
	}

	/*@Override
	public void updateEmpNo(String oldEmpNo, PersonBaseInfo newPbi) {
		User one = this.getByUsername(oldEmpNo);
		if (one != null)
			this.delete(one);
		else
			return;
		//one.setEmpNo(newPbi.getEmpNo());
		one.setUsername(newPbi.getEmpNo());
		// 重置密码
		String idCard = newPbi.getIdCard();
		if (idCard != null && idCard.length() >= 6) {
			//one.setIdNumber(idCard);
			String pwd = one.getUsername() + idCard.substring(idCard.length() - 6);
			one.setPassword(StringUtils.encrypt_MD5(pwd));
		} else {
			String pwd = one.getUsername() + "123456";
			one.setPassword(StringUtils.encrypt_MD5(pwd));
		}
		this.userDao.add(one);
	}*/

}
