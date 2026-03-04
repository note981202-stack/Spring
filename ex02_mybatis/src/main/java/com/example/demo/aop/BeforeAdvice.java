package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

	@Aspect     //advice 클래스
	@Component  //빈등록
	public class BeforeAdvice { 
	 
	   @Pointcut("execution(* com.example..*Impl.*(..))") //com.example로 시작하는 패키지 안에 impl로 시작하는 모든 파일의 모든 타입의 서비스를 불러오겠다 
	   public void  allpointcut() {} 
	 
	 
	   @Before("allpointcut()") // 서비스 매소트 실행전에 아래의 메소드 실행한다 
	   public void beforeLog(JoinPoint jp) { 
	     String methodName = jp.getSignature().getName(); 
	     System.out.println("[사전처리] beforeLog 메서드: " + methodName );
	     
	     //매개변수
	     Object[] param = jp.getArgs();
	    	 if(param !=null && param.length>0) {
	    		 System.out.println("매개변수: " + param[0]);
	    	 } //if end
	     
	   } 
	} 

