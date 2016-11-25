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
import com.sales.model.business.DrpMatWarnRule;
import com.sales.service.business.DrpMatWarnRuleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.DrpBrandService;
import com.sales.service.business.DrpMatTypeService;

import com.sales.model.business.Organization;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.DrpMatType;

@Controller
@RequestMapping("/admin/drpMatWarnRule")
public class DrpMatWarnRuleController extends BasicController {
	@Resource
	private DrpMatWarnRuleService drpMatWarnRuleService;
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private DrpBrandService drpBrandService;	
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatWarnRule") DrpMatWarnRule drpMatWarnRule,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
	
		return "/admin/drpMatWarnRule/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatWarnRule") DrpMatWarnRule drpMatWarnRule,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatWarnRuleService.selectList(drpMatWarnRule, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatWarnRule") DrpMatWarnRule drpMatWarnRule,
			BindingResult br,Model model) {
		
		DrpMatWarnRule newDrpMatWarnRule = new DrpMatWarnRule();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		
		model.addAttribute("sysUser", newDrpMatWarnRule);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatWarnRule/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatWarnRule") DrpMatWarnRule drpMatWarnRule,
			BindingResult br,Model model) {
		
		drpMatWarnRule = drpMatWarnRuleService.selectByPrimaryKey(drpMatWarnRule.getId());
		if(drpMatWarnRule==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		model.addAttribute("drpMatWarnRule", drpMatWarnRule);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatWarnRule/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatWarnRule") DrpMatWarnRule drpMatWarnRule,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatWarnRule.getId()==null){
				drpMatWarnRuleService.insert(drpMatWarnRule);
			}else{
				drpMatWarnRuleService.updateByPrimaryKey(drpMatWarnRule);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatWarnRule);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatWarnRule") DrpMatWarnRule drpMatWarnRule,Model model) {
		drpMatWarnRule = drpMatWarnRuleService.selectByPrimaryKey(drpMatWarnRule.getId());
		if(drpMatWarnRule==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatWarnRule", drpMatWarnRule);
		return "/admin/drpMatWarnRule/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatWarnRuleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatWarnRuleService.deleteByPrimaryKey(id);
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
