package com.yc.mailMgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.yc.mailMgr.dao")
public class MailMgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailMgrApplication.class, args);
	}

}
