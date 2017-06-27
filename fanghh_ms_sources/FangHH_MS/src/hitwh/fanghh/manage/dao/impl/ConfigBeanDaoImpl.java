package hitwh.fanghh.manage.dao.impl;

import hitwh.fanghh.manage.dao.ConfigBeanDao;
import hitwh.fanghh.manage.pojo.ConfigBean;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ConfigBeanDaoImpl extends BaseDaoImpl implements ConfigBeanDao {

	public List<ConfigBean> getAll() {
		String hql = "from ConfigBean";
		return this.getHibernateTemplate().find(hql);
	}

	public ConfigBean getByName(String name) {
		String hql = "from ConfigBean where name = ?";
		List<ConfigBean> cbList = this.getHibernateTemplate().find(hql, name);
		if(cbList.size() > 0)
			return cbList.get(0);
		else
			return null;
	}

}
