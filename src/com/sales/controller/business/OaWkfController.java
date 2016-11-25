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
import com.sales.model.business.OaWkf;
import com.sales.service.business.OaWkfService;
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;



@Controller
@RequestMapping("/admin/oaWkf")
public class OaWkfController extends BasicController {
	@Resource
	private OaWkfService oaWkfService;
	
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("oaWkf") OaWkf oaWkf,
			BindingResult br,Model model) {
		
	
		return "/admin/oaWkf/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("oaWkf") OaWkf oaWkf,
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = oaWkfService.selectList(oaWkf, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("oaWkf") OaWkf oaWkf,
			BindingResult br,Model model) {
		
		OaWkf newOaWkf = new OaWkf();
		
			
		
		model.addAttribute("sysUser", newOaWkf);		
		model.addAttribute("mode", Const.addMode);
		return "/admin/oaWkf/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("oaWkf") OaWkf oaWkf,
			BindingResult br,Model model) {
		
		oaWkf = oaWkfService.selectByPrimaryKey(oaWkf.getId());
		if(oaWkf==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("oaWkf", oaWkf);
		model.addAttribute("mode", Const.editMode);
		return "/admin/oaWkf/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("oaWkf") OaWkf oaWkf,
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(oaWkf.getId()==null){
				oaWkfService.insert(oaWkf);
			}else{
				oaWkfService.updateByPrimaryKey(oaWkf);
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(oaWkf);
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("oaWkf") OaWkf oaWkf,Model model) {
		oaWkf = oaWkfService.selectByPrimaryKey(oaWkf.getId());
		if(oaWkf==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("oaWkf", oaWkf);
		return "/admin/oaWkf/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			oaWkfService.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					oaWkfService.deleteByPrimaryKey(id);
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
