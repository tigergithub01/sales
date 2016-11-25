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
import com.sales.model.business.DrpMatSaleAttrProp;
import com.sales.service.business.DrpMatSaleAttrPropService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMatPropertiesService;
import com.sales.service.business.DrpMatSaleAttrService;

import com.sales.model.business.DrpMatProperties;
import com.sales.model.business.DrpMatSaleAttr;

@Controller
@RequestMapping("/admin/drpMatSaleAttrProp")
public class DrpMatSaleAttrPropController extends BasicController {
	@Resource
	private DrpMatSaleAttrPropService drpMatSaleAttrPropService;
	
	@Resource
	private DrpMatPropertiesService drpMatPropertiesService;	
	
	@Resource
	private DrpMatSaleAttrService drpMatSaleAttrService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatSaleAttrProp") DrpMatSaleAttrProp drpMatSaleAttrProp,
			BindingResult br,Model model) {
		
		List<DrpMatSaleAttr> matAttrIdList= drpMatSaleAttrService.selectList(null); 
		model.addAttribute("matAttrIdList", matAttrIdList);
			
		List<DrpMatProperties> matPropIdList= drpMatPropertiesService.selectList(null); 
		model.addAttribute("matPropIdList", matPropIdList);
			
	
		return "/admin/drpMatSaleAttrProp/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatSaleAttrProp") DrpMatSaleAttrProp drpMatSaleAttrProp,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatSaleAttrPropService.selectList(drpMatSaleAttrProp, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatSaleAttrProp") DrpMatSaleAttrProp drpMatSaleAttrProp,
			BindingResult br,Model model) {
		
		DrpMatSaleAttrProp newDrpMatSaleAttrProp = new DrpMatSaleAttrProp();
		
			
		List<DrpMatSaleAttr> matAttrIdList= drpMatSaleAttrService.selectList(null); 
		model.addAttribute("matAttrIdList", matAttrIdList);
			
		List<DrpMatProperties> matPropIdList= drpMatPropertiesService.selectList(null); 
		model.addAttribute("matPropIdList", matPropIdList);
			
		
		model.addAttribute("sysUser", newDrpMatSaleAttrProp);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatSaleAttrProp/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatSaleAttrProp") DrpMatSaleAttrProp drpMatSaleAttrProp,
			BindingResult br,Model model) {
		
		drpMatSaleAttrProp = drpMatSaleAttrPropService.selectByPrimaryKey(drpMatSaleAttrProp.getId());
		if(drpMatSaleAttrProp==null){
			throw new NoDataFoundException();
		}
		List<DrpMatSaleAttr> matAttrIdList= drpMatSaleAttrService.selectList(null); 
		model.addAttribute("matAttrIdList", matAttrIdList);
			
		List<DrpMatProperties> matPropIdList= drpMatPropertiesService.selectList(null); 
		model.addAttribute("matPropIdList", matPropIdList);
			
		model.addAttribute("drpMatSaleAttrProp", drpMatSaleAttrProp);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatSaleAttrProp/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatSaleAttrProp") DrpMatSaleAttrProp drpMatSaleAttrProp,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatSaleAttrProp.getId()==null){
				drpMatSaleAttrPropService.insert(drpMatSaleAttrProp);
			}else{
				drpMatSaleAttrPropService.updateByPrimaryKey(drpMatSaleAttrProp);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatSaleAttrProp);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatSaleAttrProp") DrpMatSaleAttrProp drpMatSaleAttrProp,Model model) {
		drpMatSaleAttrProp = drpMatSaleAttrPropService.selectByPrimaryKey(drpMatSaleAttrProp.getId());
		if(drpMatSaleAttrProp==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatSaleAttrProp", drpMatSaleAttrProp);
		return "/admin/drpMatSaleAttrProp/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatSaleAttrPropService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatSaleAttrPropService.deleteByPrimaryKey(id);
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
