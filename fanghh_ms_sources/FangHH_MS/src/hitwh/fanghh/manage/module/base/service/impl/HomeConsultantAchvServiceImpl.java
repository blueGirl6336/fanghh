package hitwh.fanghh.manage.module.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.HomeConsultantAchvDao;
import hitwh.fanghh.manage.module.base.service.HomeConsultantAchvService;
import hitwh.fanghh.manage.pojo.building.HomeConsultantAchv;
@Service
public class HomeConsultantAchvServiceImpl implements HomeConsultantAchvService{
	@Autowired
	private HomeConsultantAchvDao hAchvDao;

	@Override
	public void add(HomeConsultantAchv h) {
		this.hAchvDao.add(h);
	}

}
