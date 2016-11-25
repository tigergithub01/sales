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
import com.sales.model.business.Organization;
import com.sales.service.business.OrganizationService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysRegionService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.SysAreaService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.OrgTypeService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysRegion;
import com.sales.model.business.Organization;
import com.sales.model.business.SysArea;
import com.sales.model.business.SysParameter;
import com.sales.model.business.OrgType;

@Controller
@RequestMapping("/admin/organization")
public class OrganizationController extends BasicController {
	@Resource
	private OrganizationService organizationService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysRegionService sysRegionService;	
	
	@Resource
	private SysAreaService sysAreaService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private OrgTypeService orgTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("organization") Organization organization,
			BindingResult br,Model model) {
		
		List<Organization> parentIdList= organizationService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<OrgType> typeIdList= orgTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		List<SysArea> areaIdList= sysAreaService.selectList(null); 
		model.addAttribute("areaIdList", areaIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<SysRegion> countryIdList= sysRegionService.selectList(null); 
		model.addAttribute("countryIdList", countryIdList);
			
		List<SysRegion> provinceIdList= sysRegionService.selectList(null); 
		model.addAttribute("provinceIdList", provinceIdList);
			
		List<SysRegion> cityIdList= sysRegionService.selectList(null); 
		model.addAttribute("cityIdList", cityIdList);
			
		List<SysRegion> districtIdList= sysRegionService.selectList(null); 
		model.addAttribute("districtIdList", districtIdList);
			
	
		return "/admin/organization/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("organization") Organization organization,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = organizationService.selectList(organization, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("organization") Organization organization,
			BindingResult br,Model model) {
		
		Organization newOrganization = new Organization();
		
		newOrganization.setCreateDate(new java.util.Date());
		newOrganization.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newOrganization.setUpdateDate(new java.util.Date());
		newOrganization.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<Organization> parentIdList= organizationService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<OrgType> typeIdList= orgTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		List<SysArea> areaIdList= sysAreaService.selectList(null); 
		model.addAttribute("areaIdList", areaIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<SysRegion> countryIdList= sysRegionService.selectList(null); 
		model.addAttribute("countryIdList", countryIdList);
			
		List<SysRegion> provinceIdList= sysRegionService.selectList(null); 
		model.addAttribute("provinceIdList", provinceIdList);
			
		List<SysRegion> cityIdList= sysRegionService.selectList(null); 
		model.addAttribute("cityIdList", cityIdList);
			
		List<SysRegion> districtIdList= sysRegionService.selectList(null); 
		model.addAttribute("districtIdList", districtIdList);
			
		
		model.addAttribute("sysUser", newOrganization);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/organization/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("organization") Organization organization,
			BindingResult br,Model model) {
		
		organization = organizationService.selectByPrimaryKey(organization.getId());
		if(organization==null){
			throw new NoDataFoundException();
		}
		List<Organization> parentIdList= organizationService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<OrgType> typeIdList= orgTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		List<SysArea> areaIdList= sysAreaService.selectList(null); 
		model.addAttribute("areaIdList", areaIdList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<SysRegion> countryIdList= sysRegionService.selectList(null); 
		model.addAttribute("countryIdList", countryIdList);
			
		List<SysRegion> provinceIdList= sysRegionService.selectList(null); 
		model.addAttribute("provinceIdList", provinceIdList);
			
		List<SysRegion> cityIdList= sysRegionService.selectList(null); 
		model.addAttribute("cityIdList", cityIdList);
			
		List<SysRegion> districtIdList= sysRegionService.selectList(null); 
		model.addAttribute("districtIdList", districtIdList);
			
		model.addAttribute("organization", organization);
		model.addAttribute("mode", Const.editMode);
		return "/admin/organization/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("organization") Organization organization,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(organization.getId()==null){
				organization.setCreateDate(new java.util.Date());
				organization.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				organization.setUpdateDate(new java.util.Date());
				organization.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				organizationService.insert(organization);
			}else{
				organization.setUpdateDate(new java.util.Date());
				organization.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				organizationService.updateByPrimaryKey(organization);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(organization);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("organization") Organization organization,Model model) {
		organization = organizationService.selectByPrimaryKey(organization.getId());
		if(organization==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("organization", organization);
		return "/admin/organization/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			organizationService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					organizationService.deleteByPrimaryKey(id);
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
