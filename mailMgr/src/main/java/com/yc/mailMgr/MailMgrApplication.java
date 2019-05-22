package com.yc.mailMgr;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.pagehelper.PageHelper;
import com.yc.mailMgr.config.FIlter;

@SpringBootApplication
@MapperScan(basePackages="com.yc.mailMgr.dao")
public class MailMgrApplication implements  WebMvcConfigurer{

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

	 @Autowired
	    private FIlter filter;

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(filter).excludePathPatterns("/","/login","/tologin","/css/**","/js/**","/houl/**","/images/**","/pie/**");
			
		}
}
