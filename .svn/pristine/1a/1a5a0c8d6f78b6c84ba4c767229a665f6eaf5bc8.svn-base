package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.ShareBackService;
import hitwh.fanghh.manage.module.base.service.ShareContentService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.ShareContent;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/shareContent")
@SessionAttributes({ "user" })
public class ShareContentController {
	@Autowired
	private ShareContentService shareContentService;
	@Autowired
	private ExtResponseJsonService responseService;
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<ShareContent> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.shareContentService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<ShareContent> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.shareContentService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<ShareContent> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.shareContentService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
