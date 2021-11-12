package com.jeon.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeon.blog.domain.UserVO;
import com.jeon.blog.repository.UserService;

@Controller
@EnableAutoConfiguration
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ModelAndView userList() throws Exception {
		ModelAndView mav = new ModelAndView("/userList");
		List<UserVO> userList = userService.selectUserList();
		mav.addObject("list",userList);
		
		return mav;
	}
	
	/** Login **/
	@RequestMapping(value = "/login", method= {RequestMethod.GET, RequestMethod.POST})
    public String userLogin(UserVO userVO, HttpServletRequest req) throws Exception {
		
        HttpSession session = req.getSession();
        UserVO user = userService.userLogin(userVO);
        
        //System.out.println(userVO.getId());
        
        if (user == null) {
            session.setAttribute("user", null);
        } else {
            session.setAttribute("user", user);
        }
        
        return "/login/login";
    }
	
	/** register **/
	@GetMapping("/register")
	public String registerGet() throws Exception {  
		logger.info("****** register GET");
		return "/register/register";
	}
	
	@PostMapping("/register")
	public String userRegister(UserVO userVO) throws Exception {  
		
		logger.info("*********** register POST");
		
		int count = userService.idCheck(userVO.getId());
		
        try {
            if(count == 0) userService.userRegister(userVO);                
        } catch (Exception e) {
              logger.info("*****존재 하는 아이디");
        }
        return "redirect:/";

	}
	
	@ResponseBody
	@PostMapping("/idCheck")
    public int idCheck(@RequestBody String id) throws Exception {
        
        int count = 0;
        count = userService.idCheck(id);
 
        return count;    
    }
	
	// 회원정보 수정 화면 구현 : GET방식
	@GetMapping("/user/{id}")
	public String userModifyGET(HttpServletRequest req, Model model, UserVO userVO) throws Exception {
	        
		HttpSession session = req.getSession();
	        
	    UserVO user = (UserVO) session.getAttribute("user");
	    UserVO modifyUser = userService.userModifyGET(user.getId());
	        
	    model.addAttribute("name", modifyUser.getName());
	    model.addAttribute("id", modifyUser.getId());
	    model.addAttribute("password", modifyUser.getPassword());
	        
	    return "/user/userModify";    
	 }
	
	@ResponseBody
    @PutMapping("/user/edit/{id}")
    public String userModifyPOST(@RequestBody UserVO userVO) throws Exception {
 
        userService.userModifyPOST(userVO);
 
        return "/user/userModify";
    }
	
	@ResponseBody
	@DeleteMapping("/user/{id}")
    public String userDelete(@RequestBody UserVO userVO) throws Exception {
		
		if (userVO.getId() != null && userVO.getId() != "") {
			userService.userDelete(userVO);
		} 
        
		return "redirect:/";
    }
	
	@GetMapping("/logout")
    public String logout() throws Exception {
    
        return "/login/logout";
    }


}