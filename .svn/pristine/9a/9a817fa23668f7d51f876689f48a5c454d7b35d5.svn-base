package hitwh.fanghh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hitwh.fanghh.bean.CityAndRegionBean;
import hitwh.fanghh.service.DictionaryService;
import hitwh.fanghh.util.ResponseMapUtil;

@RequestMapping("/dictionary")
@Controller
public class DictionaryController
{
	@Autowired
	private DictionaryService dictionaryService;

	@RequestMapping("/getDictName")
	@ResponseBody
	public Map<String, Object> getDictName(@RequestParam String dictCode)
	{
		String dictName = dictionaryService.getDictName(dictCode);
		if (dictName == null)
		{
			return ResponseMapUtil.responseError(null);
		} else
		{
			return ResponseMapUtil.responseSuccess((Object) dictName);
		}
	}
	/**
	 * 
	 * @return 所有城市以及每个城市对应的区包括名字和Id
	 */
	
	@RequestMapping("/getAllCityAndRegion")
	@ResponseBody
	public Map<String, Object> getAllCityAndRegion()
	{
		List<CityAndRegionBean> cityAndRegionBeanList = dictionaryService.getAllCityAndRegion();
		if (cityAndRegionBeanList.isEmpty())
		{
			return ResponseMapUtil.responseError(null);
		} else
		{
			return ResponseMapUtil.responseSuccess(cityAndRegionBeanList);
		}
	}
}
