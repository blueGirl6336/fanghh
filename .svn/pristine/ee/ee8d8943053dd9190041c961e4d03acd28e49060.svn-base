package hitwh.fanghh.manage.service.impl;

import java.util.List;

import hitwh.fanghh.manage.dao.PermissionDao;
import hitwh.fanghh.manage.pojo.Permission;
import hitwh.fanghh.manage.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	public void add(Permission p) {
		this.permissionDao.add(p);
	}

	public void update(Permission p) {
		this.permissionDao.update(p);
	}

	public void delete(Permission p) {
		this.permissionDao.delete(p);
	}

	public List<Permission> getByRole(String roleCode) {
		return this.permissionDao.getByRole(roleCode);
	}

}
