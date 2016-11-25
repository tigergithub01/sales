package ${servicePackage};

import java.util.List;

import ${modelPackage}.${modelClsName};
import com.sales.util.pager.helper.PageInfo;
import com.sales.util.pager.helper.PaginatedListHelper;

public interface ${serviceClsName} {
	
	/**
	 * deleteByPrimaryKey
	 * @param id
	 * @return int
	 */
	int deleteByPrimaryKey(Long id);

   /**
    * insert
    * @param record
    * @return int
    */
    int insert(${modelClsName} record);

    /**
     * insertSelective
     * @param record
     * @return int
     */
    int insertSelective(${modelClsName} record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    ${modelClsName} selectByPrimaryKey(Long id);
    
    /**
     * selectBySelective
     * @param record
     * @return
     */
    ${modelClsName} selectBySelective(${modelClsName} record);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(${modelClsName} record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(${modelClsName} record);
    
    
    /**
     * @param record
     * @return
     */
    public List<${modelClsName}> selectList(
			${modelClsName} record);
    /**
     * selectList
     * @param record
     * @return
     */
    public PaginatedListHelper selectList(
			${modelClsName} record,PageInfo pageInfo);
}
