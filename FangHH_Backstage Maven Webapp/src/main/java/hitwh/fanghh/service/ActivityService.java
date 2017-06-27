package hitwh.fanghh.service;

import java.util.List;

import hitwh.fanghh.bean.ClearanceActivityBean;
import hitwh.fanghh.bean.GroupPurchaseActivityBean;
import hitwh.fanghh.bean.HouseBean;
import hitwh.fanghh.bean.PerferentialActivityBean;

public interface ActivityService
{
	public String addClearanceActivity(ClearanceActivityBean clearanceActivityBean);

	public ClearanceActivityBean getSingleClearanceActivity(int activityId);

	public String updateClearanceActivity(ClearanceActivityBean clearanceActivityBean);

	public List<ClearanceActivityBean> getAllClearanceActivity(Integer regionId, String keyBuildingName, int pageMaxNum,
			int pageNo);

	public int getClearanceActivityPageNum(Integer cityId, Integer regionId, String keyBuildingName, int pageMaxNum);

	/**
	 * 发布新活动
	 *
	 * @Title: addActivity
	 * @version:
	 * @author: LY
	 * 
	 * @param PerferentialActivityBean
	 * @return true 成功 false 失败
	 */

	public String addPerferentialActivity(PerferentialActivityBean perferentialActivityBean);

	public PerferentialActivityBean getSinglePerferentialActivity(int activityId);

	public List<PerferentialActivityBean> getPerferentialActivityByCity(String cityId, int pageMaxNum, int pageNo);

	public String updatePerferentialActivity(PerferentialActivityBean activityBean);

	/**
	 * 获取活动信息
	 *
	 * @Title: addActivity
	 * @version:
	 * @author: LY
	 * 
	 * @param regionId地区关键字
	 *            keyBuildingName 楼盘名称关键字 pageMaxNum 分页最大书目 pageNo 分页当前页数
	 * @return
	 */

	public List<PerferentialActivityBean> getAllPerferentialActivity(Integer regionId, String keyBuildingName,
			int pageMaxNum, int pageNo);

	public int getPerferentialActivityPageNum(Integer cityId, Integer regionId, String keyBuildingName, int pageMaxNum);

	/**
	 * 活动申请上架
	 *
	 * @Title: applicateActivityOnSale
	 * @version:
	 * @author: LY
	 * 
	 * @param activityId
	 * @return 1 申请成功 0 申请失败
	 */
	public int applicateActivityOnSaleByActivityId(int activityId);

	/**
	 * 活动申请下架
	 *
	 * @Title: applicateActivityOffSale
	 * @version:
	 * @author: LY
	 * 
	 * @param activityId
	 * @return 1 申请成功 0 申请失败
	 */
	public int applicateActivityOffSaleByActivityId(int activityId);

	/**
	 * 活动审核
	 *
	 * @Title: auditActivityApplication
	 * @version:
	 * @author: LY
	 * 
	 * @param activityId
	 *            auditType(1上架通过 2 上架不通过 3下架通过 4
	 *            下家不通过)notPassReason（审核不通过原因，通过传null）
	 * @return
	 */

	public String auditActivityApplicationByActivityId(int activityId, int auditType, String auditNotPassReason);

	public int giveAuditNotPassReason(int activityId, String auditNotPassReason);

	// zy

	/**
	 * 获取团购信息
	 *
	 * @Title: getGroupPurchaseActivityByCityId
	 * @version:
	 * @author: ZY
	 * 
	 * @param cityId城市id
	 * @param regionId区域id
	 * @param keyBuildingName搜索关键字（楼盘名称）
	 * @param pageMaxNum每页最大数量
	 * @param pageNo页号
	 * @return
	 */
	public List<GroupPurchaseActivityBean> getGroupPurchaseActivityByCityId(Integer cityId, Integer regionId,
			String keyBuildingName, int pageMaxNum, int pageNo);

	/**
	 * 获取团购活动页数
	 *
	 * @Title: getGroupPurchaseActivityPageNum
	 * @version:
	 * @author: ZY
	 * 
	 * @param pageMaxNum每页最大数量
	 * @return
	 */
	int getGroupPurchaseActivityPageNum(Integer cityId, Integer regionId, String keyBuildingName, int pageMaxNum);

	/**
	 * 获取单个团购活动信息
	 *
	 * @Title: getSingleGroupPurchaseActivity
	 * @version:
	 * @author: ZY
	 * 
	 * @param activityId活动id
	 * @return
	 */
	public GroupPurchaseActivityBean getSingleGroupPurchaseActivity(int activityId);

	/**
	 * 添加新团购活动
	 *
	 * @Title: addGroupPurchaseActivity
	 * @version:
	 * @author: ZY
	 * 
	 * @param groupPurchaseActivityBean
	 * @return
	 */
	public String addGroupPurchaseActivity(GroupPurchaseActivityBean groupPurchaseActivityBean);

	/**
	 * 更新团购活动
	 *
	 * @Title: updateGroupPurchaseActivity
	 * @version:
	 * @author: ZY
	 * 
	 * @param groupPurchaseActivityBean
	 * @return
	 */
	public String updateGroupPurchaseActivity(GroupPurchaseActivityBean groupPurchaseActivityBean);

	/**
	 * 获取未参加活动房屋
	 *
	 * @Title: getNoActivityHouseByBuildingId
	 * @version:
	 * @author: ZY
	 * 
	 * @param buildingId
	 * @param pageMaxNum
	 * @param pageNo
	 * @return
	 */
	public List<HouseBean> getNoActivityHouseByBuildingId(int buildingId, int pageMaxNum, int pageNo);

	/**
	 * 获取未参加活动房屋页数
	 *
	 * @Title: getNoActivityHousePageNumByBuildingId
	 * @version:
	 * @author: ZY
	 * 
	 * @param buildingId
	 * @param pageMaxNum
	 * @return
	 */
	public int getNoActivityHousePageNumByBuildingId(int buildingId, int pageMaxNum);

}
