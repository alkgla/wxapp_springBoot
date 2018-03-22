package com.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@MapperScan("com.example.mapper")
@SpringBootConfiguration
public class DataSourceConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.name}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource createDateSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
         comboPooledDataSource.setDriverClass(jdbcDriver);
         comboPooledDataSource.setUser(username);
         comboPooledDataSource.setPassword(password);
         comboPooledDataSource.setJdbcUrl(url);
         comboPooledDataSource.setAutoCommitOnClose(false);
         return  comboPooledDataSource;
    }
}
