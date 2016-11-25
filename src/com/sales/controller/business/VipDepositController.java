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
import com.sales.model.business.VipDeposit;
import com.sales.service.business.VipDepositService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.DrpPosTransInfoService;
import com.sales.service.business.DrpMaterialService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.VipService;
import com.sales.service.business.SysParameterService;

import com.sales.model.business.DrpPosTransInfo;
import com.sales.model.business.DrpMaterial;
import com.sales.model.business.Organization;
import com.sales.model.business.Vip;
import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/vipDeposit")
public class VipDepositController extends BasicController {
	@Resource
	private VipDepositService vipDepositService;
	
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;	
	
	@Resource
	private DrpMaterialService drpMaterialService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private VipService vipService;	
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipDeposit") VipDeposit vipDeposit,
			BindingResult br,Model model) {
		
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
	
		return "/admin/vipDeposit/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipDeposit") VipDeposit vipDeposit,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipDepositService.selectList(vipDeposit, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipDeposit") VipDeposit vipDeposit,
			BindingResult br,Model model) {
		
		VipDeposit newVipDeposit = new VipDeposit();
		
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		
		model.addAttribute("sysUser", newVipDeposit);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipDeposit/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipDeposit") VipDeposit vipDeposit,
			BindingResult br,Model model) {
		
		vipDeposit = vipDepositService.selectByPrimaryKey(vipDeposit.getId());
		if(vipDeposit==null){
			throw new NoDataFoundException();
		}
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<DrpMaterial> materialIdList= drpMaterialService.selectList(null); 
		model.addAttribute("materialIdList", materialIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		model.addAttribute("vipDeposit", vipDeposit);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipDeposit/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipDeposit") VipDeposit vipDeposit,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipDeposit.getId()==null){
				vipDepositService.insert(vipDeposit);
			}else{
				vipDepositService.updateByPrimaryKey(vipDeposit);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipDeposit);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipDeposit") VipDeposit vipDeposit,Model model) {
		vipDeposit = vipDepositService.selectByPrimaryKey(vipDeposit.getId());
		if(vipDeposit==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipDeposit", vipDeposit);
		return "/admin/vipDeposit/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipDepositService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipDepositService.deleteByPrimaryKey(id);
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
