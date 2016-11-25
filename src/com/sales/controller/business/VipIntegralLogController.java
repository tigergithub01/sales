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
import com.sales.model.business.VipIntegralLog;
import com.sales.service.business.VipIntegralLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpPosTransInfoService;

import com.sales.model.business.Vip;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpPosTransInfo;

@Controller
@RequestMapping("/admin/vipIntegralLog")
public class VipIntegralLogController extends BasicController {
	@Resource
	private VipIntegralLogService vipIntegralLogService;
	
	@Resource
	private VipService vipService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipIntegralLog") VipIntegralLog vipIntegralLog,
			BindingResult br,Model model) {
		
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> orgranizationIdList= organizationService.selectList(null); 
		model.addAttribute("orgranizationIdList", orgranizationIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
	
		return "/admin/vipIntegralLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipIntegralLog") VipIntegralLog vipIntegralLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipIntegralLogService.selectList(vipIntegralLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipIntegralLog") VipIntegralLog vipIntegralLog,
			BindingResult br,Model model) {
		
		VipIntegralLog newVipIntegralLog = new VipIntegralLog();
		
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> orgranizationIdList= organizationService.selectList(null); 
		model.addAttribute("orgranizationIdList", orgranizationIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		
		model.addAttribute("sysUser", newVipIntegralLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipIntegralLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipIntegralLog") VipIntegralLog vipIntegralLog,
			BindingResult br,Model model) {
		
		vipIntegralLog = vipIntegralLogService.selectByPrimaryKey(vipIntegralLog.getId());
		if(vipIntegralLog==null){
			throw new NoDataFoundException();
		}
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> orgranizationIdList= organizationService.selectList(null); 
		model.addAttribute("orgranizationIdList", orgranizationIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		model.addAttribute("vipIntegralLog", vipIntegralLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipIntegralLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipIntegralLog") VipIntegralLog vipIntegralLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipIntegralLog.getId()==null){
				vipIntegralLogService.insert(vipIntegralLog);
			}else{
				vipIntegralLogService.updateByPrimaryKey(vipIntegralLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipIntegralLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipIntegralLog") VipIntegralLog vipIntegralLog,Model model) {
		vipIntegralLog = vipIntegralLogService.selectByPrimaryKey(vipIntegralLog.getId());
		if(vipIntegralLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipIntegralLog", vipIntegralLog);
		return "/admin/vipIntegralLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipIntegralLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipIntegralLogService.deleteByPrimaryKey(id);
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
