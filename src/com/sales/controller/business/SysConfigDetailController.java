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
import com.sales.model.business.SysConfigDetail;
import com.sales.service.business.SysConfigDetailService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysConfigService;

import com.sales.model.business.SysConfig;

@Controller
@RequestMapping("/admin/sysConfigDetail")
public class SysConfigDetailController extends BasicController {
	@Resource
	private SysConfigDetailService sysConfigDetailService;
	
	@Resource
	private SysConfigService sysConfigService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysConfigDetail") SysConfigDetail sysConfigDetail,
			BindingResult br,Model model) {
		
		List<SysConfig> configIdList= sysConfigService.selectList(null); 
		model.addAttribute("configIdList", configIdList);
			
	
		return "/admin/sysConfigDetail/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysConfigDetail") SysConfigDetail sysConfigDetail,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysConfigDetailService.selectList(sysConfigDetail, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysConfigDetail") SysConfigDetail sysConfigDetail,
			BindingResult br,Model model) {
		
		SysConfigDetail newSysConfigDetail = new SysConfigDetail();
		
			
		List<SysConfig> configIdList= sysConfigService.selectList(null); 
		model.addAttribute("configIdList", configIdList);
			
		
		model.addAttribute("sysUser", newSysConfigDetail);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysConfigDetail/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysConfigDetail") SysConfigDetail sysConfigDetail,
			BindingResult br,Model model) {
		
		sysConfigDetail = sysConfigDetailService.selectByPrimaryKey(sysConfigDetail.getId());
		if(sysConfigDetail==null){
			throw new NoDataFoundException();
		}
		List<SysConfig> configIdList= sysConfigService.selectList(null); 
		model.addAttribute("configIdList", configIdList);
			
		model.addAttribute("sysConfigDetail", sysConfigDetail);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysConfigDetail/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysConfigDetail") SysConfigDetail sysConfigDetail,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysConfigDetail.getId()==null){
				sysConfigDetailService.insert(sysConfigDetail);
			}else{
				sysConfigDetailService.updateByPrimaryKey(sysConfigDetail);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysConfigDetail);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysConfigDetail") SysConfigDetail sysConfigDetail,Model model) {
		sysConfigDetail = sysConfigDetailService.selectByPrimaryKey(sysConfigDetail.getId());
		if(sysConfigDetail==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysConfigDetail", sysConfigDetail);
		return "/admin/sysConfigDetail/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysConfigDetailService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysConfigDetailService.deleteByPrimaryKey(id);
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
