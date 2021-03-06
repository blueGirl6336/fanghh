package hitwh.fanghh.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hitwh.fanghh.bean.HouseBean;
import hitwh.fanghh.dao.HouseDao;
import hitwh.fanghh.dao.HouserealpicDao;
import hitwh.fanghh.dao.RoofbeamDao;
import hitwh.fanghh.dao.UnitDao;
import hitwh.fanghh.pojo.House;
import hitwh.fanghh.pojo.Houserealpic;
import hitwh.fanghh.pojo.Roofbeam;
import hitwh.fanghh.pojo.Unit;
import hitwh.fanghh.service.HouseService;
import hitwh.fanghh.util.DictionaryString;
import hitwh.fanghh.util.PageCalculate;
import hitwh.fanghh.util.RandomUtil;

@Service
public class HouseServiceImpl implements HouseService
{
	@Autowired
	private HouseDao houseDao;
	@Autowired
	private UnitDao unitDao;
	@Autowired
	private RoofbeamDao roofBeamDao;
	@Autowired
	private HouserealpicDao houseRealPicDao;
	@Autowired
	private HttpSession session;

	@Override
	public List<HouseBean> getHouseByBuildingId(int buildingId, int pageMaxNum, int pageNo)
	{

		int pageNum = getHousePageNumByBuildingId(buildingId, pageMaxNum);
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
				houseBean.setCurrentPrice(house.getCurrentPrice());
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
	public HouseBean getHouseById(int houseId)
	{
		House house = houseDao.selectByPrimaryKey(houseId);
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
			houseBean.setCurrentPrice(house.getCurrentPrice());
			houseBean.setParkingLotPrice(house.getParkingLotPrice());
			houseBean.setParkingPlaceArea(house.getParkingPlaceArea());
			houseBean.setRecommendReason(house.getRecommendReason());
			houseBean.setStyleId(house.getStyleId());
			houseBean.setUnit(unitDao.getUnitCodeById(house.getUnitId()));
			houseBean.setAuditNotPassReason(house.getAuditNotPassReason());
			houseBean.setHouseApplicationStatus(house.getHouseApplicationStatus());
			houseBean.setBuildingNo(roofBeamDao.getRoofNameById(unitDao.getRoofIdById(house.getUnitId())));
		}

		return houseBean;
	}

	@Override
	public int getHousePageNumByBuildingId(int buildingId, int pageMaxNum)
	{
		int houseNum = houseDao.countHouseByBuildingId(buildingId);
		return houseNum % pageMaxNum == 0 ? houseNum / pageMaxNum : houseNum / pageMaxNum + 1;
	}

	@Override
	public String applicateHouseOnSaleByHouseId(int houseId)
	{
		// TODO Auto-generated method stub
		String applicationDicCode;
		int res = 0;
		House house = houseDao.selectByPrimaryKey(houseId);
		if (house != null)
		{
			applicationDicCode = houseDao.getHouseApplicationStatusByHouseId(houseId);
			if (applicationDicCode.equals(DictionaryString.APPLICATION_WAIT))
			{
				res = houseDao.updateHouseApplicationStatusByHouseId(houseId, DictionaryString.APPLICATION_ON_SALE);
				if (res == 1)
				{
					return "success";
				} else
				{
					return "数据库修改失败";
				}
			} else
			{
				return "房源申请状态错误";
			}
		} else
		{
			return "未找到房源信息，错误的houseId" + houseId;
		}
	}

	@Override
	public String applicateHouseOffSaleByHouseId(int houseId)
	{
		// TODO Auto-generated method stub
		String applicationDicCode;
		int res = 0;
		House house = houseDao.selectByPrimaryKey(houseId);
		if (house != null)
		{
			applicationDicCode = house.getHouseApplicationStatus();
			if (applicationDicCode.equals(DictionaryString.ON_SALE_ALREADY))
			{
				res = houseDao.updateHouseApplicationStatusByHouseId(houseId, DictionaryString.APPLICATION_OFF_SALE);
				if (res == 1)
				{
					return "success";
				} else
				{
					return "数据库修改失败";
				}
			} else
				return "房源申请状态错误";
		} else
		{
			return "未找到房源信息，错误的houseId" + houseId;
		}
	}

