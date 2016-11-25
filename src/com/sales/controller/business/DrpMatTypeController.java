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
import com.sales.model.business.DrpMatType;
import com.sales.service.business.DrpMatTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.DrpMatTypeService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpMatType;

@Controller
@RequestMapping("/admin/drpMatType")
public class DrpMatTypeController extends BasicController {
	@Resource
	private DrpMatTypeService drpMatTypeService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatType") DrpMatType drpMatType,
			BindingResult br,Model model) {
		
		List<DrpMatType> parentIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
	
		return "/admin/drpMatType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatType") DrpMatType drpMatType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatTypeService.selectList(drpMatType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatType") DrpMatType drpMatType,
			BindingResult br,Model model) {
		
		DrpMatType newDrpMatType = new DrpMatType();
		
			
		List<DrpMatType> parentIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		
		model.addAttribute("sysUser", newDrpMatType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatType") DrpMatType drpMatType,
			BindingResult br,Model model) {
		
		drpMatType = drpMatTypeService.selectByPrimaryKey(drpMatType.getId());
		if(drpMatType==null){
			throw new NoDataFoundException();
		}
		List<DrpMatType> parentIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		model.addAttribute("drpMatType", drpMatType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatType") DrpMatType drpMatType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatType.getId()==null){
				drpMatTypeService.insert(drpMatType);
			}else{
				drpMatTypeService.updateByPrimaryKey(drpMatType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatType") DrpMatType drpMatType,Model model) {
		drpMatType = drpMatTypeService.selectByPrimaryKey(drpMatType.getId());
		if(drpMatType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatType", drpMatType);
		return "/admin/drpMatType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatTypeService.deleteByPrimaryKey(id);
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
