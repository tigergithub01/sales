package com.sales.dao.basic;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * 
 * @ClassName: GenericMyBatisDaoImpl
 * @Description: TODO, can also inherit SqlSessionSupport
 * @author Tiger.guo
 * @date 2013-4-11 下午12:40:53
 *
 */
public abstract class GenericMyBatisDao {

	private SqlSessionTemplate sqlSessionTemplate;

	@Resource
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List selectList(String statement) {
		return sqlSessionTemplate.selectList(statement);
	}

	public List selectList(String statement, Object parameter) {
		return sqlSessionTemplate.selectList(statement, parameter);
	}

	public List selectList(String statement, Object parameter,
			int skipResults, int maxResults) {
		return sqlSessionTemplate.selectList(statement, parameter,
				new RowBounds(skipResults, maxResults));
	}
	
	public List selectList(String statement, int offset,int limit ){
		return sqlSessionTemplate.selectList(statement, new RowBounds(offset,limit));
	}
	
	public Map selectMap(String statement,String mapKey) {
		return sqlSessionTemplate.selectMap(statement, mapKey);
	}
	
	public Map selectMap(String statement, Object parameter, String mapKey) {
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}
	
	public Map selectMap(String statement, Object parameter, String mapKey, int offset,int limit ) {
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey, new RowBounds(offset,limit));
	}
	
	public int delete(String statement){
		return sqlSessionTemplate.delete(statement);
	}
	
	public int delete(String statement,Object parameter){
		return sqlSessionTemplate.delete(statement, parameter);	
	}
	
	public int update(String statement){
		return sqlSessionTemplate.update(statement);
	}
	
	public int update(String statement,Object parameter){
		return sqlSessionTemplate.update(statement, parameter);	
	}
	
	public int insert(String statement,Object parameter){
		return sqlSessionTemplate.insert(statement, parameter);
	}
	
	public int insert(String statement){
		return sqlSessionTemplate.insert(statement);
	}

}
