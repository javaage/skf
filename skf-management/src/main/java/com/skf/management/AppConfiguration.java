package com.skf.management;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfiguration {

//	@Bean
//	public PlatformTransactionManager txManager(DataSource dataSource) throws Exception {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 1
		corsConfiguration.addAllowedHeader("*"); // 2
		corsConfiguration.addAllowedMethod("*"); // 3
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); // 4
		return new CorsFilter(source);
	}
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.mysql") // application.properteis中对应属性的前缀
	@Qualifier("mysql")
	public DataSource mysql() {
		return DataSourceBuilder.create().build();
	}

	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.sqlserver") // application.properteis中对应属性的前缀
	@Qualifier("sqlserver")
	public DataSource sqlserver() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean
	@Qualifier("mysqlsession")
	public SqlSessionTemplate mysqlSession(@Qualifier("mysql") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.getObject().getConfiguration().addMappers("com.skf.management.mapper");
		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
		return new SqlSessionTemplate(factoryBean.getObject());
	}
	
	@Bean
	@Qualifier("sqlserversession")
	public SqlSessionTemplate sqlserverSession(@Qualifier("sqlserver") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.getObject().getConfiguration().addMappers("com.skf.management.sqlservermapper");
		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
		return new SqlSessionTemplate(factoryBean.getObject());
	}
	
//	@Primary
//	@Bean
//	@Qualifier("mysqlsession")
//	public SqlSession mysqlSession(@Qualifier("mysql") DataSource dataSource) throws Exception{
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource);
//		factoryBean.getObject().getConfiguration().addMappers("com.skf.management.mapper");
//		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
//		return factoryBean.getObject().openSession();
//	}
//	
//	@Bean
//	@Qualifier("sqlserversession")
//	public SqlSession sqlserverSession(@Qualifier("sqlserver") DataSource dataSource) throws Exception{
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource);
//		factoryBean.getObject().getConfiguration().addMappers("com.skf.management.sqlservermapper");
//		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
//		return factoryBean.getObject().openSession();
//	}
	
//	@Bean
//	public SqlSessionTemplate sqlserverSessionTemplate() throws Exception {
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(sqlserverDataSource);
//		factoryBean.getObject().getConfiguration().setLogPrefix("dao.");
//		return factoryBean.getObject();
//		SqlSessionTemplate template = new SqlSessionTemplate(sqlserverSessionFactory());
//		return template;
//	}
}
