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
import com.sales.model.business.SysRegion;
import com.sales.service.business.SysRegionService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.SysRegionService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.SysRegion;

@Controller
@RequestMapping("/admin/sysRegion")
public class SysRegionController extends BasicController {
	@Resource
	private SysRegionService sysRegionService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysRegion") SysRegion sysRegion,
			BindingResult br,Model model) {
		
		List<SysRegion> parentIdList= sysRegionService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> regionTypeList= sysParameterService.selectList(null); 
		model.addAttribute("regionTypeList", regionTypeList);
			
	
		return "/admin/sysRegion/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysRegion") SysRegion sysRegion,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysRegionService.selectList(sysRegion, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysRegion") SysRegion sysRegion,
			BindingResult br,Model model) {
		
		SysRegion newSysRegion = new SysRegion();
		
			
		List<SysRegion> parentIdList= sysRegionService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> regionTypeList= sysParameterService.selectList(null); 
		model.addAttribute("regionTypeList", regionTypeList);
			
		
		model.addAttribute("sysUser", newSysRegion);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysRegion/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysRegion") SysRegion sysRegion,
			BindingResult br,Model model) {
		
		sysRegion = sysRegionService.selectByPrimaryKey(sysRegion.getId());
		if(sysRegion==null){
			throw new NoDataFoundException();
		}
		List<SysRegion> parentIdList= sysRegionService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> regionTypeList= sysParameterService.selectList(null); 
		model.addAttribute("regionTypeList", regionTypeList);
			
		model.addAttribute("sysRegion", sysRegion);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysRegion/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysRegion") SysRegion sysRegion,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysRegion.getId()==null){
				sysRegionService.insert(sysRegion);
			}else{
				sysRegionService.updateByPrimaryKey(sysRegion);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysRegion);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysRegion") SysRegion sysRegion,Model model) {
		sysRegion = sysRegionService.selectByPrimaryKey(sysRegion.getId());
		if(sysRegion==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysRegion", sysRegion);
		return "/admin/sysRegion/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysRegionService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysRegionService.deleteByPrimaryKey(id);
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
