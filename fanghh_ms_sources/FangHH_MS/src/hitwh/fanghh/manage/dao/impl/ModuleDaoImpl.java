package hitwh.fanghh.manage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.ModuleDao;
import hitwh.fanghh.manage.pojo.Module;

@Repository
public class ModuleDaoImpl extends BaseDaoImpl implements ModuleDao {

	public void add(Module m) {
		this.getHibernateTemplate().save(m);
	}

	public void update(Module m) {
		this.getHibernateTemplate().update(m);
	}

	public void delete(Module m) {
		this.getHibernateTemplate().delete(m);
	}

	public List<Module> getAll() {
		String hql = "from Module";
		return this.getHibernateTemplate().find(hql);
	}

	public List<Module> getByRole(String role, int minLevel, int maxLevel) {
		String hql = "select m from Module m, Permission p where p.roleCode=? and m.level>="
				+ minLevel
				+ " and m.level<="
				+ maxLevel
				+ " and p.moduleCode = m.code order by m.no asc,m.code asc";
		return this.getHibernateTemplate().find(hql, role);
	}

	public List<Module> getByLevel(int minLevel, int maxLevel) {
		String hql = "from Module where level>=? and level <=?";
		return this.getHibernateTemplate().find(hql,
				new Object[] { minLevel, maxLevel });
	}

}
