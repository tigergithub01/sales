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
import com.sales.model.business.VipGiftLog;
import com.sales.service.business.VipGiftLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipService;
import com.sales.service.business.ActivityService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpPosTransInfoService;

import com.sales.model.business.Vip;
import com.sales.model.business.Activity;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpPosTransInfo;

@Controller
@RequestMapping("/admin/vipGiftLog")
public class VipGiftLogController extends BasicController {
	@Resource
	private VipGiftLogService vipGiftLogService;
	
	@Resource
	private VipService vipService;	
	
	@Resource
	private ActivityService activityService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipGiftLog") VipGiftLog vipGiftLog,
			BindingResult br,Model model) {
		
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Activity> activityIdList= activityService.selectList(null); 
		model.addAttribute("activityIdList", activityIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
	
		return "/admin/vipGiftLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipGiftLog") VipGiftLog vipGiftLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipGiftLogService.selectList(vipGiftLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipGiftLog") VipGiftLog vipGiftLog,
			BindingResult br,Model model) {
		
		VipGiftLog newVipGiftLog = new VipGiftLog();
		
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Activity> activityIdList= activityService.selectList(null); 
		model.addAttribute("activityIdList", activityIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		
		model.addAttribute("sysUser", newVipGiftLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipGiftLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipGiftLog") VipGiftLog vipGiftLog,
			BindingResult br,Model model) {
		
		vipGiftLog = vipGiftLogService.selectByPrimaryKey(vipGiftLog.getId());
		if(vipGiftLog==null){
			throw new NoDataFoundException();
		}
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Activity> activityIdList= activityService.selectList(null); 
		model.addAttribute("activityIdList", activityIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		model.addAttribute("vipGiftLog", vipGiftLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipGiftLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipGiftLog") VipGiftLog vipGiftLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipGiftLog.getId()==null){
				vipGiftLogService.insert(vipGiftLog);
			}else{
				vipGiftLogService.updateByPrimaryKey(vipGiftLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipGiftLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipGiftLog") VipGiftLog vipGiftLog,Model model) {
		vipGiftLog = vipGiftLogService.selectByPrimaryKey(vipGiftLog.getId());
		if(vipGiftLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipGiftLog", vipGiftLog);
		return "/admin/vipGiftLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipGiftLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipGiftLogService.deleteByPrimaryKey(id);
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
