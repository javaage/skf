package com.skf.management;

import javax.sql.DataSource;

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
@MapperScan(basePackages = {"com.skf.management.sqlservermapper"})
public class SqlserverConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.sqlserver") // application.properteis中对应属性的前缀
	@Qualifier("sqlserver")
	public DataSource sqlserver() {
		return DataSourceBuilder.create().build();
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
}
