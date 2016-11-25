package com.sales.controller.business;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.controller.common.BasicController;
import com.sales.model.basic.JsonObj;
import com.sales.model.basic.ValidErrObj;
import com.sales.model.basic.Const;
import com.sales.model.basic.Param;
import com.sales.model.business.OrgDepositAuth;
import com.sales.service.business.OrgDepositAuthService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.SysUser;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/orgDepositAuth")
public class OrgDepositAuthController extends BasicController {
	@Resource
	private OrgDepositAuthService orgDepositAuthService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("orgDepositAuth") OrgDepositAuth orgDepositAuth,
			BindingResult br,Model model) {
		
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
	
		return "/admin/orgDepositAuth/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("orgDepositAuth") OrgDepositAuth orgDepositAuth,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = orgDepositAuthService.selectList(orgDepositAuth, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("orgDepositAuth") OrgDepositAuth orgDepositAuth,
			BindingResult br,Model model) {
		
		OrgDepositAuth newOrgDepositAuth = new OrgDepositAuth();
		
		newOrgDepositAuth.setCreateDate(new java.util.Date());
		newOrgDepositAuth.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newOrgDepositAuth.setUpdateDate(new java.util.Date());
		newOrgDepositAuth.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		
		model.addAttribute("sysUser", newOrgDepositAuth);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/orgDepositAuth/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("orgDepositAuth") OrgDepositAuth orgDepositAuth,
			BindingResult br,Model model) {
		
		orgDepositAuth = orgDepositAuthService.selectByPrimaryKey(orgDepositAuth.getId());
		if(orgDepositAuth==null){
			throw new NoDataFoundException();
		}
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		model.addAttribute("orgDepositAuth", orgDepositAuth);
		model.addAttribute("mode", Const.editMode);
		return "/admin/orgDepositAuth/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("orgDepositAuth") OrgDepositAuth orgDepositAuth,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(orgDepositAuth.getId()==null){
				orgDepositAuth.setCreateDate(new java.util.Date());
				orgDepositAuth.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				orgDepositAuth.setUpdateDate(new java.util.Date());
				orgDepositAuth.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				orgDepositAuthService.insert(orgDepositAuth);
			}else{
				orgDepositAuth.setUpdateDate(new java.util.Date());
				orgDepositAuth.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				orgDepositAuthService.updateByPrimaryKey(orgDepositAuth);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(orgDepositAuth);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("orgDepositAuth") OrgDepositAuth orgDepositAuth,Model model) {
		orgDepositAuth = orgDepositAuthService.selectByPrimaryKey(orgDepositAuth.getId());
		if(orgDepositAuth==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("orgDepositAuth", orgDepositAuth);
		return "/admin/orgDepositAuth/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			orgDepositAuthService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					orgDepositAuthService.deleteByPrimaryKey(id);
				}
			}else{
				jsonObj.setStatus(false);
				jsonObj.setMessage("请选择需要删除的数据！");
				return jsonObj;
			}
		}
		return jsonObj;
	}
}