	@Override
	public String auditHouseApplicationByHouseId(int houseId, boolean auditStatus, String auditNotPassReason)
	{
		House house = houseDao.selectByPrimaryKey(houseId);

		if (house == null)
		{
			return "未找到房源信息，错误的houseId：" + houseId;
		}

		String status = null, applicationStatus = null;
		applicationStatus = house.getHouseApplicationStatus();

		if (auditStatus)
		{
			status = DictionaryString.AUDIT_PASS;// 审核通过
			auditNotPassReason = null;
			if (DictionaryString.APPLICATION_ON_SALE.equals(applicationStatus))
			{
				// 上架
				applicationStatus = DictionaryString.ON_SALE_ALREADY;
			} else if (DictionaryString.APPLICATION_OFF_SALE.equals(applicationStatus))
			{
				// 下架
				applicationStatus = DictionaryString.OFF_SALE_ALREADY;
			} else
			{
				return "数据库错误，未知的字典码：" + applicationStatus;
			}
		} else
		{
			status = DictionaryString.AUDIT_NOT_PASS;
		}

		int res1 = houseDao.updateAuditStatusByHouseId(houseId, status);
		int res2 = houseDao.updateHouseApplicationStatusByHouseId(houseId, applicationStatus);
		int res3 = houseDao.updateAuditNotPassReason(houseId, auditNotPassReason);

		if (res1 == 1 && res2 == 1 && res3 == 1)
		{
			return "success";
		} else
		{
			return "数据库更新错误：updateApplicationStatus=" + res1 + "，updateAuditStatus=" + res2 + res3;
		}
	}

	public int giveAuditNotPassReason(int houseId, String auditNotPassReason)
	{
		return houseDao.updateAuditNotPassReason(houseId, auditNotPassReason);
	}

	public String getAuditNotPassReason(int houseId)
	{
		return houseDao.getAuditNotPassReasonByHouseId(houseId);
	}

	@Override
	public String addHouse(HouseBean houseBean)
	{
		// TODO Auto-generated method stub
		House house = new House();
		Unit unit = new Unit();
		Roofbeam roofBeam = new Roofbeam();
		if (houseBean == null)
		{
			return "服务器未收到数据";
		}
		house.setArea(houseBean.getArea());
		house.setStyleId(houseBean.getStyleId());
		house.setBuildingId(houseBean.getBuildingId());// 房源所属楼盘

		roofBeam.setRoofName(houseBean.getBuildingNo());
		roofBeam.setBuildingId(houseBean.getBuildingId());
		roofBeamDao.insertSelective(roofBeam);
		int roofId = roofBeam.getRoofId();
		unit.setRoofId(roofId);
		unit.setUnitCode(houseBean.getUnit());
		unitDao.insertSelective(unit);
		int unitId = unit.getUnitId();
		house.setUnitId(unitId);
		house.setHouseNum(houseBean.getHouseNum());
		house.setOrginalPrice(houseBean.getOrginalPrice());
		house.setDownPayment(houseBean.getDownPayment());
		house.setMonthlyPayment(houseBean.getMonthlyPayment());
		houseBean.setCurrentPrice(null);
		house.setAuditStatus(null);// 房源审核状态 无
		house.setFace(houseBean.getFace());
		house.setMaxFloor(houseBean.getMaxFloor());
		house.setFloor(houseBean.getFloor());
		house.setDecoration(houseBean.getDecoration());
		house.setBasementSquare(houseBean.getBasementSquare());
		house.setParkingLotPrice(houseBean.getParkingLotPrice());
		house.setParkingPlaceArea(houseBean.getParkingPlaceArea());
		house.setRecommendReason(houseBean.getRecommendReason());
		house.setAuditNotPassReason(null);// 审核不通过原因无
		house.setHouseApplicationStatus(DictionaryString.APPLICATION_WAIT);// 新录入房源变为待审核状态
		houseDao.insertSelective(house);
		int res = 0;
		res = house.getHouseId();
		if (houseBean.getHousePic() != null)
		{
			Houserealpic houseRealPic = new Houserealpic();
			houseRealPic.setHouseId(res);
			houseRealPic.setPicLocation(houseBean.getHousePic());
			houseRealPicDao.insertSelective(houseRealPic);
		}

		if (res != 0)
		{
			return "success";
		} else
		{
			return "数据库插入失败，res" + res;
		}

	}

