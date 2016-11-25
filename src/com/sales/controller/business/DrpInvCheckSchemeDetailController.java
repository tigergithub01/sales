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
import com.sales.model.business.DrpInvCheckSchemeDetail;
import com.sales.service.business.DrpInvCheckSchemeDetailService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.DrpInvCheckSchemeService;
import com.sales.service.business.DrpBrandService;
import com.sales.service.business.DrpMatTypeService;

import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpInvCheckScheme;
import com.sales.model.business.DrpBrand;
import com.sales.model.business.DrpMatType;

@Controller
@RequestMapping("/admin/drpInvCheckSchemeDetail")
public class DrpInvCheckSchemeDetailController extends BasicController {
	@Resource
	private DrpInvCheckSchemeDetailService drpInvCheckSchemeDetailService;
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private DrpInvCheckSchemeService drpInvCheckSchemeService;	
	
	@Resource
	private DrpBrandService drpBrandService;	
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpInvCheckSchemeDetail") DrpInvCheckSchemeDetail drpInvCheckSchemeDetail,
			BindingResult br,Model model) {
		
		List<DrpInvCheckScheme> schemeIdList= drpInvCheckSchemeService.selectList(null); 
		model.addAttribute("schemeIdList", schemeIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
	
		return "/admin/drpInvCheckSchemeDetail/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpInvCheckSchemeDetail") DrpInvCheckSchemeDetail drpInvCheckSchemeDetail,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpInvCheckSchemeDetailService.selectList(drpInvCheckSchemeDetail, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpInvCheckSchemeDetail") DrpInvCheckSchemeDetail drpInvCheckSchemeDetail,
			BindingResult br,Model model) {
		
		DrpInvCheckSchemeDetail newDrpInvCheckSchemeDetail = new DrpInvCheckSchemeDetail();
		
			
		List<DrpInvCheckScheme> schemeIdList= drpInvCheckSchemeService.selectList(null); 
		model.addAttribute("schemeIdList", schemeIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		
		model.addAttribute("sysUser", newDrpInvCheckSchemeDetail);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpInvCheckSchemeDetail/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpInvCheckSchemeDetail") DrpInvCheckSchemeDetail drpInvCheckSchemeDetail,
			BindingResult br,Model model) {
		
		drpInvCheckSchemeDetail = drpInvCheckSchemeDetailService.selectByPrimaryKey(drpInvCheckSchemeDetail.getId());
		if(drpInvCheckSchemeDetail==null){
			throw new NoDataFoundException();
		}
		List<DrpInvCheckScheme> schemeIdList= drpInvCheckSchemeService.selectList(null); 
		model.addAttribute("schemeIdList", schemeIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpBrand> brandIdList= drpBrandService.selectList(null); 
		model.addAttribute("brandIdList", brandIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		model.addAttribute("drpInvCheckSchemeDetail", drpInvCheckSchemeDetail);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpInvCheckSchemeDetail/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpInvCheckSchemeDetail") DrpInvCheckSchemeDetail drpInvCheckSchemeDetail,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpInvCheckSchemeDetail.getId()==null){
				drpInvCheckSchemeDetailService.insert(drpInvCheckSchemeDetail);
			}else{
				drpInvCheckSchemeDetailService.updateByPrimaryKey(drpInvCheckSchemeDetail);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpInvCheckSchemeDetail);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpInvCheckSchemeDetail") DrpInvCheckSchemeDetail drpInvCheckSchemeDetail,Model model) {
		drpInvCheckSchemeDetail = drpInvCheckSchemeDetailService.selectByPrimaryKey(drpInvCheckSchemeDetail.getId());
		if(drpInvCheckSchemeDetail==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpInvCheckSchemeDetail", drpInvCheckSchemeDetail);
		return "/admin/drpInvCheckSchemeDetail/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpInvCheckSchemeDetailService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpInvCheckSchemeDetailService.deleteByPrimaryKey(id);
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
