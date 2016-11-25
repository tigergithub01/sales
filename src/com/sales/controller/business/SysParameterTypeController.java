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
import com.sales.model.business.SysParameterType;
import com.sales.service.business.SysParameterTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/sysParameterType")
public class SysParameterTypeController extends BasicController {
	@Resource
	private SysParameterTypeService sysParameterTypeService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysParameterType") SysParameterType sysParameterType,
			BindingResult br,Model model) {
		
	
		return "/admin/sysParameterType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysParameterType") SysParameterType sysParameterType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysParameterTypeService.selectList(sysParameterType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysParameterType") SysParameterType sysParameterType,
			BindingResult br,Model model) {
		
		SysParameterType newSysParameterType = new SysParameterType();
		
			
		
		model.addAttribute("sysUser", newSysParameterType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysParameterType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysParameterType") SysParameterType sysParameterType,
			BindingResult br,Model model) {
		
		sysParameterType = sysParameterTypeService.selectByPrimaryKey(sysParameterType.getId());
		if(sysParameterType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysParameterType", sysParameterType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysParameterType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysParameterType") SysParameterType sysParameterType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysParameterType.getId()==null){
				sysParameterTypeService.insert(sysParameterType);
			}else{
				sysParameterTypeService.updateByPrimaryKey(sysParameterType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysParameterType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysParameterType") SysParameterType sysParameterType,Model model) {
		sysParameterType = sysParameterTypeService.selectByPrimaryKey(sysParameterType.getId());
		if(sysParameterType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysParameterType", sysParameterType);
		return "/admin/sysParameterType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysParameterTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysParameterTypeService.deleteByPrimaryKey(id);
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
