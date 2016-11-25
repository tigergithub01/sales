package com.sales.util.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sales.controller.common.LoginController;
import com.sales.model.basic.Const;
import com.sales.model.business.SysUser;
import com.sales.service.business.SysUserService;
import com.sales.util.common.CommonUtils;
import com.sales.util.common.CookieUtil;

/**
 * 权限过滤
 * @author Tiger-guo
 * 2016年11月8日 上午9:32:32
 */
public class AuthInterceptor implements HandlerInterceptor {
	
	@Resource
	private SysUserService sysUserService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if(handler instanceof HandlerMethod){
			HandlerMethod method = (HandlerMethod)handler;  
			System.out.println(method.getBean().getClass().getSimpleName());
			System.out.println(method.getMethod().getName());
			System.out.println("preHandle");
			
			Long userId = CommonUtils.getInstance().getLoginUserid(request.getSession());
			if(userId==null){
				if(method.getBean().getClass().equals(LoginController.class)){
					
				}else{
					//判断是否为自动登陆
					String cookieUid = CookieUtil.getInstance().getCookieValue(request, Const.cookie_uid);
					String cookiePwd = CookieUtil.getInstance().getCookieValue(request, Const.cookie_pwd);
					if(!(StringUtils.isEmpty(cookieUid)) && !(StringUtils.isEmpty(cookiePwd))){
						//check login TODO:
						SysUser param  = new SysUser();
						param.setUserId(cookieUid);
						SysUser sysUserDB = sysUserService.selectBySelective(param);
						if(sysUserDB!=null && sysUserDB.getPassword().equals(cookiePwd)){
							request.getSession().setAttribute(Const.session_uid, sysUserDB.getId());
							request.getSession().setAttribute(Const.session_user, sysUserDB);
							//write rights TODO:
						}
												
						return true;
					}
					
					//判断是否为json请求
					if(CommonUtils.isAjax(request)){
						CommonUtils.getInstance().jsonFailed("请先登陆", 100);
						return false;
					}else{
						response.sendRedirect(request.getContextPath()+"/admin/common/login/index");
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURI());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}

	
}
