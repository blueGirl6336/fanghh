package hitwh.fanghh.manage.module.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.ConsultantBuildingRelDao;
import hitwh.fanghh.manage.module.base.service.ConsultantBuildingRelService;
import hitwh.fanghh.manage.pojo.building.ConsultantBuildingRel;
import hitwh.fanghh.manage.pojo.building.HomeConsultant;
@Service
public class ConsultantBuildingRelServiceImpl implements ConsultantBuildingRelService{
	@Autowired
	private ConsultantBuildingRelDao consultantBuildingRelDao;

	@Override
	public void add(ConsultantBuildingRel h) {
		consultantBuildingRelDao.add(h);
	}

	@Override
	public ConsultantBuildingRel getConsultantBuildingRelByhomeConsultant(
			HomeConsultant homeConsultant) {
		return consultantBuildingRelDao.getConsultantBuildingRelByhomeConsultant(homeConsultant);
	}

	@Override
	public void update(ConsultantBuildingRel c) {
		consultantBuildingRelDao.update(c);
	}

}
