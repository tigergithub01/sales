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
import com.sales.model.business.DrpMatProperties;
import com.sales.service.business.DrpMatPropertiesService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.DrpMatTypePropValService;
import com.sales.service.business.DrpMatTypePropService;

import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpMatTypePropVal;
import com.sales.model.business.DrpMatTypeProp;

@Controller
@RequestMapping("/admin/drpMatProperties")
public class DrpMatPropertiesController extends BasicController {
	@Resource
	private DrpMatPropertiesService drpMatPropertiesService;
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private DrpMatTypePropValService drpMatTypePropValService;	
	
	@Resource
	private DrpMatTypePropService drpMatTypePropService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatProperties") DrpMatProperties drpMatProperties,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpMatTypeProp> propIdList= drpMatTypePropService.selectList(null); 
		model.addAttribute("propIdList", propIdList);
			
		List<DrpMatTypePropVal> propValList= drpMatTypePropValService.selectList(null); 
		model.addAttribute("propValList", propValList);
			
	
		return "/admin/drpMatProperties/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatProperties") DrpMatProperties drpMatProperties,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatPropertiesService.selectList(drpMatProperties, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatProperties") DrpMatProperties drpMatProperties,
			BindingResult br,Model model) {
		
		DrpMatProperties newDrpMatProperties = new DrpMatProperties();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpMatTypeProp> propIdList= drpMatTypePropService.selectList(null); 
		model.addAttribute("propIdList", propIdList);
			
		List<DrpMatTypePropVal> propValList= drpMatTypePropValService.selectList(null); 
		model.addAttribute("propValList", propValList);
			
		
		model.addAttribute("sysUser", newDrpMatProperties);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatProperties/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatProperties") DrpMatProperties drpMatProperties,
			BindingResult br,Model model) {
		
		drpMatProperties = drpMatPropertiesService.selectByPrimaryKey(drpMatProperties.getId());
		if(drpMatProperties==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpMatTypeProp> propIdList= drpMatTypePropService.selectList(null); 
		model.addAttribute("propIdList", propIdList);
			
		List<DrpMatTypePropVal> propValList= drpMatTypePropValService.selectList(null); 
		model.addAttribute("propValList", propValList);
			
		model.addAttribute("drpMatProperties", drpMatProperties);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatProperties/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatProperties") DrpMatProperties drpMatProperties,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatProperties.getId()==null){
				drpMatPropertiesService.insert(drpMatProperties);
			}else{
				drpMatPropertiesService.updateByPrimaryKey(drpMatProperties);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatProperties);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatProperties") DrpMatProperties drpMatProperties,Model model) {
		drpMatProperties = drpMatPropertiesService.selectByPrimaryKey(drpMatProperties.getId());
		if(drpMatProperties==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatProperties", drpMatProperties);
		return "/admin/drpMatProperties/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatPropertiesService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatPropertiesService.deleteByPrimaryKey(id);
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
