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
import com.sales.model.business.ActOrganization;
import com.sales.service.business.ActOrganizationService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OrganizationService;
import com.sales.service.business.ActivityService;

import com.sales.model.business.Organization;
import com.sales.model.business.Activity;

@Controller
@RequestMapping("/admin/actOrganization")
public class ActOrganizationController extends BasicController {
	@Resource
	private ActOrganizationService actOrganizationService;
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private ActivityService activityService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("actOrganization") ActOrganization actOrganization,
			BindingResult br,Model model) {
		
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/actOrganization/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("actOrganization") ActOrganization actOrganization,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = actOrganizationService.selectList(actOrganization, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("actOrganization") ActOrganization actOrganization,
			BindingResult br,Model model) {
		
		ActOrganization newActOrganization = new ActOrganization();
		
			
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newActOrganization);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/actOrganization/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("actOrganization") ActOrganization actOrganization,
			BindingResult br,Model model) {
		
		actOrganization = actOrganizationService.selectByPrimaryKey(actOrganization.getId());
		if(actOrganization==null){
			throw new NoDataFoundException();
		}
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("actOrganization", actOrganization);
		model.addAttribute("mode", Const.editMode);
		return "/admin/actOrganization/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("actOrganization") ActOrganization actOrganization,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(actOrganization.getId()==null){
				actOrganizationService.insert(actOrganization);
			}else{
				actOrganizationService.updateByPrimaryKey(actOrganization);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(actOrganization);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("actOrganization") ActOrganization actOrganization,Model model) {
		actOrganization = actOrganizationService.selectByPrimaryKey(actOrganization.getId());
		if(actOrganization==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("actOrganization", actOrganization);
		return "/admin/actOrganization/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			actOrganizationService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					actOrganizationService.deleteByPrimaryKey(id);
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
