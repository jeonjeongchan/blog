package com.jeon.blog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jeon.blog.domain.BoardVO;
import com.jeon.blog.paging.Criteria;

@Mapper
public interface BoardMapper {

	List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception;

	void boardWrite(BoardVO boardVO) throws Exception;

	BoardVO boardRead(int id) throws Exception;

	void boardModify(BoardVO boardVO) throws Exception;

	void boardDelete(int id) throws Exception;

	int boardListCnt() throws Exception;

	List<Map<String, Object>> selectBoardList() throws Exception;


}
