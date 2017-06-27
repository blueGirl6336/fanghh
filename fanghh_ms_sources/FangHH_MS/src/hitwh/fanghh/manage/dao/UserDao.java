package hitwh.fanghh.manage.dao;

import java.util.List;

import hitwh.fanghh.manage.pojo.User;

public interface UserDao {
	
	public void add(User u);
	
	public void update(User u);
	
	public void delete(User u);
	
	public User getById(int id);
	
	public User getByUsername(String username);

	public List<User> getByExample(User u, int offset, int pageSize);
	
	public int getCountByExample(User u);
	
	public List<User> getByRealName(String realName);

	public List<User> getAll();
	
	public User getUserByPhoneNo(String phoneNo);
}
