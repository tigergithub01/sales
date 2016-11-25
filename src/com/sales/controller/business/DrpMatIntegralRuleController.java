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
import com.sales.model.business.DrpMatIntegralRule;
import com.sales.service.business.DrpMatIntegralRuleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMatTypeService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.DrpMatType;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/drpMatIntegralRule")
public class DrpMatIntegralRuleController extends BasicController {
	@Resource
	private DrpMatIntegralRuleService drpMatIntegralRuleService;
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatIntegralRule") DrpMatIntegralRule drpMatIntegralRule,
			BindingResult br,Model model) {
		
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/drpMatIntegralRule/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatIntegralRule") DrpMatIntegralRule drpMatIntegralRule,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatIntegralRuleService.selectList(drpMatIntegralRule, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatIntegralRule") DrpMatIntegralRule drpMatIntegralRule,
			BindingResult br,Model model) {
		
		DrpMatIntegralRule newDrpMatIntegralRule = new DrpMatIntegralRule();
		
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newDrpMatIntegralRule);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatIntegralRule/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatIntegralRule") DrpMatIntegralRule drpMatIntegralRule,
			BindingResult br,Model model) {
		
		drpMatIntegralRule = drpMatIntegralRuleService.selectByPrimaryKey(drpMatIntegralRule.getId());
		if(drpMatIntegralRule==null){
			throw new NoDataFoundException();
		}
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("drpMatIntegralRule", drpMatIntegralRule);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatIntegralRule/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatIntegralRule") DrpMatIntegralRule drpMatIntegralRule,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatIntegralRule.getId()==null){
				drpMatIntegralRuleService.insert(drpMatIntegralRule);
			}else{
				drpMatIntegralRuleService.updateByPrimaryKey(drpMatIntegralRule);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatIntegralRule);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatIntegralRule") DrpMatIntegralRule drpMatIntegralRule,Model model) {
		drpMatIntegralRule = drpMatIntegralRuleService.selectByPrimaryKey(drpMatIntegralRule.getId());
		if(drpMatIntegralRule==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatIntegralRule", drpMatIntegralRule);
		return "/admin/drpMatIntegralRule/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatIntegralRuleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatIntegralRuleService.deleteByPrimaryKey(id);
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
