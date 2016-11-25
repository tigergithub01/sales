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
import com.sales.model.business.ActRule;
import com.sales.service.business.ActRuleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.ActivityService;
import com.sales.service.business.SysParameterService;

import com.sales.model.business.Activity;
import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/actRule")
public class ActRuleController extends BasicController {
	@Resource
	private ActRuleService actRuleService;
	
	@Resource
	private ActivityService activityService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("actRule") ActRule actRule,
			BindingResult br,Model model) {
		
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<SysParameter> isDoubleGiveList= sysParameterService.selectList(null); 
		model.addAttribute("isDoubleGiveList", isDoubleGiveList);
			
		List<SysParameter> isAutoAddList= sysParameterService.selectList(null); 
		model.addAttribute("isAutoAddList", isAutoAddList);
			
	
		return "/admin/actRule/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("actRule") ActRule actRule,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = actRuleService.selectList(actRule, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("actRule") ActRule actRule,
			BindingResult br,Model model) {
		
		ActRule newActRule = new ActRule();
		
			
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<SysParameter> isDoubleGiveList= sysParameterService.selectList(null); 
		model.addAttribute("isDoubleGiveList", isDoubleGiveList);
			
		List<SysParameter> isAutoAddList= sysParameterService.selectList(null); 
		model.addAttribute("isAutoAddList", isAutoAddList);
			
		
		model.addAttribute("sysUser", newActRule);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/actRule/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("actRule") ActRule actRule,
			BindingResult br,Model model) {
		
		actRule = actRuleService.selectByPrimaryKey(actRule.getId());
		if(actRule==null){
			throw new NoDataFoundException();
		}
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<SysParameter> isDoubleGiveList= sysParameterService.selectList(null); 
		model.addAttribute("isDoubleGiveList", isDoubleGiveList);
			
		List<SysParameter> isAutoAddList= sysParameterService.selectList(null); 
		model.addAttribute("isAutoAddList", isAutoAddList);
			
		model.addAttribute("actRule", actRule);
		model.addAttribute("mode", Const.editMode);
		return "/admin/actRule/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("actRule") ActRule actRule,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(actRule.getId()==null){
				actRuleService.insert(actRule);
			}else{
				actRuleService.updateByPrimaryKey(actRule);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(actRule);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("actRule") ActRule actRule,Model model) {
		actRule = actRuleService.selectByPrimaryKey(actRule.getId());
		if(actRule==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("actRule", actRule);
		return "/admin/actRule/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			actRuleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					actRuleService.deleteByPrimaryKey(id);
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
