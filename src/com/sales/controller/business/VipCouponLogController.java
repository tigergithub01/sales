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
import com.sales.model.business.VipCouponLog;
import com.sales.service.business.VipCouponLogService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipCouponService;

import com.sales.model.business.VipCoupon;

@Controller
@RequestMapping("/admin/vipCouponLog")
public class VipCouponLogController extends BasicController {
	@Resource
	private VipCouponLogService vipCouponLogService;
	
	@Resource
	private VipCouponService vipCouponService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vipCouponLog") VipCouponLog vipCouponLog,
			BindingResult br,Model model) {
		
		List<VipCoupon> couponIdList= vipCouponService.selectList(null); 
		model.addAttribute("couponIdList", couponIdList);
			
	
		return "/admin/vipCouponLog/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vipCouponLog") VipCouponLog vipCouponLog,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipCouponLogService.selectList(vipCouponLog, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vipCouponLog") VipCouponLog vipCouponLog,
			BindingResult br,Model model) {
		
		VipCouponLog newVipCouponLog = new VipCouponLog();
		
			
		List<VipCoupon> couponIdList= vipCouponService.selectList(null); 
		model.addAttribute("couponIdList", couponIdList);
			
		
		model.addAttribute("sysUser", newVipCouponLog);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vipCouponLog/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vipCouponLog") VipCouponLog vipCouponLog,
			BindingResult br,Model model) {
		
		vipCouponLog = vipCouponLogService.selectByPrimaryKey(vipCouponLog.getId());
		if(vipCouponLog==null){
			throw new NoDataFoundException();
		}
		List<VipCoupon> couponIdList= vipCouponService.selectList(null); 
		model.addAttribute("couponIdList", couponIdList);
			
		model.addAttribute("vipCouponLog", vipCouponLog);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vipCouponLog/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vipCouponLog") VipCouponLog vipCouponLog,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vipCouponLog.getId()==null){
				vipCouponLogService.insert(vipCouponLog);
			}else{
				vipCouponLogService.updateByPrimaryKey(vipCouponLog);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vipCouponLog);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vipCouponLog") VipCouponLog vipCouponLog,Model model) {
		vipCouponLog = vipCouponLogService.selectByPrimaryKey(vipCouponLog.getId());
		if(vipCouponLog==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vipCouponLog", vipCouponLog);
		return "/admin/vipCouponLog/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipCouponLogService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipCouponLogService.deleteByPrimaryKey(id);
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
