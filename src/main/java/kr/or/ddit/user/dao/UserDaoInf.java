package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserDaoInf {
	
	public UserVo selectUser(String user_id);
	

}
