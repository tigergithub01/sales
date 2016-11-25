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
import com.sales.model.business.DrpMaterial;
import com.sales.service.business.DrpMaterialService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.DrpBrandService;
import com.sales.service.business.DrpSupplierService;
import com.sales.service.business.DrpMatTypeService;
import com.sales.service.business.SysUnitService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.DrpSupplier;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.SysUnit;

@Controller
@RequestMapping("/admin/drpMaterial")
public class DrpMaterialController extends BasicController {
	@Resource
	private DrpMaterialService drpMaterialService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private DrpBrandService drpBrandService;	
	
	@Resource
	private DrpSupplierService drpSupplierService;	
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	@Resource
	private SysUnitService sysUnitService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMaterial") DrpMaterial drpMaterial,
			BindingResult br,Model model) {
		
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpMatType> typeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<SysParameter> costTypeList= sysParameterService.selectList(null); 
		model.addAttribute("costTypeList", costTypeList);
			
		List<DrpSupplier> supplierIdList= drpSupplierService.selectList(null); 
		model.addAttribute("supplierIdList", supplierIdList);
			
		List<SysParameter> isOnSaleList= sysParameterService.selectList(null); 
		model.addAttribute("isOnSaleList", isOnSaleList);
			
		List<SysParameter> isGiftList= sysParameterService.selectList(null); 
		model.addAttribute("isGiftList", isGiftList);
			
		List<SysParameter> batchFlagList= sysParameterService.selectList(null); 
		model.addAttribute("batchFlagList", batchFlagList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysUser> auditUserIdList= sysUserService.selectList(null); 
		model.addAttribute("auditUserIdList", auditUserIdList);
			
	
		return "/admin/drpMaterial/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMaterial") DrpMaterial drpMaterial,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMaterialService.selectList(drpMaterial, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMaterial") DrpMaterial drpMaterial,
			BindingResult br,Model model) {
		
		DrpMaterial newDrpMaterial = new DrpMaterial();
		
		newDrpMaterial.setCreateDate(new java.util.Date());
		newDrpMaterial.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newDrpMaterial.setUpdateDate(new java.util.Date());
		newDrpMaterial.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpMatType> typeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<SysParameter> costTypeList= sysParameterService.selectList(null); 
		model.addAttribute("costTypeList", costTypeList);
			
		List<DrpSupplier> supplierIdList= drpSupplierService.selectList(null); 
		model.addAttribute("supplierIdList", supplierIdList);
			
		List<SysParameter> isOnSaleList= sysParameterService.selectList(null); 
		model.addAttribute("isOnSaleList", isOnSaleList);
			
		List<SysParameter> isGiftList= sysParameterService.selectList(null); 
		model.addAttribute("isGiftList", isGiftList);
			
		List<SysParameter> batchFlagList= sysParameterService.selectList(null); 
		model.addAttribute("batchFlagList", batchFlagList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysUser> auditUserIdList= sysUserService.selectList(null); 
		model.addAttribute("auditUserIdList", auditUserIdList);
			
		
		model.addAttribute("sysUser", newDrpMaterial);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMaterial/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMaterial") DrpMaterial drpMaterial,
			BindingResult br,Model model) {
		
		drpMaterial = drpMaterialService.selectByPrimaryKey(drpMaterial.getId());
		if(drpMaterial==null){
			throw new NoDataFoundException();
		}
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpMatType> typeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<SysParameter> costTypeList= sysParameterService.selectList(null); 
		model.addAttribute("costTypeList", costTypeList);
			
		List<DrpSupplier> supplierIdList= drpSupplierService.selectList(null); 
		model.addAttribute("supplierIdList", supplierIdList);
			
		List<SysParameter> isOnSaleList= sysParameterService.selectList(null); 
		model.addAttribute("isOnSaleList", isOnSaleList);
			
		List<SysParameter> isGiftList= sysParameterService.selectList(null); 
		model.addAttribute("isGiftList", isGiftList);
			
		List<SysParameter> batchFlagList= sysParameterService.selectList(null); 
		model.addAttribute("batchFlagList", batchFlagList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysUser> auditUserIdList= sysUserService.selectList(null); 
		model.addAttribute("auditUserIdList", auditUserIdList);
			
		model.addAttribute("drpMaterial", drpMaterial);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMaterial/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMaterial") DrpMaterial drpMaterial,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMaterial.getId()==null){
				drpMaterial.setCreateDate(new java.util.Date());
				drpMaterial.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				drpMaterial.setUpdateDate(new java.util.Date());
				drpMaterial.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpMaterialService.insert(drpMaterial);
			}else{
				drpMaterial.setUpdateDate(new java.util.Date());
				drpMaterial.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				drpMaterialService.updateByPrimaryKey(drpMaterial);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMaterial);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMaterial") DrpMaterial drpMaterial,Model model) {
		drpMaterial = drpMaterialService.selectByPrimaryKey(drpMaterial.getId());
		if(drpMaterial==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMaterial", drpMaterial);
		return "/admin/drpMaterial/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMaterialService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMaterialService.deleteByPrimaryKey(id);
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
