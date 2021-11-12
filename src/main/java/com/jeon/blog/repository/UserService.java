package com.jeon.blog.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.blog.domain.UserVO;
import com.jeon.blog.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	// 회원 조회
	public List<UserVO> selectUserList() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectUserList();
	}

	public UserVO userLogin(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.userLogin(userVO);
	}

	public int idCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.idCheck(id);
	}

	public void userRegister(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userMapper.userRegister(userVO);
	}

	public UserVO userModifyGET(String id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.userModifyGET(id);
	}

	public void userModifyPOST(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userMapper.userModifyPOST(userVO);
	}

	public void userDelete(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userMapper.userDelete(userVO);
	}

}