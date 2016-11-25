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
import com.sales.model.business.SysTaskQuartz;
import com.sales.service.business.SysTaskQuartzService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;

import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/sysTaskQuartz")
public class SysTaskQuartzController extends BasicController {
	@Resource
	private SysTaskQuartzService sysTaskQuartzService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysTaskQuartz") SysTaskQuartz sysTaskQuartz,
			BindingResult br,Model model) {
		
		List<SysParameter> taskStatusList= sysParameterService.selectList(null); 
		model.addAttribute("taskStatusList", taskStatusList);
			
	
		return "/admin/sysTaskQuartz/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysTaskQuartz") SysTaskQuartz sysTaskQuartz,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysTaskQuartzService.selectList(sysTaskQuartz, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysTaskQuartz") SysTaskQuartz sysTaskQuartz,
			BindingResult br,Model model) {
		
		SysTaskQuartz newSysTaskQuartz = new SysTaskQuartz();
		
			
		List<SysParameter> taskStatusList= sysParameterService.selectList(null); 
		model.addAttribute("taskStatusList", taskStatusList);
			
		
		model.addAttribute("sysUser", newSysTaskQuartz);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysTaskQuartz/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysTaskQuartz") SysTaskQuartz sysTaskQuartz,
			BindingResult br,Model model) {
		
		sysTaskQuartz = sysTaskQuartzService.selectByPrimaryKey(sysTaskQuartz.getId());
		if(sysTaskQuartz==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> taskStatusList= sysParameterService.selectList(null); 
		model.addAttribute("taskStatusList", taskStatusList);
			
		model.addAttribute("sysTaskQuartz", sysTaskQuartz);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysTaskQuartz/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysTaskQuartz") SysTaskQuartz sysTaskQuartz,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysTaskQuartz.getId()==null){
				sysTaskQuartzService.insert(sysTaskQuartz);
			}else{
				sysTaskQuartzService.updateByPrimaryKey(sysTaskQuartz);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysTaskQuartz);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysTaskQuartz") SysTaskQuartz sysTaskQuartz,Model model) {
		sysTaskQuartz = sysTaskQuartzService.selectByPrimaryKey(sysTaskQuartz.getId());
		if(sysTaskQuartz==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysTaskQuartz", sysTaskQuartz);
		return "/admin/sysTaskQuartz/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysTaskQuartzService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysTaskQuartzService.deleteByPrimaryKey(id);
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
