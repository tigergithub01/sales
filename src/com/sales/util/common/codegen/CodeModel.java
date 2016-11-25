package com.sales.util.common.codegen;

import java.util.Map;

import com.sales.model.util.meta.MetaTbl;

public class CodeModel {
	private String serviceImplPackageName;
	private String serviceImplClsName;

	private String servicePackage;
	private String serviceClsName;
	private String serviceName;

	private String daoPackage;
	private String daoClsName;
	private String daoName;
	
	private String daoMapperPackage;
	private String daoMapperName;

	private String modelPackage;
	private String modelClsName;
	private String modelName;

	private String controllerPackage;
	private String controllerClsName;
	private String requestMapping;
	private String viewPath;

	private String moduleName;
	private String moduleCode;
	
	private String webContextPath;
	
	private String uuid;
	
	
	private String tableName;
	private MetaTbl metaTbl; //table information from database
	
	private Map<String,String> tblLabelMap; //table display name mapping
	
	private Map<String,String> createUpdateMap; //create,update fields mapping
	
	public String getServiceImplPackageName() {
		return serviceImplPackageName;
	}

	public void setServiceImplPackageName(String serviceImplPackageName) {
		this.serviceImplPackageName = serviceImplPackageName;
	}

	public String getServiceImplClsName() {
		return serviceImplClsName;
	}

	public void setServiceImplClsName(String serviceImplClsName) {
		this.serviceImplClsName = serviceImplClsName;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getServiceClsName() {
		return serviceClsName;
	}

	public void setServiceClsName(String serviceClsName) {
		this.serviceClsName = serviceClsName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getDaoClsName() {
		return daoClsName;
	}

	public void setDaoClsName(String daoClsName) {
		this.daoClsName = daoClsName;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getModelClsName() {
		return modelClsName;
	}

	public void setModelClsName(String modelClsName) {
		this.modelClsName = modelClsName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	public String getControllerClsName() {
		return controllerClsName;
	}

	public void setControllerClsName(String controllerClsName) {
		this.controllerClsName = controllerClsName;
	}

	public String getRequestMapping() {
		return requestMapping;
	}

	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getViewPath() {
		return viewPath;
	}

	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	public String getWebContextPath() {
		return webContextPath;
	}

	public void setWebContextPath(String webContextPath) {
		this.webContextPath = webContextPath;
	}

	public String getDaoMapperPackage() {
		return daoMapperPackage;
	}

	public void setDaoMapperPackage(String daoMapperPackage) {
		this.daoMapperPackage = daoMapperPackage;
	}

	public String getDaoMapperName() {
		return daoMapperName;
	}

	public void setDaoMapperName(String daoMapperName) {
		this.daoMapperName = daoMapperName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public MetaTbl getMetaTbl() {
		return metaTbl;
	}

	public void setMetaTbl(MetaTbl metaTbl) {
		this.metaTbl = metaTbl;
	}

	public Map<String, String> getTblLabelMap() {
		return tblLabelMap;
	}

	public void setTblLabelMap(Map<String, String> tblLabelMap) {
		this.tblLabelMap = tblLabelMap;
	}

	public Map<String, String> getCreateUpdateMap() {
		return createUpdateMap;
	}

	public void setCreateUpdateMap(Map<String, String> createUpdateMap) {
		this.createUpdateMap = createUpdateMap;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
