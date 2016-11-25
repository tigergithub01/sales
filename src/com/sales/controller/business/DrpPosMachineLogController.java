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
import com.sales.model.business.DrpPosMachineLog;
import com.sales.service.business.DrpPosMachineLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.DrpPosMachineService;

import com.sales.model.business.SysUser;
import com.sales.model.business.DrpPosMachine;

@Controller
@RequestMapping("/admin/drpPosMachineLog")
public class DrpPosMachineLogController extends BasicController {
	@Resource
	private DrpPosMachineLogService drpPosMachineLogService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private DrpPosMachineService drpPosMachineService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpPosMachineLog") DrpPosMachineLog drpPosMachineLog,
			BindingResult br,Model model) {
		
		List<DrpPosMachine> machineIdList= drpPosMachineService.selectList(null); 
		model.addAttribute("machineIdList", machineIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
	
		return "/admin/drpPosMachineLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpPosMachineLog") DrpPosMachineLog drpPosMachineLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpPosMachineLogService.selectList(drpPosMachineLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpPosMachineLog") DrpPosMachineLog drpPosMachineLog,
			BindingResult br,Model model) {
		
		DrpPosMachineLog newDrpPosMachineLog = new DrpPosMachineLog();
		
			
		List<DrpPosMachine> machineIdList= drpPosMachineService.selectList(null); 
		model.addAttribute("machineIdList", machineIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		
		model.addAttribute("sysUser", newDrpPosMachineLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpPosMachineLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpPosMachineLog") DrpPosMachineLog drpPosMachineLog,
			BindingResult br,Model model) {
		
		drpPosMachineLog = drpPosMachineLogService.selectByPrimaryKey(drpPosMachineLog.getId());
		if(drpPosMachineLog==null){
			throw new NoDataFoundException();
		}
		List<DrpPosMachine> machineIdList= drpPosMachineService.selectList(null); 
		model.addAttribute("machineIdList", machineIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		model.addAttribute("drpPosMachineLog", drpPosMachineLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpPosMachineLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpPosMachineLog") DrpPosMachineLog drpPosMachineLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpPosMachineLog.getId()==null){
				drpPosMachineLogService.insert(drpPosMachineLog);
			}else{
				drpPosMachineLogService.updateByPrimaryKey(drpPosMachineLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpPosMachineLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpPosMachineLog") DrpPosMachineLog drpPosMachineLog,Model model) {
		drpPosMachineLog = drpPosMachineLogService.selectByPrimaryKey(drpPosMachineLog.getId());
		if(drpPosMachineLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpPosMachineLog", drpPosMachineLog);
		return "/admin/drpPosMachineLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpPosMachineLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpPosMachineLogService.deleteByPrimaryKey(id);
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
