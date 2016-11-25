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
import com.sales.model.business.DrpCommissionRuleUser;
import com.sales.service.business.DrpCommissionRuleUserService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.DrpCommissionRuleService;

import com.sales.model.business.SysUser;
import com.sales.model.business.DrpCommissionRule;

@Controller
@RequestMapping("/admin/drpCommissionRuleUser")
public class DrpCommissionRuleUserController extends BasicController {
	@Resource
	private DrpCommissionRuleUserService drpCommissionRuleUserService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private DrpCommissionRuleService drpCommissionRuleService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpCommissionRuleUser") DrpCommissionRuleUser drpCommissionRuleUser,
			BindingResult br,Model model) {
		
		List<DrpCommissionRule> ruleIdList= drpCommissionRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
	
		return "/admin/drpCommissionRuleUser/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpCommissionRuleUser") DrpCommissionRuleUser drpCommissionRuleUser,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpCommissionRuleUserService.selectList(drpCommissionRuleUser, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpCommissionRuleUser") DrpCommissionRuleUser drpCommissionRuleUser,
			BindingResult br,Model model) {
		
		DrpCommissionRuleUser newDrpCommissionRuleUser = new DrpCommissionRuleUser();
		
			
		List<DrpCommissionRule> ruleIdList= drpCommissionRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		
		model.addAttribute("sysUser", newDrpCommissionRuleUser);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpCommissionRuleUser/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpCommissionRuleUser") DrpCommissionRuleUser drpCommissionRuleUser,
			BindingResult br,Model model) {
		
		drpCommissionRuleUser = drpCommissionRuleUserService.selectByPrimaryKey(drpCommissionRuleUser.getId());
		if(drpCommissionRuleUser==null){
			throw new NoDataFoundException();
		}
		List<DrpCommissionRule> ruleIdList= drpCommissionRuleService.selectList(null); 
		model.addAttribute("ruleIdList", ruleIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		model.addAttribute("drpCommissionRuleUser", drpCommissionRuleUser);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpCommissionRuleUser/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpCommissionRuleUser") DrpCommissionRuleUser drpCommissionRuleUser,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpCommissionRuleUser.getId()==null){
				drpCommissionRuleUserService.insert(drpCommissionRuleUser);
			}else{
				drpCommissionRuleUserService.updateByPrimaryKey(drpCommissionRuleUser);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpCommissionRuleUser);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpCommissionRuleUser") DrpCommissionRuleUser drpCommissionRuleUser,Model model) {
		drpCommissionRuleUser = drpCommissionRuleUserService.selectByPrimaryKey(drpCommissionRuleUser.getId());
		if(drpCommissionRuleUser==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpCommissionRuleUser", drpCommissionRuleUser);
		return "/admin/drpCommissionRuleUser/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpCommissionRuleUserService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpCommissionRuleUserService.deleteByPrimaryKey(id);
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
