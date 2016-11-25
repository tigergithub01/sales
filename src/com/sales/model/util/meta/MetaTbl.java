package com.sales.model.util.meta;

import java.util.List;

public class MetaTbl {
	private String tableName;

	private String tableComment;
	
	private String primaryKey;
	
	private List<MetaCol> colList;
	
	private List<MetaFk> fkList;
	
	private List<MetaCol> refDistinctColList;
	
	//computed
	private String primaryKeyProperty;
	private String tableNameClsName;
	private String tableNameProperty;
	
	//create_user_id,create_date,update_user_id,update_date处理
	private MetaCol createUserIdCol;
	private MetaCol createDateCol;
	private MetaCol updateUserIdCol;
	private MetaCol updateDateCol;		

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public List<MetaCol> getColList() {
		return colList;
	}

	public void setColList(List<MetaCol> colList) {
		this.colList = colList;
	}

	public List<MetaFk> getFkList() {
		return fkList;
	}

	public void setFkList(List<MetaFk> fkList) {
		this.fkList = fkList;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getPrimaryKeyProperty() {
		return primaryKeyProperty;
	}

	public void setPrimaryKeyProperty(String primaryKeyProperty) {
		this.primaryKeyProperty = primaryKeyProperty;
	}

	public List<MetaCol> getRefDistinctColList() {
		return refDistinctColList;
	}

	public void setRefDistinctColList(List<MetaCol> refDistinctColList) {
		this.refDistinctColList = refDistinctColList;
	}

	public String getTableNameClsName() {
		return tableNameClsName;
	}

	public void setTableNameClsName(String tableNameClsName) {
		this.tableNameClsName = tableNameClsName;
	}

	public String getTableNameProperty() {
		return tableNameProperty;
	}

	public void setTableNameProperty(String tableNameProperty) {
		this.tableNameProperty = tableNameProperty;
	}

	public MetaCol getCreateUserIdCol() {
		return createUserIdCol;
	}

	public void setCreateUserIdCol(MetaCol createUserIdCol) {
		this.createUserIdCol = createUserIdCol;
	}

	public MetaCol getCreateDateCol() {
		return createDateCol;
	}

	public void setCreateDateCol(MetaCol createDateCol) {
		this.createDateCol = createDateCol;
	}

	public MetaCol getUpdateUserIdCol() {
		return updateUserIdCol;
	}

	public void setUpdateUserIdCol(MetaCol updateUserIdCol) {
		this.updateUserIdCol = updateUserIdCol;
	}

	public MetaCol getUpdateDateCol() {
		return updateDateCol;
	}

	public void setUpdateDateCol(MetaCol updateDateCol) {
		this.updateDateCol = updateDateCol;
	}

}
