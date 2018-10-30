package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserService implements UserServiceInf{

	UserDaoInf userDao = new UserDao();
	
	@Override
	public UserVo selectUser(String user_id) {
		return userDao.selectUser(user_id);
	}
	
}
