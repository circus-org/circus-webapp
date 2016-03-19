package cane.brothers.circus;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
//@EnableTransactionManagement
@PropertySource({"classpath:db.properties","classpath:hibernate.properties"})
@EnableJpaRepositories(basePackages="cane.brothers.circus.repository")
public class JpaConfig {

	
//	@Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
//    {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(new ClassPathResource("/schema.sql"));
//
//        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//        dataSourceInitializer.setDataSource(dataSource);
//        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
//        return dataSourceInitializer;
//    }
	
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		//return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));

		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.H2);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		lemfb.setDataSource(dataSource());
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setJpaProperties(getJpaProperties());
		lemfb.setPackagesToScan("cane.brothers.circus");
		return lemfb;
	}
	
	private Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
		properties.put("javax.persistence.schema-generation.database.action", env.getRequiredProperty("db.action"));
		properties.put("javax.persistence.schema-generation.scripts.action", env.getRequiredProperty("ddl.action"));
		properties.put("javax.persistence.schema-generation.scripts.create-target", env.getRequiredProperty("ddl.create-target"));
		properties.put("javax.persistence.schema-generation.scripts.drop-target", env.getRequiredProperty("ddl.drop-target"));
		//properties.put("javax.persistence.sql-load-script-source", env.getRequiredProperty("ddl.load-target"));
		
		properties.put("jadira.usertype.autoRegisterUserTypes", env.getRequiredProperty("jadira.usertype.autoRegisterUserTypes"));
		
		return properties;
	}
	
	// services
	
//	@Bean
//	public EmployeeService employeeService() {
//		return new JpaEmployeeService();
//	}
}