package com.example.demo.socket;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GreetingController {

  private final SimpMessagingTemplate template;
	
	

  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception { 
    Thread.sleep(1000); // 1초 지연
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }

  @MessageMapping("/notify")  //공지 사항 등록
  public String notify(HelloMessage message) {
	  //service 등록 처리
	  String text = new Date().toLocaleString()+"공지등록";
	  this.template.convertAndSend("/topic/notify", text); // 핵심기능 - 실시간 알림
	  return "sample"; //아무 의미 없음
  }
  
  @GetMapping("/persionNotify")
  public String personNotify() {
	  
	  this.template.convertAndSendToUser(
				"user", "/queue/personNotice", "개인 메시지");
	  return "main";
}
  }
  
  

