package com.jeon.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jeon.blog.domain.BoardVO;
import com.jeon.blog.domain.UserVO;
import com.jeon.blog.paging.Criteria;
import com.jeon.blog.paging.Paging;
import com.jeon.blog.repository.BoardService;

@Controller
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	// 게시판 리스트
	@GetMapping("/board/list")
    public String selectBoardList(HttpSession session, Criteria cri, Model model) throws Exception {
        
	    // 전체 글 개수
        //int boardListCnt = boardService.boardListCnt();
		
    	UserVO userVO = (UserVO) session.getAttribute("user");
    	String user_id = null;

		user_id = userVO.getId(); // user_id 정보 가져오기
		
		System.out.println(user_id);
		
        // 전체 글 개수
        int boardListCnt = boardService.boardListCnt();
        
        // 페이징 객체
        Paging paging = new Paging();
        paging.setCri(cri);
        paging.setTotalCount(boardListCnt);    

        List<Map<String, Object>> list = boardService.selectBoardList(cri);   
        
        System.out.println(list);
        System.out.println(paging);
        model.addAttribute("list", list);
        model.addAttribute("paging", paging); 

        return "/board/board";
    }
	
	// 게시판 글쓰기 폼
    @GetMapping("/board")
    public String boardWriteForm(HttpSession session) throws Exception {
    	
    	return "/board/boardWrite";
    }
    
    // 게시판 글쓰기
    @PostMapping("/board")
    public String boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
        
    	UserVO userVO = (UserVO) session.getAttribute("user");
    	
    	String user_id = null;

		user_id = userVO.getId(); // user_id 정보 가져오기
		
		boardVO.setUser_id(user_id); // cartVO에 user_id값 담기
		
    	boardService.boardWrite(boardVO);
        
        return "redirect:/board/list";
     
    }
    
    // 게시판 상세
    @GetMapping("/board/{id}")
    public String boardRead(@PathVariable int id, Model model) throws Exception {
        
    	BoardVO data = boardService.boardRead(id);
        model.addAttribute("data", data);        
        
        return "board/boardRead";    
    }

    // 게시판 수정 폼
    @GetMapping(value="/board/edit/{id}")
    public String boardModifyForm(@PathVariable int id, Model model) throws Exception {
 
        BoardVO data = boardService.boardRead(id);
        model.addAttribute("data", data);    
        
        return "board/boardModify";
    }
    
    // 게시글 수정
    @PutMapping("/board/edit/{id}")
    public String boardModify(BoardVO boardVO) throws Exception {
        
        boardService.boardModify(boardVO);
    
        return "redirect:/board/list";
    }
    
    // 게시글 삭제
    @DeleteMapping("/board/{id}")
    public String boardDelete(@PathVariable int id) throws Exception {
        
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

}
