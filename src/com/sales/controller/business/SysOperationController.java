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
import com.sales.model.business.SysOperation;
import com.sales.service.business.SysOperationService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/sysOperation")
public class SysOperationController extends BasicController {
	@Resource
	private SysOperationService sysOperationService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysOperation") SysOperation sysOperation,
			BindingResult br,Model model) {
		
	
		return "/admin/sysOperation/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysOperation") SysOperation sysOperation,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysOperationService.selectList(sysOperation, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysOperation") SysOperation sysOperation,
			BindingResult br,Model model) {
		
		SysOperation newSysOperation = new SysOperation();
		
			
		
		model.addAttribute("sysUser", newSysOperation);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysOperation/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysOperation") SysOperation sysOperation,
			BindingResult br,Model model) {
		
		sysOperation = sysOperationService.selectByPrimaryKey(sysOperation.getId());
		if(sysOperation==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysOperation", sysOperation);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysOperation/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysOperation") SysOperation sysOperation,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysOperation.getId()==null){
				sysOperationService.insert(sysOperation);
			}else{
				sysOperationService.updateByPrimaryKey(sysOperation);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysOperation);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysOperation") SysOperation sysOperation,Model model) {
		sysOperation = sysOperationService.selectByPrimaryKey(sysOperation.getId());
		if(sysOperation==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysOperation", sysOperation);
		return "/admin/sysOperation/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysOperationService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysOperationService.deleteByPrimaryKey(id);
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
