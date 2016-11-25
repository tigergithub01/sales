<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@include file="/WEB-INF/view/admin/common/include/header.jsp"%>
</head>
<body class="easyui-layout">
	<script type="text/javascript">
		$(function() {
			$('#tbl_${modelName}_${uuid}').datagrid({
				url : '<s:url value="${requestMapping}/ajaxIndex"></s:url>',
				method : 'post',
				title : '${metaTbl.tableComment}列表',
				singleSelect : true,
				checkOnSelect : true,
				pagination : true,
				rownumbers : true,
				collapsible : false,
				pageSize : 20,
				cache : false,
				idField : '${metaTbl.primaryKeyProperty?default('id')}',
				fit : true,
				fitColumns: true,
				toolbar : '#toolbar_${modelName}_${uuid}',
				columns : [ [
					/* {
						field : 'ck',
						checkbox : true
					}, */
					<#list metaTbl.colList as metaCol>
					<#if metaCol.refPropertyName??>
					{
						field : '${metaCol.refPropertyName}.${metaCol.refLabelColumnName}',
						title : '${metaCol.columnComment}',
						sortable : true,
						halign : 'center',
						formatter:function(val,row){
							return ((row.${metaCol.refPropertyName}!=null)?row.${metaCol.refPropertyName}.${metaCol.refLabelPropertyName}:'');
						},
					},
					<#else>
					{
						field : '${metaCol.columnName}',
						title : '${metaCol.columnComment}',
						sortable : true,
						halign : 'center',
						formatter:function(val,row){
							return ((row.${metaCol.propertyName}!=null)?row.${metaCol.propertyName}:'');
						},
					},
			    	</#if>
					</#list>
				] ],
				onClickRow : function(index, row) {},
				onDblClickRow : function(index, row) {
					viewRow({url:'<s:url value="${requestMapping}/view"></s:url>?id='+row.id, dialogId:'dlg_${modelName}_${uuid}', title:'查看${metaTbl.tableComment}', datagridId: 'tbl_${modelName}_${uuid}',uuid:'${uuid}'});
				},
				onLoadSuccess : function(data) {
					if (data.status == false) {
						$.messager.alert('提示','数据加载出错！' + data.message,'warning');
					}
				},
				onLoadError : function() {
					$.messager.alert('提示','数据加载出错！','warning');
				},
				onBeforeLoad : function(param) {
					//console.debug(param);
					$.extend(param, $("#search_form_${modelName}_${uuid}").serializeObject());
				}
			});
			
			//设置回车查询
			doSetUpKeyPressEvent({datagridId:'tbl_${modelName}_${uuid}', searchFormId:'search_form_${modelName}_${uuid}'});
		});
	</script>

	<div class="easyui-layout box box_search" data-options="fit:true">
		<div data-options="region:'north',split: true,doSize:true," class="search_box_layout">
			<div class="box_body">
				<form:form
					method="post" modelAttribute="${modelName}" id="search_form_${modelName}_${uuid}">
					<div class="form-group">
						<div class="label">主键:</div>
						<div class="content">
							<form:input path="${metaTbl.primaryKeyProperty?default('id')}" 
										cssClass="easyui-textbox" data-options="" />
						</div>
					</div>
					<#list metaTbl.colList as metaCol>
					<#if metaCol.columnName == "name" || metaCol.columnName == "user_name" || metaCol.columnName == "code" 
						|| metaCol.columnName == "sheet_no" || metaCol.columnName == "flow_no" ><#--name query-->
					<div class="form-group">
						<div class="label">${metaCol.columnComment}:</div>
						<div class="content">
							<form:input path="${metaCol.propertyName}" 
										cssClass="easyui-textbox" data-options="" />
						</div>
					</div>
					</#if>
					<#if metaCol.refPropertyName??>
					<div class="form-group">
						<div class="label">${metaCol.columnComment}:</div>
						<div class="content">
							<form:select path="${metaCol.propertyName}"  cssClass="easyui-combobox" data-options="">
								<option value="">--请选择--</option>  
								<form:options items="${"${"+metaCol.propertyName+"List}"}" itemLabel="${metaCol.refLabelPropertyName}" itemValue="id"/>
							</form:select>
						</div>
					</div>
					<#else>
					</#if>
					</#list>
	        	</form:form>
       	 	</div>
       	 	<div class="box_footer">
	       	 	<div class="form-group">
	        		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="reloadRows({datagridId:'tbl_${modelName}_${uuid}'});">查询</a>
	        	</div>
        	</div>
		</div>

		<div data-options="region:'center'">
			<div id="toolbar_${modelName}_${uuid}" style="padding:2px 5px;" class="dg_toolbar">
				<c:if test="${r'${auth.add}'}">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"
					plain="true" onclick="addRow({url:'<s:url value="${requestMapping}/add"></s:url>', dialogId:'dlg_${modelName}_${uuid}', title:'新增${metaTbl.tableComment}',uuid:'${uuid}'})">新增</a> 
				</c:if>
				
				<c:if test="${r'${auth.edit}'}">
				<a href="javascript:void(0)"  class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editRow({url:'<s:url value="${requestMapping}/edit"></s:url>', dialogId:'dlg_${modelName}_${uuid}', title:'编辑${metaTbl.tableComment}', datagridId: 'tbl_${modelName}_${uuid}',uuid:'${uuid}'})">编辑</a> 
				</c:if>
				
				<c:if test="${r'${auth.delete}'}">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"
					plain="true" onclick="deleteRows({url:'<s:url value="${requestMapping}/delete"></s:url>', datagridId: 'tbl_${modelName}_${uuid}'})">删除</a>
				</c:if>
				
				<c:if test="${r'${auth.view}'}">
				<a href="javascript:void(0)"  class="easyui-linkbutton"
					iconCls="icon-man" plain="true" onclick="viewRow({url:'<s:url value="${requestMapping}/view"></s:url>', dialogId:'dlg_${modelName}_${uuid}', title:'查看${metaTbl.tableComment}', datagridId: 'tbl_${modelName}_${uuid}',uuid:'${uuid}'})">查看</a>
				</c:if>
				
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reloadRows({datagridId:'tbl_${modelName}_${uuid}'});">刷新</a>	
				
				<c:if test="${r'${auth.print}'}">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print" plain="true" onclick="printRows({url:'<s:url value="${requestMapping}/print"></s:url>', formId:'search_form_${modelName}_${uuid}'})">打印</a>
				</c:if>
				
				<c:if test="${r'${auth.export}'}">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-filter" plain="true" onclick="exportRows({url:'<s:url value="${requestMapping}/export"></s:url>', formId:'search_form_${modelName}_${uuid}'})">导出</a>
				</c:if>
				
			</div>

			<table id="tbl_${modelName}_${uuid}"></table>
			
			<!-- dialog -->
			<div id="dlg_${modelName}_${uuid}" class="easyui-dialog" title="${metaTbl.tableComment}" style="width:800px;height:600px;padding:10px"
            data-options="closed:true,modal:true,maximizable:true,minimizable:false,collapsible:true,resizable:true,iconCls: 'icon-save',"></div>
    
		</div>
	</div>

</body>
</html>