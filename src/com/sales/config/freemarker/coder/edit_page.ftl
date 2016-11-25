<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="/WEB-INF/view/admin/common/include/header.jsp"%>
</head>
<body class="easyui-layout">
	<div class="easyui-panel box box_form" title=""
			data-options="fit:true,region:'center',footer:'#sysUser_edit_footer_${uuid}',">
		<%@include file="_form.jsp" %>
	</div>
	
	<div id="sysUser_edit_footer_${uuid}" class="panel_footer">
        <c:if test="${r'${auth.add || auth.edit}'}">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveOrUpdateRow({url:'<s:url value="${requestMapping}/saveOrUpdate"></s:url>',formId:'form_${modelName}_${uuid}', datagridId: 'tbl_${modelName}_${uuid}', dialogId:'dlg_${modelName}_${uuid}',element:this,});">保存</a>
        </c:if>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeDialog({dialogId:'dlg_${modelName}_${uuid}', element:this});">关闭</a>
    </div>
</body>
</html>