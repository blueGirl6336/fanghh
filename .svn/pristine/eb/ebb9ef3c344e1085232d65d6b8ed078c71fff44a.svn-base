package hitwh.fanghh.manage.module.base.web;

import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.StoreService;
import hitwh.fanghh.manage.pojo.building.Store;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/storemanage")
@SessionAttributes({ "user" })
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Store> list = storeService.getAll();
		return responseService.responseListMap(list);
	}
	
	//获取门店图片
	@RequestMapping(value = "/getStorePortrait", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStorePortrait(@RequestParam int storeId){
		List<String> list = storeService.getStorePortrait(storeId);
		return responseService.responseListMap(list);
	}
	
	//门店审核
	@RequestMapping(value = "/auditStore", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> auditStore(@RequestParam Integer typeId,@RequestParam String failedReason,
			@RequestParam Integer storeId){
		Integer flag = 0;
		flag = storeService.auditStore(storeId, typeId, failedReason);
		if(flag == 1){
			return responseService.responseSuccess("审核通过成功");
		}else if (flag == 2) {
			return responseService.responseSuccess("审核不通过成功");
		}else {
			return responseService.responseError("操作失败");
		}
	}
	
	/*public static String getStoreInvitateCode(String phoneNo) {
		String originalStr = phoneNo.substring(1);
		char[] strArr = originalStr.toCharArray();
		int n = strArr.length;
		int i = 0, j = n - 1;
		char tmp;
		for (; i < j; i++, j--) {
			if (i % 2 == 0) {
				tmp = strArr[i];
				strArr[i] = strArr[j];
				strArr[j] = tmp;
			}
		}
		String invitateCode = String.valueOf(strArr);
		return "md" + invitateCode;
	}*/
}
