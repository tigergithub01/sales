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
import com.sales.model.business.DrpSheetDetail;
import com.sales.service.business.DrpSheetDetailService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpSheetService;
import com.sales.service.business.ActivityService;
import com.sales.service.business.SysUnitService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.DrpMatBatchService;

import com.sales.model.business.DrpSheet;
import com.sales.model.business.Activity;
import com.sales.model.business.SysUnit;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.DrpMatBatch;

@Controller
@RequestMapping("/admin/drpSheetDetail")
public class DrpSheetDetailController extends BasicController {
	@Resource
	private DrpSheetDetailService drpSheetDetailService;
	
	@Resource
	private DrpSheetService drpSheetService;	
	
	@Resource
	private ActivityService activityService;	
	
	@Resource
	private SysUnitService sysUnitService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private DrpMatBatchService drpMatBatchService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpSheetDetail") DrpSheetDetail drpSheetDetail,
			BindingResult br,Model model) {
		
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpSheet> refSheetIdList= drpSheetService.selectList(null); 
		model.addAttribute("refSheetIdList", refSheetIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<SysParameter> isExchangeList= sysParameterService.selectList(null); 
		model.addAttribute("isExchangeList", isExchangeList);
			
	
		return "/admin/drpSheetDetail/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpSheetDetail") DrpSheetDetail drpSheetDetail,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpSheetDetailService.selectList(drpSheetDetail, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpSheetDetail") DrpSheetDetail drpSheetDetail,
			BindingResult br,Model model) {
		
		DrpSheetDetail newDrpSheetDetail = new DrpSheetDetail();
		
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpSheet> refSheetIdList= drpSheetService.selectList(null); 
		model.addAttribute("refSheetIdList", refSheetIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<SysParameter> isExchangeList= sysParameterService.selectList(null); 
		model.addAttribute("isExchangeList", isExchangeList);
			
		
		model.addAttribute("sysUser", newDrpSheetDetail);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpSheetDetail/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpSheetDetail") DrpSheetDetail drpSheetDetail,
			BindingResult br,Model model) {
		
		drpSheetDetail = drpSheetDetailService.selectByPrimaryKey(drpSheetDetail.getId());
		if(drpSheetDetail==null){
			throw new NoDataFoundException();
		}
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<SysUnit> unitIdList= sysUnitService.selectList(null); 
		model.addAttribute("unitIdList", unitIdList);
			
		List<DrpSheet> refSheetIdList= drpSheetService.selectList(null); 
		model.addAttribute("refSheetIdList", refSheetIdList);
			
		List<DrpMatBatch> batchIdList= drpMatBatchService.selectList(null); 
		model.addAttribute("batchIdList", batchIdList);
			
		List<Activity> actIdList= activityService.selectList(null); 
		model.addAttribute("actIdList", actIdList);
			
		List<SysParameter> isExchangeList= sysParameterService.selectList(null); 
		model.addAttribute("isExchangeList", isExchangeList);
			
		model.addAttribute("drpSheetDetail", drpSheetDetail);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpSheetDetail/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpSheetDetail") DrpSheetDetail drpSheetDetail,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpSheetDetail.getId()==null){
				drpSheetDetailService.insert(drpSheetDetail);
			}else{
				drpSheetDetailService.updateByPrimaryKey(drpSheetDetail);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpSheetDetail);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpSheetDetail") DrpSheetDetail drpSheetDetail,Model model) {
		drpSheetDetail = drpSheetDetailService.selectByPrimaryKey(drpSheetDetail.getId());
		if(drpSheetDetail==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpSheetDetail", drpSheetDetail);
		return "/admin/drpSheetDetail/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpSheetDetailService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpSheetDetailService.deleteByPrimaryKey(id);
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
