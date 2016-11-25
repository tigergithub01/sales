<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="/WEB-INF/view/admin/common/include/header.jsp"%>
</head>
<body class="easyui-layout">
	<div class="easyui-panel box box_view" title=""
			data-options="fit:true,region:'center',footer:'#sysUser_view_footer_${uuid}',">
			<div class="box_body">
				<form:form method="post" modelAttribute="${modelName}">
					<#list metaTbl.colList as metaCol>
					<div class="form-group">
						<div class="label">${metaCol.columnComment}:</div>
						<div class="content">
							<#if metaCol.javaTypeSimpleName=='Date'>
								<#if (metaTbl.createDateCol?? && metaTbl.createDateCol.columnName== metaCol.columnName) ||(metaTbl.updateDateCol?? && metaTbl.updateDateCol.columnName== metaCol.columnName) > 
							<fmt:formatDate value="${"${"+modelName+"."+metaCol.propertyName+"}"}" pattern="yyyy-MM-dd HH:mm:ss"/>
								<#else>
							<fmt:formatDate value="${"${"+modelName+"."+metaCol.propertyName+"}"}" pattern="yyyy-MM-dd"/>
								</#if>
							<#else>
								<#if metaCol.refPropertyName??>
							<c:out value="${"${"+modelName+"."+metaCol.refPropertyName+"."+metaCol.refLabelPropertyName+"}"}"></c:out>
								<#else>
							<c:out value="${"${"+modelName+"."+metaCol.propertyName+"}"}"></c:out>
					    		</#if>
							</#if>
							<#if metaCol.isNullable=='NO' && ((metaTbl.primaryKey?default('id')) != metaCol.columnName)>
								<#if metaCol.javaTypeSimpleName=='String'>
								<#else>
								</#if>
							</#if>
							<#if metaCol.javaTypeSimpleName=='String'>
							</#if>
						</div>
					</div>
					</#list>
				</form:form>
			</div>
	</div>
	
	<div id="sysUser_view_footer_${uuid}" class="panel_footer">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeDialog({dialogId:'dlg_${modelName}_${uuid}', element:this});">关闭</a>
    </div>
</body>
</html>