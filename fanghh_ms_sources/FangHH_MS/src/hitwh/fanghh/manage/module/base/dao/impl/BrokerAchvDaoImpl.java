package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BrokerAchvDao;
import hitwh.fanghh.manage.module.base.dao.BrokerTeamDao;
import hitwh.fanghh.manage.pojo.building.BrokerAchv;

import org.springframework.stereotype.Repository;

@Repository
public class BrokerAchvDaoImpl extends BaseDaoImpl implements BrokerAchvDao{

	@Override
	public void addBrokerAchv(BrokerAchv brokerAchv) {
		this.getHibernateTemplate().save(brokerAchv);
	}

}
