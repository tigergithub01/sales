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
import com.sales.model.business.Vip;
import com.sales.service.business.VipService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;
import com.sales.service.business.VipService;
import com.sales.service.business.VipTypeService;

import com.sales.model.business.SysParameter;
import com.sales.model.business.Vip;
import com.sales.model.business.VipType;

@Controller
@RequestMapping("/admin/vip")
public class VipController extends BasicController {
	@Resource
	private VipService vipService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	@Resource
	private VipTypeService vipTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("vip") Vip vip,
			BindingResult br,Model model) {
		
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		List<SysParameter> sexList= sysParameterService.selectList(null); 
		model.addAttribute("sexList", sexList);
			
		List<SysParameter> mobileVerifyFlagList= sysParameterService.selectList(null); 
		model.addAttribute("mobileVerifyFlagList", mobileVerifyFlagList);
			
		List<SysParameter> emailVerifyFlagList= sysParameterService.selectList(null); 
		model.addAttribute("emailVerifyFlagList", emailVerifyFlagList);
			
		List<Vip> parentIdList= vipService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> babySexList= sysParameterService.selectList(null); 
		model.addAttribute("babySexList", babySexList);
			
	
		return "/admin/vip/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("vip") Vip vip,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = vipService.selectList(vip, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("vip") Vip vip,
			BindingResult br,Model model) {
		
		Vip newVip = new Vip();
		
			
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		List<SysParameter> sexList= sysParameterService.selectList(null); 
		model.addAttribute("sexList", sexList);
			
		List<SysParameter> mobileVerifyFlagList= sysParameterService.selectList(null); 
		model.addAttribute("mobileVerifyFlagList", mobileVerifyFlagList);
			
		List<SysParameter> emailVerifyFlagList= sysParameterService.selectList(null); 
		model.addAttribute("emailVerifyFlagList", emailVerifyFlagList);
			
		List<Vip> parentIdList= vipService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> babySexList= sysParameterService.selectList(null); 
		model.addAttribute("babySexList", babySexList);
			
		
		model.addAttribute("sysUser", newVip);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/vip/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("vip") Vip vip,
			BindingResult br,Model model) {
		
		vip = vipService.selectByPrimaryKey(vip.getId());
		if(vip==null){
			throw new NoDataFoundException();
		}
		List<VipType> vipTypeIdList= vipTypeService.selectList(null); 
		model.addAttribute("vipTypeIdList", vipTypeIdList);
			
		List<SysParameter> sexList= sysParameterService.selectList(null); 
		model.addAttribute("sexList", sexList);
			
		List<SysParameter> mobileVerifyFlagList= sysParameterService.selectList(null); 
		model.addAttribute("mobileVerifyFlagList", mobileVerifyFlagList);
			
		List<SysParameter> emailVerifyFlagList= sysParameterService.selectList(null); 
		model.addAttribute("emailVerifyFlagList", emailVerifyFlagList);
			
		List<Vip> parentIdList= vipService.selectList(null); 
		model.addAttribute("parentIdList", parentIdList);
			
		List<SysParameter> babySexList= sysParameterService.selectList(null); 
		model.addAttribute("babySexList", babySexList);
			
		model.addAttribute("vip", vip);
		model.addAttribute("mode", Const.editMode);
		return "/admin/vip/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("vip") Vip vip,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(vip.getId()==null){
				vipService.insert(vip);
			}else{
				vipService.updateByPrimaryKey(vip);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(vip);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("vip") Vip vip,Model model) {
		vip = vipService.selectByPrimaryKey(vip.getId());
		if(vip==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("vip", vip);
		return "/admin/vip/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			vipService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					vipService.deleteByPrimaryKey(id);
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
