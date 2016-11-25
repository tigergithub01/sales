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
import com.sales.model.business.DrpMatInventory;
import com.sales.service.business.DrpMatInventoryService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpMatBatchService;
import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.Organization;
import com.sales.model.business.DrpMatBatch;
import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/drpMatInventory")
public class DrpMatInventoryController extends BasicController {
	@Resource
	private DrpMatInventoryService drpMatInventoryService;
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpMatBatchService drpMatBatchService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatInventory") DrpMatInventory drpMatInventory,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
	
		return "/admin/drpMatInventory/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatInventory") DrpMatInventory drpMatInventory,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatInventoryService.selectList(drpMatInventory, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatInventory") DrpMatInventory drpMatInventory,
			BindingResult br,Model model) {
		
		DrpMatInventory newDrpMatInventory = new DrpMatInventory();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		
		model.addAttribute("sysUser", newDrpMatInventory);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatInventory/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatInventory") DrpMatInventory drpMatInventory,
			BindingResult br,Model model) {
		
		drpMatInventory = drpMatInventoryService.selectByPrimaryKey(drpMatInventory.getId());
		if(drpMatInventory==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		model.addAttribute("drpMatInventory", drpMatInventory);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatInventory/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatInventory") DrpMatInventory drpMatInventory,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatInventory.getId()==null){
				drpMatInventoryService.insert(drpMatInventory);
			}else{
				drpMatInventoryService.updateByPrimaryKey(drpMatInventory);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatInventory);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatInventory") DrpMatInventory drpMatInventory,Model model) {
		drpMatInventory = drpMatInventoryService.selectByPrimaryKey(drpMatInventory.getId());
		if(drpMatInventory==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatInventory", drpMatInventory);
		return "/admin/drpMatInventory/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatInventoryService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatInventoryService.deleteByPrimaryKey(id);
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
