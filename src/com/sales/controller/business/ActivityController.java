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
import com.sales.model.business.Activity;
import com.sales.service.business.ActivityService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysUserService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.ActTypeService;

import com.sales.model.business.SysUser;
import com.sales.model.business.SysParameter;
import com.sales.model.business.ActType;

@Controller
@RequestMapping("/admin/activity")
public class ActivityController extends BasicController {
	@Resource
	private ActivityService activityService;
	
	@Resource
	private SysUserService sysUserService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private ActTypeService actTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("activity") Activity activity,
			BindingResult br,Model model) {
		
		List<ActType> activityTypeList= actTypeService.selectList(null); 
		model.addAttribute("activityTypeList", activityTypeList);
			
		List<SysParameter> activityOrgScopeList= sysParameterService.selectList(null); 
		model.addAttribute("activityOrgScopeList", activityOrgScopeList);
			
		List<SysParameter> activityRangeList= sysParameterService.selectList(null); 
		model.addAttribute("activityRangeList", activityRangeList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
	
		return "/admin/activity/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("activity") Activity activity,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = activityService.selectList(activity, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("activity") Activity activity,
			BindingResult br,Model model) {
		
		Activity newActivity = new Activity();
		
		newActivity.setCreateDate(new java.util.Date());
		newActivity.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
		newActivity.setUpdateDate(new java.util.Date());
		newActivity.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
			
		List<ActType> activityTypeList= actTypeService.selectList(null); 
		model.addAttribute("activityTypeList", activityTypeList);
			
		List<SysParameter> activityOrgScopeList= sysParameterService.selectList(null); 
		model.addAttribute("activityOrgScopeList", activityOrgScopeList);
			
		List<SysParameter> activityRangeList= sysParameterService.selectList(null); 
		model.addAttribute("activityRangeList", activityRangeList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		
		model.addAttribute("sysUser", newActivity);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/activity/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("activity") Activity activity,
			BindingResult br,Model model) {
		
		activity = activityService.selectByPrimaryKey(activity.getId());
		if(activity==null){
			throw new NoDataFoundException();
		}
		List<ActType> activityTypeList= actTypeService.selectList(null); 
		model.addAttribute("activityTypeList", activityTypeList);
			
		List<SysParameter> activityOrgScopeList= sysParameterService.selectList(null); 
		model.addAttribute("activityOrgScopeList", activityOrgScopeList);
			
		List<SysParameter> activityRangeList= sysParameterService.selectList(null); 
		model.addAttribute("activityRangeList", activityRangeList);
			
		List<SysParameter> authTypeList= sysParameterService.selectList(null); 
		model.addAttribute("authTypeList", authTypeList);
			
		List<SysParameter> auditStatusList= sysParameterService.selectList(null); 
		model.addAttribute("auditStatusList", auditStatusList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		List<SysUser> createUserIdList= sysUserService.selectList(null); 
		model.addAttribute("createUserIdList", createUserIdList);
			
		List<SysUser> updateUserIdList= sysUserService.selectList(null); 
		model.addAttribute("updateUserIdList", updateUserIdList);
			
		model.addAttribute("activity", activity);
		model.addAttribute("mode", Const.editMode);
		return "/admin/activity/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("activity") Activity activity,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(activity.getId()==null){
				activity.setCreateDate(new java.util.Date());
				activity.setCreateUserId(CommonUtils.getInstance().getLoginUserid());
				activity.setUpdateDate(new java.util.Date());
				activity.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				activityService.insert(activity);
			}else{
				activity.setUpdateDate(new java.util.Date());
				activity.setUpdateUserId(CommonUtils.getInstance().getLoginUserid());
				activityService.updateByPrimaryKey(activity);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(activity);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("activity") Activity activity,Model model) {
		activity = activityService.selectByPrimaryKey(activity.getId());
		if(activity==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("activity", activity);
		return "/admin/activity/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			activityService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					activityService.deleteByPrimaryKey(id);
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
