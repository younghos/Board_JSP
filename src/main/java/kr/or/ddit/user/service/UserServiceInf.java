package kr.or.ddit.user.service;

import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserServiceInf {
	
	/**
	* Method : selectUser
	* 작성자 : pc24
	* 변경이력 :
	* @param user_id
	* @return
	* Method 설명 : 아이디를 받아 해당 사용자만 조회하는 메서드
	*/
	public UserVo selectUser(String user_id);
	
}
