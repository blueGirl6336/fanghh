package hitwh.fanghh.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.bean.ClearanceActivityBean;
import hitwh.fanghh.bean.GroupPurchaseActivityBean;
import hitwh.fanghh.bean.HouseBean;
import hitwh.fanghh.bean.PerferentialActivityBean;
import hitwh.fanghh.bean.PerferentialRuleBean;
import hitwh.fanghh.dao.ActivityDao;
import hitwh.fanghh.dao.BuildingDao;
import hitwh.fanghh.dao.ClearancehouselistDao;
import hitwh.fanghh.dao.GrouppurchasehouselistDao;
import hitwh.fanghh.dao.GrouppurchaseinfoDao;
import hitwh.fanghh.dao.HouseDao;
import hitwh.fanghh.dao.HouserealpicDao;
import hitwh.fanghh.dao.PerferentialhouselistDao;
import hitwh.fanghh.dao.PerferentialruleDao;
import hitwh.fanghh.dao.RoofbeamDao;
import hitwh.fanghh.dao.UnitDao;
import hitwh.fanghh.pojo.Activity;
import hitwh.fanghh.pojo.Clearancehouselist;
import hitwh.fanghh.pojo.Grouppurchasehouselist;
import hitwh.fanghh.pojo.House;
import hitwh.fanghh.pojo.Perferentialhouselist;
import hitwh.fanghh.pojo.Perferentialrule;
import hitwh.fanghh.service.ActivityService;
import hitwh.fanghh.service.HouseService;
import hitwh.fanghh.util.DictionaryString;
import hitwh.fanghh.util.PageCalculate;

@Service
public class ActivityServiceImpl implements ActivityService
{
	@Autowired
	private HttpSession session;

	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private BuildingDao buildingDao;

	@Autowired
	private HouseService houseService;

	@Autowired
	private HouseDao houseDao;

	@Autowired
	private UnitDao unitDao;

	@Autowired
	private RoofbeamDao roofBeamDao;

	@Autowired
	private HouserealpicDao houseRealPicDao;

	@Autowired
	private PerferentialruleDao perferentialruleDao;

	@Autowired
	private PerferentialhouselistDao perferentialHouseListDao;
	@Autowired
	private GrouppurchasehouselistDao grouppurchasehouselistDao;
	@Autowired
	private ClearancehouselistDao clearanceHouseListDao;
	@Autowired
	private GrouppurchaseinfoDao grouppurchaseinfoDao;
	@Autowired
	private PerferentialhouselistDao perferentialhouselistDao;

