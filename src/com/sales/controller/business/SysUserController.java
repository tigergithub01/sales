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
import com.sales.model.business.SysUser;
import com.sales.service.business.SysUserService;
import com.sales.util.common.CommonUtils;
import com.sales.util.common.MD5Util;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/sysUser")
public class SysUserController extends BasicController {
	@Resource
	private SysUserService sysUserService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br,Model model) {
		
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysParameter> userTypeList= sysParameterService.selectList(null); 
		model.addAttribute("userTypeList", userTypeList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> empStatusList= sysParameterService.selectList(null); 
		model.addAttribute("empStatusList", empStatusList);
			
	
		return "/admin/sysUser/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysUserService.selectList(sysUser, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br,Model model) {
		
		SysUser newSysUser = new SysUser();
		
		newSysUser.setCreateDate(new java.util.Date());
		newSysUser.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newSysUser.setUpdateDate(new java.util.Date());
		newSysUser.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysParameter> userTypeList= sysParameterService.selectList(null); 
		model.addAttribute("userTypeList", userTypeList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> empStatusList= sysParameterService.selectList(null); 
		model.addAttribute("empStatusList", empStatusList);
			
		
		model.addAttribute("sysUser", newSysUser);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysUser/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br,Model model) {
		
		sysUser = sysUserService.selectByPrimaryKey(sysUser.getId());
		if(sysUser==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysParameter> userTypeList= sysParameterService.selectList(null); 
		model.addAttribute("userTypeList", userTypeList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> empStatusList= sysParameterService.selectList(null); 
		model.addAttribute("empStatusList", empStatusList);
			
		model.addAttribute("sysUser", sysUser);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysUser/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysUser") SysUser sysUser,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysUser.getId()==null){
				sysUser.setCreateDate(new java.util.Date());
				sysUser.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				sysUser.setUpdateDate(new java.util.Date());
				sysUser.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				sysUser.setPassword(MD5Util.MD5(sysUser.getPassword()));
				sysUserService.insert(sysUser);
			}else{
				sysUser.setPassword(MD5Util.MD5(sysUser.getPassword()));
				sysUser.setUpdateDate(new java.util.Date());
				sysUser.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				sysUserService.updateByPrimaryKey(sysUser);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysUser);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysUser") SysUser sysUser,Model model) {
		sysUser = sysUserService.selectByPrimaryKey(sysUser.getId());
		if(sysUser==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysUser", sysUser);
		return "/admin/sysUser/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysUserService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysUserService.deleteByPrimaryKey(id);
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
