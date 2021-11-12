package com.jeon.blog.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.blog.domain.BoardVO;
import com.jeon.blog.mapper.BoardMapper;
import com.jeon.blog.paging.Criteria;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardList(cri);
	}

	public void boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.boardWrite(boardVO);
	}

	// 게시판 수정 폼
	public BoardVO boardRead(int id) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.boardRead(id);
	}

	// 게시판 수정
	public void boardModify(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.boardModify(boardVO);
	}

	public void boardDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.boardDelete(id);
		
	}

	public int boardListCnt() throws Exception{
		// TODO Auto-generated method stub
		return boardMapper.boardListCnt();
	}

}
