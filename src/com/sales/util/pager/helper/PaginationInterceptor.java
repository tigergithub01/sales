package com.sales.util.pager.helper;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.sales.util.pager.dialect.Dialect;
import com.sales.util.pager.dialect.MySQLDialect;
import com.sales.util.pager.dialect.OracleDialect;

/**
 * Mybaits的拦截器
 * 
 * @author Tiger-guo 20160612
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {

	protected static Logger log = Logger.getLogger(PaginationInterceptor.class);

	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(
				statementHandler, DEFAULT_OBJECT_FACTORY,
				DEFAULT_OBJECT_WRAPPER_FACTORY);
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
				.getValue("delegate.mappedStatement");

		RowBounds rowBounds = (RowBounds) metaStatementHandler
				.getValue("delegate.rowBounds");
		BoundSql boundSql = (BoundSql) metaStatementHandler
				.getValue("delegate.boundSql");

		List list = boundSql.getParameterMappings();
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return invocation.proceed();
		}
		String originalSql = (String) metaStatementHandler
				.getValue("delegate.boundSql.sql");
		Configuration configuration = (Configuration) metaStatementHandler
				.getValue("delegate.configuration");

		Dialect.Type databaseType = null;
		try {
			databaseType = Dialect.Type.valueOf(configuration.getVariables()
					.getProperty("dialect").toUpperCase());
		} catch (Exception e) {
			System.out.println("mybatis-config.xml中未设置数据库类型");
		}

		if (databaseType == null) {
			throw new RuntimeException(
					"the value of the dialect property in configuration.xml is not defined : "
							+ configuration.getVariables().getProperty(
									"dialect"));
		}
		Dialect dialect = null;
		switch (databaseType) {
		case ORACLE: // oracle 分页
			dialect = new OracleDialect();
			break;
		case MYSQL: // MySQL分页
			dialect = new MySQLDialect();
			break;
		}

		metaStatementHandler.setValue("delegate.boundSql.sql", dialect
				.getPaginationString(originalSql, rowBounds.getOffset(),
						rowBounds.getLimit()));

		metaStatementHandler.setValue("delegate.rowBounds.offset",
				RowBounds.NO_ROW_OFFSET);

		metaStatementHandler.setValue("delegate.rowBounds.limit",
				RowBounds.NO_ROW_LIMIT);

		if (log.isDebugEnabled()) {
			BoundSql boundSqlPage = statementHandler.getBoundSql();
			log.debug(" 生成分页SQL : " + boundSqlPage.getSql());
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
	}

}