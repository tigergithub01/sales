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
import com.sales.model.business.SysAppRelease;
import com.sales.service.business.SysAppReleaseService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.SysAppInfoService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.SysAppInfo;

@Controller
@RequestMapping("/admin/sysAppRelease")
public class SysAppReleaseController extends BasicController {
	@Resource
	private SysAppReleaseService sysAppReleaseService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private SysAppInfoService sysAppInfoService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysAppRelease") SysAppRelease sysAppRelease,
			BindingResult br,Model model) {
		
		List<SysParameter> forceUpgradeList= sysParameterService.selectList(null); 
		model.addAttribute("forceUpgradeList", forceUpgradeList);
			
		List<SysAppInfo> appInfoIdList= sysAppInfoService.selectList(null); 
		model.addAttribute("appInfoIdList", appInfoIdList);
			
	
		return "/admin/sysAppRelease/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysAppRelease") SysAppRelease sysAppRelease,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysAppReleaseService.selectList(sysAppRelease, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysAppRelease") SysAppRelease sysAppRelease,
			BindingResult br,Model model) {
		
		SysAppRelease newSysAppRelease = new SysAppRelease();
		
			
		List<SysParameter> forceUpgradeList= sysParameterService.selectList(null); 
		model.addAttribute("forceUpgradeList", forceUpgradeList);
			
		List<SysAppInfo> appInfoIdList= sysAppInfoService.selectList(null); 
		model.addAttribute("appInfoIdList", appInfoIdList);
			
		
		model.addAttribute("sysUser", newSysAppRelease);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysAppRelease/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysAppRelease") SysAppRelease sysAppRelease,
			BindingResult br,Model model) {
		
		sysAppRelease = sysAppReleaseService.selectByPrimaryKey(sysAppRelease.getId());
		if(sysAppRelease==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> forceUpgradeList= sysParameterService.selectList(null); 
		model.addAttribute("forceUpgradeList", forceUpgradeList);
			
		List<SysAppInfo> appInfoIdList= sysAppInfoService.selectList(null); 
		model.addAttribute("appInfoIdList", appInfoIdList);
			
		model.addAttribute("sysAppRelease", sysAppRelease);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysAppRelease/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysAppRelease") SysAppRelease sysAppRelease,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysAppRelease.getId()==null){
				sysAppReleaseService.insert(sysAppRelease);
			}else{
				sysAppReleaseService.updateByPrimaryKey(sysAppRelease);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysAppRelease);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysAppRelease") SysAppRelease sysAppRelease,Model model) {
		sysAppRelease = sysAppReleaseService.selectByPrimaryKey(sysAppRelease.getId());
		if(sysAppRelease==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysAppRelease", sysAppRelease);
		return "/admin/sysAppRelease/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysAppReleaseService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysAppReleaseService.deleteByPrimaryKey(id);
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
