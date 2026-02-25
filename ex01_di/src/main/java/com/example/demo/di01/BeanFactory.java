package com.example.demo.di01;

public class BeanFactory {
	
	public static TV getBean(String arg) {
		if(arg.equals("sm")) {
			return new SamsungTV();
		} else {
			return new LgTV();
		}
	}
}
