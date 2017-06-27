package hitwh.fanghh.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.dao.DynamiccontentDao;
import hitwh.fanghh.pojo.Dynamiccontent;
import hitwh.fanghh.service.DynamiccontentService;
import hitwh.fanghh.util.PageCalculate;
import hitwh.fanghh.util.RandomUtil;

@Service
public class DynamiccontentServiceImpl implements DynamiccontentService
{

	@Autowired
	private DynamiccontentDao dynamiccontentDao;
	@Autowired
	private HttpSession session;

	@Override
	public List<Dynamiccontent> getAllDynamicContent()
	{
		return dynamiccontentDao.getAllDynamicContent();
	}

	@Override
	public Dynamiccontent getDynamiccontentByBdId(int dcId)
	{
		// TODO Auto-generated method stub
		return dynamiccontentDao.selectByPrimaryKey(dcId);
	}

	@Override
	public boolean addDynamiccontent(Dynamiccontent dynamiccontent)
	{

		saveDynamicContentToHTML(dynamiccontent);

		dynamiccontent.setCreateTime(new Date());

		int result = dynamiccontentDao.insertSelective(dynamiccontent);
		if (result == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDynamiccontent(int dcId)
	{
		// TODO Auto-generated method stub
		int result = dynamiccontentDao.deleteByPrimaryKey(dcId);
		if (result == 1)
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean updateDynamiccontent(Dynamiccontent dynamiccontent)
	{
		// TODO Auto-generated method stub
		Dynamiccontent original = getDynamiccontentByBdId(dynamiccontent.getDcId());
		
		saveDynamicContentToHTML(dynamiccontent);
		
		// 删除之前的文件
		String basePath = session.getServletContext().getRealPath("/");
		String path = basePath + original.getDcWriting();
		
		new File(path).delete();
		
		int result = dynamiccontentDao.updateByPrimaryKeySelective(dynamiccontent);
		if (result == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getDynamiccontentPageNum(int pageMaxNum, int bdiId)
	{
		if (pageMaxNum < 1)
		{
			pageMaxNum = 1;
		}
		int allNum = dynamiccontentDao.countByBdiId(bdiId);
		return allNum % pageMaxNum == 0 ? allNum / pageMaxNum : allNum / pageMaxNum + 1;
	}

	@Override
	public List<Dynamiccontent> getDynamicContentByBdiId(int bdiId, int pageMaxNum, int pageNo)
	{
		int pageNum = getDynamiccontentPageNum(pageMaxNum, bdiId);
		PageCalculate pageCalculate = new PageCalculate(pageNum, pageMaxNum, pageNo);
		return dynamiccontentDao.getDynamicContentByBdiId(bdiId, pageCalculate);
	}
	
	private void saveDynamicContentToHTML(Dynamiccontent dynamiccontent) {
		// 字段暂时用老的
		String title = dynamiccontent.getDcPic();
		String content = dynamiccontent.getDcWriting();
		
		String header = "<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content =\"text/html;charset=utf-8\"/><title>"
				+ title + "</title>";

		String html = header + content + "</html>";

		String basePath = session.getServletContext().getRealPath("/");
		String dirPath = "dynamic/";
		String path = basePath + dirPath;

		System.out.println("save dynamic file at " + path);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String filename = RandomUtil.getRandomEnAndNumString(32) + dateFormat.format(new Date()) + ".html";

		try
		{
			File file = new File(path + filename);
			file.getParentFile().mkdirs();
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(html);
			out.flush();
			out.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		// 更新保存的地址
		dynamiccontent.setDcWriting(dirPath + filename);
	}

}
