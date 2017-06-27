package hitwh.fanghh.manage.module.base.dao.impl;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.HomeConsultantAchvDao;
import hitwh.fanghh.manage.pojo.building.HomeConsultantAchv;
@Repository
public class HomeConsultantAchvDaoImpl extends BaseDaoImpl implements HomeConsultantAchvDao{

	@Override
	public void add(HomeConsultantAchv h) {
		this.getHibernateTemplate().save(h);
	}

}
