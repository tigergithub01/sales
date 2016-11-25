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
import com.sales.model.business.ActType;
import com.sales.service.business.ActTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;

import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/actType")
public class ActTypeController extends BasicController {
	@Resource
	private ActTypeService actTypeService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("actType") ActType actType,
			BindingResult br,Model model) {
		
		List<SysParameter> actFlagList= sysParameterService.selectList(null); 
		model.addAttribute("actFlagList", actFlagList);
			
	
		return "/admin/actType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("actType") ActType actType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = actTypeService.selectList(actType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("actType") ActType actType,
			BindingResult br,Model model) {
		
		ActType newActType = new ActType();
		
			
		List<SysParameter> actFlagList= sysParameterService.selectList(null); 
		model.addAttribute("actFlagList", actFlagList);
			
		
		model.addAttribute("sysUser", newActType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/actType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("actType") ActType actType,
			BindingResult br,Model model) {
		
		actType = actTypeService.selectByPrimaryKey(actType.getId());
		if(actType==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> actFlagList= sysParameterService.selectList(null); 
		model.addAttribute("actFlagList", actFlagList);
			
		model.addAttribute("actType", actType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/actType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("actType") ActType actType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(actType.getId()==null){
				actTypeService.insert(actType);
			}else{
				actTypeService.updateByPrimaryKey(actType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(actType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("actType") ActType actType,Model model) {
		actType = actTypeService.selectByPrimaryKey(actType.getId());
		if(actType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("actType", actType);
		return "/admin/actType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			actTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					actTypeService.deleteByPrimaryKey(id);
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
