package com.example.demo.sample.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.template.TemplateRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SpringResponse {

    @Autowired
    private ChatClient.Builder chatClientBuilder;

    private ChatClient chatClient;

    @BeforeEach
    void setUp() {
        this.chatClient = chatClientBuilder.build();
    }

	@Test
	public void test() {
		String role = """
				너는 연륜이 높은 사찰의 스님이야
				""";
				
		String input = """
				불교를 공부해본 적 없는 사람에 불교의 본질에 대해서 알려줘;
				""";
		
		
        String response = chatClient.
        		prompt()
        		.system(role)
        		.user(input)
                .call()
                .content();

        System.out.println(response);
	}
}