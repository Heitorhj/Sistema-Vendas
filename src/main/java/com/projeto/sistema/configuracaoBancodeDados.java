package com.projeto.sistema;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration 
public class configuracaoBancodeDados {

    @Bean 
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); // instanciando o objeto
        dataSource.setDriverClassName("org.postgresql.Driver"); // configurações de acesso
        dataSource.setUrl("jdbc:postgresql://localhost:5432/loja");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean 
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL); // driver do banco
        adapter.setShowSql(true); // mostra no console o sql
        adapter.setGenerateDdl(true);
        return adapter;
    }
}
