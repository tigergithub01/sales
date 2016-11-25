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
import com.sales.model.business.SysConfig;
import com.sales.service.business.SysConfigService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/sysConfig")
public class SysConfigController extends BasicController {
	@Resource
	private SysConfigService sysConfigService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysConfig") SysConfig sysConfig,
			BindingResult br,Model model) {
		
	
		return "/admin/sysConfig/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysConfig") SysConfig sysConfig,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysConfigService.selectList(sysConfig, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysConfig") SysConfig sysConfig,
			BindingResult br,Model model) {
		
		SysConfig newSysConfig = new SysConfig();
		
			
		
		model.addAttribute("sysUser", newSysConfig);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysConfig/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysConfig") SysConfig sysConfig,
			BindingResult br,Model model) {
		
		sysConfig = sysConfigService.selectByPrimaryKey(sysConfig.getId());
		if(sysConfig==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysConfig", sysConfig);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysConfig/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysConfig") SysConfig sysConfig,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysConfig.getId()==null){
				sysConfigService.insert(sysConfig);
			}else{
				sysConfigService.updateByPrimaryKey(sysConfig);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysConfig);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysConfig") SysConfig sysConfig,Model model) {
		sysConfig = sysConfigService.selectByPrimaryKey(sysConfig.getId());
		if(sysConfig==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysConfig", sysConfig);
		return "/admin/sysConfig/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysConfigService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysConfigService.deleteByPrimaryKey(id);
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
