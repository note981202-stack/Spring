package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.post.repository.Posts;
import com.example.demo.post.repository.PostsRepository;

@EnableJpaAuditing
@SpringBootApplication
public class Ex03JpaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(Ex03JpaApplication.class, args);
	}

	private	static	final	Logger	log	=	LoggerFactory.getLogger(Ex03JpaApplication.class);
	
	@Bean
	public	CommandLineRunner	demo(PostsRepository	repository)	{
	return	(args)	->	{
//		save	a	few	customers
	repository.save(new	Posts("t1", "c1",	"010"));
	repository.save(new	Posts("t2", "c2",	"111"));
	repository.save(new	Posts("t3", "c3",	"222"));
	repository.save(new	Posts("t4", "c4",	"333"));
	repository.save(new	Posts("t5", "c5",	"444"));

	};
	}
}
