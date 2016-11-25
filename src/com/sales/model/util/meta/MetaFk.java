package com.sales.model.util.meta;

public class MetaFk {
	private String columnName;
	private String constraintName;
	private String referencedTableName;
	
	private String propertyName;
	private Class javaType;
	private String javaTypeName;
	private String javaTypeSimpleName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
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
	
	

}
