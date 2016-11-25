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
import com.sales.model.business.SysAppInfo;
import com.sales.service.business.SysAppInfoService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/sysAppInfo")
public class SysAppInfoController extends BasicController {
	@Resource
	private SysAppInfoService sysAppInfoService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysAppInfo") SysAppInfo sysAppInfo,
			BindingResult br,Model model) {
		
	
		return "/admin/sysAppInfo/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysAppInfo") SysAppInfo sysAppInfo,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysAppInfoService.selectList(sysAppInfo, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysAppInfo") SysAppInfo sysAppInfo,
			BindingResult br,Model model) {
		
		SysAppInfo newSysAppInfo = new SysAppInfo();
		
			
		
		model.addAttribute("sysUser", newSysAppInfo);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysAppInfo/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysAppInfo") SysAppInfo sysAppInfo,
			BindingResult br,Model model) {
		
		sysAppInfo = sysAppInfoService.selectByPrimaryKey(sysAppInfo.getId());
		if(sysAppInfo==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysAppInfo", sysAppInfo);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysAppInfo/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysAppInfo") SysAppInfo sysAppInfo,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysAppInfo.getId()==null){
				sysAppInfoService.insert(sysAppInfo);
			}else{
				sysAppInfoService.updateByPrimaryKey(sysAppInfo);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysAppInfo);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysAppInfo") SysAppInfo sysAppInfo,Model model) {
		sysAppInfo = sysAppInfoService.selectByPrimaryKey(sysAppInfo.getId());
		if(sysAppInfo==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysAppInfo", sysAppInfo);
		return "/admin/sysAppInfo/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysAppInfoService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysAppInfoService.deleteByPrimaryKey(id);
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
