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
import com.sales.model.business.OrgActAuth;
import com.sales.service.business.OrgActAuthService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.SysUser;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/orgActAuth")
public class OrgActAuthController extends BasicController {
	@Resource
	private OrgActAuthService orgActAuthService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("orgActAuth") OrgActAuth orgActAuth,
			BindingResult br,Model model) {
		
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
	
		return "/admin/orgActAuth/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("orgActAuth") OrgActAuth orgActAuth,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = orgActAuthService.selectList(orgActAuth, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("orgActAuth") OrgActAuth orgActAuth,
			BindingResult br,Model model) {
		
		OrgActAuth newOrgActAuth = new OrgActAuth();
		
		newOrgActAuth.setCreateDate(new java.util.Date());
		newOrgActAuth.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newOrgActAuth.setUpdateDate(new java.util.Date());
		newOrgActAuth.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		
		model.addAttribute("sysUser", newOrgActAuth);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/orgActAuth/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("orgActAuth") OrgActAuth orgActAuth,
			BindingResult br,Model model) {
		
		orgActAuth = orgActAuthService.selectByPrimaryKey(orgActAuth.getId());
		if(orgActAuth==null){
			throw new NoDataFoundException();
		}
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		model.addAttribute("orgActAuth", orgActAuth);
		model.addAttribute("mode", Const.editMode);
		return "/admin/orgActAuth/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("orgActAuth") OrgActAuth orgActAuth,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(orgActAuth.getId()==null){
				orgActAuth.setCreateDate(new java.util.Date());
				orgActAuth.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				orgActAuth.setUpdateDate(new java.util.Date());
				orgActAuth.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				orgActAuthService.insert(orgActAuth);
			}else{
				orgActAuth.setUpdateDate(new java.util.Date());
				orgActAuth.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				orgActAuthService.updateByPrimaryKey(orgActAuth);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(orgActAuth);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("orgActAuth") OrgActAuth orgActAuth,Model model) {
		orgActAuth = orgActAuthService.selectByPrimaryKey(orgActAuth.getId());
		if(orgActAuth==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("orgActAuth", orgActAuth);
		return "/admin/orgActAuth/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			orgActAuthService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					orgActAuthService.deleteByPrimaryKey(id);
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
