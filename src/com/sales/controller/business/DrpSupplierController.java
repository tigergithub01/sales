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
import com.sales.model.business.DrpSupplier;
import com.sales.service.business.DrpSupplierService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.SysUserService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.SysUser;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/drpSupplier")
public class DrpSupplierController extends BasicController {
	@Resource
	private DrpSupplierService drpSupplierService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpSupplier") DrpSupplier drpSupplier,
			BindingResult br,Model model) {
		
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
	
		return "/admin/drpSupplier/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpSupplier") DrpSupplier drpSupplier,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpSupplierService.selectList(drpSupplier, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpSupplier") DrpSupplier drpSupplier,
			BindingResult br,Model model) {
		
		DrpSupplier newDrpSupplier = new DrpSupplier();
		
		newDrpSupplier.setCreateDate(new java.util.Date());
		newDrpSupplier.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newDrpSupplier.setUpdateDate(new java.util.Date());
		newDrpSupplier.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		
		model.addAttribute("sysUser", newDrpSupplier);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpSupplier/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpSupplier") DrpSupplier drpSupplier,
			BindingResult br,Model model) {
		
		drpSupplier = drpSupplierService.selectByPrimaryKey(drpSupplier.getId());
		if(drpSupplier==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		model.addAttribute("drpSupplier", drpSupplier);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpSupplier/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpSupplier") DrpSupplier drpSupplier,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpSupplier.getId()==null){
				drpSupplier.setCreateDate(new java.util.Date());
				drpSupplier.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				drpSupplier.setUpdateDate(new java.util.Date());
				drpSupplier.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpSupplierService.insert(drpSupplier);
			}else{
				drpSupplier.setUpdateDate(new java.util.Date());
				drpSupplier.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpSupplierService.updateByPrimaryKey(drpSupplier);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpSupplier);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpSupplier") DrpSupplier drpSupplier,Model model) {
		drpSupplier = drpSupplierService.selectByPrimaryKey(drpSupplier.getId());
		if(drpSupplier==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpSupplier", drpSupplier);
		return "/admin/drpSupplier/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpSupplierService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpSupplierService.deleteByPrimaryKey(id);
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
