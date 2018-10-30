package kr.or.ddit.user.dao;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{

	
	public UserVo selectUser(String user_id){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVo userVo = session.selectOne("user.selectUser", user_id); 
		session.close();
		
		return userVo;
	}

	
	
	
}
