package hitwh.fanghh.manage.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.ConfigBean;

public interface ConfigBeanService {

	public void add(ConfigBean c);

	public void update(ConfigBean c);

	public void delete(ConfigBean c);

	public List<ConfigBean> getAll();

	public String getConfigByName(String name);

}
