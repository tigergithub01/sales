package ${controllerPackage};

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
import ${modelPackage}.${modelClsName};
import ${servicePackage}.${serviceClsName};
import com.sales.util.common.CommonUtils;
import com.sales.util.exception.NoDataFoundException;
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

<#list metaTbl.refDistinctColList as metaCol>
	<#if metaCol.refPropertyName??>
import ${servicePackage}.${metaCol.referencedTableClsName}Service;
    </#if>
</#list>

<#list metaTbl.refDistinctColList as metaCol>
	<#if metaCol.refPropertyName??>
import ${modelPackage}.${metaCol.referencedTableClsName};
    </#if>
</#list>

@Controller
@RequestMapping("${requestMapping}")
public class ${controllerClsName} extends BasicController {
	@Resource
	private ${serviceClsName} ${serviceName};
	
	<#list metaTbl.refDistinctColList as metaCol>
		<#if metaCol.refPropertyName?? && (metaCol.tableName != metaCol.referencedTableName) >
	@Resource
	private ${metaCol.referencedTableClsName}Service ${metaCol.referencedTablePropertyName}Service;	
	
    	</#if>
	</#list>
	
	@RequestMapping(value = "/index")
	public String index(@ModelAttribute("${modelName}") ${modelClsName} ${modelName},
			BindingResult br,Model model) {
		
		<#list metaTbl.colList as metaCol>
			<#if metaCol.refPropertyName??>
		List<${metaCol.referencedTableClsName}> ${metaCol.propertyName}List= ${metaCol.referencedTablePropertyName}Service.selectList(null); 
		model.addAttribute("${metaCol.propertyName}List", ${metaCol.propertyName}List);
			
	    	</#if>
		</#list>
	
		return "${requestMapping}/index";
	} 
	
	@ResponseBody
	@RequestMapping(value = "/ajaxIndex")
	public JsonObj ajaxIndex(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("${modelName}") ${modelClsName} ${modelName},
			BindingResult br) {
		PageInfo pageInfo = CommonUtils.getInstance().getPageInfo(request); 
		PaginatedListHelper helper = ${serviceName}.selectList(${modelName}, pageInfo);
		return new JsonObj(true, helper.getFullListSize(), helper.getList());	  
	}
	
	
	@RequestMapping(value = "/add")
	public String add(@Validated @ModelAttribute("${modelName}") ${modelClsName} ${modelName},
			BindingResult br,Model model) {
		
		<#assign newModelName= "new"+ modelClsName />	
		${modelClsName} ${newModelName} = new ${modelClsName}();
		
		<#if metaTbl.createDateCol??>
		${newModelName}.set${metaTbl.createDateCol.capitalizePropertyName}(new java.util.Date());
		</#if>
		<#if metaTbl.createUserIdCol??>
		${newModelName}.set${metaTbl.createUserIdCol.capitalizePropertyName}(CommonUtils.getInstance().getLoginUserid());
		</#if>
		<#if metaTbl.updateDateCol??>
		${newModelName}.set${metaTbl.updateDateCol.capitalizePropertyName}(new java.util.Date());
		</#if>
		<#if metaTbl.updateUserIdCol??>
		${newModelName}.set${metaTbl.updateUserIdCol.capitalizePropertyName}(CommonUtils.getInstance().getLoginUserid());
		</#if>
			
		<#list metaTbl.colList as metaCol>
			<#if metaCol.refPropertyName??>
		List<${metaCol.referencedTableClsName}> ${metaCol.propertyName}List= ${metaCol.referencedTablePropertyName}Service.selectList(null); 
		model.addAttribute("${metaCol.propertyName}List", ${metaCol.propertyName}List);
			
	    	</#if>
		</#list>
		
		model.addAttribute("sysUser", new${modelClsName});		
		model.addAttribute("mode", Const.addMode);
		return "${requestMapping}/add";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(@Validated @ModelAttribute("${modelName}") ${modelClsName} ${modelName},
			BindingResult br,Model model) {
		
		${modelName} = ${serviceName}.selectByPrimaryKey(${modelName}.getId());
		if(${modelName}==null){
			throw new NoDataFoundException();
		}
		<#list metaTbl.colList as metaCol>
			<#if metaCol.refPropertyName??>
		List<${metaCol.referencedTableClsName}> ${metaCol.propertyName}List= ${metaCol.referencedTablePropertyName}Service.selectList(null); 
		model.addAttribute("${metaCol.propertyName}List", ${metaCol.propertyName}List);
			
	    	</#if>
		</#list>
		model.addAttribute("${modelName}", ${modelName});
		model.addAttribute("mode", Const.editMode);
		return "${requestMapping}/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate")
	public JsonObj saveOrUpdate(@Validated @ModelAttribute("${modelName}") ${modelClsName} ${modelName},
			BindingResult br) {
		JsonObj jsonObj = new JsonObj(true);	
		if(br.getErrorCount()==0){
			if(${modelName}.getId()==null){
				<#if metaTbl.createDateCol??>
				${modelName}.set${metaTbl.createDateCol.capitalizePropertyName}(new java.util.Date());
				</#if>
				<#if metaTbl.createUserIdCol??>
				${modelName}.set${metaTbl.createUserIdCol.capitalizePropertyName}(CommonUtils.getInstance().getLoginUserid());
				</#if>
				<#if metaTbl.updateDateCol??>
				${modelName}.set${metaTbl.updateDateCol.capitalizePropertyName}(new java.util.Date());
				</#if>
				<#if metaTbl.updateUserIdCol??>
				${modelName}.set${metaTbl.updateUserIdCol.capitalizePropertyName}(CommonUtils.getInstance().getLoginUserid());
				</#if>
				${serviceName}.insert(${modelName});
			}else{
				<#if metaTbl.updateDateCol??>
				${modelName}.set${metaTbl.updateDateCol.capitalizePropertyName}(new java.util.Date());
				</#if>
				<#if metaTbl.updateUserIdCol??>
				${modelName}.set${metaTbl.updateUserIdCol.capitalizePropertyName}(CommonUtils.getInstance().getLoginUserid());
				</#if>
				${serviceName}.updateByPrimaryKey(${modelName});
			}
		}else{
			List<ValidErrObj> validErrList = CommonUtils.getInstance().getValidErrors(br);
			jsonObj.setStatus(false);
			jsonObj.setValidErrList(validErrList);
			jsonObj.setMessage(CommonUtils.getInstance().getFirstValidErrMsg(br));
			return jsonObj;
		}
		jsonObj.setValue(${modelName});
		return jsonObj;
	}
	
	@RequestMapping(value = "/view")
	public String view(@ModelAttribute("${modelName}") ${modelClsName} ${modelName},Model model) {
		${modelName} = ${serviceName}.selectByPrimaryKey(${modelName}.getId());
		if(${modelName}==null){
			throw new NoDataFoundException();
		}
		model.addAttribute("${modelName}", ${modelName});
		return "${requestMapping}/view";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonObj delete(@ModelAttribute("param") Param param) {
		JsonObj jsonObj = new JsonObj(true);	
		if(param.getId()!=null){
			//删除
			${serviceName}.deleteByPrimaryKey(param.getId());
		}else{
			//批量删除
			List<Long> ids = param.getIds();
			if(ids!=null){
				for (Long id : ids) {
					${serviceName}.deleteByPrimaryKey(id);
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
