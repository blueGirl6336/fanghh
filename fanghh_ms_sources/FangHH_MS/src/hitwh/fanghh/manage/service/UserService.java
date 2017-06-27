package hitwh.fanghh.manage.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.User;

public interface UserService {
	
	public void add(User u);
	
	public void update(User u);
	
	public void delete(User u);
	
	public int checkLogin(User u, String ip);
	
	public int getTotalCount();

	public List<User> getAllUser();
	
	public User getByUsername(String username);
	
	public List<User> getByRealname(String realName);
	
	public int resetPassword(String username,String password);

	//public void updateEmpNo(String oldEmpNo, PersonBaseInfo newPbi);
	
	public void clearLoginFailureMap();
}
