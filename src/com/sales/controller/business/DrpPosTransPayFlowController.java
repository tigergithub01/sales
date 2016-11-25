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
import com.sales.model.business.DrpPosTransPayFlow;
import com.sales.service.business.DrpPosTransPayFlowService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysPayTypeService;
import com.sales.service.business.SysCurrencyService;
import com.sales.service.business.DrpPosTransInfoService;
import com.sales.service.business.SysParameterService;

import com.sales.model.business.SysPayType;
import com.sales.model.business.SysCurrency;
import com.sales.model.business.DrpPosTransInfo;
import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/drpPosTransPayFlow")
public class DrpPosTransPayFlowController extends BasicController {
	@Resource
	private DrpPosTransPayFlowService drpPosTransPayFlowService;
	
	@Resource
	private SysPayTypeService sysPayTypeService;	
	
	@Resource
	private SysCurrencyService sysCurrencyService;	
	
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpPosTransPayFlow") DrpPosTransPayFlow drpPosTransPayFlow,
			BindingResult br,Model model) {
		
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<SysParameter> saleTypeList= sysParameterService.selectList(null); 
		model.addAttribute("saleTypeList", saleTypeList);
			
		List<SysPayType> payTypeList= sysPayTypeService.selectList(null); 
		model.addAttribute("payTypeList", payTypeList);
			
		List<SysCurrency> currencyIdList= sysCurrencyService.selectList(null); 
		model.addAttribute("currencyIdList", currencyIdList);
			
	
		return "/admin/drpPosTransPayFlow/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpPosTransPayFlow") DrpPosTransPayFlow drpPosTransPayFlow,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpPosTransPayFlowService.selectList(drpPosTransPayFlow, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpPosTransPayFlow") DrpPosTransPayFlow drpPosTransPayFlow,
			BindingResult br,Model model) {
		
		DrpPosTransPayFlow newDrpPosTransPayFlow = new DrpPosTransPayFlow();
		
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<SysParameter> saleTypeList= sysParameterService.selectList(null); 
		model.addAttribute("saleTypeList", saleTypeList);
			
		List<SysPayType> payTypeList= sysPayTypeService.selectList(null); 
		model.addAttribute("payTypeList", payTypeList);
			
		List<SysCurrency> currencyIdList= sysCurrencyService.selectList(null); 
		model.addAttribute("currencyIdList", currencyIdList);
			
		
		model.addAttribute("sysUser", newDrpPosTransPayFlow);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpPosTransPayFlow/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpPosTransPayFlow") DrpPosTransPayFlow drpPosTransPayFlow,
			BindingResult br,Model model) {
		
		drpPosTransPayFlow = drpPosTransPayFlowService.selectByPrimaryKey(drpPosTransPayFlow.getId());
		if(drpPosTransPayFlow==null){
			throw new NoDataFoundException();
		}
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<SysParameter> saleTypeList= sysParameterService.selectList(null); 
		model.addAttribute("saleTypeList", saleTypeList);
			
		List<SysPayType> payTypeList= sysPayTypeService.selectList(null); 
		model.addAttribute("payTypeList", payTypeList);
			
		List<SysCurrency> currencyIdList= sysCurrencyService.selectList(null); 
		model.addAttribute("currencyIdList", currencyIdList);
			
		model.addAttribute("drpPosTransPayFlow", drpPosTransPayFlow);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpPosTransPayFlow/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpPosTransPayFlow") DrpPosTransPayFlow drpPosTransPayFlow,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpPosTransPayFlow.getId()==null){
				drpPosTransPayFlowService.insert(drpPosTransPayFlow);
			}else{
				drpPosTransPayFlowService.updateByPrimaryKey(drpPosTransPayFlow);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpPosTransPayFlow);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpPosTransPayFlow") DrpPosTransPayFlow drpPosTransPayFlow,Model model) {
		drpPosTransPayFlow = drpPosTransPayFlowService.selectByPrimaryKey(drpPosTransPayFlow.getId());
		if(drpPosTransPayFlow==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpPosTransPayFlow", drpPosTransPayFlow);
		return "/admin/drpPosTransPayFlow/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpPosTransPayFlowService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpPosTransPayFlowService.deleteByPrimaryKey(id);
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
