package com.skf.scheduler.common;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 
 * @author P0088589
 *
 */
@Configuration
public class DataSourceConfig {

	@Bean(name = "mysql")
	@ConfigurationProperties(prefix = "spring.datasource.mysql") // application.properteis中对应属性的前缀
	public DataSource mysql() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "sqlserver")
	@ConfigurationProperties(prefix = "spring.datasource.sqlserver") // application.properteis中对应属性的前缀
	public DataSource sqlserver() {
		return DataSourceBuilder.create().build();
	}

}