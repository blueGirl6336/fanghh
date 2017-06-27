package hitwh.fanghh.manage.web;

import hitwh.fanghh.manage.pojo.Dictionary;
import hitwh.fanghh.manage.service.DictionaryService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据字典Controller 接收数据字典方面的操作请求
 * 
 * @author Jiang Shuqi
 * @Date 2013-8-7
 */
@Controller
@RequestMapping(value = "manage/dictionary")
public class DictonaryController {

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private ExtResponseJsonService responseService;

	// 获取某个模块下所有的字典组
	@RequestMapping(value = "/getAllGroup", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllModule(@RequestParam String moduleCode) {
		List<Dictionary> dicList = this.dictionaryService
				.getAllGroup(moduleCode);
		return this.responseService.responseListMap(dicList);
	}

	// 获取某个数据字典组下面的所有字典项
	@RequestMapping(value = "/getItemsByGroupCode", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getItemsByGroupCode(
			@RequestParam String groupCode) {
		List<Dictionary> dicList = this.dictionaryService
				.getItemsByGroupCode(groupCode);
		return this.responseService.responseListMap(dicList);
	}

	// 获取某个模块下所有字典项
	@RequestMapping(value = "/getItemsByModule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getItemsByModule(@RequestParam String moduleCode) {
		List<Dictionary> dicList = this.dictionaryService
				.getItemsByModule(moduleCode);
		return this.responseService.responseListMap(dicList);
	}

	// 添加新的字典项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addDictionary(@RequestBody Dictionary d) {
		// 检验是否输入字典项名称
		if (d.getDictName() == null || d.getDictName().length() == 0)
			return this.responseService.responseError("添加失败，字典项名称为空！");

		// 如果为控制，则设置为null
		if (d.getDictParentCode() != null && d.getDictParentCode().length() == 0)
			d.setDictParentCode(null);
		this.dictionaryService.add(d);
		return this.responseService.responseSuccess("添加成功");
	}

	// 更新字典项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateDictionary(@RequestBody Dictionary d) {
		this.dictionaryService.update(d);
		return this.responseService.responseSuccess("更新成功");
	}

	// 删除字典组
	@RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteDictionaryGroup(
			@RequestParam String groupCode) {
		Dictionary d = this.dictionaryService.getByCode(groupCode);
		List<Dictionary> dList = this.dictionaryService
				.getItemsByGroupCode(groupCode);
		dList.add(d);
		while (dList.size() > 0) {
			this.dictionaryService.delete(dList.get(0));
			dList.remove(0);
		}
		return this.responseService.responseSuccess("刪除成功");
	}

	// 删除字典项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteDictionary(@RequestBody Dictionary d) {
		this.dictionaryService.delete(d);
		return this.responseService.responseSuccess("刪除成功");
	}

	// 获取所有学科的简化结构
	@RequestMapping(value = "/getAllDictionaryLikeModule", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAllDictionaryLikeModule(@RequestParam String moduleCode) {
		List<Dictionary> dicList = this.dictionaryService
				.getAllDictionaryLikeModule(moduleCode);
		return this.responseService.responseListMap(dicList);
	}
}