	@Override
	public String updateHouseToWait(HouseBean houseBean)
	{
		House house = new House();
		Unit unit = new Unit();
		Roofbeam roofBeam = new Roofbeam();

		if (houseBean == null)
		{
			return "服务器未收到数据";
		}
		house.setHouseId(houseBean.getHouseId());
		house.setArea(houseBean.getArea());
		house.setStyleId(houseBean.getStyleId());
		house.setBuildingId(houseBean.getBuildingId());
		roofBeam.setRoofName(houseBean.getBuildingNo());
		roofBeamDao.insertSelective(roofBeam);
		int roofId = roofBeam.getRoofId();
		unit.setRoofId(roofId);
		unit.setUnitCode(houseBean.getUnit());
		unitDao.insertSelective(unit);
		int unitId = unit.getUnitId();
		house.setUnitId(unitId);
		house.setHouseNum(houseBean.getHouseNum());
		house.setOrginalPrice(houseBean.getOrginalPrice());
		house.setCurrentPrice(null);
		house.setDownPayment(houseBean.getDownPayment());
		house.setMonthlyPayment(houseBean.getMonthlyPayment());
		house.setAuditStatus(null);// 房源审核状态 无
		house.setFace(houseBean.getFace());
		house.setMaxFloor(houseBean.getMaxFloor());
		house.setFloor(houseBean.getFloor());
		house.setDecoration(houseBean.getDecoration());
		house.setBasementSquare(houseBean.getBasementSquare());
		house.setParkingLotPrice(houseBean.getParkingLotPrice());
		house.setParkingPlaceArea(houseBean.getParkingPlaceArea());
		house.setRecommendReason(houseBean.getRecommendReason());
		house.setAuditNotPassReason(null);// 审核不通过原因无
		if (houseBean.getHouseApplicationStatus().equals(DictionaryString.APPLICATION_ON_SALE))
		{
			house.setHouseApplicationStatus(DictionaryString.APPLICATION_WAIT);// 修改房源信息后变为待上架状态
		}
		if (houseBean.getHouseApplicationStatus().equals(DictionaryString.APPLICATION_OFF_SALE))
		{
			house.setHouseApplicationStatus(DictionaryString.ON_SALE_ALREADY);
		}
		house.setAttachedHouseDescription(null);
		house.setBasementPrice(null);
		house.setBasementSquare(null);
		house.setCurrentPrice(null);
		house.setCurrentPricePerSquare(null);
		house.setHasParkingLot(null);
		house.setHasParkingPlace(null);
		house.setHaveBasement(null);
		house.setHighestCommission(null);
		house.setHouseStatus(null);
		house.setMasterBedroomFace(null);
		house.setOrginalPricePerSquare(null);
		house.setOtherFacility(null);
		house.setRecommendReason(null);
		house.setRemark(null);

		houseBean.setHousePic(houseBean.getHousePic());

		if (houseBean.getHousePic() != null)
		{
			Houserealpic houseRealPic = new Houserealpic();
			houseRealPic.setHouseId(houseBean.getHouseId());
			houseRealPic.setPicLocation(houseBean.getHousePic());
			houseRealPic.setId(houseRealPicDao.selectIdByHouseId(houseBean.getHouseId()));
			houseRealPicDao.updateByPrimaryKeySelective(houseRealPic);
		}

		int res = houseDao.updateByPrimaryKeySelective(house);

		if (res == 1)
		{
			return "success";
		} else
		{
			return "数据库插入失败，res" + res;
		}
	}

