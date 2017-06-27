package hitwh.fanghh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.bean.CityAndRegionBean;
import hitwh.fanghh.dao.CityDao;
import hitwh.fanghh.dao.DictionaryDao;
import hitwh.fanghh.dao.RegionDao;
import hitwh.fanghh.pojo.City;
import hitwh.fanghh.pojo.Dictionary;
import hitwh.fanghh.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService
{
	// 字典表的缓存,dictCode唯一
	private Map<String, Dictionary> dictionaryDictCodeCacheMap = new ConcurrentHashMap<String, Dictionary>();

	@Autowired
	private DictionaryDao dictionaryDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private RegionDao regionDao;
	@Override
	public String getDictName(String dictCode)
	{
		Dictionary dictionary = dictionaryDictCodeCacheMap.get(dictCode);
		if (dictionary != null)
		{
			return dictionary.getDictname();
		} else
		{
			List<Dictionary> dictionaryList = dictionaryDao.selectByDictCode(dictCode);
			if (dictionaryList.isEmpty())
			{
				return null;
			} else
			{
				dictionaryDictCodeCacheMap.put(dictCode, dictionaryList.get(0));
				return dictionaryList.get(0).getDictname();
			}
		}

	}

	@Override
	public List<CityAndRegionBean> getAllCityAndRegion() {
		// TODO Auto-generated method stub
		List<CityAndRegionBean> cityAndRegionBeanList = new ArrayList<CityAndRegionBean>();
		List<City> cityList = cityDao.selectAllCity();
		for(City city : cityList)
		{
			CityAndRegionBean cityAndRegionBean = new CityAndRegionBean();
			cityAndRegionBean.setCityId(city.getCityId());
			cityAndRegionBean.setCityName(city.getCityName());
			cityAndRegionBean.setRegionList(regionDao.selectByCityId(city.getCityId()));
			cityAndRegionBeanList.add(cityAndRegionBean);
		}
		if(cityAndRegionBeanList.isEmpty())
		{
			return null;
		}else
		{
			return cityAndRegionBeanList;
		}
	}
}
