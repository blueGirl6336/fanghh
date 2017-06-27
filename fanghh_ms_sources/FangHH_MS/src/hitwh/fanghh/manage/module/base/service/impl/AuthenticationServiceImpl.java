package hitwh.fanghh.manage.module.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.module.base.dao.BrokerAchvDao;
import hitwh.fanghh.manage.module.base.dao.BrokerDao;
import hitwh.fanghh.manage.module.base.dao.FourDoubleZeroPhoneDao;
import hitwh.fanghh.manage.module.base.service.AuthenticationService;
import hitwh.fanghh.manage.module.base.service.BrokerTeamService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.BrokerAchv;
import hitwh.fanghh.manage.pojo.building.FourDoubleZeroPhone;
import hitwh.fanghh.manage.util.DecryptUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	private BrokerDao brokerDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private FourDoubleZeroPhoneDao fourDoubleZeroPhoneDao;
	@Autowired
	private BrokerTeamService brokerTeamService;
	@Autowired
	private BrokerAchvDao brokerAchvDao;

	@Override
	public List<Broker> getAll() {
		List<Broker> resultList = new ArrayList<Broker>();
		List<Broker> brokerList = brokerDao.getAll();
		boolean flag = false;
		if(brokerList != null){
			for(Broker broker : brokerList){
				String roleString = broker.getBrokerIdcard();
				String failedReason = broker.getFailedReason();
				if(failedReason == null || failedReason.equals("")){
					flag = true;
				}
				//当用户为 普通用户而且审核失败理由为空时--该用户待审核
				if(roleString != null &&  flag && !(broker.getUser().getIsAuthenticated())){
					resultList.add(broker);
				}
				flag = false;
			}
			if(resultList.size() > 0){
				return resultList;
			}
		}
		return resultList;
	}

	@Override
	public List<String> getIdCardPic(Integer brokerId) {
		List<String> list = new ArrayList<String>();
		Broker broker = brokerDao.getByBrokerId(brokerId);
		String[] portrait = new String[2];
		if (broker != null) {
			String idcardPic = broker.getIdcardPic();
			if(idcardPic != null){
				String[] pic = idcardPic.split("#");
				if("".equals(pic[0])){
					portrait[0] = "http://222.194.15.118:8080/img/msDefalutPortrait/defaultnull.jpg";
					portrait[1] = "http://222.194.15.118:8080/img/msDefalutPortrait/defaultnull.jpg";
				}else if (pic.length == 1) {
					portrait[0] = pic[0];
					portrait[1] = "http://222.194.15.118:8080/img/msDefalutPortrait/defaultnull.jpg";
				}else {
					portrait[0] = pic[0];
					portrait[1] = pic[1];
				}
				
				list.add(portrait[0]);
				list.add(portrait[1]);
			}else {
				portrait[0] = "http://222.194.15.118:8080/img/msDefalutPortrait/defaultnull.jpg";
				portrait[1] = "http://222.194.15.118:8080/img/msDefalutPortrait/defaultnull.jpg";
				list.add(portrait[0]);
				list.add(portrait[1]);
			}
			if(list.size()>0){
				return list;
			}
		}
		return list;
	}

	@Override
	public Integer authenticate(Integer brokerId, Integer typeId, String result) {
		//String PUSH_URL = "http://222.194.15.118:7071/fanghh/pushNewsToUser?";//测试库
		String PUSH_URL = "http://222.194.15.118:8080/fanghh/pushNewsToUser?";//正式库
		Integer resultInteger = 0;//默认为0
		//boolean phoneFlag = false;
		Broker broker = brokerDao.getByBrokerId(brokerId);
		User user = userDao.getById(broker.getUser().getId());
		if(typeId == 1){//验证成功
			if (user != null && broker != null) {
				//user.setRole("09020700");
				user.setIsAuthenticated(true);// 修改用户为经纪人

				/*FourDoubleZeroPhone fourDoubleZeroPhone = new FourDoubleZeroPhone();// 保存400电话
				fourDoubleZeroPhone.setOrginalPhoneNum(user.getPhoneNo());
				fourDoubleZeroPhone.setTargetPhoneNum(result);
				FourDoubleZeroPhone fPhone = fourDoubleZeroPhoneDao.havingFourDOuble(result);
				if(fPhone != null){
					if(!(fPhone.getOrginalPhoneNum().equals(user.getPhoneNo()))){//如果400电话已被其他人注册
						resultInteger = 2;
						return resultInteger;
					}else {
						fPhone.setTargetPhoneNum(result);
						phoneFlag = true;
					}
				}*/
				
				/*BrokerAchv brokerAchv = new BrokerAchv();
				brokerAchv.setBroker(broker);
				brokerAchv.setBuildingNum(0);
				brokerAchv.setCustomerNum(0);
				brokerAchv.setDealNum(0);
				brokerAchv.setSaleProfit(new Long(0));
				brokerAchv.setTotalCommission(new Long(0));*/
				
				//boolean flag = brokerTeamService.createBrokerTeam(broker.getBrokerId());//创建经纪人团队
				//if (flag) {
					userDao.update(user);
					/*if(phoneFlag){
						fourDoubleZeroPhoneDao.update(fPhone);						
					}else {
						fourDoubleZeroPhoneDao.add(fourDoubleZeroPhone);
					}*/
					//brokerAchvDao.addBrokerAchv(brokerAchv);
					resultInteger = 1;//实名认证成功
					
					try {
						PUSH_URL += "dicContent=16010100&userId="+user.getId();
						URL url = new URL(PUSH_URL);//把字符串转换为URL地址
						HttpURLConnection connection = (HttpURLConnection)url.openConnection();//打开链接
						connection.connect();//连接会话
						//获取输入流
						BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
						String line;
						StringBuilder sBuilder = new StringBuilder();
						while((line = bReader.readLine())!= null){//循环读取流
							sBuilder.append(line);
						}
						bReader.close();//关闭流
						connection.disconnect();//断开连接						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				/*}else {
					resultInteger = 4;//如果存在团队
				}*/
				return resultInteger;
			}

			return resultInteger;
		}else if (typeId == 3) {//暂存
			FourDoubleZeroPhone fourDoubleZeroPhone = new FourDoubleZeroPhone();// 保存400电话
			fourDoubleZeroPhone.setOrginalPhoneNum(user.getPhoneNo());
			fourDoubleZeroPhone.setTargetPhoneNum(result);
			FourDoubleZeroPhone fPhone = fourDoubleZeroPhoneDao.havingFourDOuble(result);
			if(fPhone != null){
				if(!(fPhone.getOrginalPhoneNum().equals(user.getPhoneNo()))){//如果400电话已被其他人注册
					resultInteger = 2;					
				}else {
					fPhone.setTargetPhoneNum(result);
					fourDoubleZeroPhoneDao.update(fPhone);
					resultInteger = 6;
				}
			}else {
				fourDoubleZeroPhoneDao.add(fourDoubleZeroPhone);
				resultInteger = 5;
			}

			return resultInteger;
		}else {//验证失败
			if (user != null && broker != null) {
				broker.setFailedReason(result);//保存验证失败的失败原因
				brokerDao.update(broker);
				resultInteger = 3;//认证不通过
				String enString = DecryptUtil.gb2312ToUtf8(result);
				String base64Str = (new sun.misc.BASE64Encoder()).encode(enString.getBytes()); 
				PUSH_URL += "dicContent=16010200&userId="+user.getId()+"&arg0="+base64Str;
				try{
					URL url = new URL(PUSH_URL);//把字符串转换为URL地址
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();//打开链接
					connection.connect();//连接会话
					//获取输入流
					BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String line = null;
					StringBuilder sBuilder = new StringBuilder();
					while((line = bReader.readLine())!= null){//循环读取流
						sBuilder.append(line);
					}
					bReader.close();//关闭流
					connection.disconnect();//断开连接
					System.out.println(sBuilder.toString());
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
			return resultInteger;
		}
	}

	@Override
	public Broker getByPhoneNo(String phoneNo) {
		List<Broker> brokerList = brokerDao.getAll();
		boolean flag = false;
		if(brokerList != null){
			for(Broker broker : brokerList){
				String roleString = broker.getUser().getRole();
				String failedReason = broker.getFailedReason();
				if(failedReason == null || failedReason.equals("")){
					flag = true;
				}
				//返回指定手机号的待审核用户
				if(roleString.equals("09021400") 
						&& flag
						&& broker.getPhoneNo().equals(phoneNo)){
					return broker;
				}
			}
		}
		return null;
	}

	@Override
	public String getFourDoublephone(String phoneNo) {
		FourDoubleZeroPhone fourDoubleZeroPhone = fourDoubleZeroPhoneDao.getFourDOuble(phoneNo);
		if(fourDoubleZeroPhone != null && !("待审核".equals(fourDoubleZeroPhone.getTargetPhoneNum())) ){
			String phone = fourDoubleZeroPhone.getTargetPhoneNum();
			String[] result = phone.split(",");
			return result[1];
		}else if (fourDoubleZeroPhone != null && "待审核".equals(fourDoubleZeroPhone.getTargetPhoneNum())) {
			return "";
		}
		return "error";
	}

}
