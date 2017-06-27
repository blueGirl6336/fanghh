package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.ActivityService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Activity;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "manage/activity")
@SessionAttributes({ "user" })
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索分享返现规则
	 * @param buildingName
	 * @param activityName
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String buildingName, 
			@RequestParam String activityName)
	{
		List<Activity> pList = new ArrayList<Activity>();
		StringBuilder hql = new StringBuilder("select a from Activity as a,Building as b " +
				"where a.buildingId=b.buildingId ");
		if(buildingName != null && buildingName.length() > 0)
		{
			hql.append(" and b.buildingName like '%" + buildingName + "%'");
		}
		if(activityName != null && activityName.length()>0)
		{
			hql.append(" and a.activityName like '%" + activityName+"%'" );
		}
		pList = this.activityService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 获取所有分享返现规则信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Activity> list = 
				this.activityService.getAll();
		return responseService.responseListMap(list);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam String activityName,@RequestParam String picture,
			@RequestParam String url,@RequestParam Integer buildingId,@RequestParam Double totalCash,
			@RequestParam Integer totalTimes,@RequestParam Integer limitTimes,
			@RequestParam String startDate,@RequestParam String endDate,@RequestParam Integer currentTimes,
			@RequestParam double leftCash,@RequestParam String state) {
		Activity activity = new Activity();
		activity.setActivityName(activityName);
		activity.setPicture(picture);
		activity.setUrl(url);
		activity.setBuildingId(buildingId);
		activity.setTotalCash(totalCash);
		activity.setTotalTimes(totalTimes);
		activity.setLimitTimes(limitTimes);
		activity.setCurrentTimes(currentTimes);
		activity.setStartDate(startDate);
		activity.setEndDate(endDate);
		activity.setLeftCash(leftCash);
		activity.setState(state);
		this.activityService.add(activity);
		return this.responseService.responseSuccess("添加成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestParam Integer activityId,@RequestParam String activityName,@RequestParam String picture,
			@RequestParam String url,@RequestParam Integer buildingId,@RequestParam Double totalCash,
			@RequestParam Integer totalTimes,@RequestParam Integer limitTimes,
			@RequestParam String startDate,@RequestParam String endDate,@RequestParam Integer currentTimes,
			@RequestParam double leftCash,@RequestParam String state) {
		Activity activity = new Activity();
		activity.setActivityId(activityId);
		activity.setActivityName(activityName);
		activity.setPicture(picture);
		activity.setUrl(url);
		activity.setBuildingId(buildingId);
		activity.setTotalCash(totalCash);
		activity.setTotalTimes(totalTimes);
		activity.setLimitTimes(limitTimes);
		activity.setCurrentTimes(currentTimes);
		activity.setStartDate(startDate);
		activity.setEndDate(endDate);
		activity.setLeftCash(leftCash);
		activity.setState(state);
		this.activityService.update(activity);
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Activity> list,HttpServletRequest request) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.activityService.delete(list.get(i));
			
			//删除照片文件
			String [] parts = list.get(i).getPicture().split("/");
			String path = request.getSession().getServletContext().getRealPath("upload");
			String fileName = parts[parts.length-1];
			File file = new File(path,fileName);
			if(file.exists())
				file.delete();
		}
		return this.responseService.responseSuccess("删除成功");
	}
		// 上传图片
		@RequestMapping(value = "/upload", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> upload(@RequestParam MultipartFile file,@RequestParam Integer activityId,HttpServletRequest request) {
			
			System.out.println("开始");
			String path = "F:\\images\\Activity";
			System.out.println(path);
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			String [] parts = fileName.split("\\.");
			System.out.println(parts.length);
			String newFileName = activityId  + "." + parts[1];
			System.out.println(path);
			File targetFile = new File(path,newFileName);
			if(!targetFile.exists())
			{
				targetFile.mkdirs();
				
			}
			try{
				file.transferTo(targetFile);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
					+"/img/Activity/"+newFileName;
			Activity activity = this.activityService.getById(activityId);
			activity.setPicture(url);
			this.activityService.update(activity);
			return this.responseService.responseSuccess("上传成功");
		}
	
}
