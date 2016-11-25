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
import com.sales.model.business.OaSheetWkfDataDetail;
import com.sales.service.business.OaSheetWkfDataDetailService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OaSheetWkfDataService;

import com.sales.model.business.OaSheetWkfData;

@Controller
@RequestMapping("/admin/oaSheetWkfDataDetail")
public class OaSheetWkfDataDetailController extends BasicController {
	@Resource
	private OaSheetWkfDataDetailService oaSheetWkfDataDetailService;
	
	@Resource
	private OaSheetWkfDataService oaSheetWkfDataService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("oaSheetWkfDataDetail") OaSheetWkfDataDetail oaSheetWkfDataDetail,
			BindingResult br,Model model) {
		
		List<OaSheetWkfData> wkfDataIdList= oaSheetWkfDataService.selectList(null); 
		model.addAttribute("wkfDataIdList", wkfDataIdList);
			
	
		return "/admin/oaSheetWkfDataDetail/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("oaSheetWkfDataDetail") OaSheetWkfDataDetail oaSheetWkfDataDetail,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = oaSheetWkfDataDetailService.selectList(oaSheetWkfDataDetail, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("oaSheetWkfDataDetail") OaSheetWkfDataDetail oaSheetWkfDataDetail,
			BindingResult br,Model model) {
		
		OaSheetWkfDataDetail newOaSheetWkfDataDetail = new OaSheetWkfDataDetail();
		
			
		List<OaSheetWkfData> wkfDataIdList= oaSheetWkfDataService.selectList(null); 
		model.addAttribute("wkfDataIdList", wkfDataIdList);
			
		
		model.addAttribute("sysUser", newOaSheetWkfDataDetail);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/oaSheetWkfDataDetail/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("oaSheetWkfDataDetail") OaSheetWkfDataDetail oaSheetWkfDataDetail,
			BindingResult br,Model model) {
		
		oaSheetWkfDataDetail = oaSheetWkfDataDetailService.selectByPrimaryKey(oaSheetWkfDataDetail.getId());
		if(oaSheetWkfDataDetail==null){
			throw new NoDataFoundException();
		}
		List<OaSheetWkfData> wkfDataIdList= oaSheetWkfDataService.selectList(null); 
		model.addAttribute("wkfDataIdList", wkfDataIdList);
			
		model.addAttribute("oaSheetWkfDataDetail", oaSheetWkfDataDetail);
		model.addAttribute("mode", Const.editMode);
		return "/admin/oaSheetWkfDataDetail/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("oaSheetWkfDataDetail") OaSheetWkfDataDetail oaSheetWkfDataDetail,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(oaSheetWkfDataDetail.getId()==null){
				oaSheetWkfDataDetailService.insert(oaSheetWkfDataDetail);
			}else{
				oaSheetWkfDataDetailService.updateByPrimaryKey(oaSheetWkfDataDetail);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(oaSheetWkfDataDetail);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("oaSheetWkfDataDetail") OaSheetWkfDataDetail oaSheetWkfDataDetail,Model model) {
		oaSheetWkfDataDetail = oaSheetWkfDataDetailService.selectByPrimaryKey(oaSheetWkfDataDetail.getId());
		if(oaSheetWkfDataDetail==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("oaSheetWkfDataDetail", oaSheetWkfDataDetail);
		return "/admin/oaSheetWkfDataDetail/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			oaSheetWkfDataDetailService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					oaSheetWkfDataDetailService.deleteByPrimaryKey(id);
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
