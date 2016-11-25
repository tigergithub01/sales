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
import com.sales.model.business.OrgActAuthDetail;
import com.sales.service.business.OrgActAuthDetailService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.ActTypeService;
import com.sales.service.business.OrgActAuthService;

import com.sales.model.business.ActType;
import com.sales.model.business.OrgActAuth;

@Controller
@RequestMapping("/admin/orgActAuthDetail")
public class OrgActAuthDetailController extends BasicController {
	@Resource
	private OrgActAuthDetailService orgActAuthDetailService;
	
	@Resource
	private ActTypeService actTypeService;	
	
	@Resource
	private OrgActAuthService orgActAuthService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("orgActAuthDetail") OrgActAuthDetail orgActAuthDetail,
			BindingResult br,Model model) {
		
		List<OrgActAuth> actAuthIdList= orgActAuthService.selectList(null); 
		model.addAttribute("actAuthIdList", actAuthIdList);
			
		List<ActType> actTypeIdList= actTypeService.selectList(null); 
		model.addAttribute("actTypeIdList", actTypeIdList);
			
	
		return "/admin/orgActAuthDetail/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("orgActAuthDetail") OrgActAuthDetail orgActAuthDetail,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = orgActAuthDetailService.selectList(orgActAuthDetail, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("orgActAuthDetail") OrgActAuthDetail orgActAuthDetail,
			BindingResult br,Model model) {
		
		OrgActAuthDetail newOrgActAuthDetail = new OrgActAuthDetail();
		
			
		List<OrgActAuth> actAuthIdList= orgActAuthService.selectList(null); 
		model.addAttribute("actAuthIdList", actAuthIdList);
			
		List<ActType> actTypeIdList= actTypeService.selectList(null); 
		model.addAttribute("actTypeIdList", actTypeIdList);
			
		
		model.addAttribute("sysUser", newOrgActAuthDetail);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/orgActAuthDetail/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("orgActAuthDetail") OrgActAuthDetail orgActAuthDetail,
			BindingResult br,Model model) {
		
		orgActAuthDetail = orgActAuthDetailService.selectByPrimaryKey(orgActAuthDetail.getId());
		if(orgActAuthDetail==null){
			throw new NoDataFoundException();
		}
		List<OrgActAuth> actAuthIdList= orgActAuthService.selectList(null); 
		model.addAttribute("actAuthIdList", actAuthIdList);
			
		List<ActType> actTypeIdList= actTypeService.selectList(null); 
		model.addAttribute("actTypeIdList", actTypeIdList);
			
		model.addAttribute("orgActAuthDetail", orgActAuthDetail);
		model.addAttribute("mode", Const.editMode);
		return "/admin/orgActAuthDetail/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("orgActAuthDetail") OrgActAuthDetail orgActAuthDetail,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(orgActAuthDetail.getId()==null){
				orgActAuthDetailService.insert(orgActAuthDetail);
			}else{
				orgActAuthDetailService.updateByPrimaryKey(orgActAuthDetail);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(orgActAuthDetail);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("orgActAuthDetail") OrgActAuthDetail orgActAuthDetail,Model model) {
		orgActAuthDetail = orgActAuthDetailService.selectByPrimaryKey(orgActAuthDetail.getId());
		if(orgActAuthDetail==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("orgActAuthDetail", orgActAuthDetail);
		return "/admin/orgActAuthDetail/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			orgActAuthDetailService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					orgActAuthDetailService.deleteByPrimaryKey(id);
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
