package com.example.demo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //어느 시점까지 메모리를 가져 갈것인지 설정(런타임에 리플렉션으로 사용 가능)
@Target(ElementType.METHOD)  //이 어노테이션이 부착될 수 있는 타입(메서드에만 적용 가능)
public @interface  PrintExecutionTime { //###어노테이션을 내가 직접 만듦

	
	
}