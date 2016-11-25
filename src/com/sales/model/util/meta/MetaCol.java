package com.sales.model.util.meta;

public class MetaCol {
	private String tableName;
	private String columnName;
	private String dataType;
	private String columnComment;
	private String isNullable;
	private Integer columnLength;
	private String constraintName;
	private String referencedTableName;
	
	
	private String propertyName;
	private Class javaType;
	private String javaTypeName;
	private String javaTypeSimpleName;
	private String  capitalizePropertyName;
	private String jdbcType;	
	
	private String refPropertyName;
	private String referencedTableClsName;
	private String  capitalizeRefPropertyName;
	private String referencedTablePropertyName;
	
	private String refLabelColumnName;
	private String refLabelPropertyName;
	
	

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Class getJavaType() {
		return javaType;
	}

	public void setJavaType(Class javaType) {
		this.javaType = javaType;
	}

	public String getJavaTypeName() {
		return javaTypeName;
	}

	public void setJavaTypeName(String javaTypeName) {
		this.javaTypeName = javaTypeName;
	}

	public String getJavaTypeSimpleName() {
		return javaTypeSimpleName;
	}

	public void setJavaTypeSimpleName(String javaTypeSimpleName) {
		this.javaTypeSimpleName = javaTypeSimpleName;
	}

	public String getCapitalizePropertyName() {
		return capitalizePropertyName;
	}

	public void setCapitalizePropertyName(String capitalizePropertyName) {
		this.capitalizePropertyName = capitalizePropertyName;
	}

	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public Integer getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}

	public String getConstraintName() {
		return constraintName;
	}

	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}

	public String getReferencedTableName() {
		return referencedTableName;
	}

	public void setReferencedTableName(String referencedTableName) {
		this.referencedTableName = referencedTableName;
	}

	public String getReferencedTableClsName() {
		return referencedTableClsName;
	}

	public void setReferencedTableClsName(String referencedTableClsName) {
		this.referencedTableClsName = referencedTableClsName;
	}

	public String getRefPropertyName() {
		return refPropertyName;
	}

	public void setRefPropertyName(String refPropertyName) {
		this.refPropertyName = refPropertyName;
	}

	public String getCapitalizeRefPropertyName() {
		return capitalizeRefPropertyName;
	}

	public void setCapitalizeRefPropertyName(String capitalizeRefPropertyName) {
		this.capitalizeRefPropertyName = capitalizeRefPropertyName;
	}

	public String getReferencedTablePropertyName() {
		return referencedTablePropertyName;
	}

	public void setReferencedTablePropertyName(String referencedTablePropertyName) {
		this.referencedTablePropertyName = referencedTablePropertyName;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getRefLabelColumnName() {
		return refLabelColumnName;
	}

	public void setRefLabelColumnName(String refLabelColumnName) {
		this.refLabelColumnName = refLabelColumnName;
	}

	public String getRefLabelPropertyName() {
		return refLabelPropertyName;
	}

	public void setRefLabelPropertyName(String refLabelPropertyName) {
		this.refLabelPropertyName = refLabelPropertyName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	

}