	@Override
	public String addClearanceActivity(ClearanceActivityBean clearanceActivityBean)
	{
		// TODO Auto-generated method stub
		int res1 = 1;
		int res2 = 1;

		if (clearanceActivityBean != null)
		{
			Activity activity = new Activity();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			activity.setActivityName(clearanceActivityBean.getActivityName());
			activity.setBuildingId(clearanceActivityBean.getBuildingId());
			activity.setStartDate(clearanceActivityBean.getStartTime());
			activity.setEndDate(clearanceActivityBean.getEndTime());
			activity.setState(null);
			activity.setModifiedTime(time);
			activity.setActivityType(DictionaryString.CLEARANCE_ACTIVITY);
			activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);
			activityDao.insertSelective(activity);
			int activityId = activity.getActivityId();
			if (clearanceActivityBean.getHouseBeanList() != null)
			{

				for (HouseBean houseBean : clearanceActivityBean.getHouseBeanList())
				{
					Clearancehouselist clearanceHouseList = new Clearancehouselist();
					clearanceHouseList.setHouseId(houseBean.getHouseId());
					clearanceHouseList.setActivityId(activityId);
					houseDao.addPerferentialPrice(houseBean.getHouseId(), houseBean.getCurrentPrice());
					res1 = clearanceHouseListDao.insertSelective(clearanceHouseList);

				}
			}
			if (clearanceActivityBean.getPerferentialRuleBeanList() != null)
			{
				for (PerferentialRuleBean perferentialRuleBean : clearanceActivityBean.getPerferentialRuleBeanList())
				{
					Perferentialrule perferentialRule = new Perferentialrule();
					perferentialRule.setActivityId(activityId);
					perferentialRule.setPerferentialDescription(perferentialRuleBean.getPerferentialDescription());
					perferentialRule.setPerferentialRuleType(perferentialRuleBean.getPerferentialRuleType());
					perferentialRule.setPerferentialTitle(perferentialRuleBean.getPerferentialRuleTitle());
					perferentialRule.setIsUsed(true);
					res2 = perferentialruleDao.insertSelective(perferentialRule);
				}
			}
		}
		if (res1 != 0 && res2 != 0)
		{
			return "success";
		} else
		{
			return "数据库更新失败res1 :" + res1 + "res2:" + res2;
		}
	}

	@Override
	public ClearanceActivityBean getSingleClearanceActivity(int activityId)
	{
		// TODO Auto-generated method stub
		Activity activity = activityDao.selectByPrimaryKey(activityId);
		ClearanceActivityBean clearanceActivityBean = new ClearanceActivityBean();
		List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
		if (activity != null)
		{

			List<PerferentialRuleBean> perferentialRuleBeanList = new ArrayList<PerferentialRuleBean>();
			clearanceActivityBean.setActivityId(activity.getActivityId());
			clearanceActivityBean.setActivityName(activity.getActivityName());
			clearanceActivityBean.setBuildingId(activity.getBuildingId());
			clearanceActivityBean.setBuildingName(buildingDao.getBuildingNameById(activity.getBuildingId()));
			clearanceActivityBean.setEndTime(activity.getEndDate());
			clearanceActivityBean.setModifiedTime(activity.getModifiedTime());
			clearanceActivityBean.setStartTime(activity.getStartDate());
			clearanceActivityBean.setState(activity.getState());
			clearanceActivityBean.setActivityType(activity.getActivityType());
			clearanceActivityBean.setActivityApplicationStatus(activity.getActivityApplicationStatus());
			clearanceActivityBean.setAuditNotPassReason(activity.getAuditNotPassReason());
			List<Perferentialrule> perferentialRuleList = new ArrayList<Perferentialrule>();
			perferentialRuleList = perferentialruleDao.selectByActivityId(activity.getActivityId());
			if (perferentialRuleList != null)
			{
				for (Perferentialrule perferentialRule : perferentialRuleList)
				{

					PerferentialRuleBean perferentialRuleBean = new PerferentialRuleBean();
					perferentialRuleBean.setActivityId(perferentialRule.getActivityId());
					perferentialRuleBean.setPerferentialDescription(perferentialRule.getPerferentialDescription());
					perferentialRuleBean.setPerferentialRuleTitle(perferentialRule.getPerferentialTitle());
					perferentialRuleBean.setPerferentialRuleType(perferentialRule.getPerferentialRuleType());
					perferentialRuleBean.setRuleId(perferentialRule.getRuleId());
					perferentialRuleBeanList.add(perferentialRuleBean);
				}
				clearanceActivityBean.setPerferentialRuleBeanList(perferentialRuleBeanList);
			} else
			{
				clearanceActivityBean.setPerferentialRuleBeanList(null);
			}
			List<Clearancehouselist> clearanceHouselist = new ArrayList<Clearancehouselist>();
			clearanceHouselist = clearanceHouseListDao.selectByActivityId(activity.getActivityId());
			if (clearanceHouselist != null)
			{
				for (Clearancehouselist clearanceHouse : clearanceHouselist)
				{
					HouseBean houseBean = new HouseBean();
					houseBean = houseService.getHouseById(clearanceHouse.getHouseId());
					houseBeanList.add(houseBean);
				}
				clearanceActivityBean.setHouseBeanList(houseBeanList);
			} else
			{
				clearanceActivityBean.setHouseBeanList(null);
			}

		}

		return clearanceActivityBean;

	}

	@Override
	public String updateClearanceActivity(ClearanceActivityBean clearanceActivityBean)
	{
		// TODO Auto-generated method stub
		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		if (clearanceActivityBean != null)
		{
			Activity activity = new Activity();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			activity.setActivityId(clearanceActivityBean.getActivityId());
			activity.setActivityName(clearanceActivityBean.getActivityName());
			activity.setBuildingId(clearanceActivityBean.getBuildingId());
			activity.setStartDate(clearanceActivityBean.getStartTime());
			activity.setEndDate(clearanceActivityBean.getEndTime());
			activity.setState(clearanceActivityBean.getState());
			if (DictionaryString.APPLICATION_ON_SALE.equals(clearanceActivityBean.getActivityApplicationStatus()))
			{
				activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);// 修改房源信息后变为待上架状态
			} else if (DictionaryString.APPLICATION_OFF_SALE
					.equals(clearanceActivityBean.getActivityApplicationStatus()))
			{
				activity.setActivityApplicationStatus(DictionaryString.ON_SALE_ALREADY);
			} else
			{
				activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);
			}
			activity.setModifiedTime(time);
			activity.setActivityType(clearanceActivityBean.getActivityType());
			res3 = activityDao.updateByPrimaryKeySelective(activity);
			clearanceHouseListDao.deleteByActivityId(clearanceActivityBean.getActivityId());// 删除数据库中原有信息
			perferentialruleDao.deleteByActivityId(clearanceActivityBean.getActivityId());// 删除数据库中原有信息
			// 采用先删除数据库数据再插入新数据方法
			if (clearanceActivityBean.getHouseBeanList() != null)
			{

				for (HouseBean houseBean : clearanceActivityBean.getHouseBeanList())
				{
					Clearancehouselist clearanceHouseList = new Clearancehouselist();
					clearanceHouseList.setHouseId(houseBean.getHouseId());
					clearanceHouseList.setActivityId(clearanceActivityBean.getActivityId());
					houseDao.addPerferentialPrice(houseBean.getHouseId(), houseBean.getCurrentPrice());
					res1 = clearanceHouseListDao.insertSelective(clearanceHouseList);
				}
			}
			if (clearanceActivityBean.getPerferentialRuleBeanList() != null)
			{
				for (PerferentialRuleBean perferentialRuleBean : clearanceActivityBean.getPerferentialRuleBeanList())
				{
					Perferentialrule perferentialRule = new Perferentialrule();
					perferentialRule.setActivityId(clearanceActivityBean.getActivityId());
					perferentialRule.setPerferentialDescription(perferentialRuleBean.getPerferentialDescription());
					perferentialRule.setPerferentialRuleType(perferentialRuleBean.getPerferentialRuleType());
					perferentialRule.setPerferentialTitle(perferentialRuleBean.getPerferentialRuleTitle());
					res2 = perferentialruleDao.insertSelective(perferentialRule);
				}
			}
		}
		if (res1 != 0 && res2 != 0 && res3 != 0)
		{
			return "success";
		} else
		{
			return "数据库更新失败res1 :" + res1 + "res2:" + res2 + "res3:" + res3;
		}
	}

	@Override
	public List<ClearanceActivityBean> getAllClearanceActivity(Integer regionId, String keyBuildingName, int pageMaxNum,
			int pageNo)
	{
		// TODO Auto-generated method stub
		Object cityIdObject = session.getAttribute("cityId");
		Integer cityId = cityIdObject == null ? null : Integer.parseInt(cityIdObject.toString());

		int pageNum = getClearanceActivityPageNum(cityId, regionId, keyBuildingName, pageMaxNum);
		PageCalculate pageCalculate = new PageCalculate(pageNum, pageMaxNum, pageNo);
		List<Activity> activityList = activityDao.selectByRegionIdAndKeyBuildingNameAndCityId(
				DictionaryString.CLEARANCE_ACTIVITY, cityId, regionId, keyBuildingName, pageCalculate);
		List<ClearanceActivityBean> clearanceActivityList = new ArrayList<ClearanceActivityBean>();
		List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
		if (activityList != null)
		{
			for (Activity activity : activityList)
			{
				ClearanceActivityBean clearanceActivityBean = new ClearanceActivityBean();
				List<PerferentialRuleBean> perferentialRuleBeanList = new ArrayList<PerferentialRuleBean>();
				clearanceActivityBean.setActivityId(activity.getActivityId());
				clearanceActivityBean.setActivityName(activity.getActivityName());
				clearanceActivityBean.setBuildingId(activity.getBuildingId());
				clearanceActivityBean.setBuildingName(buildingDao.getBuildingNameById(activity.getBuildingId()));
				clearanceActivityBean.setEndTime(activity.getEndDate());
				clearanceActivityBean.setModifiedTime(activity.getModifiedTime());
				clearanceActivityBean.setStartTime(activity.getStartDate());
				clearanceActivityBean.setState(activity.getState());
				clearanceActivityBean.setActivityType(activity.getActivityType());
				clearanceActivityBean.setActivityApplicationStatus(activity.getActivityApplicationStatus());
				clearanceActivityBean.setAuditNotPassReason(activity.getAuditNotPassReason());
				// clearanceActivityBean.setCity();
				// clearanceActivityBean.set
				List<Perferentialrule> perferentialRuleList = new ArrayList<Perferentialrule>();
				perferentialRuleList = perferentialruleDao.selectByActivityId(activity.getActivityId());
				if (perferentialRuleList != null)
				{
					for (Perferentialrule perferentialRule : perferentialRuleList)
					{
						if (perferentialRule.getIsUsed())
						{
							PerferentialRuleBean perferentialRuleBean = new PerferentialRuleBean();
							perferentialRuleBean.setActivityId(perferentialRule.getActivityId());
							perferentialRuleBean
									.setPerferentialDescription(perferentialRule.getPerferentialDescription());
							perferentialRuleBean.setPerferentialRuleTitle(perferentialRule.getPerferentialTitle());
							perferentialRuleBean.setPerferentialRuleType(perferentialRule.getPerferentialRuleType());
							perferentialRuleBean.setRuleId(perferentialRule.getRuleId());
							perferentialRuleBeanList.add(perferentialRuleBean);
						}
					}
					clearanceActivityBean.setPerferentialRuleBeanList(perferentialRuleBeanList);
				} else
				{
					clearanceActivityBean.setPerferentialRuleBeanList(null);
				}
				List<Clearancehouselist> clearanceHouselist = new ArrayList<Clearancehouselist>();
				clearanceHouselist = clearanceHouseListDao.selectByActivityId(activity.getActivityId());
				if (clearanceHouselist != null)
				{
					for (Clearancehouselist clearanceHouse : clearanceHouselist)
					{
						HouseBean houseBean = new HouseBean();
						houseBean = houseService.getHouseById(clearanceHouse.getHouseId());
						houseBeanList.add(houseBean);
					}
					clearanceActivityBean.setHouseBeanList(houseBeanList);
				} else
				{
					clearanceActivityBean.setHouseBeanList(null);
				}
				clearanceActivityList.add(clearanceActivityBean);
			}
		}

		return clearanceActivityList;
	}

	@Override
	public int getClearanceActivityPageNum(Integer cityId, Integer regionId, String keyBuildingName, int pageMaxNum)
	{
		int houseNum = activityDao.countActivity(DictionaryString.CLEARANCE_ACTIVITY, cityId, regionId,
				keyBuildingName);
		return houseNum % pageMaxNum == 0 ? houseNum / pageMaxNum : houseNum / pageMaxNum + 1;
	}

	@Override
	public String addPerferentialActivity(PerferentialActivityBean perferentialActivityBean)
	{
		int res1 = 0;
		int res2 = 0;

		if (perferentialActivityBean != null)
		{
			Activity activity = new Activity();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			activity.setActivityName(perferentialActivityBean.getActivityName());
			activity.setBuildingId(perferentialActivityBean.getBuildingId());
			activity.setStartDate(perferentialActivityBean.getStartTime());
			activity.setEndDate(perferentialActivityBean.getEndTime());
			activity.setActivityType(DictionaryString.PERFERENTIAL_ACTIVITY);
			activity.setState(null);
			activity.setModifiedTime(time);
			activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);
			activityDao.insertSelective(activity);
			int activityId = activity.getActivityId();
			if (perferentialActivityBean.getHouseBeanList() != null)
			{

				for (HouseBean houseBean : perferentialActivityBean.getHouseBeanList())
				{
					Perferentialhouselist perferentialHouseList = new Perferentialhouselist();
					perferentialHouseList.setHouseId(houseBean.getHouseId());
					perferentialHouseList.setActivityId(activityId);
					houseDao.addPerferentialPrice(houseBean.getHouseId(), houseBean.getCurrentPrice());
					res1 = perferentialHouseListDao.insertSelective(perferentialHouseList);

				}
			}
			if (perferentialActivityBean.getPerferentialRuleBeanList() != null)
			{
				for (PerferentialRuleBean perferentialRuleBean : perferentialActivityBean.getPerferentialRuleBeanList())
				{
					Perferentialrule perferentialRule = new Perferentialrule();
					perferentialRule.setActivityId(activityId);
					perferentialRule.setPerferentialDescription(perferentialRuleBean.getPerferentialDescription());
					perferentialRule.setPerferentialRuleType(perferentialRuleBean.getPerferentialRuleType());
					perferentialRule.setPerferentialTitle(perferentialRuleBean.getPerferentialRuleTitle());
					perferentialRule.setIsUsed(true);
					res2 = perferentialruleDao.insertSelective(perferentialRule);
				}
			}
		}
		if (res1 != 0 && res2 != 0)
		{
			return "success";
		} else
		{
			return "数据库更新失败res1 :" + res1 + "res2:" + res2;
		}

	}

	@Override
	public List<PerferentialActivityBean> getAllPerferentialActivity(Integer regionId, String keyBuildingName,
			int pageMaxNum, int pageNo)
	{
		Object cityIdObject = session.getAttribute("cityId");
		Integer cityId = cityIdObject == null ? null : Integer.parseInt(cityIdObject.toString());

		int pageNum = getPerferentialActivityPageNum(cityId, regionId, keyBuildingName, pageMaxNum);
		PageCalculate pageCalculate = new PageCalculate(pageNum, pageMaxNum, pageNo);
		List<Activity> activityList = activityDao.selectByRegionIdAndKeyBuildingNameAndCityId(
				DictionaryString.PERFERENTIAL_ACTIVITY, cityId, regionId, keyBuildingName, pageCalculate);
		List<PerferentialActivityBean> perferentialActivityList = new ArrayList<PerferentialActivityBean>();
		List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
		if (activityList != null)
		{
			for (Activity activity : activityList)
			{
				PerferentialActivityBean perferentialActivityBean = new PerferentialActivityBean();
				List<PerferentialRuleBean> perferentialRuleBeanList = new ArrayList<PerferentialRuleBean>();
				perferentialActivityBean.setActivityId(activity.getActivityId());
				perferentialActivityBean.setActivityName(activity.getActivityName());
				perferentialActivityBean.setBuildingId(activity.getBuildingId());
				perferentialActivityBean.setBuildingName(buildingDao.getBuildingNameById(activity.getBuildingId()));
				perferentialActivityBean.setEndTime(activity.getEndDate());
				perferentialActivityBean.setModifiedTime(activity.getModifiedTime());
				perferentialActivityBean.setStartTime(activity.getStartDate());
				perferentialActivityBean.setState(activity.getState());
				perferentialActivityBean.setActivityType(activity.getActivityType());
				perferentialActivityBean.setActivityApplicationStatus(activity.getActivityApplicationStatus());
				perferentialActivityBean.setAuditNotPassReason(activity.getAuditNotPassReason());
				List<Perferentialrule> perferentialRuleList = new ArrayList<Perferentialrule>();
				perferentialRuleList = perferentialruleDao.selectByActivityId(activity.getActivityId());
				if (perferentialRuleList != null)
				{
					for (Perferentialrule perferentialRule : perferentialRuleList)
					{
						if (perferentialRule.getIsUsed())
						{
							PerferentialRuleBean perferentialRuleBean = new PerferentialRuleBean();
							perferentialRuleBean.setActivityId(perferentialRule.getActivityId());
							perferentialRuleBean
									.setPerferentialDescription(perferentialRule.getPerferentialDescription());
							perferentialRuleBean.setPerferentialRuleTitle(perferentialRule.getPerferentialTitle());
							perferentialRuleBean.setPerferentialRuleType(perferentialRule.getPerferentialRuleType());
							perferentialRuleBean.setRuleId(perferentialRule.getRuleId());
							perferentialRuleBeanList.add(perferentialRuleBean);
						}
					}
					perferentialActivityBean.setPerferentialRuleBeanList(perferentialRuleBeanList);
				} else
				{
					perferentialActivityBean.setPerferentialRuleBeanList(null);
				}
				List<Perferentialhouselist> perferentialHouselist = new ArrayList<Perferentialhouselist>();
				perferentialHouselist = perferentialHouseListDao.selectByActivityId(activity.getActivityId());
				if (perferentialHouselist != null)
				{
					for (Perferentialhouselist perferentialHouse : perferentialHouselist)
					{
						HouseBean houseBean = new HouseBean();
						houseBean = houseService.getHouseById(perferentialHouse.getHouseId());
						houseBeanList.add(houseBean);
					}
					perferentialActivityBean.setHouseBeanList(houseBeanList);
				} else
				{
					perferentialActivityBean.setHouseBeanList(null);
				}
				perferentialActivityList.add(perferentialActivityBean);
			}
		}

		return perferentialActivityList;
	}

	@Override
	public int getPerferentialActivityPageNum(Integer cityId, Integer regionId, String keyBuildingName, int pageMaxNum)
	{
		// TODO Auto-generated method stub
		int houseNum = activityDao.countActivity(DictionaryString.PERFERENTIAL_ACTIVITY, cityId, regionId,
				keyBuildingName);
		return houseNum % pageMaxNum == 0 ? houseNum / pageMaxNum : houseNum / pageMaxNum + 1;

	}

	@Override
	public PerferentialActivityBean getSinglePerferentialActivity(int activityId)
	{
		// TODO Auto-generated method stub
		Activity activity = activityDao.selectByPrimaryKey(activityId);
		PerferentialActivityBean perferentialActivityBean = new PerferentialActivityBean();
		List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
		if (activity != null)
		{

			List<PerferentialRuleBean> perferentialRuleBeanList = new ArrayList<PerferentialRuleBean>();
			perferentialActivityBean.setActivityId(activity.getActivityId());
			perferentialActivityBean.setActivityName(activity.getActivityName());
			perferentialActivityBean.setBuildingId(activity.getBuildingId());
			perferentialActivityBean.setBuildingName(buildingDao.getBuildingNameById(activity.getBuildingId()));
			perferentialActivityBean.setEndTime(activity.getEndDate());
			perferentialActivityBean.setModifiedTime(activity.getModifiedTime());
			perferentialActivityBean.setStartTime(activity.getStartDate());
			perferentialActivityBean.setState(activity.getState());
			perferentialActivityBean.setActivityType(activity.getActivityType());
			perferentialActivityBean.setActivityApplicationStatus(activity.getActivityApplicationStatus());
			perferentialActivityBean.setAuditNotPassReason(activity.getAuditNotPassReason());
			List<Perferentialrule> perferentialRuleList = new ArrayList<Perferentialrule>();
			perferentialRuleList = perferentialruleDao.selectByActivityId(activity.getActivityId());
			if (perferentialRuleList != null)
			{
				for (Perferentialrule perferentialRule : perferentialRuleList)
				{

					PerferentialRuleBean perferentialRuleBean = new PerferentialRuleBean();
					perferentialRuleBean.setActivityId(perferentialRule.getActivityId());
					perferentialRuleBean.setPerferentialDescription(perferentialRule.getPerferentialDescription());
					perferentialRuleBean.setPerferentialRuleTitle(perferentialRule.getPerferentialTitle());
					perferentialRuleBean.setPerferentialRuleType(perferentialRule.getPerferentialRuleType());
					perferentialRuleBean.setRuleId(perferentialRule.getRuleId());
					perferentialRuleBeanList.add(perferentialRuleBean);
				}
				perferentialActivityBean.setPerferentialRuleBeanList(perferentialRuleBeanList);
			} else
			{
				perferentialActivityBean.setPerferentialRuleBeanList(null);
			}
			List<Perferentialhouselist> perferentialHouselist = new ArrayList<Perferentialhouselist>();
			perferentialHouselist = perferentialHouseListDao.selectByActivityId(activity.getActivityId());
			if (perferentialHouselist != null)
			{
				for (Perferentialhouselist perferentialHouse : perferentialHouselist)
				{
					HouseBean houseBean = new HouseBean();
					houseBean = houseService.getHouseById(perferentialHouse.getHouseId());
					houseBeanList.add(houseBean);
				}
				perferentialActivityBean.setHouseBeanList(houseBeanList);
			} else
			{
				perferentialActivityBean.setHouseBeanList(null);
			}

		}

		return perferentialActivityBean;

	}

	@Override
	public List<PerferentialActivityBean> getPerferentialActivityByCity(String cityId, int pageMaxNum, int pageNo)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String updatePerferentialActivity(PerferentialActivityBean perferentialActivityBean)
	{
		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		if (perferentialActivityBean != null)
		{
			Activity activity = new Activity();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			activity.setActivityId(perferentialActivityBean.getActivityId());
			activity.setActivityName(perferentialActivityBean.getActivityName());
			activity.setBuildingId(perferentialActivityBean.getBuildingId());
			activity.setStartDate(perferentialActivityBean.getStartTime());
			activity.setEndDate(perferentialActivityBean.getEndTime());
			activity.setState(perferentialActivityBean.getState());
			if (DictionaryString.APPLICATION_ON_SALE.equals(perferentialActivityBean.getActivityApplicationStatus()))
			{
				activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);// 修改房源信息后变为待上架状态
			} else if (DictionaryString.APPLICATION_OFF_SALE
					.equals(perferentialActivityBean.getActivityApplicationStatus()))
			{
				activity.setActivityApplicationStatus(DictionaryString.ON_SALE_ALREADY);
			} else
			{
				activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);
			}
			activity.setModifiedTime(time);
			res3 = activityDao.updateByPrimaryKeySelective(activity);
			perferentialHouseListDao.deleteByActivityId(perferentialActivityBean.getActivityId());// 删除数据库中原有信息
			perferentialruleDao.deleteByActivityId(perferentialActivityBean.getActivityId());// 删除数据库中原有信息
			// 采用先删除数据库数据再插入新数据方法
			if (perferentialActivityBean.getHouseBeanList() != null)
			{

				for (HouseBean houseBean : perferentialActivityBean.getHouseBeanList())
				{
					// perferentialHouseListDao.deleteByPrimaryKey(houseBean.getHouseId());
					Perferentialhouselist perferentialHouseList = new Perferentialhouselist();
					perferentialHouseList.setHouseId(houseBean.getHouseId());
					perferentialHouseList.setActivityId(perferentialActivityBean.getActivityId());
					// perferentialHouseList.setPhlId(perferentialhouselistDao.selectIdByHouseId(houseBean.getHouseId()));
					houseDao.addPerferentialPrice(houseBean.getHouseId(), houseBean.getCurrentPrice());
					res1 = perferentialHouseListDao.insertSelective(perferentialHouseList);
				}
			}
			if (perferentialActivityBean.getPerferentialRuleBeanList() != null)
			{
				for (PerferentialRuleBean perferentialRuleBean : perferentialActivityBean.getPerferentialRuleBeanList())
				{
					Perferentialrule perferentialRule = new Perferentialrule();
					perferentialRule.setActivityId(perferentialActivityBean.getActivityId());
					perferentialRule.setPerferentialDescription(perferentialRuleBean.getPerferentialDescription());
					perferentialRule.setPerferentialRuleType(perferentialRuleBean.getPerferentialRuleType());
					perferentialRule.setPerferentialTitle(perferentialRuleBean.getPerferentialRuleTitle());
					perferentialRule.setRuleId(perferentialRuleBean.getRuleId());
					res2 = perferentialruleDao.insertSelective(perferentialRule);
				}
			}
		}
		if (res1 != 0 && res2 != 0 && res3 != 0)
		{
			return "success";
		} else
		{
			return "数据库更新失败res1 :" + res1 + "res2:" + res2 + "res3:" + res3;
		}
	}

	@Override
	public int applicateActivityOnSaleByActivityId(int activityId)
	{
		// TODO Auto-generated method stub
		String applicationDicCode;
		String auditCode;
		int res = 0;
		int res1 = 0;
		Activity activity = activityDao.selectByPrimaryKey(activityId);
		if (activity == null)
		{
			return res;
		}

		applicationDicCode = activityDao.getActivityApplicationStatusByActivityId(activityId);
		auditCode = activityDao.getAuditStatusByActivityId(activityId);
		if (applicationDicCode.equals(DictionaryString.APPLICATION_WAIT))
		{
			res = activityDao.updateActivityApplicationStatusByActivityId(activityId,
					DictionaryString.APPLICATION_ON_SALE);
			// res1 = activityDao.updateAuditStatusByActivityId(activityId,
			// DictionaryString.AUDIT_WAIT);
			if (res == 1)
			{
				return 1;
			} else
			{
				return res;
			}
		} else
			return 0;
	}

	@Override
	public int applicateActivityOffSaleByActivityId(int activityId)
	{
		// TODO Auto-generated method stub
		String applicationDicCode;
		String auditCode;
		int res = 0;
		int res1 = 0;
		Activity activity = activityDao.selectByPrimaryKey(activityId);
		if (activity == null)
		{
			return res;
		}
		applicationDicCode = activityDao.getActivityApplicationStatusByActivityId(activityId);
		auditCode = activityDao.getAuditStatusByActivityId(activityId);
		if (applicationDicCode.equals(DictionaryString.ON_SALE_ALREADY))
		{
			res = activityDao.updateActivityApplicationStatusByActivityId(activityId,
					DictionaryString.APPLICATION_OFF_SALE);
			// res1 = activityDao.updateAuditStatusByActivityId(activityId,
			// DictionaryString.AUDIT_WAIT);
			if (res == 1)
			{
				return 1;
			} else
			{
				return res;
			}
		} else
			return 0;
	}

	@Override
	public String auditActivityApplicationByActivityId(int activityId, int auditType, String auditNotPassReason)
	{
		Activity activity = activityDao.selectByPrimaryKey(activityId);
		String applicationStatus = null;
		String auditStatus = null;
		int res1 = 0;
		int res2 = 0;
		if (activity == null)
		{
			return "未找到相应活动信息，错误的activityId" + activityId;
		}
		switch (auditType)
		{
		case 1: // 审核通过上架申请
			applicationStatus = activity.getActivityApplicationStatus();
			auditStatus = activity.getState();
			if (applicationStatus.equals(DictionaryString.APPLICATION_ON_SALE))
			{
				res1 = activityDao.updateActivityApplicationStatusByActivityId(activityId,
						DictionaryString.ON_SALE_ALREADY);
				// res2 = activityDao.updateAuditStatusByActivityId(activityId,
				// DictionaryString.AUDIT_PASS);
				if (res1 == 1)
				{
					return "success";
				} else
				{
					return "活动上架审核通过异常" + "res1" + res1;
				}
			}
			break;
		case 2: // 审核不通过上架申请
			applicationStatus = activity.getActivityApplicationStatus();
			auditStatus = activity.getState();
			if (applicationStatus.equals(DictionaryString.APPLICATION_ON_SALE))
			{
				res2 = activityDao.updateAuditStatusByActivityId(activityId, DictionaryString.AUDIT_NOT_PASS);
				res1 = activityDao.updateAuditNotPassReason(activityId, auditNotPassReason);
				if (res1 == 1 && res2 == 1)
				{
					return "success";
				} else
				{
					return "活动上架审核未通过异常" + "res1" + res1 + "res2" + res2;
				}
			}
			break;
		case 3: // 审核通过下架申请
			applicationStatus = activity.getActivityApplicationStatus();
			auditStatus = activity.getState();
			if (applicationStatus.equals(DictionaryString.APPLICATION_OFF_SALE))
			{
				// res2 = activityDao.updateAuditStatusByActivityId(activityId,
				// DictionaryString.AUDIT_PASS);
				res1 = activityDao.updateActivityApplicationStatusByActivityId(activityId,
						DictionaryString.OFF_SALE_ALREADY);
				if (res1 == 1)
				{
					return "success";
				} else
				{
					return "活动下架审核通过异常" + "res1" + res1 + "res2" + res2;
				}
			}
			break;
		case 4: // 审核不通过下架申请
			applicationStatus = activity.getActivityApplicationStatus();
			auditStatus = activity.getState();
			if (applicationStatus.equals(DictionaryString.APPLICATION_OFF_SALE))
			{
				res2 = activityDao.updateAuditStatusByActivityId(activityId, DictionaryString.AUDIT_NOT_PASS);
				res1 = activityDao.updateAuditNotPassReason(activityId, auditNotPassReason);
				if (res1 == 1 && res2 == 1)
				{
					return "success";
				} else
				{
					return "活动下架审核不通过异常" + "res1" + res1 + "res2" + res2;
				}
			}
			break;

		}
		return "错误的auditType";

	}

	@Override
	public int giveAuditNotPassReason(int activityId, String auditNotPassReason)
	{
		return activityDao.updateAuditNotPassReason(activityId, auditNotPassReason);
	}

	// zy

	@Override
	public List<GroupPurchaseActivityBean> getGroupPurchaseActivityByCityId(Integer cityId, Integer regionId,
			String keyBuildingName, int pageMaxNum, int pageNo)
	{
		// 系统管理员可见到所有地区活动
		Object city = session.getAttribute("cityId");
		if (city != null)
		{
			cityId = Integer.parseInt(city.toString());
		}

		int pageNum = getGroupPurchaseActivityPageNum(cityId, regionId, keyBuildingName, pageMaxNum);
		PageCalculate pageCalculate = new PageCalculate(pageNum, pageMaxNum, pageNo);
		List<Activity> activityList = activityDao.selectByRegionIdAndKeyBuildingNameAndCityId(
				DictionaryString.GROUP_PURCHASE_ACTIVITY, cityId, regionId, keyBuildingName, pageCalculate);

		List<GroupPurchaseActivityBean> groupPurchaseActivityBeanList = new ArrayList<GroupPurchaseActivityBean>();

		for (Activity activity : activityList)
		{
			GroupPurchaseActivityBean groupPurchaseActivityBean = new GroupPurchaseActivityBean();

			groupPurchaseActivityBean.setActivityApplicationStatus(activity.getActivityApplicationStatus());
			groupPurchaseActivityBean.setActivityId(activity.getActivityId());
			groupPurchaseActivityBean.setActivityName(activity.getActivityName());
			groupPurchaseActivityBean.setActivityType(activity.getActivityType());
			groupPurchaseActivityBean.setAuditNotPassReason(activity.getAuditNotPassReason());
			groupPurchaseActivityBean.setBuildingId(activity.getBuildingId());
			groupPurchaseActivityBean.setEndTime(activity.getEndDate());
			groupPurchaseActivityBean.setModifiedTime(activity.getModifiedTime());
			groupPurchaseActivityBean.setStartTime(activity.getStartDate());
			groupPurchaseActivityBean.setState(activity.getState());
			groupPurchaseActivityBean.setBuildingName(buildingDao.getBuildingNameById(activity.getBuildingId()));
			List<Perferentialrule> perferentialRuleList = perferentialruleDao
					.selectByActivityId(activity.getActivityId());
			List<PerferentialRuleBean> perferentialRuleBeanList = new ArrayList<PerferentialRuleBean>();
			for (Perferentialrule perferentialrule : perferentialRuleList)
			{
				if (perferentialrule.getIsUsed())
				{
					PerferentialRuleBean perferentialRuleBean = new PerferentialRuleBean();
					perferentialRuleBean.setActivityId(perferentialrule.getActivityId());
					perferentialRuleBean.setPerferentialDescription(perferentialrule.getPerferentialDescription());
					perferentialRuleBean.setPerferentialRuleTitle(perferentialrule.getPerferentialTitle());
					perferentialRuleBean.setPerferentialRuleType(perferentialrule.getPerferentialRuleType());
					perferentialRuleBean.setRuleId(perferentialrule.getRuleId());
					perferentialRuleBeanList.add(perferentialRuleBean);
				}
			}
			groupPurchaseActivityBean.setPerferentialRuleBeanList(perferentialRuleBeanList);

			List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
			List<Grouppurchasehouselist> grouppurchasehouselist = grouppurchasehouselistDao
					.selectByActivityId(activity.getActivityId());
			if (grouppurchasehouselist != null)
			{
				for (Grouppurchasehouselist grouppurchasehouse : grouppurchasehouselist)
				{
					HouseBean houseBean = new HouseBean();
					houseBean = houseService.getHouseById(grouppurchasehouse.getHouseId());
					houseBeanList.add(houseBean);
				}
			}
			groupPurchaseActivityBean.setHouseBeanList(houseBeanList);

			groupPurchaseActivityBeanList.add(groupPurchaseActivityBean);
		}
		return groupPurchaseActivityBeanList;
	}

	@Override
	public int getGroupPurchaseActivityPageNum(Integer cityId, Integer regionId, String keyBuildingName, int pageMaxNum)
	{
		int num = activityDao.countActivity(DictionaryString.GROUP_PURCHASE_ACTIVITY, cityId, regionId,
				keyBuildingName);
		return num % pageMaxNum == 0 ? num / pageMaxNum : num / pageMaxNum + 1;
	}

	@Override
	public GroupPurchaseActivityBean getSingleGroupPurchaseActivity(int activityId)
	{
		Activity activity = activityDao.selectByPrimaryKey(activityId);

		GroupPurchaseActivityBean groupPurchaseActivityBean = new GroupPurchaseActivityBean();

		groupPurchaseActivityBean.setActivityApplicationStatus(activity.getActivityApplicationStatus());
		groupPurchaseActivityBean.setActivityId(activity.getActivityId());
		groupPurchaseActivityBean.setActivityName(activity.getActivityName());
		groupPurchaseActivityBean.setActivityType(activity.getActivityType());
		groupPurchaseActivityBean.setAuditNotPassReason(activity.getAuditNotPassReason());
		groupPurchaseActivityBean.setBuildingId(activity.getBuildingId());
		groupPurchaseActivityBean.setEndTime(activity.getEndDate());
		groupPurchaseActivityBean.setModifiedTime(activity.getModifiedTime());
		groupPurchaseActivityBean.setStartTime(activity.getStartDate());
		groupPurchaseActivityBean.setState(activity.getState());
		groupPurchaseActivityBean.setBuildingName(buildingDao.getBuildingNameById(activity.getBuildingId()));

		List<Perferentialrule> perferentialRuleList = perferentialruleDao.selectByActivityId(activity.getActivityId());
		List<PerferentialRuleBean> perferentialRuleBeanList = new ArrayList<PerferentialRuleBean>();
		for (Perferentialrule perferentialrule : perferentialRuleList)
		{
			if (perferentialrule.getIsUsed())
			{
				PerferentialRuleBean perferentialRuleBean = new PerferentialRuleBean();
				perferentialRuleBean.setActivityId(perferentialrule.getActivityId());
				perferentialRuleBean.setPerferentialDescription(perferentialrule.getPerferentialDescription());
				perferentialRuleBean.setPerferentialRuleTitle(perferentialrule.getPerferentialTitle());
				perferentialRuleBean.setPerferentialRuleType(perferentialrule.getPerferentialRuleType());
				perferentialRuleBean.setRuleId(perferentialrule.getRuleId());
				perferentialRuleBeanList.add(perferentialRuleBean);
			}
		}
		groupPurchaseActivityBean.setPerferentialRuleBeanList(perferentialRuleBeanList);

		List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
		List<Grouppurchasehouselist> grouppurchasehouselist = grouppurchasehouselistDao
				.selectByActivityId(activity.getActivityId());
		if (grouppurchasehouselist != null)
		{
			for (Grouppurchasehouselist grouppurchasehouse : grouppurchasehouselist)
			{
				HouseBean houseBean = new HouseBean();
				houseBean = houseService.getHouseById(grouppurchasehouse.getHouseId());
				houseBeanList.add(houseBean);
			}
		}
		groupPurchaseActivityBean.setHouseBeanList(houseBeanList);

		return groupPurchaseActivityBean;
	}

	@Override
	public String addGroupPurchaseActivity(GroupPurchaseActivityBean groupPurchaseActivityBean)
	{
		int res1 = 1, res2 = 1;
		if (groupPurchaseActivityBean != null)
		{
			Activity activity = new Activity();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			activity.setActivityName(groupPurchaseActivityBean.getActivityName());
			activity.setBuildingId(groupPurchaseActivityBean.getBuildingId());
			activity.setStartDate(groupPurchaseActivityBean.getStartTime());
			activity.setEndDate(groupPurchaseActivityBean.getEndTime());
			activity.setState(null);
			activity.setModifiedTime(time);
			activity.setActivityType(DictionaryString.GROUP_PURCHASE_ACTIVITY);
			activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);
			activityDao.insertSelective(activity);
			Integer activityId = activity.getActivityId();
			if (groupPurchaseActivityBean.getHouseBeanList() != null)
			{

				for (HouseBean houseBean : groupPurchaseActivityBean.getHouseBeanList())
				{
					Grouppurchasehouselist grouppurchasehouselist = new Grouppurchasehouselist();
					grouppurchasehouselist.setHouseId(houseBean.getHouseId());
					grouppurchasehouselist.setActivityId(activityId.toString());
					houseDao.addPerferentialPrice(houseBean.getHouseId(), houseBean.getCurrentPrice());
					res1 &= grouppurchasehouselistDao.insertSelective(grouppurchasehouselist);
				}
			}
			if (groupPurchaseActivityBean.getPerferentialRuleBeanList() != null)
			{
				for (PerferentialRuleBean perferentialRuleBean : groupPurchaseActivityBean
						.getPerferentialRuleBeanList())
				{
					Perferentialrule perferentialRule = new Perferentialrule();
					perferentialRule.setActivityId(activityId);
					perferentialRule.setPerferentialDescription(perferentialRuleBean.getPerferentialDescription());
					perferentialRule.setPerferentialRuleType(perferentialRuleBean.getPerferentialRuleType());
					perferentialRule.setPerferentialTitle(perferentialRuleBean.getPerferentialRuleTitle());
					perferentialRule.setIsUsed(true);
					res2 &= perferentialruleDao.insertSelective(perferentialRule);
				}
			}
		}
		if (res1 != 0 && res2 != 0)
		{
			return "success";
		} else
		{
			return "addGroupPurchaseActivity数据库更新失败res1 :" + res1 + "res2:" + res2;
		}
	}

	@Override
	public String updateGroupPurchaseActivity(GroupPurchaseActivityBean groupPurchaseActivityBean)
	{
		int res1 = 1;
		int res2 = 1;

		if (groupPurchaseActivityBean != null)
		{
			Activity activity = new Activity();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			activity.setActivityId(groupPurchaseActivityBean.getActivityId());
			activity.setActivityName(groupPurchaseActivityBean.getActivityName());
			// activity.setBuildingId(groupPurchaseActivityBean.getBuildingId());
			activity.setStartDate(groupPurchaseActivityBean.getStartTime());
			activity.setEndDate(groupPurchaseActivityBean.getEndTime());
			activity.setState(groupPurchaseActivityBean.getState());
			activity.setModifiedTime(time);
			if (groupPurchaseActivityBean.getActivityApplicationStatus().equals(DictionaryString.APPLICATION_ON_SALE))
			{
				activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);// 修改房源信息后变为待上架状态
			} else if (groupPurchaseActivityBean.getActivityApplicationStatus()
					.equals(DictionaryString.APPLICATION_OFF_SALE))
			{
				activity.setActivityApplicationStatus(DictionaryString.ON_SALE_ALREADY);
			} else
			{
				activity.setActivityApplicationStatus(DictionaryString.APPLICATION_WAIT);
			}
			activityDao.updateByPrimaryKeySelective(activity);
			if (groupPurchaseActivityBean.getHouseBeanList() != null)
			{
				// 先删除，再插入，用于更新
				grouppurchasehouselistDao.deleteByActivityId(groupPurchaseActivityBean.getActivityId());

				for (HouseBean houseBean : groupPurchaseActivityBean.getHouseBeanList())
				{
					Grouppurchasehouselist grouppurchasehouselist = new Grouppurchasehouselist();
					grouppurchasehouselist.setHouseId(houseBean.getHouseId());
					grouppurchasehouselist.setActivityId(groupPurchaseActivityBean.getActivityId().toString());
					houseDao.addPerferentialPrice(houseBean.getHouseId(), houseBean.getCurrentPrice());
					res1 &= grouppurchasehouselistDao.insertSelective(grouppurchasehouselist);
				}
			}
			if (groupPurchaseActivityBean.getPerferentialRuleBeanList() != null)
			{
				// 先删除，再插入，用于更新
				perferentialruleDao.deleteByActivityId(groupPurchaseActivityBean.getActivityId());

				for (PerferentialRuleBean perferentialRuleBean : groupPurchaseActivityBean
						.getPerferentialRuleBeanList())
				{
					Perferentialrule perferentialRule = new Perferentialrule();
					perferentialRule.setActivityId(groupPurchaseActivityBean.getActivityId());
					perferentialRule.setPerferentialDescription(perferentialRuleBean.getPerferentialDescription());
					perferentialRule.setPerferentialRuleType(perferentialRuleBean.getPerferentialRuleType());
					perferentialRule.setPerferentialTitle(perferentialRuleBean.getPerferentialRuleTitle());
					perferentialRule.setRuleId(perferentialRuleBean.getRuleId());
					res2 &= perferentialruleDao.insertSelective(perferentialRule);
				}
			}
		}
		if (res1 != 0 && res2 != 0)
		{
			return "success";
		} else
		{
			return "数据库更新失败res1 :" + res1 + "res2:" + res2;
		}
	}

	@Override
	public List<HouseBean> getNoActivityHouseByBuildingId(int buildingId, int pageMaxNum, int pageNo)
	{
		int pageNum = getNoActivityHousePageNumByBuildingId(buildingId, pageMaxNum);
		PageCalculate pageCalculate = new PageCalculate(pageNum, pageMaxNum, pageNo);
		List<House> houseList = houseDao.selectByBuildingId(buildingId, pageCalculate);
		List<HouseBean> houseBeanList = new ArrayList<HouseBean>();
		for (House house : houseList)
		{
			HouseBean houseBean = new HouseBean();
			if (house != null)
			{
				houseBean.setArea(house.getArea());
				houseBean.setAuditStatus(house.getAuditStatus());
				houseBean.setBasementSquare(house.getBasementSquare());
				houseBean.setBuildingId(house.getBuildingId());
				houseBean.setDecoration(house.getDecoration());
				houseBean.setDownPayment(house.getDownPayment());
				houseBean.setFace(house.getFace());
				houseBean.setFloor(house.getFloor());
				houseBean.setHouseId(house.getHouseId());
				houseBean.setHouseNum(house.getHouseNum());
				if (houseRealPicDao.selectByHouseId(house.getHouseId()) != null)
				{
					houseBean.setHousePic(houseRealPicDao.selectByHouseId(house.getHouseId()).getPicLocation());
				} else
				{
					houseBean.setHousePic(null);
				}
				houseBean.setMaxFloor(house.getMaxFloor());
				houseBean.setMonthlyPayment(house.getMonthlyPayment());
				houseBean.setOrginalPrice(house.getOrginalPrice());
				houseBean.setParkingLotPrice(house.getParkingLotPrice());
				houseBean.setParkingPlaceArea(house.getParkingPlaceArea());
				houseBean.setRecommendReason(house.getRecommendReason());
				houseBean.setStyleId(house.getStyleId());
				houseBean.setUnit(unitDao.getUnitCodeById(house.getUnitId()));
				houseBean.setAuditNotPassReason(house.getAuditNotPassReason());
				houseBean.setHouseApplicationStatus(house.getHouseApplicationStatus());
				houseBean.setBuildingNo(roofBeamDao.getRoofNameById(unitDao.getRoofIdById(house.getUnitId())));
			}
			houseBeanList.add(houseBean);
		}
		return houseBeanList;

	}

	@Override
	public int getNoActivityHousePageNumByBuildingId(int buildingId, int pageMaxNum)
	{
		int houseNum = houseDao.countNoActivityHouseByBuildingId(buildingId);
		return houseNum % pageMaxNum == 0 ? houseNum / pageMaxNum : houseNum / pageMaxNum + 1;
	}

}