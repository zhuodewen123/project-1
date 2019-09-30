package com.zhuodewen.myproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot启动类
 */
@EnableSwagger2
@EnableTransactionManagement					//事务管理器
@MapperScan("com.zhuodewen.myproject.mapper") 	//mapper扫描器(指定扫描mapper接口的位置)
@SpringBootApplication
public class MyprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

}
