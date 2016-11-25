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
import com.sales.model.business.VipDepositLog;
import com.sales.service.business.VipDepositLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipDepositService;

import com.sales.model.business.VipDeposit;

@Controller
@RequestMapping("/admin/vipDepositLog")
public class VipDepositLogController extends BasicController {
	@Resource
	private VipDepositLogService vipDepositLogService;
	
	@Resource
	private VipDepositService vipDepositService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipDepositLog") VipDepositLog vipDepositLog,
			BindingResult br,Model model) {
		
		List<VipDeposit> depositIdList= vipDepositService.selectList(null); 
		model.addAttribute("depositIdList", depositIdList);
			
	
		return "/admin/vipDepositLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipDepositLog") VipDepositLog vipDepositLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipDepositLogService.selectList(vipDepositLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipDepositLog") VipDepositLog vipDepositLog,
			BindingResult br,Model model) {
		
		VipDepositLog newVipDepositLog = new VipDepositLog();
		
			
		List<VipDeposit> depositIdList= vipDepositService.selectList(null); 
		model.addAttribute("depositIdList", depositIdList);
			
		
		model.addAttribute("sysUser", newVipDepositLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipDepositLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipDepositLog") VipDepositLog vipDepositLog,
			BindingResult br,Model model) {
		
		vipDepositLog = vipDepositLogService.selectByPrimaryKey(vipDepositLog.getId());
		if(vipDepositLog==null){
			throw new NoDataFoundException();
		}
		List<VipDeposit> depositIdList= vipDepositService.selectList(null); 
		model.addAttribute("depositIdList", depositIdList);
			
		model.addAttribute("vipDepositLog", vipDepositLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipDepositLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipDepositLog") VipDepositLog vipDepositLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipDepositLog.getId()==null){
				vipDepositLogService.insert(vipDepositLog);
			}else{
				vipDepositLogService.updateByPrimaryKey(vipDepositLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipDepositLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipDepositLog") VipDepositLog vipDepositLog,Model model) {
		vipDepositLog = vipDepositLogService.selectByPrimaryKey(vipDepositLog.getId());
		if(vipDepositLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipDepositLog", vipDepositLog);
		return "/admin/vipDepositLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipDepositLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipDepositLogService.deleteByPrimaryKey(id);
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
