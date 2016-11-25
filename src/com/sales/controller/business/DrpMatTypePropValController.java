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
import com.sales.model.business.DrpMatTypePropVal;
import com.sales.service.business.DrpMatTypePropValService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpMatTypePropService;

import com.sales.model.business.DrpMatTypeProp;

@Controller
@RequestMapping("/admin/drpMatTypePropVal")
public class DrpMatTypePropValController extends BasicController {
	@Resource
	private DrpMatTypePropValService drpMatTypePropValService;
	
	@Resource
	private DrpMatTypePropService drpMatTypePropService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatTypePropVal") DrpMatTypePropVal drpMatTypePropVal,
			BindingResult br,Model model) {
		
		List<DrpMatTypeProp> propertyTypeIdList= drpMatTypePropService.selectList(null); 
		model.addAttribute("propertyTypeIdList", propertyTypeIdList);
			
	
		return "/admin/drpMatTypePropVal/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatTypePropVal") DrpMatTypePropVal drpMatTypePropVal,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatTypePropValService.selectList(drpMatTypePropVal, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatTypePropVal") DrpMatTypePropVal drpMatTypePropVal,
			BindingResult br,Model model) {
		
		DrpMatTypePropVal newDrpMatTypePropVal = new DrpMatTypePropVal();
		
			
		List<DrpMatTypeProp> propertyTypeIdList= drpMatTypePropService.selectList(null); 
		model.addAttribute("propertyTypeIdList", propertyTypeIdList);
			
		
		model.addAttribute("sysUser", newDrpMatTypePropVal);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatTypePropVal/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatTypePropVal") DrpMatTypePropVal drpMatTypePropVal,
			BindingResult br,Model model) {
		
		drpMatTypePropVal = drpMatTypePropValService.selectByPrimaryKey(drpMatTypePropVal.getId());
		if(drpMatTypePropVal==null){
			throw new NoDataFoundException();
		}
		List<DrpMatTypeProp> propertyTypeIdList= drpMatTypePropService.selectList(null); 
		model.addAttribute("propertyTypeIdList", propertyTypeIdList);
			
		model.addAttribute("drpMatTypePropVal", drpMatTypePropVal);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatTypePropVal/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatTypePropVal") DrpMatTypePropVal drpMatTypePropVal,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatTypePropVal.getId()==null){
				drpMatTypePropValService.insert(drpMatTypePropVal);
			}else{
				drpMatTypePropValService.updateByPrimaryKey(drpMatTypePropVal);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatTypePropVal);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatTypePropVal") DrpMatTypePropVal drpMatTypePropVal,Model model) {
		drpMatTypePropVal = drpMatTypePropValService.selectByPrimaryKey(drpMatTypePropVal.getId());
		if(drpMatTypePropVal==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatTypePropVal", drpMatTypePropVal);
		return "/admin/drpMatTypePropVal/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatTypePropValService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatTypePropValService.deleteByPrimaryKey(id);
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
