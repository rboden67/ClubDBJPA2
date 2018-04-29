package com.jrb.ClubDBJPA2;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ClubJPAConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/CLUB296?serverTimezone=UTC&useSSL=false");
		dataSource.setUsername("webapp_user");
		dataSource.setPassword("testing123");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.jrb.ClubDBJPA2");
		factoryBean.setJpaPropertyMap(jpaProperties());
		return factoryBean;
	}

	private Map<String, ?> jpaProperties() {
		Map<String, String> jpaPropertiesMap = new HashMap<String, String>();
		jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		// jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "validate");
		return jpaPropertiesMap;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public MemberDaoImpl memberDao() {
		MemberDaoImpl dao = new MemberDaoImpl();
		return dao;
	}
	
	@Bean
	public PurchaseDaoImpl purchaseDao() {
		PurchaseDaoImpl dao = new PurchaseDaoImpl();
		return dao;
	}
}