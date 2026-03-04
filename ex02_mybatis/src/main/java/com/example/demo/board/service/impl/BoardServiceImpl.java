package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.BoardVO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> findAll() {
		return boardMapper.findAll();
	}

	@Override
	public BoardVO findByBno(int bno) {
		return boardMapper.findByBno(bno);
	}

	@Override
	public int deleteByBno(Integer bno) {
		return boardMapper.deleteByBno(bno);
	}

	@Override
	public int insertBoard(BoardVO boardvo) {
		return boardMapper.insertBoard(boardvo);
	}

	
}
