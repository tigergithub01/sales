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
import com.sales.model.business.DrpMatTypeProp;
import com.sales.service.business.DrpMatTypePropService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.DrpMatTypeService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpMatType;

@Controller
@RequestMapping("/admin/drpMatTypeProp")
public class DrpMatTypePropController extends BasicController {
	@Resource
	private DrpMatTypePropService drpMatTypePropService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatTypeProp") DrpMatTypeProp drpMatTypeProp,
			BindingResult br,Model model) {
		
		List<DrpMatType> materialTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("materialTypeIdList", materialTypeIdList);
			
		List<SysParameter> isSalePropList= sysParameterService.selectList(null); 
		model.addAttribute("isSalePropList", isSalePropList);
			
		List<SysParameter> isRequiredList= sysParameterService.selectList(null); 
		model.addAttribute("isRequiredList", isRequiredList);
			
		List<SysParameter> inputTypeList= sysParameterService.selectList(null); 
		model.addAttribute("inputTypeList", inputTypeList);
			
		List<SysParameter> multiSelectList= sysParameterService.selectList(null); 
		model.addAttribute("multiSelectList", multiSelectList);
			
	
		return "/admin/drpMatTypeProp/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatTypeProp") DrpMatTypeProp drpMatTypeProp,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatTypePropService.selectList(drpMatTypeProp, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatTypeProp") DrpMatTypeProp drpMatTypeProp,
			BindingResult br,Model model) {
		
		DrpMatTypeProp newDrpMatTypeProp = new DrpMatTypeProp();
		
			
		List<DrpMatType> materialTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("materialTypeIdList", materialTypeIdList);
			
		List<SysParameter> isSalePropList= sysParameterService.selectList(null); 
		model.addAttribute("isSalePropList", isSalePropList);
			
		List<SysParameter> isRequiredList= sysParameterService.selectList(null); 
		model.addAttribute("isRequiredList", isRequiredList);
			
		List<SysParameter> inputTypeList= sysParameterService.selectList(null); 
		model.addAttribute("inputTypeList", inputTypeList);
			
		List<SysParameter> multiSelectList= sysParameterService.selectList(null); 
		model.addAttribute("multiSelectList", multiSelectList);
			
		
		model.addAttribute("sysUser", newDrpMatTypeProp);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatTypeProp/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatTypeProp") DrpMatTypeProp drpMatTypeProp,
			BindingResult br,Model model) {
		
		drpMatTypeProp = drpMatTypePropService.selectByPrimaryKey(drpMatTypeProp.getId());
		if(drpMatTypeProp==null){
			throw new NoDataFoundException();
		}
		List<DrpMatType> materialTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("materialTypeIdList", materialTypeIdList);
			
		List<SysParameter> isSalePropList= sysParameterService.selectList(null); 
		model.addAttribute("isSalePropList", isSalePropList);
			
		List<SysParameter> isRequiredList= sysParameterService.selectList(null); 
		model.addAttribute("isRequiredList", isRequiredList);
			
		List<SysParameter> inputTypeList= sysParameterService.selectList(null); 
		model.addAttribute("inputTypeList", inputTypeList);
			
		List<SysParameter> multiSelectList= sysParameterService.selectList(null); 
		model.addAttribute("multiSelectList", multiSelectList);
			
		model.addAttribute("drpMatTypeProp", drpMatTypeProp);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatTypeProp/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatTypeProp") DrpMatTypeProp drpMatTypeProp,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatTypeProp.getId()==null){
				drpMatTypePropService.insert(drpMatTypeProp);
			}else{
				drpMatTypePropService.updateByPrimaryKey(drpMatTypeProp);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatTypeProp);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatTypeProp") DrpMatTypeProp drpMatTypeProp,Model model) {
		drpMatTypeProp = drpMatTypePropService.selectByPrimaryKey(drpMatTypeProp.getId());
		if(drpMatTypeProp==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatTypeProp", drpMatTypeProp);
		return "/admin/drpMatTypeProp/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatTypePropService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatTypePropService.deleteByPrimaryKey(id);
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
