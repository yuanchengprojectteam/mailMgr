package com.yc.mailMgr;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootApplication
@MapperScan(basePackages="com.yc.mailMgr.dao")
public class MailMgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailMgrApplication.class, args);
	}
	
	 @Bean
	    public PageHelper pageHelper(){
	        PageHelper pageHelper = new PageHelper();
	        Properties properties = new Properties();
	        properties.setProperty("offsetAsPageNum","true");
	        properties.setProperty("rowBoundsWithCount","true");
	        properties.setProperty("reasonable","true");
	        //配置mysql数据库的方言
	        properties.setProperty("dialect","mysql");   
	        pageHelper.setProperties(properties);
	        return pageHelper;
	     }

}
