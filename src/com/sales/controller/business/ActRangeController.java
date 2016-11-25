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
import com.sales.model.business.ActRange;
import com.sales.service.business.ActRangeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMatTypeService;
import com.sales.service.business.ActRuleService;
import com.sales.service.business.DrpBrandService;
import com.sales.service.business.ActivityService;
import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.DrpMatType;
import com.sales.model.business.ActRule;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.Activity;
import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/actRange")
public class ActRangeController extends BasicController {
	@Resource
	private ActRangeService actRangeService;
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	@Resource
	private ActRuleService actRuleService;	
	
	@Resource
	private DrpBrandService drpBrandService;	
	
	@Resource
	private ActivityService activityService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("actRange") ActRange actRange,
			BindingResult br,Model model) {
		
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<ActRule> ruleIdList= actRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
	
		return "/admin/actRange/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("actRange") ActRange actRange,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = actRangeService.selectList(actRange, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("actRange") ActRange actRange,
			BindingResult br,Model model) {
		
		ActRange newActRange = new ActRange();
		
			
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<ActRule> ruleIdList= actRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		
		model.addAttribute("sysUser", newActRange);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/actRange/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("actRange") ActRange actRange,
			BindingResult br,Model model) {
		
		actRange = actRangeService.selectByPrimaryKey(actRange.getId());
		if(actRange==null){
			throw new NoDataFoundException();
		}
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<ActRule> ruleIdList= actRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		model.addAttribute("actRange", actRange);
		model.addAttribute("mode", Const.editMode);
		return "/admin/actRange/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("actRange") ActRange actRange,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(actRange.getId()==null){
				actRangeService.insert(actRange);
			}else{
				actRangeService.updateByPrimaryKey(actRange);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(actRange);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("actRange") ActRange actRange,Model model) {
		actRange = actRangeService.selectByPrimaryKey(actRange.getId());
		if(actRange==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("actRange", actRange);
		return "/admin/actRange/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			actRangeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					actRangeService.deleteByPrimaryKey(id);
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
