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
import com.sales.model.business.DrpInvCheckScheme;
import com.sales.service.business.DrpInvCheckSchemeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysParameter;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/drpInvCheckScheme")
public class DrpInvCheckSchemeController extends BasicController {
	@Resource
	private DrpInvCheckSchemeService drpInvCheckSchemeService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpInvCheckScheme") DrpInvCheckScheme drpInvCheckScheme,
			BindingResult br,Model model) {
		
		List<SysParameter> checkExtendList= sysParameterService.selectList(null); 
		model.addAttribute("checkExtendList", checkExtendList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysParameter> checkStatusList= sysParameterService.selectList(null); 
		model.addAttribute("checkStatusList", checkStatusList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/drpInvCheckScheme/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpInvCheckScheme") DrpInvCheckScheme drpInvCheckScheme,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpInvCheckSchemeService.selectList(drpInvCheckScheme, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpInvCheckScheme") DrpInvCheckScheme drpInvCheckScheme,
			BindingResult br,Model model) {
		
		DrpInvCheckScheme newDrpInvCheckScheme = new DrpInvCheckScheme();
		
		newDrpInvCheckScheme.setCreateDate(new java.util.Date());
		newDrpInvCheckScheme.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newDrpInvCheckScheme.setUpdateDate(new java.util.Date());
		newDrpInvCheckScheme.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<SysParameter> checkExtendList= sysParameterService.selectList(null); 
		model.addAttribute("checkExtendList", checkExtendList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysParameter> checkStatusList= sysParameterService.selectList(null); 
		model.addAttribute("checkStatusList", checkStatusList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newDrpInvCheckScheme);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpInvCheckScheme/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpInvCheckScheme") DrpInvCheckScheme drpInvCheckScheme,
			BindingResult br,Model model) {
		
		drpInvCheckScheme = drpInvCheckSchemeService.selectByPrimaryKey(drpInvCheckScheme.getId());
		if(drpInvCheckScheme==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> checkExtendList= sysParameterService.selectList(null); 
		model.addAttribute("checkExtendList", checkExtendList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysParameter> checkStatusList= sysParameterService.selectList(null); 
		model.addAttribute("checkStatusList", checkStatusList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("drpInvCheckScheme", drpInvCheckScheme);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpInvCheckScheme/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpInvCheckScheme") DrpInvCheckScheme drpInvCheckScheme,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpInvCheckScheme.getId()==null){
				drpInvCheckScheme.setCreateDate(new java.util.Date());
				drpInvCheckScheme.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				drpInvCheckScheme.setUpdateDate(new java.util.Date());
				drpInvCheckScheme.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpInvCheckSchemeService.insert(drpInvCheckScheme);
			}else{
				drpInvCheckScheme.setUpdateDate(new java.util.Date());
				drpInvCheckScheme.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpInvCheckSchemeService.updateByPrimaryKey(drpInvCheckScheme);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpInvCheckScheme);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpInvCheckScheme") DrpInvCheckScheme drpInvCheckScheme,Model model) {
		drpInvCheckScheme = drpInvCheckSchemeService.selectByPrimaryKey(drpInvCheckScheme.getId());
		if(drpInvCheckScheme==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpInvCheckScheme", drpInvCheckScheme);
		return "/admin/drpInvCheckScheme/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpInvCheckSchemeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpInvCheckSchemeService.deleteByPrimaryKey(id);
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
