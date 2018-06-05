package com.skf.management;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
	@Bean(name = "mysql")
	@ConfigurationProperties(prefix = "spring.datasource.mysql") // application.properteis中对应属性的前缀
	public DataSource mysql() {
		return DataSourceBuilder.create().build();
	}

//	@Bean(name = "sqlserver")
//	@ConfigurationProperties(prefix = "spring.datasource.sqlserver") // application.properteis中对应属性的前缀
//	public DataSource sqlserver() {
//		return DataSourceBuilder.create().build();
//	}
	
	@Primary
	@Bean(name = "mysqlsession")
	@Qualifier("mysql")
	public SqlSession mysqlSession(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.getObject().getConfiguration().addMappers("com.skf.management.mapper");
		factoryBean.getObject().getConfiguration().setLogPrefix("mysql.");
		return factoryBean.getObject().openSession();
	}
	
//	@Bean(name = "sqlserversession")
//	@Qualifier("sqlserver")
//	public SqlSession sqlserverSession(DataSource dataSource) throws Exception{
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource);
//		factoryBean.getObject().getConfiguration().addMappers("com.skf.management.sqlservermapper");
//		factoryBean.getObject().getConfiguration().setLogPrefix("sqlserver.");
//		return factoryBean.getObject().openSession();
//	}
}
