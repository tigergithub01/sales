<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="box_body">
	<form:form action="${webContextPath}${requestMapping}/saveOrUpdate" enctype="multipart/form-data"
			method="post" modelAttribute="${modelName}" id="form_${modelName}_${uuid}">
		<#list metaTbl.colList as metaCol>
			<#if ((metaTbl.primaryKey?default('id')) == metaCol.columnName)>
		<form:hidden path="${metaTbl.primaryKeyProperty}"/>
			<#elseif (metaTbl.createDateCol?? && metaTbl.createDateCol.columnName== metaCol.columnName) ||(metaTbl.createUserIdCol?? && metaTbl.createUserIdCol.columnName== metaCol.columnName)
			|| (metaTbl.updateDateCol?? && metaTbl.updateDateCol.columnName== metaCol.columnName) ||(metaTbl.updateUserIdCol?? && metaTbl.updateUserIdCol.columnName== metaCol.columnName) >
			<#else>
		<div class="form-group">
			<#--cssClass-->
			<#assign cssClass = "easyui-textbox" />
			<#if metaCol.javaTypeSimpleName=='Date'>
				<#if (metaTbl.createDateCol?? && metaTbl.createDateCol.columnName== metaCol.columnName) ||(metaTbl.updateDateCol?? && metaTbl.updateDateCol.columnName== metaCol.columnName) > 
					<#assign cssClass = "easyui-datetimebox" />
				<#else>
					<#assign cssClass = "easyui-datebox" />
				</#if>
			</#if>
			<#--required-->
			<#assign required = "required:false" />
			<#if metaCol.isNullable=='NO' && ((metaTbl.primaryKey?default('id')) != metaCol.columnName)>
				<#if metaCol.refPropertyName??>	
					<#assign required = "validType:'combobox_required'" />
				<#else>
					<#assign required = "required:true" />
				</#if>
			</#if>
			<#--length-->
			<#assign lengthValid = "" />
			<#if metaCol.javaTypeSimpleName=='String'>
				<#assign lengthValid = "validType:'length[0,${(metaCol.columnLength?c)!0}]'" />
			</#if>
			<div class="label">${metaCol.columnComment}:</div><#--primary key is not need to be updated.-->
			<div class="content">
				<#if metaCol.refPropertyName??>
				<form:select path="${metaCol.propertyName}"  cssClass="easyui-combobox" data-options="${required},">
					<option value="">--请选择--</option>  
					<form:options items="${"${"+metaCol.propertyName+"List}"}" itemLabel="${metaCol.refLabelPropertyName}" itemValue="id"/>
				</form:select>
				<#else>
				<form:input path="${metaCol.propertyName}" cssClass="${cssClass} form-control" data-options="${required},${lengthValid}" />
		    	</#if>
			</div>
		</div>
			</#if>
		</#list>
	</form:form>
</div>
	
	