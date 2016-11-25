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
import com.sales.model.business.SysRole;
import com.sales.service.business.SysRoleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/sysRole")
public class SysRoleController extends BasicController {
	@Resource
	private SysRoleService sysRoleService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysRole") SysRole sysRole,
			BindingResult br,Model model) {
		
	
		return "/admin/sysRole/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysRole") SysRole sysRole,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysRoleService.selectList(sysRole, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysRole") SysRole sysRole,
			BindingResult br,Model model) {
		
		SysRole newSysRole = new SysRole();
		
			
		
		model.addAttribute("sysUser", newSysRole);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysRole/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysRole") SysRole sysRole,
			BindingResult br,Model model) {
		
		sysRole = sysRoleService.selectByPrimaryKey(sysRole.getId());
		if(sysRole==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysRole", sysRole);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysRole/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysRole") SysRole sysRole,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysRole.getId()==null){
				sysRoleService.insert(sysRole);
			}else{
				sysRoleService.updateByPrimaryKey(sysRole);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysRole);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysRole") SysRole sysRole,Model model) {
		sysRole = sysRoleService.selectByPrimaryKey(sysRole.getId());
		if(sysRole==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysRole", sysRole);
		return "/admin/sysRole/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysRoleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysRoleService.deleteByPrimaryKey(id);
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
