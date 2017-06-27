package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.Broker;

import java.util.List;

public interface FourDoubleZeroPhoneService {
	public List<Broker> getAll();
	
	public Integer bindFourDoubleZeroPhone(Integer brokerId,Integer typeId,String fourPhone);

}
