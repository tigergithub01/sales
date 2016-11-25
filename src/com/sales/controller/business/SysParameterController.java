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
import com.sales.model.business.SysParameter;
import com.sales.service.business.SysParameterService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

import com.sales.service.business.SysParameterTypeService;

import com.sales.model.business.SysParameterType;

@Controller
@RequestMapping("/admin/sysParameter")
public class SysParameterController extends BasicController {
	@Resource
	private SysParameterService sysParameterService;
	
	@Resource
	private SysParameterTypeService sysParameterTypeService;	
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("sysParameter") SysParameter sysParameter,
			BindingResult br,Model model) {
		
		List<SysParameterType> typeIdList= sysParameterTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
	
		return "/admin/sysParameter/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("sysParameter") SysParameter sysParameter,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = sysParameterService.selectList(sysParameter, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("sysParameter") SysParameter sysParameter,
			BindingResult br,Model model) {
		
		SysParameter newSysParameter = new SysParameter();
		
			
		List<SysParameterType> typeIdList= sysParameterTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		
		model.addAttribute("sysUser", newSysParameter);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/sysParameter/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("sysParameter") SysParameter sysParameter,
			BindingResult br,Model model) {
		
		sysParameter = sysParameterService.selectByPrimaryKey(sysParameter.getId());
		if(sysParameter==null){
			throw new NoDataFoundException();
		}
		List<SysParameterType> typeIdList= sysParameterTypeService.selectList(null); 
		model.addAttribute("typeIdList", typeIdList);
			
		model.addAttribute("sysParameter", sysParameter);
		model.addAttribute("mode", Const.editMode);
		return "/admin/sysParameter/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("sysParameter") SysParameter sysParameter,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(sysParameter.getId()==null){
				sysParameterService.insert(sysParameter);
			}else{
				sysParameterService.updateByPrimaryKey(sysParameter);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(sysParameter);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("sysParameter") SysParameter sysParameter,Model model) {
		sysParameter = sysParameterService.selectByPrimaryKey(sysParameter.getId());
		if(sysParameter==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("sysParameter", sysParameter);
		return "/admin/sysParameter/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			sysParameterService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					sysParameterService.deleteByPrimaryKey(id);
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
