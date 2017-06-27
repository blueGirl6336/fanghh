package hitwh.fanghh.manage.web;

import hitwh.fanghh.manage.ext.bean.TreeNode;
import hitwh.fanghh.manage.pojo.Module;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.service.ModuleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 获取模块，及对模块的管理
 * 
 * @author Jiang Shuqi
 * @Date 2013-7-15
 */
@Controller
@RequestMapping(value = "/manage")
@SessionAttributes({"user"})
public class ManageController {

	@Autowired
	private ModuleService moduleService;


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView goIndex(ModelMap modelMap) {
		if(modelMap.get("user") == null){
			return new ModelAndView("redirect:/index");
		}
		ModelAndView view = new ModelAndView("/manage/index.jsp");
		
		return view;
	}

	// 获取模块树
	@RequestMapping(value = "/module/getMenu", method = RequestMethod.GET)
	@ResponseBody
	public TreeNode getAllModule(@ModelAttribute User user) {
		
		if(user.getRole() != null){
			List<Module> mList = this.moduleService.getByRole(user.getRole(), 1, 5);
			TreeNode tr = this.moduleService.generateTree(mList, -1);
			return tr;
		}
		return new TreeNode("null", 0);
	}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,  ModelMap modelMap) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		modelMap.clear();
		ModelAndView view = new ModelAndView("redirect:/index");
		return view;
	}
	
}