	@Override
	public String updateHouse(HouseBean houseBean)
	{
		House house = new House();
		Unit unit = new Unit();
		Roofbeam roofBeam = new Roofbeam();

		if (houseBean == null)
		{
			return "服务器未收到数据";
		}
		house.setHouseId(houseBean.getHouseId());
		house.setArea(houseBean.getArea());
		house.setStyleId(houseBean.getStyleId());
		house.setBuildingId(houseBean.getBuildingId());
		roofBeam.setRoofName(houseBean.getBuildingNo());
		roofBeamDao.insertSelective(roofBeam);
		int roofId = roofBeam.getRoofId();
		unit.setRoofId(roofId);
		unit.setUnitCode(houseBean.getUnit());
		unitDao.insertSelective(unit);
		int unitId = unit.getUnitId();
		house.setUnitId(unitId);
		house.setHouseNum(houseBean.getHouseNum());
		house.setOrginalPrice(houseBean.getOrginalPrice());
		house.setCurrentPrice(null);
		house.setDownPayment(houseBean.getDownPayment());
		house.setMonthlyPayment(houseBean.getMonthlyPayment());
		house.setAuditStatus(null);// 房源审核状态 无
		house.setFace(houseBean.getFace());
		house.setMaxFloor(houseBean.getMaxFloor());
		house.setFloor(houseBean.getFloor());
		house.setDecoration(houseBean.getDecoration());
		house.setBasementSquare(houseBean.getBasementSquare());
		house.setParkingLotPrice(houseBean.getParkingLotPrice());
		house.setParkingPlaceArea(houseBean.getParkingPlaceArea());
		house.setRecommendReason(houseBean.getRecommendReason());
		house.setAuditNotPassReason(null);// 审核不通过原因无
		if (houseBean.getHouseApplicationStatus().equals(DictionaryString.APPLICATION_ON_SALE))
		{
			house.setHouseApplicationStatus(DictionaryString.APPLICATION_WAIT);// 修改房源信息后变为待上架状态
		} else if (houseBean.getHouseApplicationStatus().equals(DictionaryString.APPLICATION_OFF_SALE))
		{
			house.setHouseApplicationStatus(DictionaryString.ON_SALE_ALREADY);
		} else
		{
			house.setHouseApplicationStatus(DictionaryString.APPLICATION_WAIT);// 修改房源信息后变为待上架状态
		}
		house.setAttachedHouseDescription(null);
		house.setBasementPrice(null);
		house.setBasementSquare(null);
		house.setCurrentPrice(null);
		house.setCurrentPricePerSquare(null);
		house.setHasParkingLot(null);
		house.setHasParkingPlace(null);
		house.setHaveBasement(null);
		house.setHighestCommission(null);
		house.setHouseStatus(null);
		house.setMasterBedroomFace(null);
		house.setOrginalPricePerSquare(null);
		house.setOtherFacility(null);
		house.setRecommendReason(null);
		house.setRemark(null);

		houseBean.setHousePic(houseBean.getHousePic());

		if (houseBean.getHousePic() != null)
		{
			Houserealpic houseRealPic = new Houserealpic();
			houseRealPic.setHouseId(houseBean.getHouseId());
			houseRealPic.setPicLocation(houseBean.getHousePic());
			houseRealPic.setId(houseRealPicDao.selectIdByHouseId(houseBean.getHouseId()));
			houseRealPicDao.updateByPrimaryKeySelective(houseRealPic);
		}

		int res = houseDao.updateByPrimaryKeySelective(house);

		if (res == 1)
		{
			return "success";
		} else
		{
			return "数据库插入失败，res" + res;
		}
	}

	@Override
	public String uploadHousePic(MultipartFile file)
	{
		// TODO Auto-generated method stub
		String basePath = session.getServletContext().getRealPath("/");
		String dirPath = "/pic/";
		String path = basePath + dirPath;
		String res = null;
		if (file.isEmpty())
		{
			return null;
		}
		try
		{
			File writeFile = null;
			String fileName = file.getOriginalFilename().toLowerCase();// 得到上传之前的文件名
			while (writeFile == null)
			{
				String[] fileNames = fileName.split("//.");
				fileName = RandomUtil.getRandomEnAndNumString(32) + "." + fileNames[fileNames.length - 1];
				writeFile = new File(path + fileName);
			}
			file.transferTo(writeFile);// 上传文件
			res = dirPath + fileName;

		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		return res;

	}

	@Override
	public String addPerferentialPrice(int houseId, BigDecimal perferentialPrice)
	{
		// TODO Auto-generated method stub
		int res = 0;
		res = houseDao.addPerferentialPrice(houseId, perferentialPrice);
		if (res == 1)
		{
			return "success";
		} else
			return "数据库插入失败 res：" + res;
	}

}
