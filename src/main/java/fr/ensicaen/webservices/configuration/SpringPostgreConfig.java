package fr.ensicaen.webservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringPostgreConfig {
    @Bean
    public DataSource postgreSQLDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(System.getenv().get("URL"));
        dataSource.setUsername(System.getenv().get("USERNAME"));
        dataSource.setPassword(System.getenv().get("PASSWORD"));
        return dataSource;
    }
}
