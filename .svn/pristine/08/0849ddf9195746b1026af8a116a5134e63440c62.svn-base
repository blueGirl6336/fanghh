package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.HouseStyleDao;
import hitwh.fanghh.manage.module.base.dao.HousingStrategyDao;
import hitwh.fanghh.manage.pojo.building.HouseStyle;
import hitwh.fanghh.manage.pojo.building.HousingStrategy;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class HousingStrategyDaoImpl extends BaseDaoImpl implements HousingStrategyDao{
	@Override
	public void add(HousingStrategy h) {
		this.getHibernateTemplate().save(h);
	}

	@Override
	public void update(HousingStrategy h) {
		this.getHibernateTemplate().update(h);
	}

	@Override
	public void delete(HousingStrategy h) {
		this.getHibernateTemplate().delete(h);
	}

	@Override
	public HousingStrategy getById(int id) {
		return this.getHibernateTemplate().get(HousingStrategy.class, id);
	}
	@Override
	public List<HousingStrategy> getAll() {
		String hql = "from HousingStrategy";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<HousingStrategy> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}

}
