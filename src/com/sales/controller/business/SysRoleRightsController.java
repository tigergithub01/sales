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
import com.sales.model.business.SysRoleRights;
import com.sales.service.business.SysRoleRightsService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysRoleService;
import com.sales.service.business.SysModuleService;
import com.sales.service.business.SysOperationService;

import com.sales.model.business.SysRole;
import com.sales.model.business.SysModule;
import com.sales.model.business.SysOperation;

@Controller
@RequestMapping("/admin/sysRoleRights")
public class SysRoleRightsController extends BasicController {
	@Resource
	private SysRoleRightsService sysRoleRightsService;
	
	@Resource
	private SysRoleService sysRoleService;	
	
	@Resource
	private SysModuleService sysModuleService;	
	
	@Resource
	private SysOperationService sysOperationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysRoleRights") SysRoleRights sysRoleRights,
			BindingResult br,Model model) {
		
		List<SysRole> roleIdList= sysRoleService.selectList(null); 
		model.addAttribute("roleIdList", roleIdList);
			
		List<SysModule> moduleIdList= sysModuleService.selectList(null); 
		model.addAttribute("moduleIdList", moduleIdList);
			
		List<SysOperation> operationIdList= sysOperationService.selectList(null); 
		model.addAttribute("operationIdList", operationIdList);
			
	
		return "/admin/sysRoleRights/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysRoleRights") SysRoleRights sysRoleRights,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysRoleRightsService.selectList(sysRoleRights, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysRoleRights") SysRoleRights sysRoleRights,
			BindingResult br,Model model) {
		
		SysRoleRights newSysRoleRights = new SysRoleRights();
		
			
		List<SysRole> roleIdList= sysRoleService.selectList(null); 
		model.addAttribute("roleIdList", roleIdList);
			
		List<SysModule> moduleIdList= sysModuleService.selectList(null); 
		model.addAttribute("moduleIdList", moduleIdList);
			
		List<SysOperation> operationIdList= sysOperationService.selectList(null); 
		model.addAttribute("operationIdList", operationIdList);
			
		
		model.addAttribute("sysUser", newSysRoleRights);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysRoleRights/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysRoleRights") SysRoleRights sysRoleRights,
			BindingResult br,Model model) {
		
		sysRoleRights = sysRoleRightsService.selectByPrimaryKey(sysRoleRights.getId());
		if(sysRoleRights==null){
			throw new NoDataFoundException();
		}
		List<SysRole> roleIdList= sysRoleService.selectList(null); 
		model.addAttribute("roleIdList", roleIdList);
			
		List<SysModule> moduleIdList= sysModuleService.selectList(null); 
		model.addAttribute("moduleIdList", moduleIdList);
			
		List<SysOperation> operationIdList= sysOperationService.selectList(null); 
		model.addAttribute("operationIdList", operationIdList);
			
		model.addAttribute("sysRoleRights", sysRoleRights);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysRoleRights/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysRoleRights") SysRoleRights sysRoleRights,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysRoleRights.getId()==null){
				sysRoleRightsService.insert(sysRoleRights);
			}else{
				sysRoleRightsService.updateByPrimaryKey(sysRoleRights);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysRoleRights);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysRoleRights") SysRoleRights sysRoleRights,Model model) {
		sysRoleRights = sysRoleRightsService.selectByPrimaryKey(sysRoleRights.getId());
		if(sysRoleRights==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysRoleRights", sysRoleRights);
		return "/admin/sysRoleRights/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysRoleRightsService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysRoleRightsService.deleteByPrimaryKey(id);
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
