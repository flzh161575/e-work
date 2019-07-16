package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.prototype.IAccountDao;
import entity.Account;

/**
 * 账户控制器
 * 规约大于配置：约定好的规则，大家都明白
 * @author RanJi
 *
 */
@Controller
@RequestMapping("/act")
public class ActController {
	@Autowired
	private IAccountDao actDao;
	
	@RequestMapping("/toadd")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("account/add");
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(Account act){
		ModelAndView mv = new ModelAndView();
		try {
			actDao.saveOrUpdate(act);
			mv.setViewName("account/addSuccess");
		} catch (Exception e) {
			mv.setViewName("account/addfailure");
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/add2",method=RequestMethod.POST)
	@ResponseBody
	public String add2(Account act){
		String result = "";
		try {
			actDao.saveOrUpdate(act);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}
	
	public void update(){}
	
	public void delete(){}
}
