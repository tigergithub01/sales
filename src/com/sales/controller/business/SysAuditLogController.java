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
import com.sales.model.business.SysAuditLog;
import com.sales.service.business.SysAuditLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;

import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/sysAuditLog")
public class SysAuditLogController extends BasicController {
	@Resource
	private SysAuditLogService sysAuditLogService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysAuditLog") SysAuditLog sysAuditLog,
			BindingResult br,Model model) {
		
		List<SysParameter> auditTypeList= sysParameterService.selectList(null); 
		model.addAttribute("auditTypeList", auditTypeList);
			
		List<SysParameter> auditOperateList= sysParameterService.selectList(null); 
		model.addAttribute("auditOperateList", auditOperateList);
			
	
		return "/admin/sysAuditLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysAuditLog") SysAuditLog sysAuditLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysAuditLogService.selectList(sysAuditLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysAuditLog") SysAuditLog sysAuditLog,
			BindingResult br,Model model) {
		
		SysAuditLog newSysAuditLog = new SysAuditLog();
		
			
		List<SysParameter> auditTypeList= sysParameterService.selectList(null); 
		model.addAttribute("auditTypeList", auditTypeList);
			
		List<SysParameter> auditOperateList= sysParameterService.selectList(null); 
		model.addAttribute("auditOperateList", auditOperateList);
			
		
		model.addAttribute("sysUser", newSysAuditLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysAuditLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysAuditLog") SysAuditLog sysAuditLog,
			BindingResult br,Model model) {
		
		sysAuditLog = sysAuditLogService.selectByPrimaryKey(sysAuditLog.getId());
		if(sysAuditLog==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> auditTypeList= sysParameterService.selectList(null); 
		model.addAttribute("auditTypeList", auditTypeList);
			
		List<SysParameter> auditOperateList= sysParameterService.selectList(null); 
		model.addAttribute("auditOperateList", auditOperateList);
			
		model.addAttribute("sysAuditLog", sysAuditLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysAuditLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysAuditLog") SysAuditLog sysAuditLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysAuditLog.getId()==null){
				sysAuditLogService.insert(sysAuditLog);
			}else{
				sysAuditLogService.updateByPrimaryKey(sysAuditLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysAuditLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysAuditLog") SysAuditLog sysAuditLog,Model model) {
		sysAuditLog = sysAuditLogService.selectByPrimaryKey(sysAuditLog.getId());
		if(sysAuditLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysAuditLog", sysAuditLog);
		return "/admin/sysAuditLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysAuditLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysAuditLogService.deleteByPrimaryKey(id);
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
