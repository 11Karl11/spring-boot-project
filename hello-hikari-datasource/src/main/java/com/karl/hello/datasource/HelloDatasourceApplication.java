package com.karl.hello.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@SpringBootApplication
public class HelloDatasourceApplication implements CommandLineRunner {

    // @Autowired
    // private DataSource dataSource;

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;

    public static void main(String[] args) {
        SpringApplication.run(HelloDatasourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try(Connection conn=ordersDataSource.getConnection()){
            log.info("获得连接{}",conn);
        }catch (Exception e){
            e.printStackTrace();
        }

        try(Connection conn=usersDataSource.getConnection()){
            log.info("获得连接{}",conn);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
