package hitwh.fanghh.manage.module.base.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.module.base.dao.BrokerDao;
import hitwh.fanghh.manage.module.base.dao.StoreDao;
import hitwh.fanghh.manage.module.base.service.StoreService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.Store;
import hitwh.fanghh.manage.util.DecryptUtil;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private BrokerDao brokerDao;
	@Autowired
	private UserDao userDao;

	@Override
	public List<Store> getAll() {
		List<Store> resultList = new ArrayList<Store>();
		List<Store> list = storeDao.getAll();
		if(list!=null){
			return list;
		}else {
			return resultList;
		}		
	}

	@Override
	public List<String> getStorePortrait(int storeId) {
		List<String> list = new ArrayList<String>();
		Store store = storeDao.getStorePortrait(storeId);
		String[] portrait = new String[2];
		if (store != null) {
			String idcardPic = store.getStorePortrait();
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
	public Integer auditStore(Integer storeId, Integer typeId,
			String failedReason) {
		//String PUSH_URL = "http://222.194.15.118:7071/fanghh/pushNewsToUser?";//测试库
		
		String PUSH_URL = "http://222.194.15.118:8080/fanghh/pushNewsToUser?";//测试库
		Integer result = 0;
		Store store = storeDao.getStorePortrait(storeId);
		if(store != null && typeId == 1){
			Broker broker= store.getBroker();
			User user = broker.getUser();
			//user.setRole("09030200");
			broker.setBrokerType("09030200");
			brokerDao.update(broker);
			store.setStatus("06110200");
			storeDao.update(store);
			result = 1;
			//门店审核成功消息推送
			try {
				PUSH_URL += "dicContent=16011800&userId="+broker.getUser().getId();
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
		}else if(store != null && typeId == 2){
			Broker broker= store.getBroker();
			store.setStatus("06110300");
			store.setFailedReason(failedReason);
			storeDao.update(store);
			result = 2;
			
			String enString = DecryptUtil.gb2312ToUtf8(failedReason);
			String base64Str = (new sun.misc.BASE64Encoder()).encode(enString.getBytes()); 
			PUSH_URL += "dicContent=16011900&userId="+broker.getUser().getId()+"&arg0="+base64Str;
			
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
		}else {
			result = 3;
		}
		return result;
	}

}
