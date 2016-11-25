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
import com.sales.model.business.ActRuleExtend;
import com.sales.service.business.ActRuleExtendService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.ActRuleService;

import com.sales.model.business.DrpMaterial;
import com.sales.model.business.ActRule;

@Controller
@RequestMapping("/admin/actRuleExtend")
public class ActRuleExtendController extends BasicController {
	@Resource
	private ActRuleExtendService actRuleExtendService;
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private ActRuleService actRuleService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("actRuleExtend") ActRuleExtend actRuleExtend,
			BindingResult br,Model model) {
		
		List<ActRule> ruleIdList= actRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
	
		return "/admin/actRuleExtend/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("actRuleExtend") ActRuleExtend actRuleExtend,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = actRuleExtendService.selectList(actRuleExtend, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("actRuleExtend") ActRuleExtend actRuleExtend,
			BindingResult br,Model model) {
		
		ActRuleExtend newActRuleExtend = new ActRuleExtend();
		
			
		List<ActRule> ruleIdList= actRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		
		model.addAttribute("sysUser", newActRuleExtend);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/actRuleExtend/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("actRuleExtend") ActRuleExtend actRuleExtend,
			BindingResult br,Model model) {
		
		actRuleExtend = actRuleExtendService.selectByPrimaryKey(actRuleExtend.getId());
		if(actRuleExtend==null){
			throw new NoDataFoundException();
		}
		List<ActRule> ruleIdList= actRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		model.addAttribute("actRuleExtend", actRuleExtend);
		model.addAttribute("mode", Const.editMode);
		return "/admin/actRuleExtend/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("actRuleExtend") ActRuleExtend actRuleExtend,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(actRuleExtend.getId()==null){
				actRuleExtendService.insert(actRuleExtend);
			}else{
				actRuleExtendService.updateByPrimaryKey(actRuleExtend);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(actRuleExtend);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("actRuleExtend") ActRuleExtend actRuleExtend,Model model) {
		actRuleExtend = actRuleExtendService.selectByPrimaryKey(actRuleExtend.getId());
		if(actRuleExtend==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("actRuleExtend", actRuleExtend);
		return "/admin/actRuleExtend/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			actRuleExtendService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					actRuleExtendService.deleteByPrimaryKey(id);
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
