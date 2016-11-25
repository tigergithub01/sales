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
import com.sales.model.business.OrgType;
import com.sales.service.business.OrgTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/orgType")
public class OrgTypeController extends BasicController {
	@Resource
	private OrgTypeService orgTypeService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("orgType") OrgType orgType,
			BindingResult br,Model model) {
		
	
		return "/admin/orgType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("orgType") OrgType orgType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = orgTypeService.selectList(orgType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("orgType") OrgType orgType,
			BindingResult br,Model model) {
		
		OrgType newOrgType = new OrgType();
		
			
		
		model.addAttribute("sysUser", newOrgType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/orgType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("orgType") OrgType orgType,
			BindingResult br,Model model) {
		
		orgType = orgTypeService.selectByPrimaryKey(orgType.getId());
		if(orgType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("orgType", orgType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/orgType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("orgType") OrgType orgType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(orgType.getId()==null){
				orgTypeService.insert(orgType);
			}else{
				orgTypeService.updateByPrimaryKey(orgType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(orgType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("orgType") OrgType orgType,Model model) {
		orgType = orgTypeService.selectByPrimaryKey(orgType.getId());
		if(orgType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("orgType", orgType);
		return "/admin/orgType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			orgTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					orgTypeService.deleteByPrimaryKey(id);
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
