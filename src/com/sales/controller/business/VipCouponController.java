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
import com.sales.model.business.VipCoupon;
import com.sales.service.business.VipCouponService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipService;
import com.sales.service.business.ActRuleService;
import com.sales.service.business.OrganizationService;
import com.sales.service.business.DrpPosTransInfoService;

import com.sales.model.business.Vip;
import com.sales.model.business.ActRule;
import com.sales.model.business.Organization;
import com.sales.model.business.DrpPosTransInfo;

@Controller
@RequestMapping("/admin/vipCoupon")
public class VipCouponController extends BasicController {
	@Resource
	private VipCouponService vipCouponService;
	
	@Resource
	private VipService vipService;	
	
	@Resource
	private ActRuleService actRuleService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	@Resource
	private DrpPosTransInfoService drpPosTransInfoService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipCoupon") VipCoupon vipCoupon,
			BindingResult br,Model model) {
		
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<ActRule> activityIdList= actRuleService.selectList(null); 
		model.addAttribute("activityIdList", activityIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
	
		return "/admin/vipCoupon/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipCoupon") VipCoupon vipCoupon,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipCouponService.selectList(vipCoupon, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipCoupon") VipCoupon vipCoupon,
			BindingResult br,Model model) {
		
		VipCoupon newVipCoupon = new VipCoupon();
		
			
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<ActRule> activityIdList= actRuleService.selectList(null); 
		model.addAttribute("activityIdList", activityIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		
		model.addAttribute("sysUser", newVipCoupon);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipCoupon/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipCoupon") VipCoupon vipCoupon,
			BindingResult br,Model model) {
		
		vipCoupon = vipCouponService.selectByPrimaryKey(vipCoupon.getId());
		if(vipCoupon==null){
			throw new NoDataFoundException();
		}
		List<Vip> vipIdList= vipService.selectList(null); 
		model.addAttribute("vipIdList", vipIdList);
			
		List<ActRule> activityIdList= actRuleService.selectList(null); 
		model.addAttribute("activityIdList", activityIdList);
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpPosTransInfo> transactionIdList= drpPosTransInfoService.selectList(null); 
		model.addAttribute("transactionIdList", transactionIdList);
			
		model.addAttribute("vipCoupon", vipCoupon);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipCoupon/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipCoupon") VipCoupon vipCoupon,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipCoupon.getId()==null){
				vipCouponService.insert(vipCoupon);
			}else{
				vipCouponService.updateByPrimaryKey(vipCoupon);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipCoupon);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipCoupon") VipCoupon vipCoupon,Model model) {
		vipCoupon = vipCouponService.selectByPrimaryKey(vipCoupon.getId());
		if(vipCoupon==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipCoupon", vipCoupon);
		return "/admin/vipCoupon/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipCouponService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipCouponService.deleteByPrimaryKey(id);
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
