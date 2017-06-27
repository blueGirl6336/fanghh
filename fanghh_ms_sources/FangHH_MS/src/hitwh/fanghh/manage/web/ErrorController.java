package hitwh.fanghh.manage.web;

import hitwh.fanghh.manage.pojo.Dictionary;
import hitwh.fanghh.manage.service.DictionaryService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private ExtResponseJsonService responseService;

	// 404错误页面
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView erro404() {
		return new ModelAndView("/404.jsp");
	}

	// test
	@RequestMapping(value = "/dealDictionary", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> dealDictionary() {
		List<Dictionary> dList = this.dictionaryService
				.getItemsByGroupCode("2017000");
		List<Dictionary> subList = new ArrayList<Dictionary>();
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i).getDictCode().compareTo("2017018") > 0) {
				List<Dictionary> temp = this.dictionaryService
						.getItemsByGroupCode(dList.get(i).getDictCode());
				String oldCode = dList.get(i).getDictCode();
				int c = Integer.valueOf(oldCode);
				String newCode = String.valueOf(++c);
				subList.add(dList.get(i));
				dList.get(i).setDictCode(newCode);
				for (Dictionary d : temp) {
					d.setDictParentCode(newCode);
					subList.add(d);
				}
			}
		}
		for (Dictionary d : subList) {
			this.dictionaryService.update(d);
		}
		return this.responseService.responseSuccess("done");
	}

	// test
	@RequestMapping(value = "/reCodeSubUnit1", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> reCodeSubUnit1() {
		List<Dictionary> dList = this.dictionaryService
				.getItemsByGroupCode("2017000");
		List<Dictionary> subList = new ArrayList<Dictionary>();
		for (int i = 0; i < dList.size(); i++) {
			String parentCode = dList.get(i).getDictCode();
			// from 20
			if (parentCode.compareTo("2017019") > 0) {
				List<Dictionary> temp = this.dictionaryService
						.getItemsByGroupCode(parentCode);

				int c = Integer.valueOf(parentCode);
				String newParentCode = String.valueOf(++c);

				String dpCode = newParentCode.substring(4);
				int k = 1;
				String newCode = "29" + dpCode;
				for (Dictionary d : temp) {
					d.setDictParentCode(newParentCode);
					if (k >= 10) {
						newCode += k;
					} else
						newCode = newCode + "0" + k;
					k++;
					d.setDictCode(newCode);
					subList.add(d);
				}
			}
		}
		for (Dictionary d : subList) {
			this.dictionaryService.update(d);
		}
		return this.responseService.responseSuccess("done");
	}

	// test
	@RequestMapping(value = "/reCodeSubUnit2", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> reCodeSubUnit2() {
		List<Dictionary> dList = this.dictionaryService
				.getItemsByGroupCode("2017000");
		List<Dictionary> subList = new ArrayList<Dictionary>();
		int k = 1;
		for (int i = 0; i < dList.size(); i++) {
			String parentCode = dList.get(i).getDictCode();
			List<Dictionary> temp = this.dictionaryService
					.getItemsByGroupCode(parentCode);

			String dpCode = parentCode.substring(4);
			String newCode = "29" + dpCode;
			for (Dictionary d : temp) {
				newCode = "29" + dpCode;
				d.setDictParentCode(parentCode);
				if (k >= 10) {
					newCode += k;
				} else
					newCode = newCode + "0" + k;
				k++;
				d.setDictCode(newCode);
				subList.add(d);
			}
		}
		for (Dictionary d : subList) {
			this.dictionaryService.update(d);
		}
		return this.responseService.responseSuccess("done");
	}

	// test
	@RequestMapping(value = "/makeUpSubUnit", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> makeUpSubUnit() {
		List<Dictionary> dList = this.dictionaryService
				.getItemsByGroupCode("2017000");
		List<Dictionary> subList = new ArrayList<Dictionary>();
		
		for (int i = 0; i < dList.size(); i++) {
			int k = 1;
			String parentCode = dList.get(i).getDictCode();
			List<Dictionary> temp = this.dictionaryService
					.getItemsByGroupCode(parentCode);

			String dpCode = parentCode.substring(4);
			String newCode = "29" + dpCode;
			for (Dictionary d : temp) {
				newCode = "29" + dpCode;
				if (k >= 10) {
					newCode += k;
				} else
					newCode = newCode + "0" + k;
				k++;
				d.setDictCode(newCode);
				subList.add(d);
			}
		}
		for (Dictionary d : subList) {
			this.dictionaryService.update(d);
		}
		return this.responseService.responseSuccess("done");
	}
}
