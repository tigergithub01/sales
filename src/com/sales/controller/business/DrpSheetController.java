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
import com.sales.model.business.DrpSheet;
import com.sales.service.business.DrpSheetService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysShippingTypeService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.DrpInvCheckSchemeService;
import com.sales.service.business.DrpSheetTypeService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysShippingType;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpInvCheckScheme;
import com.sales.model.business.DrpSheetType;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/drpSheet")
public class DrpSheetController extends BasicController {
	@Resource
	private DrpSheetService drpSheetService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysShippingTypeService sysShippingTypeService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private DrpInvCheckSchemeService drpInvCheckSchemeService;	
	
	@Resource
	private DrpSheetTypeService drpSheetTypeService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpSheet") DrpSheet drpSheet,
			BindingResult br,Model model) {
		
		List<DrpSheetType> sheetTypeList= drpSheetTypeService.selectList(null); 
		model.addAttribute("sheetTypeList", sheetTypeList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysUser> auditUserIdList= sysUserService.selectList(null); 
		model.addAttribute("auditUserIdList", auditUserIdList);
			
		List<DrpInvCheckScheme> invSchemeIdList= drpInvCheckSchemeService.selectList(null); 
		model.addAttribute("invSchemeIdList", invSchemeIdList);
			
		List<SysParameter> payStatusList= sysParameterService.selectList(null); 
		model.addAttribute("payStatusList", payStatusList);
			
		List<SysParameter> shippingStatusList= sysParameterService.selectList(null); 
		model.addAttribute("shippingStatusList", shippingStatusList);
			
		List<SysShippingType> shippingIdList= sysShippingTypeService.selectList(null); 
		model.addAttribute("shippingIdList", shippingIdList);
			
	
		return "/admin/drpSheet/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpSheet") DrpSheet drpSheet,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpSheetService.selectList(drpSheet, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpSheet") DrpSheet drpSheet,
			BindingResult br,Model model) {
		
		DrpSheet newDrpSheet = new DrpSheet();
		
		newDrpSheet.setCreateDate(new java.util.Date());
		newDrpSheet.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newDrpSheet.setUpdateDate(new java.util.Date());
		newDrpSheet.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<DrpSheetType> sheetTypeList= drpSheetTypeService.selectList(null); 
		model.addAttribute("sheetTypeList", sheetTypeList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysUser> auditUserIdList= sysUserService.selectList(null); 
		model.addAttribute("auditUserIdList", auditUserIdList);
			
		List<DrpInvCheckScheme> invSchemeIdList= drpInvCheckSchemeService.selectList(null); 
		model.addAttribute("invSchemeIdList", invSchemeIdList);
			
		List<SysParameter> payStatusList= sysParameterService.selectList(null); 
		model.addAttribute("payStatusList", payStatusList);
			
		List<SysParameter> shippingStatusList= sysParameterService.selectList(null); 
		model.addAttribute("shippingStatusList", shippingStatusList);
			
		List<SysShippingType> shippingIdList= sysShippingTypeService.selectList(null); 
		model.addAttribute("shippingIdList", shippingIdList);
			
		
		model.addAttribute("sysUser", newDrpSheet);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpSheet/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpSheet") DrpSheet drpSheet,
			BindingResult br,Model model) {
		
		drpSheet = drpSheetService.selectByPrimaryKey(drpSheet.getId());
		if(drpSheet==null){
			throw new NoDataFoundException();
		}
		List<DrpSheetType> sheetTypeList= drpSheetTypeService.selectList(null); 
		model.addAttribute("sheetTypeList", sheetTypeList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysUser> auditUserIdList= sysUserService.selectList(null); 
		model.addAttribute("auditUserIdList", auditUserIdList);
			
		List<DrpInvCheckScheme> invSchemeIdList= drpInvCheckSchemeService.selectList(null); 
		model.addAttribute("invSchemeIdList", invSchemeIdList);
			
		List<SysParameter> payStatusList= sysParameterService.selectList(null); 
		model.addAttribute("payStatusList", payStatusList);
			
		List<SysParameter> shippingStatusList= sysParameterService.selectList(null); 
		model.addAttribute("shippingStatusList", shippingStatusList);
			
		List<SysShippingType> shippingIdList= sysShippingTypeService.selectList(null); 
		model.addAttribute("shippingIdList", shippingIdList);
			
		model.addAttribute("drpSheet", drpSheet);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpSheet/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpSheet") DrpSheet drpSheet,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpSheet.getId()==null){
				drpSheet.setCreateDate(new java.util.Date());
				drpSheet.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				drpSheet.setUpdateDate(new java.util.Date());
				drpSheet.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpSheetService.insert(drpSheet);
			}else{
				drpSheet.setUpdateDate(new java.util.Date());
				drpSheet.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpSheetService.updateByPrimaryKey(drpSheet);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpSheet);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpSheet") DrpSheet drpSheet,Model model) {
		drpSheet = drpSheetService.selectByPrimaryKey(drpSheet.getId());
		if(drpSheet==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpSheet", drpSheet);
		return "/admin/drpSheet/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpSheetService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpSheetService.deleteByPrimaryKey(id);
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
