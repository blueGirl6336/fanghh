package hitwh.fanghh.manage.service.impl;

import hitwh.fanghh.manage.dao.ConfigBeanDao;
import hitwh.fanghh.manage.pojo.ConfigBean;
import hitwh.fanghh.manage.service.ConfigBeanService;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigBeanServiceImpl implements ConfigBeanService {

	@Autowired
	private ConfigBeanDao configBeanDao;

	private HashMap<String, String> configMap = new HashMap<String, String>();

	private boolean needUpdateMap = true;

	public void add(ConfigBean c) {

		this.configBeanDao.add(c);
		this.needUpdateMap = true;
	}

	public void update(ConfigBean c) {
		this.needUpdateMap = true;
		this.configBeanDao.update(c);
	}

	public void delete(ConfigBean c) {
		this.needUpdateMap = true;
		this.configBeanDao.delete(c);
	}

	public List<ConfigBean> getAll() {
		return this.configBeanDao.getAll();
	}

	public String getConfigByName(String name) {
		if (this.needUpdateMap) {
			this.updateMap();
		}
		if (this.configMap.containsKey(name)) {
			return this.configMap.get(name);
		} else {
			ConfigBean cb = this.configBeanDao.getByName(name);
			if (cb == null)
				return null;
			else {
				this.configMap.put(cb.getName(), cb.getValue());
				return cb.getValue();
			}
		}
	}

	private void updateMap() {
		List<ConfigBean> cgList = this.configBeanDao.getAll();
		this.configMap.clear();
		for (int i = 0; i < cgList.size(); i++) {
			this.configMap.put(cgList.get(i).getName(), cgList.get(i)
					.getValue());
		}
		this.needUpdateMap = false;
	}

}
