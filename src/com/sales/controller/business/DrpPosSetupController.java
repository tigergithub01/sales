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
import com.sales.model.business.DrpPosSetup;
import com.sales.service.business.DrpPosSetupService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/drpPosSetup")
public class DrpPosSetupController extends BasicController {
	@Resource
	private DrpPosSetupService drpPosSetupService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpPosSetup") DrpPosSetup drpPosSetup,
			BindingResult br,Model model) {
		
	
		return "/admin/drpPosSetup/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpPosSetup") DrpPosSetup drpPosSetup,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpPosSetupService.selectList(drpPosSetup, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpPosSetup") DrpPosSetup drpPosSetup,
			BindingResult br,Model model) {
		
		DrpPosSetup newDrpPosSetup = new DrpPosSetup();
		
			
		
		model.addAttribute("sysUser", newDrpPosSetup);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpPosSetup/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpPosSetup") DrpPosSetup drpPosSetup,
			BindingResult br,Model model) {
		
		drpPosSetup = drpPosSetupService.selectByPrimaryKey(drpPosSetup.getId());
		if(drpPosSetup==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpPosSetup", drpPosSetup);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpPosSetup/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpPosSetup") DrpPosSetup drpPosSetup,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpPosSetup.getId()==null){
				drpPosSetupService.insert(drpPosSetup);
			}else{
				drpPosSetupService.updateByPrimaryKey(drpPosSetup);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpPosSetup);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpPosSetup") DrpPosSetup drpPosSetup,Model model) {
		drpPosSetup = drpPosSetupService.selectByPrimaryKey(drpPosSetup.getId());
		if(drpPosSetup==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpPosSetup", drpPosSetup);
		return "/admin/drpPosSetup/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpPosSetupService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpPosSetupService.deleteByPrimaryKey(id);
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
