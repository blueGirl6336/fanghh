/**     
 * @discription {在此输入一句话描述此文件的作用}
 * @author wangxinjie       
 * @created 2016年12月27日 下午4:47:24    
 */

package hitwh.fanghh.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hitwh.fanghh.bean.CommissionBean;
import hitwh.fanghh.service.CommissionRuleService;
import hitwh.fanghh.util.ResponseMapUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: CommissionRule.java Description: 描述
 * 
 * @author wangxinjie
 * @created 2016年12月27日 下午4:47:24
 */
@Controller
@RequestMapping(value = "commission")
public class CommissionRuleController {
	@Autowired
	private CommissionRuleService CommissionRuleService;
	
	@RequestMapping("/getAllCommission")
	@ResponseBody
	public Map<String, Object> getAllCommission(@RequestParam int buildingId,HttpSession session) {
		return ResponseMapUtil.responseListMap(CommissionRuleService
				.getAllCommission(buildingId));
	}
	

	
}
