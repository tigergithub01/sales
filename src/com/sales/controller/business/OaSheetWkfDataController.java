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
import com.sales.model.business.OaSheetWkfData;
import com.sales.service.business.OaSheetWkfDataService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OaWkfInstanceService;

import com.sales.model.business.OaWkfInstance;

@Controller
@RequestMapping("/admin/oaSheetWkfData")
public class OaSheetWkfDataController extends BasicController {
	@Resource
	private OaSheetWkfDataService oaSheetWkfDataService;
	
	@Resource
	private OaWkfInstanceService oaWkfInstanceService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("oaSheetWkfData") OaSheetWkfData oaSheetWkfData,
			BindingResult br,Model model) {
		
		List<OaWkfInstance> wkfInstanceIdList= oaWkfInstanceService.selectList(null); 
		model.addAttribute("wkfInstanceIdList", wkfInstanceIdList);
			
	
		return "/admin/oaSheetWkfData/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("oaSheetWkfData") OaSheetWkfData oaSheetWkfData,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = oaSheetWkfDataService.selectList(oaSheetWkfData, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("oaSheetWkfData") OaSheetWkfData oaSheetWkfData,
			BindingResult br,Model model) {
		
		OaSheetWkfData newOaSheetWkfData = new OaSheetWkfData();
		
			
		List<OaWkfInstance> wkfInstanceIdList= oaWkfInstanceService.selectList(null); 
		model.addAttribute("wkfInstanceIdList", wkfInstanceIdList);
			
		
		model.addAttribute("sysUser", newOaSheetWkfData);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/oaSheetWkfData/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("oaSheetWkfData") OaSheetWkfData oaSheetWkfData,
			BindingResult br,Model model) {
		
		oaSheetWkfData = oaSheetWkfDataService.selectByPrimaryKey(oaSheetWkfData.getId());
		if(oaSheetWkfData==null){
			throw new NoDataFoundException();
		}
		List<OaWkfInstance> wkfInstanceIdList= oaWkfInstanceService.selectList(null); 
		model.addAttribute("wkfInstanceIdList", wkfInstanceIdList);
			
		model.addAttribute("oaSheetWkfData", oaSheetWkfData);
		model.addAttribute("mode", Const.editMode);
		return "/admin/oaSheetWkfData/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("oaSheetWkfData") OaSheetWkfData oaSheetWkfData,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(oaSheetWkfData.getId()==null){
				oaSheetWkfDataService.insert(oaSheetWkfData);
			}else{
				oaSheetWkfDataService.updateByPrimaryKey(oaSheetWkfData);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(oaSheetWkfData);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("oaSheetWkfData") OaSheetWkfData oaSheetWkfData,Model model) {
		oaSheetWkfData = oaSheetWkfDataService.selectByPrimaryKey(oaSheetWkfData.getId());
		if(oaSheetWkfData==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("oaSheetWkfData", oaSheetWkfData);
		return "/admin/oaSheetWkfData/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			oaSheetWkfDataService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					oaSheetWkfDataService.deleteByPrimaryKey(id);
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
