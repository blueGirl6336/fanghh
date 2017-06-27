/**     
 * @discription {在此输入一句话描述此文件的作用}
 * @author wangxinjie       
 * @created 2016年12月27日 下午4:55:45    
 */

package hitwh.fanghh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.bean.CommissionBean;
import hitwh.fanghh.dao.CommissionruleDao;
import hitwh.fanghh.dao.CommissionruleinfoDao;
import hitwh.fanghh.pojo.Commissionrule;
import hitwh.fanghh.pojo.Commissionruleinfo;
import hitwh.fanghh.service.CommissionRuleService;

/**
 * Title: CommissionRuleServiceImpl.java Description: 描述
 * 
 * @author wangxinjie
 * @created 2016年12月27日 下午4:55:45
 */
@Service
public class CommissionRuleServiceImpl implements CommissionRuleService {
	@Autowired
	private CommissionruleDao commissionRuleDao;
	@Autowired
	private CommissionruleinfoDao CommissionruleinfoDao;

	/**
	 * @discription {在此输入一句话描述作用}
	 * @author wangxinjie
	 * @created 2016年12月27日 下午5:11:15
	 * @param buildingId
	 * @return
	 * @see hitwh.fanghh.service.CommissionRuleService#getAllCommission(int)
	 */

	@Override
	public List<CommissionBean> getAllCommission(int buildingId) {
		List<CommissionBean> list = new ArrayList<CommissionBean>();
		List<Commissionrule> ruleList = commissionRuleDao.selectByBuildingId(buildingId);
		for(Commissionrule c:ruleList){
			List<Commissionruleinfo> infoList = CommissionruleinfoDao.selectByRuleId(c.getRuleId());
			for(Commissionruleinfo ci:infoList){
				CommissionBean commissionBean = new CommissionBean(ci,c);
				list.add(commissionBean);
			}	
		}
		return list;
	}

}
