package com.sales.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.model.basic.Const;
import com.sales.model.basic.JsonObj;
import com.sales.model.business.SysUser;
import com.sales.service.business.SysUserService;
import com.sales.util.common.CommonUtils;
import com.sales.util.common.CookieUtil;
import com.sales.util.common.MD5Util;

@Controller
@RequestMapping("/admin/common/login")
public class LoginController {
	
	@Resource
	private SysUserService sysUserService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br,Model model) {
		sysUser.setRememberMe(true);
		return "/admin/common/login/index";
	} 
	
	
	@ResponseBody
	@RequestMapping(value = "/ajaxSubmit")
	public JsonObj ajaxSubmit(HttpServletRequest request,
			HttpServletResponse response,HttpSession session, @ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br) {
		if(StringUtils.isEmpty(sysUser.getUserId())){
			return CommonUtils.getInstance().failed("用户名不能为空！");
		}
		
		if(StringUtils.isEmpty(sysUser.getPassword())){
			return CommonUtils.getInstance().failed("密码不能为空！");
		}
		
		SysUser param  = new SysUser();
		param.setUserId(sysUser.getUserId());
		SysUser sysUserDB = sysUserService.selectBySelective(param);
		if(sysUserDB==null){
			return CommonUtils.getInstance().failed("用户不存在！");
		}			
		
		if(!(sysUserDB.getPassword().equals(MD5Util.MD5(sysUser.getPassword())))){
			return CommonUtils.getInstance().failed("密码不正确！");
		}
		
		//写session
		session.setAttribute(Const.session_uid, sysUserDB.getId());
		session.setAttribute(Const.session_user, sysUserDB);
		
		//write rights TODO:
		
		//更新cookie
		if(sysUser.isRememberMe()){
			CookieUtil.getInstance().addCookie(response, Const.cookie_uid, sysUserDB.getUserId());
			CookieUtil.getInstance().addCookie(response, Const.cookie_pwd, sysUserDB.getPassword());
		}else{
			CookieUtil.getInstance().delCookie(request, response, Const.cookie_uid);
			CookieUtil.getInstance().delCookie(request, response, Const.cookie_pwd);
		}
		
		return CommonUtils.getInstance().success();	  
	}
	
	
}
