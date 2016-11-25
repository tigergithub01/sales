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
import com.sales.model.business.DrpMatSaleAttr;
import com.sales.service.business.DrpMatSaleAttrService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/drpMatSaleAttr")
public class DrpMatSaleAttrController extends BasicController {
	@Resource
	private DrpMatSaleAttrService drpMatSaleAttrService;
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatSaleAttr") DrpMatSaleAttr drpMatSaleAttr,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
	
		return "/admin/drpMatSaleAttr/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatSaleAttr") DrpMatSaleAttr drpMatSaleAttr,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatSaleAttrService.selectList(drpMatSaleAttr, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatSaleAttr") DrpMatSaleAttr drpMatSaleAttr,
			BindingResult br,Model model) {
		
		DrpMatSaleAttr newDrpMatSaleAttr = new DrpMatSaleAttr();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		
		model.addAttribute("sysUser", newDrpMatSaleAttr);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatSaleAttr/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatSaleAttr") DrpMatSaleAttr drpMatSaleAttr,
			BindingResult br,Model model) {
		
		drpMatSaleAttr = drpMatSaleAttrService.selectByPrimaryKey(drpMatSaleAttr.getId());
		if(drpMatSaleAttr==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		model.addAttribute("drpMatSaleAttr", drpMatSaleAttr);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatSaleAttr/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatSaleAttr") DrpMatSaleAttr drpMatSaleAttr,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatSaleAttr.getId()==null){
				drpMatSaleAttrService.insert(drpMatSaleAttr);
			}else{
				drpMatSaleAttrService.updateByPrimaryKey(drpMatSaleAttr);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatSaleAttr);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatSaleAttr") DrpMatSaleAttr drpMatSaleAttr,Model model) {
		drpMatSaleAttr = drpMatSaleAttrService.selectByPrimaryKey(drpMatSaleAttr.getId());
		if(drpMatSaleAttr==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatSaleAttr", drpMatSaleAttr);
		return "/admin/drpMatSaleAttr/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatSaleAttrService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatSaleAttrService.deleteByPrimaryKey(id);
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
