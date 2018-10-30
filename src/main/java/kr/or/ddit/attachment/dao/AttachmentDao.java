package kr.or.ddit.attachment.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.attachment.model.AttachmentVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AttachmentDao implements AttachmentDaoInf{

	@Override
	public List<AttachmentVo> getAttachment(String notice_no) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<AttachmentVo> attachmentList = session.selectList("attachment.filefind", notice_no); 
		session.close();
		
		return attachmentList;
	}

	@Override
	public int attachmentInsert(Map<String, Object> param) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int attachmentInsert = session.insert("attachment.fileUpload", param); 
		session.commit();
		session.close();
		
		return attachmentInsert;
	}

}
