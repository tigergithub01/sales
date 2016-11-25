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
import com.sales.model.business.SysShippingType;
import com.sales.service.business.SysShippingTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/sysShippingType")
public class SysShippingTypeController extends BasicController {
	@Resource
	private SysShippingTypeService sysShippingTypeService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysShippingType") SysShippingType sysShippingType,
			BindingResult br,Model model) {
		
	
		return "/admin/sysShippingType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysShippingType") SysShippingType sysShippingType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysShippingTypeService.selectList(sysShippingType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysShippingType") SysShippingType sysShippingType,
			BindingResult br,Model model) {
		
		SysShippingType newSysShippingType = new SysShippingType();
		
			
		
		model.addAttribute("sysUser", newSysShippingType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysShippingType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysShippingType") SysShippingType sysShippingType,
			BindingResult br,Model model) {
		
		sysShippingType = sysShippingTypeService.selectByPrimaryKey(sysShippingType.getId());
		if(sysShippingType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysShippingType", sysShippingType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysShippingType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysShippingType") SysShippingType sysShippingType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysShippingType.getId()==null){
				sysShippingTypeService.insert(sysShippingType);
			}else{
				sysShippingTypeService.updateByPrimaryKey(sysShippingType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysShippingType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysShippingType") SysShippingType sysShippingType,Model model) {
		sysShippingType = sysShippingTypeService.selectByPrimaryKey(sysShippingType.getId());
		if(sysShippingType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysShippingType", sysShippingType);
		return "/admin/sysShippingType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysShippingTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysShippingTypeService.deleteByPrimaryKey(id);
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
