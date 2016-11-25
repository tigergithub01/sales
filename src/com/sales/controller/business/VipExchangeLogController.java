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
import com.sales.model.business.VipExchangeLog;
import com.sales.service.business.VipExchangeLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.Vip;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/vipExchangeLog")
public class VipExchangeLogController extends BasicController {
	@Resource
	private VipExchangeLogService vipExchangeLogService;
	
	@Resource
	private VipService vipService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipExchangeLog") VipExchangeLog vipExchangeLog,
			BindingResult br,Model model) {
		
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> orgranizationIdList= organizationService.selectList(null); 
		model.addAttribute("orgranizationIdList", orgranizationIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
	
		return "/admin/vipExchangeLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipExchangeLog") VipExchangeLog vipExchangeLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipExchangeLogService.selectList(vipExchangeLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipExchangeLog") VipExchangeLog vipExchangeLog,
			BindingResult br,Model model) {
		
		VipExchangeLog newVipExchangeLog = new VipExchangeLog();
		
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> orgranizationIdList= organizationService.selectList(null); 
		model.addAttribute("orgranizationIdList", orgranizationIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		
		model.addAttribute("sysUser", newVipExchangeLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipExchangeLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipExchangeLog") VipExchangeLog vipExchangeLog,
			BindingResult br,Model model) {
		
		vipExchangeLog = vipExchangeLogService.selectByPrimaryKey(vipExchangeLog.getId());
		if(vipExchangeLog==null){
			throw new NoDataFoundException();
		}
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> orgranizationIdList= organizationService.selectList(null); 
		model.addAttribute("orgranizationIdList", orgranizationIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		model.addAttribute("vipExchangeLog", vipExchangeLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipExchangeLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipExchangeLog") VipExchangeLog vipExchangeLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipExchangeLog.getId()==null){
				vipExchangeLogService.insert(vipExchangeLog);
			}else{
				vipExchangeLogService.updateByPrimaryKey(vipExchangeLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipExchangeLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipExchangeLog") VipExchangeLog vipExchangeLog,Model model) {
		vipExchangeLog = vipExchangeLogService.selectByPrimaryKey(vipExchangeLog.getId());
		if(vipExchangeLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipExchangeLog", vipExchangeLog);
		return "/admin/vipExchangeLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipExchangeLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipExchangeLogService.deleteByPrimaryKey(id);
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
