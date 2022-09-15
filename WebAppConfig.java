package it.corsojava.spring.rest.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "it.corsojava.rest")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.corsojava.spring.rest.repository", entityManagerFactoryRef ="emf",
transactionManagerRef = "tmf")


public class WebAppConfig {

	
	@Bean
	public DataSource getDbConn() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/db_esempio?serverTimezone=CET");
		ds.setUsername("root");
		
		
		return ds;
	}
	
	@Bean(name= "emf")
	public LocalContainerEntityManagerFactoryBean getEntityMan() {
		HibernateJpaVendorAdapter hJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hJpaVendorAdapter.setDatabase(Database.MYSQL);
		hJpaVendorAdapter.setShowSql(true);
		hJpaVendorAdapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(getDbConn());
		factoryBean.setJpaVendorAdapter(hJpaVendorAdapter);
		factoryBean.setPackagesToScan("it.corsojava");
		
		return factoryBean;
	}
	
	@Bean(name = "tmf")
	public PlatformTransactionManager getTransactionManager() {
		JpaTransactionManager jtm = new JpaTransactionManager();
		
		jtm.setEntityManagerFactory(getEntityMan().getObject());
		
		return jtm;
	}
	
	
	
	
}
