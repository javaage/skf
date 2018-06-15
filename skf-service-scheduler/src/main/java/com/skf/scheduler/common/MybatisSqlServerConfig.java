package com.skf.scheduler.common;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author P0088589
 *
 */
@Configuration
@MapperScan(basePackages = { "com.skf.scheduler.mapper.sqlserver" }, sqlSessionFactoryRef = "sqlserverSessionFactory")
public class MybatisSqlServerConfig {

	@Autowired
	@Qualifier("sqlserver")
	private DataSource sqlserverDataSource;

	@Bean
	public SqlSessionFactory sqlserverSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(sqlserverDataSource);
		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
		return factoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlserverSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(sqlserverSessionFactory());
		return template;
	}

}
