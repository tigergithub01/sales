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
import com.sales.model.business.VipType;
import com.sales.service.business.VipTypeService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/vipType")
public class VipTypeController extends BasicController {
	@Resource
	private VipTypeService vipTypeService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipType") VipType vipType,
			BindingResult br,Model model) {
		
	
		return "/admin/vipType/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipType") VipType vipType,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipTypeService.selectList(vipType, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipType") VipType vipType,
			BindingResult br,Model model) {
		
		VipType newVipType = new VipType();
		
			
		
		model.addAttribute("sysUser", newVipType);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipType/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipType") VipType vipType,
			BindingResult br,Model model) {
		
		vipType = vipTypeService.selectByPrimaryKey(vipType.getId());
		if(vipType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipType", vipType);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipType/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipType") VipType vipType,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipType.getId()==null){
				vipTypeService.insert(vipType);
			}else{
				vipTypeService.updateByPrimaryKey(vipType);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipType);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipType") VipType vipType,Model model) {
		vipType = vipTypeService.selectByPrimaryKey(vipType.getId());
		if(vipType==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipType", vipType);
		return "/admin/vipType/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipTypeService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipTypeService.deleteByPrimaryKey(id);
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
