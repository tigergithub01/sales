package ${serviceImplPackageName};

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import ${daoPackage}.${daoClsName};
import ${modelPackage}.${modelClsName};
import ${servicePackage}.${serviceClsName};
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

@Service("${serviceName}")
public class ${serviceImplClsName} implements ${serviceClsName} {
	
	@Resource
	private ${daoClsName} ${daoName};
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return ${daoName}.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(${modelClsName} record) {
		return ${daoName}.insert(record);
	}

	@Override
	public int insertSelective(${modelClsName} record) {
		return ${daoName}.insertSelective(record);
	}

	@Override
	public ${modelClsName} selectByPrimaryKey(Long id) {
		return ${daoName}.selectByPrimaryKey(id);
	}
	
	@Override
	public ${modelClsName} selectBySelective(${modelClsName} record) {
		List<${modelClsName}> selectList = this.selectList(record);
		if(selectList!=null && !(selectList.isEmpty())){
			return selectList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(${modelClsName} record) {
		return ${daoName}.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(${modelClsName} record) {
		return ${daoName}.updateByPrimaryKey(record);
	}
	 
	@Override
	public List<${modelClsName}> selectList(
			${modelClsName} record) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(1);
		pageInfo.setPageSize(Integer.MAX_VALUE);
		return this.selectList(record, pageInfo).getList(); 
	}
	
	@Override
	public PaginatedListHelper selectList(
			${modelClsName} record,PageInfo pageInfo) {
		if(record==null){
			record = new ${modelClsName}();
		}
		List<${modelClsName}> list = ${daoName}.selectList(record,pageInfo); 
		PaginatedListHelper helper = new PaginatedListHelper();		
//		helper.setPageNumber(pageInfo.getPageNumber());
//		helper.setPageSize(pageInfo.getPageSize());		
		helper.setList(list);
		helper.setFullListSize(pageInfo.getTotalCount());
		
		return helper; 
	}
	
}
