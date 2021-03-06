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
import com.sales.model.business.DrpCommissionRule;
import com.sales.service.business.DrpCommissionRuleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMatTypeService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.DrpBrandService;

import com.sales.model.business.DrpMatType;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpBrand;

@Controller
@RequestMapping("/admin/drpCommissionRule")
public class DrpCommissionRuleController extends BasicController {
	@Resource
	private DrpCommissionRuleService drpCommissionRuleService;
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private DrpBrandService drpBrandService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpCommissionRule") DrpCommissionRule drpCommissionRule,
			BindingResult br,Model model) {
		
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
	
		return "/admin/drpCommissionRule/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpCommissionRule") DrpCommissionRule drpCommissionRule,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpCommissionRuleService.selectList(drpCommissionRule, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpCommissionRule") DrpCommissionRule drpCommissionRule,
			BindingResult br,Model model) {
		
		DrpCommissionRule newDrpCommissionRule = new DrpCommissionRule();
		
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		
		model.addAttribute("sysUser", newDrpCommissionRule);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpCommissionRule/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpCommissionRule") DrpCommissionRule drpCommissionRule,
			BindingResult br,Model model) {
		
		drpCommissionRule = drpCommissionRuleService.selectByPrimaryKey(drpCommissionRule.getId());
		if(drpCommissionRule==null){
			throw new NoDataFoundException();
		}
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		model.addAttribute("drpCommissionRule", drpCommissionRule);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpCommissionRule/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpCommissionRule") DrpCommissionRule drpCommissionRule,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpCommissionRule.getId()==null){
				drpCommissionRuleService.insert(drpCommissionRule);
			}else{
				drpCommissionRuleService.updateByPrimaryKey(drpCommissionRule);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpCommissionRule);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpCommissionRule") DrpCommissionRule drpCommissionRule,Model model) {
		drpCommissionRule = drpCommissionRuleService.selectByPrimaryKey(drpCommissionRule.getId());
		if(drpCommissionRule==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpCommissionRule", drpCommissionRule);
		return "/admin/drpCommissionRule/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpCommissionRuleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpCommissionRuleService.deleteByPrimaryKey(id);
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
