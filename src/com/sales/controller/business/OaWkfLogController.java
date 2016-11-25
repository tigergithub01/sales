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
import com.sales.model.business.OaWkfLog;
import com.sales.service.business.OaWkfLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OaWkfInstanceService;

import com.sales.model.business.OaWkfInstance;

@Controller
@RequestMapping("/admin/oaWkfLog")
public class OaWkfLogController extends BasicController {
	@Resource
	private OaWkfLogService oaWkfLogService;
	
	@Resource
	private OaWkfInstanceService oaWkfInstanceService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("oaWkfLog") OaWkfLog oaWkfLog,
			BindingResult br,Model model) {
		
		List<OaWkfInstance> wkfInsIdList= oaWkfInstanceService.selectList(null); 
		model.addAttribute("wkfInsIdList", wkfInsIdList);
			
	
		return "/admin/oaWkfLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("oaWkfLog") OaWkfLog oaWkfLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = oaWkfLogService.selectList(oaWkfLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("oaWkfLog") OaWkfLog oaWkfLog,
			BindingResult br,Model model) {
		
		OaWkfLog newOaWkfLog = new OaWkfLog();
		
			
		List<OaWkfInstance> wkfInsIdList= oaWkfInstanceService.selectList(null); 
		model.addAttribute("wkfInsIdList", wkfInsIdList);
			
		
		model.addAttribute("sysUser", newOaWkfLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/oaWkfLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("oaWkfLog") OaWkfLog oaWkfLog,
			BindingResult br,Model model) {
		
		oaWkfLog = oaWkfLogService.selectByPrimaryKey(oaWkfLog.getId());
		if(oaWkfLog==null){
			throw new NoDataFoundException();
		}
		List<OaWkfInstance> wkfInsIdList= oaWkfInstanceService.selectList(null); 
		model.addAttribute("wkfInsIdList", wkfInsIdList);
			
		model.addAttribute("oaWkfLog", oaWkfLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/oaWkfLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("oaWkfLog") OaWkfLog oaWkfLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(oaWkfLog.getId()==null){
				oaWkfLogService.insert(oaWkfLog);
			}else{
				oaWkfLogService.updateByPrimaryKey(oaWkfLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(oaWkfLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("oaWkfLog") OaWkfLog oaWkfLog,Model model) {
		oaWkfLog = oaWkfLogService.selectByPrimaryKey(oaWkfLog.getId());
		if(oaWkfLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("oaWkfLog", oaWkfLog);
		return "/admin/oaWkfLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			oaWkfLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					oaWkfLogService.deleteByPrimaryKey(id);
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
