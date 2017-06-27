package hitwh.fanghh.service;

import java.util.List;

import hitwh.fanghh.pojo.Dynamiccontent;

/**
 * 动态管理
 *
 * @ClassName: DynamiccontentService
 * @Description: TODO
 * @author: LSG
 *
 */

public interface DynamiccontentService
{

	public int getDynamiccontentPageNum(int pageMaxNum, int bdiId);

	public List<Dynamiccontent> getAllDynamicContent();

	public Dynamiccontent getDynamiccontentByBdId(int dcId);

	public boolean addDynamiccontent(Dynamiccontent dynamiccontent);

	public boolean deleteDynamiccontent(int dcId);

	public boolean updateDynamiccontent(Dynamiccontent dynamiccontent);

	public List<Dynamiccontent> getDynamicContentByBdiId(int bdiId, int pageMaxNum, int pageNo);
}