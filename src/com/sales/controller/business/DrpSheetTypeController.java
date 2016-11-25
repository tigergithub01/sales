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
import com.sales.model.business.DrpSheetType;
import com.sales.service.business.DrpSheetTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/drpSheetType")
public class DrpSheetTypeController extends BasicController {
	@Resource
	private DrpSheetTypeService drpSheetTypeService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpSheetType") DrpSheetType drpSheetType,
			BindingResult br,Model model) {
		
	
		return "/admin/drpSheetType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpSheetType") DrpSheetType drpSheetType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpSheetTypeService.selectList(drpSheetType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpSheetType") DrpSheetType drpSheetType,
			BindingResult br,Model model) {
		
		DrpSheetType newDrpSheetType = new DrpSheetType();
		
			
		
		model.addAttribute("sysUser", newDrpSheetType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpSheetType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpSheetType") DrpSheetType drpSheetType,
			BindingResult br,Model model) {
		
		drpSheetType = drpSheetTypeService.selectByPrimaryKey(drpSheetType.getId());
		if(drpSheetType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpSheetType", drpSheetType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpSheetType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpSheetType") DrpSheetType drpSheetType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpSheetType.getId()==null){
				drpSheetTypeService.insert(drpSheetType);
			}else{
				drpSheetTypeService.updateByPrimaryKey(drpSheetType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpSheetType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpSheetType") DrpSheetType drpSheetType,Model model) {
		drpSheetType = drpSheetTypeService.selectByPrimaryKey(drpSheetType.getId());
		if(drpSheetType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpSheetType", drpSheetType);
		return "/admin/drpSheetType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpSheetTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpSheetTypeService.deleteByPrimaryKey(id);
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
