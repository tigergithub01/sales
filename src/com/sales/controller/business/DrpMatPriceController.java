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
import com.sales.model.business.DrpMatPrice;
import com.sales.service.business.DrpMatPriceService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/drpMatPrice")
public class DrpMatPriceController extends BasicController {
	@Resource
	private DrpMatPriceService drpMatPriceService;
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatPrice") DrpMatPrice drpMatPrice,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/drpMatPrice/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatPrice") DrpMatPrice drpMatPrice,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatPriceService.selectList(drpMatPrice, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatPrice") DrpMatPrice drpMatPrice,
			BindingResult br,Model model) {
		
		DrpMatPrice newDrpMatPrice = new DrpMatPrice();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newDrpMatPrice);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatPrice/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatPrice") DrpMatPrice drpMatPrice,
			BindingResult br,Model model) {
		
		drpMatPrice = drpMatPriceService.selectByPrimaryKey(drpMatPrice.getId());
		if(drpMatPrice==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("drpMatPrice", drpMatPrice);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatPrice/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatPrice") DrpMatPrice drpMatPrice,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatPrice.getId()==null){
				drpMatPriceService.insert(drpMatPrice);
			}else{
				drpMatPriceService.updateByPrimaryKey(drpMatPrice);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatPrice);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatPrice") DrpMatPrice drpMatPrice,Model model) {
		drpMatPrice = drpMatPriceService.selectByPrimaryKey(drpMatPrice.getId());
		if(drpMatPrice==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatPrice", drpMatPrice);
		return "/admin/drpMatPrice/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatPriceService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatPriceService.deleteByPrimaryKey(id);
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
