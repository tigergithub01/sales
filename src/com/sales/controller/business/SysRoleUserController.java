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
import com.sales.model.business.SysRoleUser;
import com.sales.service.business.SysRoleUserService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysRoleService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysRole;

@Controller
@RequestMapping("/admin/sysRoleUser")
public class SysRoleUserController extends BasicController {
	@Resource
	private SysRoleUserService sysRoleUserService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysRoleService sysRoleService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysRoleUser") SysRoleUser sysRoleUser,
			BindingResult br,Model model) {
		
		List<SysRole> roleIdList= sysRoleService.selectList(null); 
		model.addAttribute("roleIdList", roleIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
	
		return "/admin/sysRoleUser/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysRoleUser") SysRoleUser sysRoleUser,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysRoleUserService.selectList(sysRoleUser, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysRoleUser") SysRoleUser sysRoleUser,
			BindingResult br,Model model) {
		
		SysRoleUser newSysRoleUser = new SysRoleUser();
		
			
		List<SysRole> roleIdList= sysRoleService.selectList(null); 
		model.addAttribute("roleIdList", roleIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		
		model.addAttribute("sysUser", newSysRoleUser);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysRoleUser/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysRoleUser") SysRoleUser sysRoleUser,
			BindingResult br,Model model) {
		
		sysRoleUser = sysRoleUserService.selectByPrimaryKey(sysRoleUser.getId());
		if(sysRoleUser==null){
			throw new NoDataFoundException();
		}
		List<SysRole> roleIdList= sysRoleService.selectList(null); 
		model.addAttribute("roleIdList", roleIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		model.addAttribute("sysRoleUser", sysRoleUser);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysRoleUser/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysRoleUser") SysRoleUser sysRoleUser,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysRoleUser.getId()==null){
				sysRoleUserService.insert(sysRoleUser);
			}else{
				sysRoleUserService.updateByPrimaryKey(sysRoleUser);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysRoleUser);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysRoleUser") SysRoleUser sysRoleUser,Model model) {
		sysRoleUser = sysRoleUserService.selectByPrimaryKey(sysRoleUser.getId());
		if(sysRoleUser==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysRoleUser", sysRoleUser);
		return "/admin/sysRoleUser/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysRoleUserService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysRoleUserService.deleteByPrimaryKey(id);
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
