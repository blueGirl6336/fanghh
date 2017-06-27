package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.BrokerTeam;

public interface BrokerTeamDao {
	
	public boolean checkBrokerTeam(String invitationCode);
	
	public void addBrokerTeam(BrokerTeam brokerTeam);

}
