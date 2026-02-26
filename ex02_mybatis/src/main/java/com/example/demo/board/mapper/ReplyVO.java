package com.example.demo.board.mapper;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Alias("Reply")
public class ReplyVO { 
	private Integer bno;
	private Integer rno;
	private String  reply;
	private String  replyer;
	private Date    replydate;
	private Date    updatedate;

}
