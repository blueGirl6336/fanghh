package hitwh.fanghh.manage.dao.impl;

import hitwh.fanghh.manage.dao.PermissionDao;
import hitwh.fanghh.manage.pojo.Permission;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PermissionDaoImpl extends BaseDaoImpl implements PermissionDao {

	public List<Permission> getByRole(String roleCode) {
		String hql = "from Permission where roleCode = ?";
		return this.getHibernateTemplate().find(hql, roleCode);
	}
}
