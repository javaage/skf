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
@MapperScan(basePackages = { "com.skf.scheduler.mapper.mysql" }, sqlSessionFactoryRef = "mysqlSessionFactory")
public class MybatisMysqlConfig {

	@Autowired
	@Qualifier("mysql")
	private DataSource mysqlDataSource;

	@Bean
	public SqlSessionFactory mysqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(mysqlDataSource);
		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
		return factoryBean.getObject();

	}

	@Bean
	public SqlSessionTemplate mysqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(mysqlSessionFactory());
		return template;
	}
}
