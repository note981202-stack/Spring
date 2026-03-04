//스프링부트의 출발점 파일

package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy(proxyTargetClass = true) 
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.example.demo1"})
@MapperScan(basePackages = "com.example.demo.**.mapper")// 해당 주소에 생성된 인터페이스를 모두 확인함
public class Ex02MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex02MybatisApplication.class, args);
	}

}
