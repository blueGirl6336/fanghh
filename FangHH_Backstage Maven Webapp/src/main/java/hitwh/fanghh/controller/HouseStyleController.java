package hitwh.fanghh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hitwh.fanghh.annotation.RequiredPermission;
import hitwh.fanghh.bean.HouseStyleBean;
import hitwh.fanghh.service.HouseStyleService;
import hitwh.fanghh.util.ResponseMapUtil;

@Controller
@RequestMapping("/houseStyle")
public class HouseStyleController
{
	@Autowired
	private HouseStyleService houseStyleService;

	/**
	 * 获取楼盘所有户型信息
	 *
	 * @Title: getAllHouseStyle
	 * @version:
	 * @author: ZY
	 * 
	 * @param buildingId楼盘id
	 * @param pageMaxNum每页最大数量
	 * @param pageNo页号
	 * @return
	 */
	@RequestMapping("/getAllHouseStyle")
	@ResponseBody
	public Map<String, Object> getAllHouseStyle(@RequestParam int buildingId, @RequestParam int pageMaxNum,
			@RequestParam int pageNo)
	{
		List<HouseStyleBean> houseStyleBeanList = houseStyleService.getStyleByBuildingId(buildingId, pageMaxNum,
				pageNo);
		return ResponseMapUtil.responseSuccess(houseStyleBeanList);
	}

	/**
	 * 获取单个户型信息
	 *
	 * @Title: getSingleHouseStyle
	 * @version:
	 * @author: ZY
	 * 
	 * @param styleId户型id
	 * @return
	 */
	@RequestMapping("/getSingleHouseStyle")
	@ResponseBody
	public Map<String, Object> getSingleHouseStyle(@RequestParam int styleId)
	{
		HouseStyleBean houseStyleBean = houseStyleService.getStyleByStyleId(styleId);
		return ResponseMapUtil.responseSuccess(houseStyleBean);
	}

	/**
	 * 获取楼盘户型页面页数
	 *
	 * @Title: getHouseStylePageNum
	 * @version:
	 * @author: ZY
	 * 
	 * @param buildingId楼盘id
	 * @param pageMaxNum单页最大数量
	 * @return
	 */
	@RequestMapping("/getHouseStylePageNum")
	@ResponseBody
	public Map<String, Object> getHouseStylePageNum(@RequestParam int buildingId, @RequestParam int pageMaxNum)
	{
		int num = houseStyleService.getHouseStylePageNumByBuildingId(buildingId, pageMaxNum);
		return ResponseMapUtil.responseSuccess(num);
	}

	/**
	 * 户型图上传
	 *
	 * @Title: uploadStylePic
	 * @version:
	 * @author: ZY
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/uploadStylePic")
	@ResponseBody
	public Map<String, Object> uploadStylePic(MultipartFile file)
	{
		String res = houseStyleService.uploadStylePic(file);
		if (res != null)
		{
			return ResponseMapUtil.responseSuccess(res);
		} else
		{
			return ResponseMapUtil.responseError(null);
		}
	}

	/**
	 * 户型特色图上传
	 *
	 * @Title: uploadSpecialitiesPic
	 * @version:
	 * @author: ZY
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/uploadSpecialitiesPic")
	@ResponseBody
	public Map<String, Object> uploadSpecialitiesPic(MultipartFile file)
	{
		String res = houseStyleService.uploadSpecialitiesPic(file);
		if (res != null)
		{
			return ResponseMapUtil.responseSuccess(res);
		} else
		{
			return ResponseMapUtil.responseError(null);
		}
	}

	/**
	 * 添加新户型
	 *
	 * @Title: addStyle
	 * @version:
	 * @author: ZY
	 * 
	 * @param houseStyleBean/json
	 * @return
	 */
	@RequestMapping("/addStyle")
	@ResponseBody
	public Map<String, Object> addStyle(@RequestBody HouseStyleBean houseStyleBean)
	{
		String res = houseStyleService.addStyle(houseStyleBean);
		if (res.equals("success"))
		{
			return ResponseMapUtil.responseSuccess(null);
		} else
		{
			return ResponseMapUtil.responseError(res);
		}
	}

	/**
	 * 修改户型
	 *
	 * @Title: updateStyle
	 * @version:
	 * @author: ZY
	 * 
	 * @param houseStyleBean/json
	 * @return
	 */
	@RequestMapping("/updateStyle")
	@ResponseBody
	public Map<String, Object> updateStyle(@RequestBody HouseStyleBean houseStyleBean)
	{
		String res = houseStyleService.updateStyle(houseStyleBean);
		if (res.equals("success"))
		{
			return ResponseMapUtil.responseSuccess(null);
		} else
		{
			return ResponseMapUtil.responseError(res);
		}
	}

	/**
	 * 户型申请上下架
	 *
	 * @Title: houseStyleApplication
	 * @version:
	 * @author: ZY
	 * 
	 * @param styleId户型id
	 * @param status上下架
	 * @return
	 */
	@RequestMapping("/houseStyleApplication")
	@ResponseBody
	public Map<String, Object> houseStyleApplication(int styleId, boolean status)
	{
		String res = houseStyleService.updateHouseStyleApplicationStatus(styleId, status);
		if (res.equals("success"))
		{
			return ResponseMapUtil.responseSuccess(null);
		} else
		{
			return ResponseMapUtil.responseError(res);
		}
	}

	/**
	 * 审核
	 *
	 * @Title: houseStyleAudit
	 * @version:
	 * @author: ZY
	 * 
	 * @param styleId户型id
	 * @param status是否通过
	 * @param auditNotPassReason未通过理由
	 * @return
	 */
	@RequiredPermission
	@RequestMapping("/houseStyleAudit")
	@ResponseBody
	public Map<String, Object> houseStyleAudit(int styleId, boolean status, String auditNotPassReason)
	{
		String res = houseStyleService.updateHouseStyleAuditStatus(styleId, status, auditNotPassReason);
		if (res.equals("success"))
		{
			return ResponseMapUtil.responseSuccess(null);
		} else
		{
			return ResponseMapUtil.responseError(res);
		}
	}
}