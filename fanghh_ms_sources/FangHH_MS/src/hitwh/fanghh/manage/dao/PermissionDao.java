package hitwh.fanghh.manage.dao;

import hitwh.fanghh.manage.pojo.Permission;

import java.util.List;

public interface PermissionDao extends BaseDao {
	
	public List<Permission> getByRole(String roleCode);

}
