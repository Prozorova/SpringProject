package ru.gb.portal.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan("ru.gb.portal")
@PropertySource("classpath:config.properties")
public class ApplicationConfig {
	
	@Bean
	public DataSource dataSource(
			@Value("${datasource.driver}") final String dataSourceDriver,
			@Value("${datasource.url}") final String dataSourceUrl,
			@Value("${datasource.user}") final String dataSourceUser,
			@Value("${datasource.password}") final String dataSourcePassword
			) {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceDriver);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUser);
		dataSource.setPassword(dataSourcePassword);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			final DataSource dataSource,
			@Value("${hibernate.show_sql}") final boolean showSQL,
			@Value("${hibernate.hbm2ddl.auto}") final String tableSrategy,
			@Value("${hibernate.dialect}") final String dialect,
			@Value("${hibernate.format_sql}") final String format,
			@Value("${current_session_context_class}") final String curContext
			) {
		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setPackagesToScan("ru.gb.portal.domain");
		final Properties properties = new Properties();
		properties.put("hibernate.show_sql", showSQL);
		properties.put("hibernate.hbm2ddl.auto", tableSrategy);
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.format_sql", format);
		properties.put("current_session_context_class", curContext);
		factoryBean.setJpaProperties(properties);
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
