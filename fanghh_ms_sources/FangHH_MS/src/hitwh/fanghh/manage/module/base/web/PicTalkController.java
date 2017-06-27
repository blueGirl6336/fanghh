package hitwh.fanghh.manage.module.base.web;

import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.PicTalkService;
import hitwh.fanghh.manage.module.base.service.PropertyService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.PicTalk;
import hitwh.fanghh.manage.pojo.building.Property;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/picTalk")
@SessionAttributes({ "user" })
public class PicTalkController {
	@Autowired
	private PicTalkService picTalkService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<PicTalk> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.picTalkService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<PicTalk> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.picTalkService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<PicTalk> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.picTalkService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
