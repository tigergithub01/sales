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
import com.sales.model.business.DrpPosTransSaleFlow;
import com.sales.service.business.DrpPosTransSaleFlowService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUnitService;
import com.sales.service.business.DrpMatBatchService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.DrpPosTransInfoService;

import com.sales.model.business.SysUnit;
import com.sales.model.business.DrpMatBatch;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpPosTransInfo;

@Controller
@RequestMapping("/admin/drpPosTransSaleFlow")
public class DrpPosTransSaleFlowController extends BasicController {
	@Resource
	private DrpPosTransSaleFlowService drpPosTransSaleFlowService;
	
	@Resource
	private SysUnitService sysUnitService;	
	
	@Resource
	private DrpMatBatchService drpMatBatchService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpPosTransSaleFlow") DrpPosTransSaleFlow drpPosTransSaleFlow,
			BindingResult br,Model model) {
		
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
	
		return "/admin/drpPosTransSaleFlow/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpPosTransSaleFlow") DrpPosTransSaleFlow drpPosTransSaleFlow,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpPosTransSaleFlowService.selectList(drpPosTransSaleFlow, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpPosTransSaleFlow") DrpPosTransSaleFlow drpPosTransSaleFlow,
			BindingResult br,Model model) {
		
		DrpPosTransSaleFlow newDrpPosTransSaleFlow = new DrpPosTransSaleFlow();
		
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		
		model.addAttribute("sysUser", newDrpPosTransSaleFlow);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpPosTransSaleFlow/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpPosTransSaleFlow") DrpPosTransSaleFlow drpPosTransSaleFlow,
			BindingResult br,Model model) {
		
		drpPosTransSaleFlow = drpPosTransSaleFlowService.selectByPrimaryKey(drpPosTransSaleFlow.getId());
		if(drpPosTransSaleFlow==null){
			throw new NoDataFoundException();
		}
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		model.addAttribute("drpPosTransSaleFlow", drpPosTransSaleFlow);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpPosTransSaleFlow/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpPosTransSaleFlow") DrpPosTransSaleFlow drpPosTransSaleFlow,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpPosTransSaleFlow.getId()==null){
				drpPosTransSaleFlowService.insert(drpPosTransSaleFlow);
			}else{
				drpPosTransSaleFlowService.updateByPrimaryKey(drpPosTransSaleFlow);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpPosTransSaleFlow);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpPosTransSaleFlow") DrpPosTransSaleFlow drpPosTransSaleFlow,Model model) {
		drpPosTransSaleFlow = drpPosTransSaleFlowService.selectByPrimaryKey(drpPosTransSaleFlow.getId());
		if(drpPosTransSaleFlow==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpPosTransSaleFlow", drpPosTransSaleFlow);
		return "/admin/drpPosTransSaleFlow/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpPosTransSaleFlowService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpPosTransSaleFlowService.deleteByPrimaryKey(id);
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
