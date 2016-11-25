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
import com.sales.model.business.SysCurrency;
import com.sales.service.business.SysCurrencyService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterService;

import com.sales.model.business.SysParameter;

@Controller
@RequestMapping("/admin/sysCurrency")
public class SysCurrencyController extends BasicController {
	@Resource
	private SysCurrencyService sysCurrencyService;
	
	@Resource
	private SysParameterService sysParameterService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysCurrency") SysCurrency sysCurrency,
			BindingResult br,Model model) {
		
		List<SysParameter> isStandardMoneyList= sysParameterService.selectList(null); 
		model.addAttribute("isStandardMoneyList", isStandardMoneyList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
	
		return "/admin/sysCurrency/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysCurrency") SysCurrency sysCurrency,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysCurrencyService.selectList(sysCurrency, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysCurrency") SysCurrency sysCurrency,
			BindingResult br,Model model) {
		
		SysCurrency newSysCurrency = new SysCurrency();
		
			
		List<SysParameter> isStandardMoneyList= sysParameterService.selectList(null); 
		model.addAttribute("isStandardMoneyList", isStandardMoneyList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		
		model.addAttribute("sysUser", newSysCurrency);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysCurrency/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysCurrency") SysCurrency sysCurrency,
			BindingResult br,Model model) {
		
		sysCurrency = sysCurrencyService.selectByPrimaryKey(sysCurrency.getId());
		if(sysCurrency==null){
			throw new NoDataFoundException();
		}
		List<SysParameter> isStandardMoneyList= sysParameterService.selectList(null); 
		model.addAttribute("isStandardMoneyList", isStandardMoneyList);
			
		List<SysParameter> statusList= sysParameterService.selectList(null); 
		model.addAttribute("statusList", statusList);
			
		model.addAttribute("sysCurrency", sysCurrency);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysCurrency/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysCurrency") SysCurrency sysCurrency,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysCurrency.getId()==null){
				sysCurrencyService.insert(sysCurrency);
			}else{
				sysCurrencyService.updateByPrimaryKey(sysCurrency);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysCurrency);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysCurrency") SysCurrency sysCurrency,Model model) {
		sysCurrency = sysCurrencyService.selectByPrimaryKey(sysCurrency.getId());
		if(sysCurrency==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysCurrency", sysCurrency);
		return "/admin/sysCurrency/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysCurrencyService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysCurrencyService.deleteByPrimaryKey(id);
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
