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
import com.sales.model.business.OaWkfInstance;
import com.sales.service.business.OaWkfInstanceService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.OaWkfService;

import com.sales.model.business.OaWkf;

@Controller
@RequestMapping("/admin/oaWkfInstance")
public class OaWkfInstanceController extends BasicController {
	@Resource
	private OaWkfInstanceService oaWkfInstanceService;
	
	@Resource
	private OaWkfService oaWkfService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("oaWkfInstance") OaWkfInstance oaWkfInstance,
			BindingResult br,Model model) {
		
		List<OaWkf> wkfIdList= oaWkfService.selectList(null); 
		model.addAttribute("wkfIdList", wkfIdList);
			
	
		return "/admin/oaWkfInstance/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("oaWkfInstance") OaWkfInstance oaWkfInstance,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = oaWkfInstanceService.selectList(oaWkfInstance, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("oaWkfInstance") OaWkfInstance oaWkfInstance,
			BindingResult br,Model model) {
		
		OaWkfInstance newOaWkfInstance = new OaWkfInstance();
		
			
		List<OaWkf> wkfIdList= oaWkfService.selectList(null); 
		model.addAttribute("wkfIdList", wkfIdList);
			
		
		model.addAttribute("sysUser", newOaWkfInstance);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/oaWkfInstance/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("oaWkfInstance") OaWkfInstance oaWkfInstance,
			BindingResult br,Model model) {
		
		oaWkfInstance = oaWkfInstanceService.selectByPrimaryKey(oaWkfInstance.getId());
		if(oaWkfInstance==null){
			throw new NoDataFoundException();
		}
		List<OaWkf> wkfIdList= oaWkfService.selectList(null); 
		model.addAttribute("wkfIdList", wkfIdList);
			
		model.addAttribute("oaWkfInstance", oaWkfInstance);
		model.addAttribute("mode", Const.editMode);
		return "/admin/oaWkfInstance/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("oaWkfInstance") OaWkfInstance oaWkfInstance,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(oaWkfInstance.getId()==null){
				oaWkfInstanceService.insert(oaWkfInstance);
			}else{
				oaWkfInstanceService.updateByPrimaryKey(oaWkfInstance);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(oaWkfInstance);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("oaWkfInstance") OaWkfInstance oaWkfInstance,Model model) {
		oaWkfInstance = oaWkfInstanceService.selectByPrimaryKey(oaWkfInstance.getId());
		if(oaWkfInstance==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("oaWkfInstance", oaWkfInstance);
		return "/admin/oaWkfInstance/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			oaWkfInstanceService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					oaWkfInstanceService.deleteByPrimaryKey(id);
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
