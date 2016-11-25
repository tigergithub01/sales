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
import com.sales.model.business.DrpMatVipPriceRegular;
import com.sales.service.business.DrpMatVipPriceRegularService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.VipTypeService;
import com.sales.service.business.DrpMatTypeService;
import com.sales.service.business.OrganizationService;

import com.sales.model.business.VipType;
import com.sales.model.business.DrpMatType;
import com.sales.model.business.Organization;

@Controller
@RequestMapping("/admin/drpMatVipPriceRegular")
public class DrpMatVipPriceRegularController extends BasicController {
	@Resource
	private DrpMatVipPriceRegularService drpMatVipPriceRegularService;
	
	@Resource
	private VipTypeService vipTypeService;	
	
	@Resource
	private DrpMatTypeService drpMatTypeService;	
	
	@Resource
	private OrganizationService organizationService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("drpMatVipPriceRegular") DrpMatVipPriceRegular drpMatVipPriceRegular,
			BindingResult br,Model model) {
		
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
	
		return "/admin/drpMatVipPriceRegular/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("drpMatVipPriceRegular") DrpMatVipPriceRegular drpMatVipPriceRegular,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = drpMatVipPriceRegularService.selectList(drpMatVipPriceRegular, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("drpMatVipPriceRegular") DrpMatVipPriceRegular drpMatVipPriceRegular,
			BindingResult br,Model model) {
		
		DrpMatVipPriceRegular newDrpMatVipPriceRegular = new DrpMatVipPriceRegular();
		
			
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		
		model.addAttribute("sysUser", newDrpMatVipPriceRegular);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/drpMatVipPriceRegular/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("drpMatVipPriceRegular") DrpMatVipPriceRegular drpMatVipPriceRegular,
			BindingResult br,Model model) {
		
		drpMatVipPriceRegular = drpMatVipPriceRegularService.selectByPrimaryKey(drpMatVipPriceRegular.getId());
		if(drpMatVipPriceRegular==null){
			throw new NoDataFoundException();
		}
		List<Organization> organizationIdList= organizationService.selectList(null); 
		model.addAttribute("organizationIdList", organizationIdList);
			
		List<DrpMatType> matTypeIdList= drpMatTypeService.selectList(null); 
		model.addAttribute("matTypeIdList", matTypeIdList);
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		model.addAttribute("drpMatVipPriceRegular", drpMatVipPriceRegular);
		model.addAttribute("mode", Const.editMode);
		return "/admin/drpMatVipPriceRegular/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("drpMatVipPriceRegular") DrpMatVipPriceRegular drpMatVipPriceRegular,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(drpMatVipPriceRegular.getId()==null){
				drpMatVipPriceRegularService.insert(drpMatVipPriceRegular);
			}else{
				drpMatVipPriceRegularService.updateByPrimaryKey(drpMatVipPriceRegular);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(drpMatVipPriceRegular);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("drpMatVipPriceRegular") DrpMatVipPriceRegular drpMatVipPriceRegular,Model model) {
		drpMatVipPriceRegular = drpMatVipPriceRegularService.selectByPrimaryKey(drpMatVipPriceRegular.getId());
		if(drpMatVipPriceRegular==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("drpMatVipPriceRegular", drpMatVipPriceRegular);
		return "/admin/drpMatVipPriceRegular/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			drpMatVipPriceRegularService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					drpMatVipPriceRegularService.deleteByPrimaryKey(id);
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
