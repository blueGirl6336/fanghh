package hitwh.fanghh.manage.module.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.module.base.dao.BrokerDao;
import hitwh.fanghh.manage.module.base.dao.FourDoubleZeroPhoneDao;
import hitwh.fanghh.manage.module.base.service.FourDoubleZeroPhoneService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.FourDoubleZeroPhone;
@Service
public class FourDoubleZeroPhoneServiceImpl implements FourDoubleZeroPhoneService{
	@Autowired
	private FourDoubleZeroPhoneDao fourDoubleZeroPhoneDao;
	@Autowired
	private BrokerDao brokerDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Broker> getAll() {
		List<FourDoubleZeroPhone> brokerList = fourDoubleZeroPhoneDao.getUnCheckedFourDoublePhone();
		List<Broker> list = new ArrayList<Broker>();
		if(brokerList != null && brokerList.size() > 0){
			for(int i=0;i<brokerList.size();i++){
				User user = userDao.getUserByPhoneNo(brokerList.get(i).getOrginalPhoneNum());
				if(user != null){
					Broker broker = brokerDao.getByUserId(user);
					if(broker != null){
						list.add(broker);
					}
				}
			}
		}
		return list;
	}

	@Override
	public Integer bindFourDoubleZeroPhone(Integer brokerId, Integer typeId,
			String fourPhone) {
		Integer resultInteger = 0;//默认为0
		Broker broker = brokerDao.getByBrokerId(brokerId);
		User user = userDao.getById(broker.getUser().getId());
		if(typeId == 1){//保存400电话
			FourDoubleZeroPhone fourDoubleZeroPhone = new FourDoubleZeroPhone();// 保存400电话
			fourDoubleZeroPhone.setOrginalPhoneNum(user.getPhoneNo());
			fourDoubleZeroPhone.setTargetPhoneNum(fourPhone);
			fourDoubleZeroPhone.setStatus(true);
			FourDoubleZeroPhone fPhone = fourDoubleZeroPhoneDao.havingFourDOuble(fourPhone);
			if(fPhone != null){
				if(!(fPhone.getOrginalPhoneNum().equals(user.getPhoneNo()))){//如果400电话已被其他人注册
					resultInteger = 1;
				}else {//已暂存过，保存成功
					resultInteger = 2;
					fPhone.setStatus(true);
					fourDoubleZeroPhoneDao.update(fPhone);
				}
			}else {//没暂存过，保存成功
				resultInteger = 2;
				FourDoubleZeroPhone fZeroPhone = fourDoubleZeroPhoneDao.getFourDOuble(user.getPhoneNo());
				fZeroPhone.setTargetPhoneNum(fourPhone);
				fZeroPhone.setStatus(true);
				fourDoubleZeroPhoneDao.update(fZeroPhone);
			}
		}else if (typeId == 2) {//暂存400电话
			FourDoubleZeroPhone fPhone = fourDoubleZeroPhoneDao.havingFourDOuble(fourPhone);
			if(fPhone != null){
				if(!(fPhone.getOrginalPhoneNum().equals(user.getPhoneNo()))){//如果400电话已被其他人注册
					resultInteger = 1;					
				}
			}else {
				FourDoubleZeroPhone fZeroPhone = fourDoubleZeroPhoneDao.getFourDOuble(user.getPhoneNo());
				fZeroPhone.setTargetPhoneNum(fourPhone);
				fourDoubleZeroPhoneDao.update(fZeroPhone);
				resultInteger = 3;
			}
		}else {
			FourDoubleZeroPhone fourDoubleZeroPhone = fourDoubleZeroPhoneDao.getFourDOuble(user.getPhoneNo());
			if(fourDoubleZeroPhone != null){
				fourDoubleZeroPhoneDao.delete(fourDoubleZeroPhone);
				resultInteger = 4;
			}
		}
		return resultInteger;
	}

}
