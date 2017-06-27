package hitwh.fanghh.manage.web;


import hitwh.fanghh.manage.pojo.Dictionary;
import hitwh.fanghh.manage.service.DictionaryService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共信息检索Controller
 * 
 */
@Controller
@RequestMapping(value = "/public")
public class PublicSearchController {

	/*@Autowired
	private DepartmentService departmentService;*/

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private ExtResponseJsonService responseService;

	// 获取某个部门下所有的二级部门
	/*@RequestMapping(value = "/getSubUnitByDepartment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getSubUnitByDepartment(
			@RequestParam String department) {
		List<Dictionary> list = this.departmentService
				.getSubUnitByDepartmentCode(department);
		return this.responseService.responseListMap(list);
	}*/

	// 获取所有的二级部门
	/*@RequestMapping(value = "/getAllSubUnitInDictionary", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAllSubUnitInDictionary() {
		List<Dictionary> list = this.departmentService
				.getAllSubUnitInDictionary();
		return this.responseService.responseListMap(list);
	}*/

	/**
	 * 通过学历查询培养方式
	 */
	@RequestMapping(value = "/getTrainTypeByEducation", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTrainTypeByEducation(
			@RequestParam String education) {
		List<Dictionary> list = this.dictionaryService
				.getItemsByGroupCodeAndValue("2009000", education);
		return this.responseService.responseListMap(list);
	}

	// 获取学科信息
	@RequestMapping(value = "/getDiscipline", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getDiscipline(@RequestParam String parentCode) {

//		if (parentCode == null || parentCode.length() == 0) {
//			// parentCode失效，直接获取门类
//			List<Dictionary> list = this.dictionaryService.getAllGroup(3);
//			return responseService.responseListMap(list);
//		}
		List<Dictionary> list = this.dictionaryService
				.getItemsByGroupCode(parentCode);
		return responseService.responseListMap(list);
	}

}
