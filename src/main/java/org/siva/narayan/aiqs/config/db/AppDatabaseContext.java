package org.siva.narayan.aiqs.config.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * AppDatabaseContext to configure the database connections : data-source,
 * entity-manager, session-factory, transaction-manager.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "org.siva.narayan.aiqs.db.repo", entityManagerFactoryRef = "aiqs_entityManager", transactionManagerRef = "aiqs_transactionManager")
public class AppDatabaseContext {
	
	private static final String ENTITY_PACKAGES_TO_SCAN = "org.siva.narayan.aiqs.db.entity";

	@Value(value = "classpath:database/initScript.sql")
	private Resource databaseInitScript;

	@Order(value = 1)
	@Bean(name = "aiqs_dataSource")
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Desktop/aiqs");
//		dataSource.setUrl("jdbc:h2:/Users/si255323/Desktop/aiqs");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setDriverClassName("org.h2.Driver");
		return dataSource;
	}

	@Order(value = 2)
	@Bean(name = "aiqs_dataSourceInitializer")
	public DataSourceInitializer dataSourceInitializer(@Qualifier("aiqs_dataSource") DataSource dataSource) {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(databasePopulator());
		return dataSourceInitializer;
	}
	
	public DatabasePopulator databasePopulator() {
		return new ResourceDatabasePopulator(databaseInitScript);
	}

	@Order(value = 3)
	@Bean(name = "aiqs_entityManager")
	public LocalContainerEntityManagerFactoryBean entityManager(@Qualifier("aiqs_dataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource);
		entityManager.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
		entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.put("hibernate.show_sql", "true");
		entityManager.setJpaProperties(props);
		return entityManager;
	}

	@Order(value = 4)
	@Bean(name = "aiqs_sessionFactory")
	public LocalSessionFactoryBean sessionFactory(@Qualifier("aiqs_dataSource") DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory;
	}

	@Order(value = 5)
	@Bean(name = "aiqs_transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		return transactionManager;
	}

}
