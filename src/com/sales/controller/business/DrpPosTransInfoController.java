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
import com.sales.model.business.DrpPosTransInfo;
import com.sales.service.business.DrpPosTransInfoService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipService;
import com.sales.service.business.SysParameterService;
import com.sales.service.business.DrpPosMachineService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.SysUserService;

import com.sales.model.business.Vip;
import com.sales.model.business.SysParameter;
import com.sales.model.business.DrpPosMachine;
import com.sales.model.business.Organization;
import com.sales.model.business.SysUser;

@Controller
@RequestMapping("/admin/drpPosTransInfo")
public class DrpPosTransInfoController extends BasicController {
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;
	
	@Resource
	private VipService vipService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private DrpPosMachineService drpPosMachineService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private SysUserService sysUserService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpPosTransInfo") DrpPosTransInfo drpPosTransInfo,
			BindingResult br,Model model) {
		
		List<SysParameter> transactionTypeList= sysParameterService.selectList(null); 
		model.addAttribute("transactionTypeList", transactionTypeList);
			
		List<DrpPosMachine> machineIdList= drpPosMachineService.selectList(null); 
		model.addAttribute("machineIdList", machineIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
	
		return "/admin/drpPosTransInfo/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpPosTransInfo") DrpPosTransInfo drpPosTransInfo,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpPosTransInfoService.selectList(drpPosTransInfo, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpPosTransInfo") DrpPosTransInfo drpPosTransInfo,
			BindingResult br,Model model) {
		
		DrpPosTransInfo newDrpPosTransInfo = new DrpPosTransInfo();
		
			
		List<SysParameter> transactionTypeList= sysParameterService.selectList(null); 
		model.addAttribute("transactionTypeList", transactionTypeList);
			
		List<DrpPosMachine> machineIdList= drpPosMachineService.selectList(null); 
		model.addAttribute("machineIdList", machineIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		
		model.addAttribute("sysUser", newDrpPosTransInfo);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpPosTransInfo/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpPosTransInfo") DrpPosTransInfo drpPosTransInfo,
			BindingResult br,Model model) {
		
		drpPosTransInfo = drpPosTransInfoService.selectByPrimaryKey(drpPosTransInfo.getId());
		if(drpPosTransInfo==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> transactionTypeList= sysParameterService.selectList(null); 
		model.addAttribute("transactionTypeList", transactionTypeList);
			
		List<DrpPosMachine> machineIdList= drpPosMachineService.selectList(null); 
		model.addAttribute("machineIdList", machineIdList);
			
		List<SysUser> userIdList= sysUserService.selectList(null); 
		model.addAttribute("userIdList", userIdList);
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		model.addAttribute("drpPosTransInfo", drpPosTransInfo);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpPosTransInfo/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpPosTransInfo") DrpPosTransInfo drpPosTransInfo,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpPosTransInfo.getId()==null){
				drpPosTransInfoService.insert(drpPosTransInfo);
			}else{
				drpPosTransInfoService.updateByPrimaryKey(drpPosTransInfo);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpPosTransInfo);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpPosTransInfo") DrpPosTransInfo drpPosTransInfo,Model model) {
		drpPosTransInfo = drpPosTransInfoService.selectByPrimaryKey(drpPosTransInfo.getId());
		if(drpPosTransInfo==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpPosTransInfo", drpPosTransInfo);
		return "/admin/drpPosTransInfo/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpPosTransInfoService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpPosTransInfoService.deleteByPrimaryKey(id);
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
