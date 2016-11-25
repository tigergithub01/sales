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
import com.sales.model.business.SysArea;
import com.sales.service.business.SysAreaService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysAreaService;

import com.sales.model.business.SysArea;

@Controller
@RequestMapping("/admin/sysArea")
public class SysAreaController extends BasicController {
	@Resource
	private SysAreaService sysAreaService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysArea") SysArea sysArea,
			BindingResult br,Model model) {
		
		List<SysArea> parentIdList= sysAreaService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
	
		return "/admin/sysArea/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysArea") SysArea sysArea,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysAreaService.selectList(sysArea, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysArea") SysArea sysArea,
			BindingResult br,Model model) {
		
		SysArea newSysArea = new SysArea();
		
			
		List<SysArea> parentIdList= sysAreaService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		
		model.addAttribute("sysUser", newSysArea);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysArea/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysArea") SysArea sysArea,
			BindingResult br,Model model) {
		
		sysArea = sysAreaService.selectByPrimaryKey(sysArea.getId());
		if(sysArea==null){
			throw new NoDataFoundException();
		}
		List<SysArea> parentIdList= sysAreaService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		model.addAttribute("sysArea", sysArea);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysArea/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysArea") SysArea sysArea,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysArea.getId()==null){
				sysAreaService.insert(sysArea);
			}else{
				sysAreaService.updateByPrimaryKey(sysArea);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysArea);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysArea") SysArea sysArea,Model model) {
		sysArea = sysAreaService.selectByPrimaryKey(sysArea.getId());
		if(sysArea==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysArea", sysArea);
		return "/admin/sysArea/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysAreaService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysAreaService.deleteByPrimaryKey(id);
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
