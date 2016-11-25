package com.sales.controller.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.model.basic.Const;
import com.sales.model.basic.JsonObj;
import com.sales.model.business.SysModule;
import com.sales.service.util.TreeService;
import com.sales.util.common.CookieUtil;

@Controller
@RequestMapping("/admin/common/main")
public class MainController extends BasicController {
	
	@Resource
	private TreeService treeService;
	
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		SysModule param = new SysModule();
		param.setStatus(1L); 
		List<SysModule> rootModuleList =  treeService.getRootModuleList(param);
		model.addAttribute("rootModuleList", rootModuleList);
		
		return "/admin/common/main/index";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/logOut")
	public JsonObj logOut(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) {
		
		session.removeAttribute(Const.session_uid);
		session.removeAttribute(Const.session_user);
		
		CookieUtil.getInstance().delCookie(request, response, Const.cookie_uid);
		CookieUtil.getInstance().delCookie(request, response, Const.cookie_pwd);
		
		return new JsonObj(true);	  
	}
	
	@ResponseBody
	@RequestMapping(value = "/navTree")
	public List<SysModule> navTree(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("sysModule") SysModule sysModule) {
		SysModule param = new SysModule();
		param.setStatus(1L); 
		List<SysModule> list  = treeService.getSubSysModuleTreeList(sysModule.getId(), param);
		JsonObj  jsonObj = new JsonObj(true);
		jsonObj.setValue(list);
		return list;	  
	}
	
	
	
}
