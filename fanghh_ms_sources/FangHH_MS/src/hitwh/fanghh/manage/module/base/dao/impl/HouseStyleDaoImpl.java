package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.HouseDao;
import hitwh.fanghh.manage.module.base.dao.HouseStyleDao;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.HouseStyle;
@Repository
public class HouseStyleDaoImpl extends BaseDaoImpl implements HouseStyleDao{
	@Override
	public void add(HouseStyle h) {
		this.getHibernateTemplate().save(h);
	}

	@Override
	public void update(HouseStyle h) {
		this.getHibernateTemplate().update(h);
	}

	@Override
	public void delete(HouseStyle h) {
		this.getHibernateTemplate().delete(h);
	}

	@Override
	public HouseStyle getById(int id) {
		return this.getHibernateTemplate().get(HouseStyle.class, id);
	}
	@Override
	public List<HouseStyle> getAll() {
		String hql = "from HouseStyle";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<HouseStyle> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
}
