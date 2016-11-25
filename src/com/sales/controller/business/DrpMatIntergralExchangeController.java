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
import com.sales.model.business.DrpMatIntergralExchange;
import com.sales.service.business.DrpMatIntergralExchangeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMaterialService;

import com.sales.model.business.DrpMaterial;

@Controller
@RequestMapping("/admin/drpMatIntergralExchange")
public class DrpMatIntergralExchangeController extends BasicController {
	@Resource
	private DrpMatIntergralExchangeService drpMatIntergralExchangeService;
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatIntergralExchange") DrpMatIntergralExchange drpMatIntergralExchange,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
	
		return "/admin/drpMatIntergralExchange/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatIntergralExchange") DrpMatIntergralExchange drpMatIntergralExchange,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatIntergralExchangeService.selectList(drpMatIntergralExchange, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatIntergralExchange") DrpMatIntergralExchange drpMatIntergralExchange,
			BindingResult br,Model model) {
		
		DrpMatIntergralExchange newDrpMatIntergralExchange = new DrpMatIntergralExchange();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		
		model.addAttribute("sysUser", newDrpMatIntergralExchange);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatIntergralExchange/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatIntergralExchange") DrpMatIntergralExchange drpMatIntergralExchange,
			BindingResult br,Model model) {
		
		drpMatIntergralExchange = drpMatIntergralExchangeService.selectByPrimaryKey(drpMatIntergralExchange.getId());
		if(drpMatIntergralExchange==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		model.addAttribute("drpMatIntergralExchange", drpMatIntergralExchange);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatIntergralExchange/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatIntergralExchange") DrpMatIntergralExchange drpMatIntergralExchange,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatIntergralExchange.getId()==null){
				drpMatIntergralExchangeService.insert(drpMatIntergralExchange);
			}else{
				drpMatIntergralExchangeService.updateByPrimaryKey(drpMatIntergralExchange);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatIntergralExchange);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatIntergralExchange") DrpMatIntergralExchange drpMatIntergralExchange,Model model) {
		drpMatIntergralExchange = drpMatIntergralExchangeService.selectByPrimaryKey(drpMatIntergralExchange.getId());
		if(drpMatIntergralExchange==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatIntergralExchange", drpMatIntergralExchange);
		return "/admin/drpMatIntergralExchange/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatIntergralExchangeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatIntergralExchangeService.deleteByPrimaryKey(id);
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
