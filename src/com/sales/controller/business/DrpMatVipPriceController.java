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
import com.sales.model.business.DrpMatVipPrice;
import com.sales.service.business.DrpMatVipPriceService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipTypeService;
import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.VipType;
import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/drpMatVipPrice")
public class DrpMatVipPriceController extends BasicController {
	@Resource
	private DrpMatVipPriceService drpMatVipPriceService;
	
	@Resource
	private VipTypeService vipTypeService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatVipPrice") DrpMatVipPrice drpMatVipPrice,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
	
		return "/admin/drpMatVipPrice/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatVipPrice") DrpMatVipPrice drpMatVipPrice,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatVipPriceService.selectList(drpMatVipPrice, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatVipPrice") DrpMatVipPrice drpMatVipPrice,
			BindingResult br,Model model) {
		
		DrpMatVipPrice newDrpMatVipPrice = new DrpMatVipPrice();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		
		model.addAttribute("sysUser", newDrpMatVipPrice);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatVipPrice/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatVipPrice") DrpMatVipPrice drpMatVipPrice,
			BindingResult br,Model model) {
		
		drpMatVipPrice = drpMatVipPriceService.selectByPrimaryKey(drpMatVipPrice.getId());
		if(drpMatVipPrice==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		model.addAttribute("drpMatVipPrice", drpMatVipPrice);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatVipPrice/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatVipPrice") DrpMatVipPrice drpMatVipPrice,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatVipPrice.getId()==null){
				drpMatVipPriceService.insert(drpMatVipPrice);
			}else{
				drpMatVipPriceService.updateByPrimaryKey(drpMatVipPrice);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatVipPrice);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatVipPrice") DrpMatVipPrice drpMatVipPrice,Model model) {
		drpMatVipPrice = drpMatVipPriceService.selectByPrimaryKey(drpMatVipPrice.getId());
		if(drpMatVipPrice==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatVipPrice", drpMatVipPrice);
		return "/admin/drpMatVipPrice/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatVipPriceService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatVipPriceService.deleteByPrimaryKey(id);
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
