package com.jeon.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jeon.blog.domain.UserVO;

@Mapper
public interface UserMapper {

	public List<UserVO> selectUserList() throws Exception;

	public UserVO userLogin(UserVO userVO) throws Exception;

	public void userRegister(UserVO userVO) throws Exception;

	public int idCheck(String id) throws Exception;

	public UserVO userModifyGET(String id) throws Exception;

	public void userModifyPOST(UserVO userVO) throws Exception;

	public void userDelete(UserVO userVO) throws Exception;

}
