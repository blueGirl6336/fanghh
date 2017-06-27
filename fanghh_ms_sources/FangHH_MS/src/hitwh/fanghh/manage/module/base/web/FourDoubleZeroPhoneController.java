package hitwh.fanghh.manage.module.base.web;
/**
 * @author 赵阳
 */
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.FourDoubleZeroPhoneService;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/fourDoubleZeroPhone")
@SessionAttributes({ "user" })
public class FourDoubleZeroPhoneController {
	
	@Autowired
	private FourDoubleZeroPhoneService fourDoubleZeroPhoneService;
	@Autowired
	private ExtResponseJsonService responseService;

	// 获取所有信息
	@RequestMapping(value = "/getAllPhone", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Broker> list = fourDoubleZeroPhoneService.getAll();
		return responseService.responseListMap(list);
	}
	/**
	 * 绑定400电话
	 * @param brokerId
	 * @param typeId
	 * @param fourZeroPhone  
	 * @return
	 */
	@RequestMapping(value = "/bindFourDoubleZeroPhone",method =RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> bindFourDoubleZeroPhone(@RequestParam Integer typeId,@RequestParam Integer brokerId,@RequestParam String brokerName,
			@RequestParam String brokerIdcard,@RequestParam String phoneNo,@RequestParam String fourZeroPhone){
		Integer flag = 0;
		String fourDoubleZeroPhone = "4006316161,"+fourZeroPhone;
		flag = fourDoubleZeroPhoneService.bindFourDoubleZeroPhone(brokerId, typeId, fourDoubleZeroPhone);
		if(flag == 1){
			return responseService.responseError("400电话已被其他人注册");
		}else if (flag == 2) {
			return responseService.responseSuccess("400电话绑定成功");
		}else if (flag == 3) {
			return responseService.responseSuccess("400电话暂存成功");
		}else if(flag == 4){
			return responseService.responseError("400审核不通过成功");
		}
		return responseService.responseError("操作失败,请检查操作后重试");
	}

}
