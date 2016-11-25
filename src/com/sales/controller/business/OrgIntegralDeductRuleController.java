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
import com.sales.model.business.OrgIntegralDeductRule;
import com.sales.service.business.OrgIntegralDeductRuleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OrganizationService;

import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/orgIntegralDeductRule")
public class OrgIntegralDeductRuleController extends BasicController {
	@Resource
	private OrgIntegralDeductRuleService orgIntegralDeductRuleService;
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("orgIntegralDeductRule") OrgIntegralDeductRule orgIntegralDeductRule,
			BindingResult br,Model model) {
		
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/orgIntegralDeductRule/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("orgIntegralDeductRule") OrgIntegralDeductRule orgIntegralDeductRule,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = orgIntegralDeductRuleService.selectList(orgIntegralDeductRule, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("orgIntegralDeductRule") OrgIntegralDeductRule orgIntegralDeductRule,
			BindingResult br,Model model) {
		
		OrgIntegralDeductRule newOrgIntegralDeductRule = new OrgIntegralDeductRule();
		
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newOrgIntegralDeductRule);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/orgIntegralDeductRule/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("orgIntegralDeductRule") OrgIntegralDeductRule orgIntegralDeductRule,
			BindingResult br,Model model) {
		
		orgIntegralDeductRule = orgIntegralDeductRuleService.selectByPrimaryKey(orgIntegralDeductRule.getId());
		if(orgIntegralDeductRule==null){
			throw new NoDataFoundException();
		}
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("orgIntegralDeductRule", orgIntegralDeductRule);
		model.addAttribute("mode", Const.editMode);
		return "/admin/orgIntegralDeductRule/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("orgIntegralDeductRule") OrgIntegralDeductRule orgIntegralDeductRule,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(orgIntegralDeductRule.getId()==null){
				orgIntegralDeductRuleService.insert(orgIntegralDeductRule);
			}else{
				orgIntegralDeductRuleService.updateByPrimaryKey(orgIntegralDeductRule);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(orgIntegralDeductRule);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("orgIntegralDeductRule") OrgIntegralDeductRule orgIntegralDeductRule,Model model) {
		orgIntegralDeductRule = orgIntegralDeductRuleService.selectByPrimaryKey(orgIntegralDeductRule.getId());
		if(orgIntegralDeductRule==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("orgIntegralDeductRule", orgIntegralDeductRule);
		return "/admin/orgIntegralDeductRule/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			orgIntegralDeductRuleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					orgIntegralDeductRuleService.deleteByPrimaryKey(id);
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
