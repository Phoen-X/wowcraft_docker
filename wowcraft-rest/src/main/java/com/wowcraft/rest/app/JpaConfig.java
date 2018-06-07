package com.wowcraft.rest.app;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.wowcraft.rest.app.repositories")
@PropertySource("classpath:db.properties")
public class JpaConfig {
    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:liquibase/change_sets.xml");
        return springLiquibase;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       HibernateJpaVendorAdapter vendor) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.wowcraft.rest.app.repositories.entities");
        factory.setJpaVendorAdapter(vendor);
        return factory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public DataSource dataSource(@Value("${db.url}") final String dbUrl, @Value("${db.username}")String userName,
                                 @Value("${db.password}") String password) {
        return DataSourceBuilder.create()
                .url(dbUrl)
                .username(userName)
                .password(password)
                .build();
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendor() {
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setDatabase(Database.MYSQL);
        return vendor;
    }
}
