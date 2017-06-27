package hitwh.fanghh.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMapUtil
{

	public static Map<String, Object> responseSuccess(Object o)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("data", o);
		return map;
	}

	/**
	 * 添加删除修改失败操作
	 * 
	 * @param msg
	 * @return 返回操作标识和信息
	 */
	public static Map<String, Object> responseError(String message)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		map.put("message", message);
		return map;
	}

	/**
	 * 列表
	 * 
	 * @param list
	 * @return 返回标识、列表数据和条数
	 */
	public static Map<String, Object> responseListMap(List list)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("success", true);
		modelMap.put("data", list);
		if (list == null)
		{
			modelMap.put("count", 0);
		} else
		{
			modelMap.put("count", list.size());
		}
		return modelMap;
	}

	/**
	 * 对象
	 * 
	 * @param object
	 * @return 返回标识、对象数据和条数
	 */
	public static Map<String, Object> responseObjectMap(Object o)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("success", true);
		modelMap.put("data", o);
		modelMap.put("total", 1);
		return modelMap;
	}

	/*
	 * public static Map<String, Object> responseListMap(List list, int
	 * totalCount) { Map<String, Object> modelMap = new HashMap<String,
	 * Object>(4); modelMap.put("total", totalCount); modelMap.put("size",
	 * list.size()); modelMap.put("data", list); modelMap.put("success", true);
	 * return modelMap; }
	 */

}
