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
import com.sales.model.business.SysOperationLog;
import com.sales.service.business.SysOperationLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysModuleService;
import com.sales.service.business.SysOperationService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysModule;
import com.sales.model.business.SysOperation;

@Controller
@RequestMapping("/admin/sysOperationLog")
public class SysOperationLogController extends BasicController {
	@Resource
	private SysOperationLogService sysOperationLogService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysModuleService sysModuleService;	
	
	@Resource
	private SysOperationService sysOperationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysOperationLog") SysOperationLog sysOperationLog,
			BindingResult br,Model model) {
		
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<SysModule> moduleIdList= sysModuleService.selectList(null); 
		model.addAttribute("moduleIdList", moduleIdList);
			
		List<SysOperation> operationIdList= sysOperationService.selectList(null); 
		model.addAttribute("operationIdList", operationIdList);
			
	
		return "/admin/sysOperationLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysOperationLog") SysOperationLog sysOperationLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysOperationLogService.selectList(sysOperationLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysOperationLog") SysOperationLog sysOperationLog,
			BindingResult br,Model model) {
		
		SysOperationLog newSysOperationLog = new SysOperationLog();
		
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<SysModule> moduleIdList= sysModuleService.selectList(null); 
		model.addAttribute("moduleIdList", moduleIdList);
			
		List<SysOperation> operationIdList= sysOperationService.selectList(null); 
		model.addAttribute("operationIdList", operationIdList);
			
		
		model.addAttribute("sysUser", newSysOperationLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysOperationLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysOperationLog") SysOperationLog sysOperationLog,
			BindingResult br,Model model) {
		
		sysOperationLog = sysOperationLogService.selectByPrimaryKey(sysOperationLog.getId());
		if(sysOperationLog==null){
			throw new NoDataFoundException();
		}
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<SysModule> moduleIdList= sysModuleService.selectList(null); 
		model.addAttribute("moduleIdList", moduleIdList);
			
		List<SysOperation> operationIdList= sysOperationService.selectList(null); 
		model.addAttribute("operationIdList", operationIdList);
			
		model.addAttribute("sysOperationLog", sysOperationLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysOperationLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysOperationLog") SysOperationLog sysOperationLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysOperationLog.getId()==null){
				sysOperationLogService.insert(sysOperationLog);
			}else{
				sysOperationLogService.updateByPrimaryKey(sysOperationLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysOperationLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysOperationLog") SysOperationLog sysOperationLog,Model model) {
		sysOperationLog = sysOperationLogService.selectByPrimaryKey(sysOperationLog.getId());
		if(sysOperationLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysOperationLog", sysOperationLog);
		return "/admin/sysOperationLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysOperationLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysOperationLogService.deleteByPrimaryKey(id);
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
