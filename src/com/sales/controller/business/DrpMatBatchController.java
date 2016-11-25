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
import com.sales.model.business.DrpMatBatch;
import com.sales.service.business.DrpMatBatchService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpSheetService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.DrpSheet;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/drpMatBatch")
public class DrpMatBatchController extends BasicController {
	@Resource
	private DrpMatBatchService drpMatBatchService;
	
	@Resource
	private DrpSheetService drpSheetService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatBatch") DrpMatBatch drpMatBatch,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpSheet> sheetIdList= drpSheetService.selectList(null); 
		model.addAttribute("sheetIdList", sheetIdList);
			
	
		return "/admin/drpMatBatch/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatBatch") DrpMatBatch drpMatBatch,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatBatchService.selectList(drpMatBatch, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatBatch") DrpMatBatch drpMatBatch,
			BindingResult br,Model model) {
		
		DrpMatBatch newDrpMatBatch = new DrpMatBatch();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpSheet> sheetIdList= drpSheetService.selectList(null); 
		model.addAttribute("sheetIdList", sheetIdList);
			
		
		model.addAttribute("sysUser", newDrpMatBatch);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatBatch/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatBatch") DrpMatBatch drpMatBatch,
			BindingResult br,Model model) {
		
		drpMatBatch = drpMatBatchService.selectByPrimaryKey(drpMatBatch.getId());
		if(drpMatBatch==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpSheet> sheetIdList= drpSheetService.selectList(null); 
		model.addAttribute("sheetIdList", sheetIdList);
			
		model.addAttribute("drpMatBatch", drpMatBatch);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatBatch/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatBatch") DrpMatBatch drpMatBatch,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatBatch.getId()==null){
				drpMatBatchService.insert(drpMatBatch);
			}else{
				drpMatBatchService.updateByPrimaryKey(drpMatBatch);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatBatch);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatBatch") DrpMatBatch drpMatBatch,Model model) {
		drpMatBatch = drpMatBatchService.selectByPrimaryKey(drpMatBatch.getId());
		if(drpMatBatch==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatBatch", drpMatBatch);
		return "/admin/drpMatBatch/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatBatchService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatBatchService.deleteByPrimaryKey(id);
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
