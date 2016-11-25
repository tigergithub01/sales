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
import com.sales.model.business.SysModule;
import com.sales.service.business.SysModuleService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.SysModuleService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.SysModule;

@Controller
@RequestMapping("/admin/sysModule")
public class SysModuleController extends BasicController {
	@Resource
	private SysModuleService sysModuleService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysModule") SysModule sysModule,
			BindingResult br,Model model) {
		
		List<SysModule> parentIdList= sysModuleService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> menuFlagList= sysParameterService.selectList(null); 
		model.addAttribute("menuFlagList", menuFlagList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
	
		return "/admin/sysModule/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysModule") SysModule sysModule,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysModuleService.selectList(sysModule, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysModule") SysModule sysModule,
			BindingResult br,Model model) {
		
		SysModule newSysModule = new SysModule();
		
			
		List<SysModule> parentIdList= sysModuleService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> menuFlagList= sysParameterService.selectList(null); 
		model.addAttribute("menuFlagList", menuFlagList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		
		model.addAttribute("sysUser", newSysModule);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysModule/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysModule") SysModule sysModule,
			BindingResult br,Model model) {
		
		sysModule = sysModuleService.selectByPrimaryKey(sysModule.getId());
		if(sysModule==null){
			throw new NoDataFoundException();
		}
		List<SysModule> parentIdList= sysModuleService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> menuFlagList= sysParameterService.selectList(null); 
		model.addAttribute("menuFlagList", menuFlagList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		model.addAttribute("sysModule", sysModule);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysModule/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysModule") SysModule sysModule,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysModule.getId()==null){
				sysModuleService.insert(sysModule);
			}else{
				sysModuleService.updateByPrimaryKey(sysModule);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysModule);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysModule") SysModule sysModule,Model model) {
		sysModule = sysModuleService.selectByPrimaryKey(sysModule.getId());
		if(sysModule==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysModule", sysModule);
		return "/admin/sysModule/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysModuleService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysModuleService.deleteByPrimaryKey(id);
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
