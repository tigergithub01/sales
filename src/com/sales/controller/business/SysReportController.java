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
import com.sales.model.business.SysReport;
import com.sales.service.business.SysReportService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;

import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/sysReport")
public class SysReportController extends BasicController {
	@Resource
	private SysReportService sysReportService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysReport") SysReport sysReport,
			BindingResult br,Model model) {
		
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
	
		return "/admin/sysReport/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysReport") SysReport sysReport,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysReportService.selectList(sysReport, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysReport") SysReport sysReport,
			BindingResult br,Model model) {
		
		SysReport newSysReport = new SysReport();
		
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		
		model.addAttribute("sysUser", newSysReport);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysReport/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysReport") SysReport sysReport,
			BindingResult br,Model model) {
		
		sysReport = sysReportService.selectByPrimaryKey(sysReport.getId());
		if(sysReport==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		model.addAttribute("sysReport", sysReport);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysReport/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysReport") SysReport sysReport,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysReport.getId()==null){
				sysReportService.insert(sysReport);
			}else{
				sysReportService.updateByPrimaryKey(sysReport);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysReport);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysReport") SysReport sysReport,Model model) {
		sysReport = sysReportService.selectByPrimaryKey(sysReport.getId());
		if(sysReport==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysReport", sysReport);
		return "/admin/sysReport/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysReportService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysReportService.deleteByPrimaryKey(id);
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
