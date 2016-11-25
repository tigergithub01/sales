package ${modelPackage};

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sales.model.basic.BasicModel;
<#list metaTbl.refDistinctColList as metaCol>
	<#if metaCol.refPropertyName?? && (metaCol.tableName != metaCol.referencedTableName) >
import ${modelPackage}.${metaCol.referencedTableClsName};
    </#if>
</#list>



//${metaTbl.tableName}
//${metaTbl.tableComment}
public class ${modelClsName} extends BasicModel{

	<#-- property -->
	<#list metaTbl.colList as metaCol>
		//${metaCol.columnComment}
		<#if metaCol.javaTypeSimpleName=='Date'>
			<#if (metaTbl.createDateCol?? && metaTbl.createDateCol.columnName== metaCol.columnName) ||(metaTbl.updateDateCol?? && metaTbl.updateDateCol.columnName== metaCol.columnName) > 
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
			<#else>
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
			</#if>
		</#if>
		<#if metaCol.isNullable=='NO' && ((metaTbl.primaryKey?default('id')) != metaCol.columnName)>
			<#if metaCol.javaTypeSimpleName=='String'>
		@NotBlank(message="${metaCol.columnComment}不能为空！") 
			<#else>
		@NotNull(message="${metaCol.columnComment}不能为空！") 
			</#if>
		</#if>
		<#if metaCol.javaTypeSimpleName=='String'>
		@Length(max=${(metaCol.columnLength?c)!0})
		</#if>
		private ${metaCol.javaTypeSimpleName} ${metaCol.propertyName};
		
	</#list>
	<#-- reference property -->
	<#list metaTbl.colList as metaCol>
		<#if metaCol.refPropertyName??>
		private ${metaCol.referencedTableClsName} ${metaCol.refPropertyName};
		</#if>

	</#list>
	<#-- get set for property -->
	<#list metaTbl.colList as metaCol>
		public ${metaCol.javaTypeSimpleName} get${metaCol.capitalizePropertyName}() {
	        return ${metaCol.propertyName};
	    }
	    
	    public void set${metaCol.capitalizePropertyName}(${metaCol.javaTypeSimpleName} ${metaCol.propertyName}) {
	    	<#if metaCol.javaTypeSimpleName=='String'>
	        this.${metaCol.propertyName} = ${metaCol.propertyName} == null ? null : ${metaCol.propertyName}.trim();
	        <#else>
	        this.${metaCol.propertyName} = ${metaCol.propertyName};	
	        </#if> 
	    }
	    
	</#list>
	<#-- get set for reference property -->
	<#list metaTbl.colList as metaCol>
		<#if metaCol.refPropertyName??>
		public ${metaCol.referencedTableClsName} get${metaCol.capitalizeRefPropertyName}() {
	        return ${metaCol.refPropertyName};
	    }
	    
	    public void set${metaCol.capitalizeRefPropertyName}(${metaCol.referencedTableClsName} ${metaCol.refPropertyName}) {
	        this.${metaCol.refPropertyName} = ${metaCol.refPropertyName};	
	    }
	    </#if>
	</#list>

}