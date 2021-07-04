package prasun.banking.common;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories("prasun.banking")
public class JpaConfiguration {
	@Autowired
	DataSource dataSource;
	
	//This was done to comply with the project requirements
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://192.168.56.105:3306/bank_project?serverTimezone=UTC");
//		dataSource.setUsername("bank_user");
//		dataSource.setPassword("Bank_Password@1");
////        dataSource.setUsername( "root" );
////        dataSource.setPassword( "root" );
//		return dataSource;
//	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);

		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		//lemfb.setDataSource(dataSource());
		lemfb.setDataSource(dataSource);
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setPackagesToScan("prasun.banking.dao");
		Properties jpaProperties = new Properties();
		jpaProperties.put("spring.jpa.hibernate.ddl-auto", "update");
		lemfb.setJpaProperties(jpaProperties);
		return lemfb;
	}
}