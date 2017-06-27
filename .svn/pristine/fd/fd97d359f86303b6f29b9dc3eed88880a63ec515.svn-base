package hitwh.fanghh.manage.module.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.module.base.dao.BrokerDao;
import hitwh.fanghh.manage.module.base.dao.BrokerTeamDao;
import hitwh.fanghh.manage.module.base.service.BrokerTeamService;
import hitwh.fanghh.manage.module.base.util.TeamInvitateCode;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.BrokerTeam;
@Service
public class BrokerTeamServiceImpl implements BrokerTeamService{
	@Autowired
	private BrokerTeamDao brokerTeamDao;
	@Autowired
	private BrokerDao brokerDao;
	@Autowired
	private UserDao userDao;

	@Override
	public boolean createBrokerTeam(Integer brokerId) {
		// 生成邀请码
		// 邀请码是根据手机号生成的，所以需要先得到经纪人的电话号
		// 根据经纪人id得到用户id 根据用户id得到电话号码，涉及到2个表
		Broker broker = brokerDao.getByBrokerId(brokerId);
		User user = userDao.getById(broker.getUser().getId());
		String phoneNo = user.getPhoneNo();
		String invitationCode = TeamInvitateCode.getTeamInvitateCode(phoneNo);
		BrokerTeam bt = new BrokerTeam();
		bt.setBroker(broker);
		bt.setInvitationCode(invitationCode);
		bt.setTeamNum(0); // 新建的，初始团队人数为0，团长不计算在内

		brokerTeamDao.addBrokerTeam(bt);
		boolean resultFlag = brokerTeamDao.checkBrokerTeam(invitationCode);
		if (resultFlag) {//添加成功
			return true;
		}
		return false;
	}

}
