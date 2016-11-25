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
import com.sales.model.business.DrpMatAuth;
import com.sales.service.business.DrpMatAuthService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.Organization;
import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/drpMatAuth")
public class DrpMatAuthController extends BasicController {
	@Resource
	private DrpMatAuthService drpMatAuthService;
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatAuth") DrpMatAuth drpMatAuth,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/drpMatAuth/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatAuth") DrpMatAuth drpMatAuth,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatAuthService.selectList(drpMatAuth, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatAuth") DrpMatAuth drpMatAuth,
			BindingResult br,Model model) {
		
		DrpMatAuth newDrpMatAuth = new DrpMatAuth();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newDrpMatAuth);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatAuth/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatAuth") DrpMatAuth drpMatAuth,
			BindingResult br,Model model) {
		
		drpMatAuth = drpMatAuthService.selectByPrimaryKey(drpMatAuth.getId());
		if(drpMatAuth==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("drpMatAuth", drpMatAuth);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatAuth/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatAuth") DrpMatAuth drpMatAuth,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatAuth.getId()==null){
				drpMatAuthService.insert(drpMatAuth);
			}else{
				drpMatAuthService.updateByPrimaryKey(drpMatAuth);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatAuth);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatAuth") DrpMatAuth drpMatAuth,Model model) {
		drpMatAuth = drpMatAuthService.selectByPrimaryKey(drpMatAuth.getId());
		if(drpMatAuth==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatAuth", drpMatAuth);
		return "/admin/drpMatAuth/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatAuthService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatAuthService.deleteByPrimaryKey(id);
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
