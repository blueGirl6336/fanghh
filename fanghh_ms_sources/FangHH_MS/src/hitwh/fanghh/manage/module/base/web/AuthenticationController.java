package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.AuthenticationService;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/realNameAuthentication")
@SessionAttributes({ "user" })
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll(){
		List<Broker> list = authenticationService.getAll();
		return responseService.responseListMap(list);
	}
	
	//根据经纪人ID查找身份证照片
	@RequestMapping(value = "/getIdCardPic", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getIdCardPic(@RequestParam int brokerId){
		List<String> list = authenticationService.getIdCardPic(brokerId);
		return responseService.responseListMap(list);
	}
	
	/**
	 * 实名认证
	 * @param brokerId -- 经纪人ID
	 * @param typeId -- 1为验证成功，2为验证失败
	 * @param result -- 验证成功时发送 400 电话，失败时发送失败理由
	 * @return
	 */
	@RequestMapping(value = "/authenticatePass", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> authenticatePass(@RequestParam Integer brokerId,@RequestParam Integer typeId,
			@RequestParam String result){
		Integer flag = 0;
		//String fourDoubleZeroPhone = "4006316161,"+fourZeroPhone;
		if(typeId==1 || typeId==3){
			flag = authenticationService.authenticate(brokerId, typeId, "");			
		}
		if(typeId==2) {
			flag = authenticationService.authenticate(brokerId, typeId, result);			
		}
		if (flag == 1) {
			return responseService.responseSuccess("审核通过成功");
		} else if (flag == 2) {
			return responseService.responseError("400电话已被其他人注册");
		} else if (flag == 3) {
			return responseService.responseSuccess("审核不通过成功");
		} else if (flag == 4) {
			return responseService.responseError("已存在经纪人团队");
		} else if (flag == 5) {
			return responseService.responseSuccess("暂存成功");
		} else if (flag == 6) {
			return responseService.responseSuccess("更新400电话成功");
		}
		return responseService.responseError("操作失败");
	}
	
	//根据手机号码查询
	@RequestMapping(value = "/getByPhoneNo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getByPhoneNo(@RequestParam String phoneNo){
		Broker broker = authenticationService.getByPhoneNo(phoneNo) ;
		return responseService.responseObjectMap(broker);
	}
	
	//根据手机号获取400电话
	@RequestMapping(value = "/getFourDoublephone", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFourDoublephone(@RequestParam String phoneNo){
		String result = authenticationService.getFourDoublephone(phoneNo);
		List<String> list = new ArrayList<String>();
		if(!("error".equals(result)) && !("".equals(result)) ){
			list.add(result);
		}else if ("".equals(result)) {
			list.add(result);
		}else {
			result = "";
			list.add(result);
		}
		return responseService.responseListMap(list);
	}
	
}
