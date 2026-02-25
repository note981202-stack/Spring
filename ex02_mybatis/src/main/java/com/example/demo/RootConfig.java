//DB연결이랑 mybits 동작 연결하는 설정파일
//전체 구조 흐름 DataSource -> SqlSessionFactory -> EmpMapper -> sql실행


package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration //스프링 설정파일이라는 의미이고, 여기서 만드는 메서드는 bean으로 등록 가능
public class RootConfig {
	
	// DataSource Bean 등록
//		@Bean
		public DataSource dataSource() { //db연결
			HikariDataSource dataSource = new HikariDataSource(); //커넥션 풀
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버사용
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/xe");  //오라클 XE접속
			dataSource.setUsername("hr"); //계정정보
			dataSource.setPassword("hr"); //계정정보
			dataSource.setMaximumPoolSize(5); //최대 연결수 5개
			dataSource.setConnectionTimeout(1000); //연결대기 시간 1초
			return dataSource;
		}

		
		// SqlSessionFactory Bean 등록 
//		@Bean //SqlSessionFactory 설정 = Mybatis 실행 엔진 생성
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); //mybits가 사용할 DB연결 주입
			factoryBean.setDataSource(dataSource);
			return factoryBean.getObject();
		}
}
