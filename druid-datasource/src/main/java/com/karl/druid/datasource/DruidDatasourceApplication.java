package com.karl.druid.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class DruidDatasourceApplication implements CommandLineRunner {

    // @Autowired
    // private DataSource dataSource;

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;


    public static void main(String[] args) {
        SpringApplication.run(DruidDatasourceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // orders 数据源
        log.info("[run][获得数据源：{}]", ordersDataSource.getClass());

        // users 数据源
        log.info("[run][获得数据源：{}]", usersDataSource.getClass());
    }
}
