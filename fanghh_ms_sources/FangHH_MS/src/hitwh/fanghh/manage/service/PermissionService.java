package hitwh.fanghh.manage.service;

import hitwh.fanghh.manage.pojo.Permission;

import java.util.List;

public interface PermissionService {
	
	public void add(Permission p);
	
	public void update(Permission p);
	
	public void delete(Permission p);
	
	public List<Permission> getByRole(String roleCode);
	
	

}
